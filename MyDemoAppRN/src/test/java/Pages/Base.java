package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    public static AppiumDriver driver;


    @BeforeTest


    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("appium:app", "C:/Users/Student-Day-1/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceReadyTimeout", 15);
        capabilities.setCapability("appium:udid", "emulator-5556");
        capabilities.setCapability("appium:appWaitForLaunch", false);
        capabilities.setCapability("appium:adbExecTimeout", 30000);

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();

        }
    }
}


