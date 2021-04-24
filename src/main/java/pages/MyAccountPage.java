package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    public static String MY_ACCOUNT_TITLE_TEXT = "My Account";
    public static String MY_ACCOUNT_LOGOUT_TITLE_TEXT = "Account Logout";
    private final String MY_ACCOUNT_PAGE_ADDRESS = "http://electonicstore.com/index.php?route=account/account";
    private final By MY_ACCOUNT_TITLE_TEXT_LOCATOR = By.xpath("//h2[1]");
    private final By LOGOUT_TEXT_LOCATOR = By.xpath("//h1[text()='Account Logout']");

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage open() {
        driver.get(MY_ACCOUNT_PAGE_ADDRESS);
        return this;
    }

    public String getMyAccountTitleText() {
        return driver.findElement(MY_ACCOUNT_TITLE_TEXT_LOCATOR).getText();
    }

    public String getLogoutTextTitle() {
        return driver.findElement(LOGOUT_TEXT_LOCATOR).getText();
    }
}
