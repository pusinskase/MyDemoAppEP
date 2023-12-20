package Tests;

import Pages.Base;

import Pages.LoginPage;
import Pages.SortTestPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ProdSortTest extends Base {


    @Test
    public void testProductSorting() {
        SortTestPage sortTestPage = new SortTestPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin("bob@example.com", "10203040");
        sortTestPage.productsSortingNameAsc();
        assertTrue(sortTestPage.isListSortedAsc());
        sortTestPage.productsSortingNameDesc();
        assertTrue(sortTestPage.isListSortedDesc());
        sortTestPage.productsSortedByPriceAsc();
        assertTrue(sortTestPage.isVerifyProductSortedByPriceAsc());
        sortTestPage.productsSortedByPriceDesc();
        assertTrue(sortTestPage.isVerifyProductSortedByPriceDesc());
        loginPage.performLogout();
    }
}




