package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AccessingMembershipSectionPage extends CommonMethods {
    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement myInfo;

    @FindBy(xpath = "//a[text()='Memberships']")
    public WebElement membershipsSection;

    @FindBy(xpath = "//div[@id='content']/div/div[3]/div/h1")
    public WebElement assignedMembershipPage;

    public AccessingMembershipSectionPage() {
        PageFactory.initElements(driver, this);
    }
}

