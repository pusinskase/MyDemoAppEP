package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SortTestPage extends Base {

    private final WebDriverWait wait;

    public SortTestPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void productsSortingNameAsc() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Products\")")));
        WebElement sortProductsButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("sort button")));
        sortProductsButton.click();

        WebElement chooseSortingOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("nameAsc")));
        chooseSortingOption.click();
    }


    public static boolean isListSortedAsc() {
        List<String> listOfTitles = new ArrayList<>();

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]"));
        for (WebElement element : elements) {
            listOfTitles.add(element.getText());
        }

        boolean isSorted = true;
        for (int i = 0; i < listOfTitles.size() - 1; i++) {
            if (listOfTitles.get(i).compareTo(listOfTitles.get(i + 1)) > 0) {
                isSorted = false;
                break;
            }
        }

        System.out.println("First element: " + listOfTitles.get(0));
        return isSorted;
    }

    public void productsSortingNameDesc() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Products\")")));
        WebElement sortProductsButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("sort button")));
        sortProductsButton.click();

        WebElement chooseSortingOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("nameDesc")));
        chooseSortingOption.click();
    }

    public static boolean isListSortedDesc() {
        List<String> listOfTitles = new ArrayList<>();

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]"));
        for (WebElement element : elements) {
            listOfTitles.add(element.getText());
        }

        boolean isSorted = true;
        for (int i = 0; i < listOfTitles.size() - 1; i++) {
            if (listOfTitles.get(i).compareTo(listOfTitles.get(i + 1)) < 0) {
                isSorted = false;
                break;
            }
        }

        System.out.println("First element: " + listOfTitles.get(0));
        return isSorted;
    }

    public void productsSortedByPriceAsc() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Products\")")));
        WebElement sortProductsButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("sort button")));
        sortProductsButton.click();

        WebElement chooseSortingOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("priceAsc")));
        chooseSortingOption.click();
    }

    public static boolean isVerifyProductSortedByPriceAsc() {
        List<String> listOfPrices = new ArrayList<>();

        List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item price\"]"));
        for (WebElement element : elements) {
            String price = element.getText().replaceAll("\\$", ""); // Replace '$' with an empty string
            listOfPrices.add(price);
        }

        boolean isSorted = true;
        for (int i = 0; i < listOfPrices.size() - 1; i++) {

            double price1 = Double.parseDouble(listOfPrices.get(i).replace("$", ""));
            double price2 = Double.parseDouble(listOfPrices.get(i + 1).replace("$", ""));

            if (price1 > price2) {
                isSorted = false;
                break;
            }
        }
        System.out.println("First element: " + listOfPrices.get(0));
        return isSorted;
    }

            public void productsSortedByPriceDesc () {
                wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Products\")")));
                WebElement sortProductsButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("sort button")));
                sortProductsButton.click();

                WebElement chooseSortingOption = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("priceDesc")));
                chooseSortingOption.click();
            }

            public static boolean isVerifyProductSortedByPriceDesc () {
                List<String> listOfPrices = new ArrayList<>();

                List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item price\"]"));
                for (WebElement element : elements) {
                    String price = element.getText().replaceAll("\\$", ""); // Replace '$' with an empty string
                    listOfPrices.add(price);
                }

                boolean isSorted = true;
                for (int i = 0; i < listOfPrices.size() - 1; i++) {

                    double price1 = Double.parseDouble(listOfPrices.get(i).replace("$", ""));
                    double price2 = Double.parseDouble(listOfPrices.get(i + 1).replace("$", ""));

                    if (price1 < price2) {
                        isSorted = false;
                        break;
                    }
                }
                System.out.println("First element: " + listOfPrices.get(0));
                return isSorted;
            }
        }

















