package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement ViewEmployeeList;

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement SearchEmpByNameField;

    @FindBy(id = "empsearch_id")
    public WebElement SearchEmpByIdField;

    @FindBy(id = "empsearch_employee_status")
    public WebElement SearchEmpStatusField;

    @FindBy(id = "empsearch_termination")
    public WebElement SearchCurrOrPastEmp;

    @FindBy(id = "empsearch_termination")
    public WebElement SearchBySupervisorName;

    @FindBy(id = "empsearch_job_title")
    public WebElement SearchByJobTitle;

    @FindBy(id = "empsearch_sub_unit")
    public WebElement SearchSubUnit;

    @FindBy(id = "searchBtn")
    public WebElement EmpSearchButton;

    @FindBy(id = "resetBtn")
    public WebElement ResetButton;

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);

    }
}
