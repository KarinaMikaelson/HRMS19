package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class ManageEmployeeMembershipPage extends CommonMethods {


    @FindBy(id = "btnAddMembershipDetail")
    public WebElement addMembershipBtn;


    @FindBy(id = "delMemsBtn")
    public WebElement deleteMembershipBtn;

    @FindBy(name = "chkmemdel[]")
    public WebElement membershipCheckbox;

    @FindBy(id = "membership_membership")
    public WebElement selectMembDD;

    @FindBy(id = "membership_subscriptionPaidBy")
    public WebElement selectMembSubscriptionDD;

    @FindBy(id = "membership_subscriptionAmount")
    public WebElement subscriptionAmountField;

    @FindBy(id = "membership_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "membership_subscriptionCommenceDate")
    public WebElement subscriptionStartCalendar;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div/select")
    public WebElement subStartMonth;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div/select[2]")
    public WebElement subStartYear;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/table/tbody")
    public WebElement subStartDate;

    @FindBy(xpath = "//div[@id='addPaneMembership']/div[2]/form/fieldset/ol/li/span")
    public WebElement requiredFieldErrorMsg;

    @FindBy(id = "membership_subscriptionRenewalDate")
    public WebElement subscriptionRenewalDate;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div/select")
    public WebElement subRenewMonth;
    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/div/select[2]")
    public WebElement subRenewYear;
    @FindBy(xpath = "//div[@id='ui-datepicker-div']/table/tbody")
    public WebElement subRenewDate;

    @FindBy(id = "btnSaveMembership")
    public WebElement saveMembershipBtn;

    @FindBy(css = "div.fadable")
    public WebElement successfullyAddedMessage;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div[2]/form/table/tbody/tr/td[@class='check']")
    public WebElement newMembershipCheckbox;

    @FindBy(css = "div.fadable")
    public WebElement membSuccessDeletedMessage;

    @FindBy(xpath = "//td[@class='memshipCode']/a[@href='#']")
    public WebElement membCode;

    @FindBy(id = "frmEmpMembership")
    public WebElement editMembPage;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div[2]/form/table/thead/tr/th[3]")
    public WebElement subsPaidByColumn;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div[2]/form/table/thead/tr/th[5]")
    public WebElement currencyColumn;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div[2]/form/table/tbody/tr/td[3]")
    public WebElement subsPaidByColumnValue;

    @FindBy(xpath = "//div[@id='listMembershipDetails']/div[2]/form/table/tbody/tr/td[5]")
    public WebElement currencyColumnValue;

    public ManageEmployeeMembershipPage() {
        PageFactory.initElements(driver, this);
    }
}
