package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer{
    public static WebDriver driver;

    public void openBrowserAndLaunchApplication() throws IOException {
        switch (ConfigReader.read("browser")){

            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }
    public static void closeBrowser() {
        if(driver!=null){
            driver.quit();
        }
    }
    public static void selectFromDropdown(WebElement dropdown, int index){
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }
    public static void selectFromDropdown(WebElement dropdown, String visibleText){
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
    public static void selectFromDropdown(String value,WebElement dropdown){
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public static void sendText(String text, WebElement element){
        element.clear();
        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        return wait;
    }
    public static void waitForElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }
    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            File destinationFile = new File(Constants.SCREENSHOT_FILEPATH + fileName +
                    "_" + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png");
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }

        return picBytes;
    }
    private static String getTimeStamp(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                getJSExecutor().executeScript("arguments[0].click();", element);
            } else {
                throw new RuntimeException("Element is not clickable: " + element.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on the element using JavaScript: " + element.toString(), e);
        }
    }
    public static void clickCheckbox(WebElement checkboxElement) {
        if (checkboxElement != null && checkboxElement.isDisplayed() && checkboxElement.isEnabled()) {
            if (!checkboxElement.isSelected()) {
                checkboxElement.click();
            }
        } else {
            throw new RuntimeException("Checkbox element is not clickable: " + checkboxElement);
        }
    }
}



