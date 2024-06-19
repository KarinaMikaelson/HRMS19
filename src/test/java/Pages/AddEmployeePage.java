package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstName;
    @FindBy(id="middleName")
    public WebElement middleName;
    @FindBy(id="lastName")
    public WebElement lastName;
    @FindBy(id="employeeId")
    public WebElement employeeId;
    @FindBy(id="chkLogin")
    public WebElement CreateLoginDetails;
    @FindBy(id="user_name")
    public WebElement username;
    @FindBy(id="user_password")
    public WebElement password;
    @FindBy(id="re_password")
    public WebElement reenterPassword;
    @FindBy(id="status")
    public WebElement statusMenu;
    @FindBy(id="btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }


}
