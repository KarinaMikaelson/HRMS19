package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
    @FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
    public WebElement adminOption;

    @FindBy (xpath = "//a[@id='menu_leave_viewLeaveModule']")
    public WebElement leaveOption;

    @FindBy(id="menu_time_viewTimeModule")
    public WebElement timeOption;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    public WebElement performanceOption;

    @FindBy(id = "menu_dashboard_index")
    public WebElement dashboardOption;

    @FindBy(id = "menu_directory_viewDirectory")
    public WebElement directoryOption;

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id="welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//span[text()='Assign Leave']")
    public  WebElement assignLeave;

    @FindBy(xpath = "//span[text()='Leave List']")
    public WebElement leaveList;

    @FindBy(xpath = "//span[text()='Timesheets']")
    public WebElement timesheetsOption;

    @FindBy(xpath = "//legend[text()='Employee Distribution by Subunit']")
    public WebElement employeeDistributionBySubunit;

    @FindBy(xpath = "//legend[text()='Legend']")
    public WebElement legendOption;

    @FindBy(xpath = "//a[@id='welcome']")
    public  WebElement welcomeAdmin;

    @FindBy(xpath = "//a[@id='aboutDisplayLink']")
    public WebElement aboutOption;

    @FindBy(linkText = "Change Password")
    public WebElement changePassword;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public  WebElement empListOption;

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }


}

