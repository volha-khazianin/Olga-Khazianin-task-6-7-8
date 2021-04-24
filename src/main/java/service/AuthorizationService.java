package service;

import data.Account;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;

public class AuthorizationService {

    public static LoginPage loginAccount(WebDriver driver, Account account) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.open().
                loginInpun(account.getEmail()).
                passwordInput(account.getPassword()).
                submitInput();
    }

    public static LoginPage loginWrongEmail(WebDriver driver, Account account) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.open().
                loginInpun("1" + account.getEmail())
                .passwordInput(account.getPassword())
                .submitInput();
    }

    public static LoginPage loginWrongPassword(WebDriver driver, Account account) {
        LoginPage loginPage = new LoginPage(driver);
        return loginPage.open()
                .loginInpun(account.getEmail())
                .passwordInput(account.getPassword() + "1")
                .submitInput();
    }

    public static LoginPage logoutAccount(WebDriver driver) {
        LoginPage logout = new LoginPage(driver);
        return logout.myAccount()
                .logoutButton();
    }

    public static RegistrationPage RegistrationAccount(WebDriver driver, Account acount) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputFirstNameValue(acount.getFirstName())
                .inputLastNameValue(acount.getLastName())
                .inputEmailValue(acount.getEmail())
                .inputPhoneNumber(acount.getPhoneNumber())
                .inputPassword(acount.getPassword())
                .inputPasswordConfirm(acount.getPassword())
                .clickCheckboxAgree()
                .clickContinueButton();
    }

    public static RegistrationPage RegistrationEmptyFirstName(WebDriver driver, Account account) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputLastNameValue(account.getLastName())
                .inputEmailValue(account.getEmail())
                .inputPhoneNumber(account.getPhoneNumber())
                .inputPassword(account.getPassword())
                .inputPasswordConfirm(account.getPassword())
                .clickCheckboxAgree()
                .clickContinueButton();
    }

    public static RegistrationPage RegistrationEmptyLastName(WebDriver driver, Account acount) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputFirstNameValue(acount.getFirstName())
                .inputEmailValue(acount.getEmail())
                .inputPhoneNumber(acount.getPhoneNumber())
                .inputPassword(acount.getPassword())
                .inputPasswordConfirm(acount.getPassword())
                .clickCheckboxAgree()
                .clickContinueButton();
    }

    public static RegistrationPage RegistrationEmptyEmail(WebDriver driver, Account acount) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputFirstNameValue(acount.getFirstName())
                .inputLastNameValue(acount.getLastName())
                .inputPhoneNumber(acount.getPhoneNumber())
                .inputPassword(acount.getPassword())
                .inputPasswordConfirm(acount.getPassword())
                .clickCheckboxAgree()
                .clickContinueButton();
    }

    public static RegistrationPage RegistrationEmptyTelephone(WebDriver driver, Account acount) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputFirstNameValue(acount.getFirstName())
                .inputLastNameValue(acount.getLastName())
                .inputEmailValue(acount.getEmail())
                .inputPassword(acount.getPassword())
                .inputPasswordConfirm(acount.getPassword())
                .clickCheckboxAgree()
                .clickContinueButton();
    }

    public static RegistrationPage RegistrationEmptyPassword(WebDriver driver, Account acount) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        return registrationPage.open()
                .inputFirstNameValue(acount.getFirstName())
                .inputLastNameValue(acount.getLastName())
                .inputEmailValue(acount.getEmail())
                .inputPhoneNumber(acount.getPhoneNumber())
                .clickCheckboxAgree()
                .clickContinueButton();
    }
}
