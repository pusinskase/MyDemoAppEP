package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {

    private final WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void performLogin(String username, String password) {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();

        WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void performLogout() {
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log Out\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"LOG OUT\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"OK\")")).click();

        WebElement usernameField = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        WebElement passwordField = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        usernameField.clear();
        passwordField.clear();
    }

    public boolean isProductsPageDisplayed() {
        WebElement productsPage = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Products\")")));
        return productsPage.isDisplayed();
    }

    public boolean isEmptyPasswordMessageDisplayed() {
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Password is required\")")));
        return errorMessage.isDisplayed();
    }

    public boolean isInvalidCredentialsDisplayed() {
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Provided credentials do not match any user in this service.\")")));
        return errorMessage.isDisplayed();
    }
    public boolean isLockedOutUserDisplayed() {
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Sorry, this user has been locked out.\")")));
        return errorMessage.isDisplayed();
    }
}




