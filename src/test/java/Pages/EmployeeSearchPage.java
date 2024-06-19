package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {
    @FindBy(id = "employee-information")
    public WebElement empInfoTab;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement empSrchNameField;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@id='tableWrapper']/table/tbody/tr/td[3]")
    public WebElement searchResults;

    @FindBy(id = "empsearch_id")
    public WebElement empIdField;
    @FindBy(id = "//div[@id='tableWrapper']/table/tbody/tr/td[2]")
    public WebElement idSearchResults;

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);

    }
}
