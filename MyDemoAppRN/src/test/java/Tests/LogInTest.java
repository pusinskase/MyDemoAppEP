package Tests;

import Pages.Base;
import Pages.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInTest extends Base  {

    @Test(priority = 1)
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("bob@example.com", "10203040");
        assertTrue(loginPage.isProductsPageDisplayed());
        loginPage.performLogout();
    }

    @Test(priority = 2)
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("bob@example.com", "");
        assertTrue(loginPage.isEmptyPasswordMessageDisplayed());
        loginPage.performLogout();
    }

    @Test(priority = 3)
    public void testInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("bob@example", "1020304");
        assertTrue(loginPage.isInvalidCredentialsDisplayed());
        loginPage.performLogout();
    }

    @Test(priority = 4)
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("alice@example.com", "10203040");
        assertTrue(loginPage.isLockedOutUserDisplayed());
        loginPage.performLogout();
    }


}


