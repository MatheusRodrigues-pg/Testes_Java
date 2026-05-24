package br.com.matheusrodrigues_pg.pages;

import br.com.matheusrodrigues_pg.models.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {
    //login & signup pages elements and actions
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    //region Locators pagina de Login

    @FindBy(xpath = "//a[.//i[@class='fa fa-home']]")
    public WebElement navHome;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement navProducts;

    @FindBy(xpath = "//a[@href='/view_cart']")
    public WebElement navCart;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement navSignupLogin;

    @FindBy(xpath = "//a[@href='/test_cases']")
    public WebElement navTestCases;

    @FindBy(xpath = "//a[@href='/api_list']")
    public WebElement navApiTesting;

    @FindBy(xpath = "//a[contains(@href, 'www')]")
    public WebElement navVideoTutorials;

    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement navContact;

    @FindBy(xpath = "/html/body/section/div/div/div[1]/div/h2")
    public WebElement h2LoginYourAccount;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement inputLoginEmail;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement inputLoginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement buttonLogin;

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/h2")
    public WebElement h2NewUserSignup;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputSignupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement inputSignupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement buttonSignup;

    @FindBy(xpath = "//p[@style='color: red;']")
    public WebElement pYourEmailPasswordIncorrect;
    //endregion

    //region Locators pagina de Signup
    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/h2/b")
    public WebElement bEnterAccountInformation;

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement inputGender;

    @FindBy(xpath = "//*[@id='id_gender2']")
    public WebElement inputGender2;

    @FindBy(css = "input[data-qa='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement selectDays;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement selectMonth;

    @FindBy(xpath = "//*[@id='years']")
    public WebElement selectYears;

    @FindBy(xpath = "//*[@id='newsletter']")
    public WebElement inputNewsletter;

    @FindBy(xpath = "//*[@id='optin']")
    public WebElement inputOptin;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement inputFirstName;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement inputLastName;

    @FindBy(xpath = "//*[@id='company']")
    public WebElement inputCompany;

    @FindBy(xpath = "//*[@id='address1']")
    public WebElement inputAddress;

    @FindBy(xpath = "//*[@id='address2']")
    public WebElement inputAddress2;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement selectCountry;

    @FindBy(xpath = "//*[@id='state']")
    public WebElement inputState;

    @FindBy(xpath = "//*[@id='city']")
    public WebElement inputCity;

    @FindBy(xpath = "//*[@id='zipcode']")
    public WebElement inputZipcode;

    @FindBy(xpath = "//*[@id='mobile_number']")
    public WebElement inputMobileNumber;
    //endregion

    //region Locators pagina de account_created
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement buttonCreateAccount;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    public WebElement buttonContinueCreateAccount;

    @FindBy(xpath = "//b")
    public WebElement bAccountCreated;

    //endregion
    public void sigNup (UserData usuario) {
        inputSignupName.sendKeys(usuario.getName());
        inputSignupEmail.sendKeys(usuario.getEmail());
        buttonSignup.click();
    }

    public void login (UserData usuario) {
        inputLoginEmail.sendKeys(usuario.getEmail());
        inputLoginPassword.sendKeys(usuario.getPassword());
        buttonLogin.click();
    }

    public void selectDay( UserData usuario) {

        Select select = new Select(selectDays);

        select.selectByIndex(Integer.parseInt(usuario.getDayBirth()));
    }

    public void selectMonth( UserData usuario) {

        Select select = new Select(selectMonth);

        select.selectByIndex(Integer.parseInt(usuario.getMonthBirth()));
    }

    public void selectYear( UserData usuario) {

        Select select = new Select(selectYears);

        select.selectByValue(usuario.getYearBirth());
    }

    public void selectCountry( UserData usuario) {

        Select select = new Select(selectCountry);

        select.selectByIndex(Integer.parseInt(usuario.getCountry()));
    }

    public void enterInformation (UserData usuario) {
        inputGender.click();
        inputPassword.sendKeys(usuario.getPassword());
        selectDay(usuario);
        selectMonth(usuario);
        selectYear(usuario);
        inputNewsletter.click();
        inputOptin.click();
        inputFirstName.sendKeys(usuario.getFirstName());
        inputLastName.sendKeys(usuario.getLastName());
        inputCompany.sendKeys(usuario.getCompany());
        inputAddress.sendKeys(usuario.getAddress());
        inputAddress2.sendKeys(usuario.getAddress2());
        selectCountry(usuario);
        inputState.sendKeys(usuario.getState());
        inputCity.sendKeys(usuario.getCity());
        inputZipcode.sendKeys(usuario.getZipcode());
        inputMobileNumber.sendKeys(usuario.getMobileNumber());
        buttonCreateAccount.click();
    }

}