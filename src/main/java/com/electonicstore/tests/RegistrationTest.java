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
import pages.RegistrationPage;
import service.AuthorizationService;

public class RegistrationTest {

    private static WebDriver driver = null;

    private Account accountForRegistration= AccountFactory.getAccountForRegistration();

    @BeforeClass
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 10)
    public void RegistrationTest() throws InterruptedException {
        String titleValue = AuthorizationService.RegistrationAccount(driver, accountForRegistration).getSuccessRegistrationTitleText();
        Assert.assertEquals(titleValue, RegistrationPage.SUCCESS_TITLE_TEXT, "Testing of the registration is failed");
    }
    @Test(priority = 1)
    public void RegistrationEmptyFirstName() throws InterruptedException{
        String titleValue = AuthorizationService.RegistrationEmptyFirstName(driver,accountForRegistration).getAlertTextEmptyFirstname();
        Assert.assertEquals(titleValue,RegistrationPage.ALERT_TEXT_EMPTY_FIRSTNAME, "Testing of the registration with empty First Name field is failed" );
    }

    @Test(priority = 2)
    public void RegistrationEmptyLastName() throws InterruptedException{
        String titleValue = AuthorizationService.RegistrationEmptyLastName(driver, accountForRegistration).getAlertTextEmptyLastname();
        Assert.assertEquals(titleValue, RegistrationPage.ALERT_TEXT_EMPTY_LASTNAME, "Testing of the registration with empty Last Name field is failed" );
    }

    @Test(priority = 3)
    public void RegistrationEmptyEmail() throws InterruptedException{
        String titleValue = AuthorizationService.RegistrationEmptyEmail(driver, accountForRegistration).getAlertTextEmptyEmail();
        Assert.assertEquals(titleValue, RegistrationPage.ALERT_TEXT_EMPTY_EMAIL, "Testing of the registration with empty Email field is failed" );
    }

    @Test(priority = 4)
    public void RegistrationEmptyTelephone() throws InterruptedException{
        String titleValue = AuthorizationService.RegistrationEmptyTelephone(driver, accountForRegistration).getAlertTextEmptyTelephone();
        Assert.assertEquals(titleValue, RegistrationPage.ALERT_TEXT_EMPTY_TELEPHONE, "Testing of the registration with empty Telephone field is failed");
    }

    @Test(priority = 5)
    public void RegistrationEmptyPassword() throws InterruptedException{
        String titleValue = AuthorizationService.RegistrationEmptyPassword(driver, accountForRegistration).getAlertTextEmptyPassword();
        Assert.assertEquals(titleValue,RegistrationPage.ALERT_TEXT_EMPTY_PASSWORD, "Testing of the registration with empty Password field is failed" );
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


}
