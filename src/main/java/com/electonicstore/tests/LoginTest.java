package com.electonicstore.tests;

import data.Account;
import data.AccountFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import service.AuthorizationService;

public class LoginTest {

    private static WebDriver driver = null;

    private Account accountForLogin = AccountFactory.getAccountForLogin();


    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginAccountTest() throws InterruptedException {
        AuthorizationService.loginAccount(driver, accountForLogin);
        MyAccountPage myAccount = new MyAccountPage(driver);
        String titleValue = myAccount.getMyAccountTitleText();
        Assert.assertEquals(titleValue, MyAccountPage.MY_ACCOUNT_TITLE_TEXT, "Testing of logging with valid data is failed");
    }

    @Test(priority = 2)
    public void logOutTest() throws InterruptedException {
        AuthorizationService.logoutAccount(driver);
        MyAccountPage myAccount = new MyAccountPage(driver);
        String titleValue = myAccount.getLogoutTextTitle();
        Assert.assertEquals(titleValue, MyAccountPage.MY_ACCOUNT_LOGOUT_TITLE_TEXT, "Testing of logout is failed");
    }

    @Test(priority = 3)
    public void LoginWrongPassword() throws InterruptedException {
        AuthorizationService.loginWrongPassword(driver, accountForLogin);
        LoginPage loginPage = new LoginPage(driver);
        String titleValue = loginPage.getWrongPasswordText();
        Assert.assertEquals(titleValue, LoginPage.WRONG_PASSWORD_TEXT, "Testing of logging with wrong password is failed");
    }

    @Test(priority = 4)
    public void LoginWrongEmail() throws InterruptedException {
        AuthorizationService.loginWrongEmail(driver, accountForLogin);
        LoginPage loginPage = new LoginPage(driver);
        String titleValue = loginPage.getWrongPasswordText();
        Assert.assertEquals(titleValue, LoginPage.WRONG_PASSWORD_TEXT, "Testing of logging with wrong email is failed");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}