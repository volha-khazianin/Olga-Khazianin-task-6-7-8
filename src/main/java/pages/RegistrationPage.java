package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public static final String SUCCESS_TITLE_TEXT = "Your Account Has Been Created!";
    public static final String ALERT_TEXT_EMPTY_FIRSTNAME = "First Name must be between 1 and 32 characters!";
    public static final String ALERT_TEXT_EMPTY_LASTNAME = "Last Name must be between 1 and 32 characters!";
    public static final String ALERT_TEXT_EMPTY_EMAIL = "E-Mail Address does not appear to be valid!";
    public static final String ALERT_TEXT_EMPTY_TELEPHONE ="Telephone must be between 3 and 32 characters!";
    public static final String ALERT_TEXT_EMPTY_PASSWORD ="Password must be between 4 and 20 characters!";

    private final String registrationPageAddress = "http://electonicstore.com/index.php?route=account/register";
    WebDriver driver;
    @FindBy(xpath = "//input[@name='firstname' and @class='form-control']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name = 'lastname' and @class = 'form-control']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name = 'email' and @class='form-control']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='telephone' and @class='form-control']")
    private WebElement phoneNumberInput;
    @FindBy(xpath = "//input[@name='password' and @class='form-control']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name = 'confirm' and @class = 'form-control']")
    private WebElement passwordConfirmInput;
    @FindBy(xpath = "//input[@name='agree' and @type ='checkbox']")
    private WebElement checkboxAgree;
    @FindBy(xpath = "//input[@type='submit' and @value ='Continue']")
    private WebElement continueButton;

    private By successTitleLocator = By.xpath("//*[@id = 'content']/h1[1]");
    private By emptyFirstNameLocator = By.xpath("//fieldset[@id='account']/div[2]/div/div");
    private By emptyLastNameLocator = By.xpath("//fieldset[@id='account']/div[3]/div/div");
    private By emptyEmailLocator = By.xpath("//fieldset[@id='account']/div[4]/div/div");
    private By emptyTelephoneLocator = By.xpath("//fieldset[@id='account']/div[5]/div/div");
    private By emptyPasswordLocator = By.xpath("//fieldset[2]/div[1]/div/div");
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public RegistrationPage open() {
        driver.get(registrationPageAddress);
        return this;
    }

    public RegistrationPage inputFirstNameValue(String value) {
        firstNameInput.clear();
        firstNameInput.sendKeys(value);
        return this;
    }

    public RegistrationPage inputLastNameValue(String value) {
        lastNameInput.clear();
        lastNameInput.sendKeys(value);
        return this;
    }

    public RegistrationPage inputEmailValue(String value) {
        emailInput.clear();
        emailInput.sendKeys(value);
        return this;
    }

    public RegistrationPage inputPhoneNumber(String value) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(value);
        return this;
    }

    public RegistrationPage inputPassword(String value) {
        passwordInput.clear();
        passwordInput.sendKeys(value);
        return this;
    }

    public RegistrationPage inputPasswordConfirm(String value) {
        passwordConfirmInput.clear();
        passwordConfirmInput.sendKeys(value);
        return this;
    }

    public RegistrationPage clickCheckboxAgree() {
        checkboxAgree.click();
        return this;
    }

    public RegistrationPage clickContinueButton() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        continueButton.click();
        return this;
    }

    public String getSuccessRegistrationTitleText() {
        return driver.findElement(successTitleLocator).getText();
    }

    public String getAlertTextEmptyFirstname(){
        return driver.findElement(emptyFirstNameLocator).getText();
    }

    public String getAlertTextEmptyLastname(){
        return driver.findElement(emptyLastNameLocator).getText();
    }

    public String getAlertTextEmptyEmail(){
        return driver.findElement(emptyEmailLocator).getText();
    }

    public String getAlertTextEmptyTelephone(){
        return driver.findElement(emptyTelephoneLocator).getText();
    }

    public String getAlertTextEmptyPassword(){
        return driver.findElement(emptyPasswordLocator).getText();
    }
}
