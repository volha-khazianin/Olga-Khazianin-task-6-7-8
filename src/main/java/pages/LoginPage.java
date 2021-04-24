package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static String WRONG_PASSWORD_TEXT = "Warning: No match for E-Mail Address and/or Password.";
    public final By SUBMIT_INPUT_LOCATOR = By.xpath("//input[@type='submit' and @value='Login']");
    private final String LOGIN_PAGE_ADDRESS = "http://electonicstore.com/index.php?route=account/login";
    private final By LOGIN_INPUT_LOCATOR = By.xpath("//input[@id='input-email']");
    private final By PASSWORD_INPUT_LOCATOR = By.xpath("//*[@id='input-password']");
    private final By MY_ACCOUNT_LOCATOR = By.xpath("//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']");
    private final By LOGOUT_OUTPUT_LOCATOR = By.xpath("//li//a[text()='Logout']");
    private final By LOGOUT_TEXT_LOCATOR = By.xpath("//h1[text()='Account Logout']");
    private final By LOGIN_WRONG_PASSWORD_TEXT_LOCATOR = By.xpath("//div[@class='alert alert-danger alert-dismissible']");


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(LOGIN_PAGE_ADDRESS);
        return this;
    }

    public LoginPage loginInpun(String value) {
        WebElement loginField = driver.findElement(LOGIN_INPUT_LOCATOR);
        loginField.clear();
        loginField.sendKeys(value);
        return this;
    }

    public LoginPage passwordInput(String value) {
        WebElement passwordField = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordField.clear();
        passwordField.sendKeys(value);
        return this;
    }

    public LoginPage submitInput() {
        WebElement enterButton = driver.findElement(SUBMIT_INPUT_LOCATOR);
        enterButton.click();
        return this;
    }


    public LoginPage myAccount() {
        WebElement myAccount = driver.findElement(MY_ACCOUNT_LOCATOR);
        myAccount.click();
        return this;
    }

    public LoginPage logoutButton() {
        WebElement logout = driver.findElement(LOGOUT_OUTPUT_LOCATOR);
        logout.click();
        return this;
    }

    public String getWrongPasswordText() {
        return driver.findElement(LOGIN_WRONG_PASSWORD_TEXT_LOCATOR).getText();
    }

}
