package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EditEmployeeDetailsPage extends CommonMethods{
    @FindBy(id = "personal_txtEmpID")
    public WebElement personalDetailsTab;
    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement editFirstName;
    @FindBy(id = "personal_txtEmpLastName")
    public WebElement editLastName;
    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement editMidName;
    @FindBy(id = "personal_optGender_1")
    public WebElement selectMaleGender;

    @FindBy(id = "personal_cmbNation")
    public WebElement selectNation;
    @FindBy(id = "personal_cmbMarital")
    public WebElement selectMaritStatus;
    @FindBy(xpath = "//*[@id='btnSave']")
    public WebElement editBtn;
    @FindBy(id = "btnSave")
    public WebElement saveBtn;
    public EditEmployeeDetailsPage() {
        PageFactory.initElements(driver, this);

    }
}
