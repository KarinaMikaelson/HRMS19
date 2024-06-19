package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(xpath = "//div[@id='content']")
    public WebElement addEmployeeTab;
    @FindBy(id="firstName")
    public WebElement firstNameField;
    @FindBy(id="lastName")
    public WebElement lastNameField;
    @FindBy(id="employeeId")
    public WebElement employeeIdField;
    @FindBy(id="employee-details")
    public WebElement newEmpPersonalDetailsTab;

    @FindBy(id="btnSave")
    public WebElement svBtn;


    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
