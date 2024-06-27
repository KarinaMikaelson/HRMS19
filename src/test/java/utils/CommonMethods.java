package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.List;


public class CommonMethods extends PageInitializer{
    public static WebDriver driver;
    public void openBrowserAndLaunchApplication() throws IOException {
        // Opens the browser and launches the application
        // Read the browser type from the configuration file
        switch (ConfigReader.read("browser")){

            // Initialize needed driver
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

                // Throw an exception if the browser type is invalid
                throw new RuntimeException("Invalid Browser Name");
        }

        // Set an implicit wait timeout of 20 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the URL specified in the configuration file
        driver.get(ConfigReader.read("url"));

        // Initialize page objects
        initializePageObjects();
    }
    public static void closeBrowser() {
        // Closes the browser if it is open.

        // Check if the driver instance is not null (the browser is open)
        if(driver!=null){
            // Quit the driver, closing all associated windows
            driver.quit();
        }
    }
    public static void selectFromDropdown(WebElement dropdown, int index){
        // Selects an option from a dropdown menu by its index.
        // Create a Select object to interact with the dropdown menu
        Select select = new Select(dropdown);
        // Select the option at the specified index
        select.selectByIndex(index);
    }
    public static void selectFromDropdown(WebElement dropdown, String visibleText){
        // Select from dropdown method using visibleText of WebElement
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
    public static void selectFromDropdown(String value,WebElement dropdown){
        // Select from dropdown method using value of WebElement
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public static void sendText(String text, WebElement element){
        // Sends a specified text to a web element, typically an input field.

        // Clear any existing text in the input field
        element.clear();
        // Send the specified text to the input field
        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        // Creates and returns a WebDriverWait object with a specified wait time.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        return wait;
    }
    public static void waitForElementToBeClickable(WebElement element){
        // Explicit wait --> wait for element to be clickable method
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        // Waits for a web element to be clickable and then clicks it.
        waitForElementToBeClickable(element);
        element.click();
    }
    public static byte[] takeScreenshot(String fileName) {
        // Takes a screenshot of the current browser window
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot as a byte array
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        // Capture the screenshot as a file
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            // Create the destination file with the specified file name, including a timestamp
            File destinationFile = new File(Constants.SCREENSHOT_FILEPATH + fileName +
                    "_" + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png");

            // Copy the screenshot file to the destination location
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {

            // Throw a runtime exception if there is an issue saving the screenshot
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage(), e);
        }

        // Return the screenshot as a byte array
        return picBytes;
    }
    private static String getTimeStamp(String pattern) {
        // Create a SimpleDateFormat object initialized with the given pattern
        // Format the current date and time according to the specified pattern
        return new SimpleDateFormat(pattern).format(new Date());
    }
    public static JavascriptExecutor getJSExecutor(){
        // Returns a JavascriptExecutor instance for the current WebDriver instance.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Returns the JavascriptExecutor instance
        return js;
    }
    public static void jsClick(WebElement element){
        // Click element using JavaScript
        try {
            // Check if the element is both displayed and enabled
            if (element.isDisplayed() && element.isEnabled()) {
                // If yes, execute JavaScript to click on the element
                getJSExecutor().executeScript("arguments[0].click();", element);
            } else {
                // If not clickable (either not displayed or not enabled), throw an exception
                throw new RuntimeException("Element is not clickable: " + element.toString());
            }
        } catch (Exception e) {
            // Catch any exception that occurs during JavaScript execution
            throw new RuntimeException("Failed to click on the element using JavaScript: " + element.toString(), e);
        }
    }

    public static void clickCheckbox(WebElement checkboxElement) {
        // Clicks on a checkbox element if it is clickable and not already selected.

        // Wait for the checkbox element to be clickable
        waitForElementToBeClickable(checkboxElement);

        // Check if the checkbox element is not null, displayed, and enabled
        if (checkboxElement != null && checkboxElement.isDisplayed() && checkboxElement.isEnabled()) {
            // If the checkbox is not already selected, click on it
            if (!checkboxElement.isSelected()) {
                checkboxElement.click();
            }
        } else {
            // If the checkbox element is not clickable, throw a RuntimeException
            throw new RuntimeException("Checkbox element is not clickable: " + checkboxElement);
        }
    }
    public static void waitForElementToBeVisible(WebElement element){
        // Waits for the specified WebElement to become visible on the web page.
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public static void chooseCalendarDate(WebElement element, String date){
        //  Chooses a specific date from a calendar

        // Find all the td elements within the calendar
        List<WebElement> days = element.findElements(By.tagName("td"));

        // Iterate through each day element in the calendar
        for (WebElement day : days) {
            // Check if the text of the day element matches the desired date
            if (day.getText().equals(date)) {
                // If found, click on the day element
                day.click();
                // Exit the loop once the date is selected
                break;
            }
        }
    }
}



