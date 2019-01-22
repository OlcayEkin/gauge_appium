package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static AppiumDriver driver;
    public static String appPackage = "app.beamuae.stg";
    public static String appActivity = "com.beamwallet.home.HomeActivity";
    public String bundleId = "app.beamuae.stg";
    public static Boolean isAndroid = false;


    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(isAndroid) {
            capabilities.setCapability("BROWSER_NAME", "Android");
            capabilities.setCapability("VERSION","8.1.0");
            capabilities.setCapability("deviceName","emulator");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
        }else{
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("platformVersion","11.2.1");
            capabilities.setCapability("deviceName","iPhone8");
            capabilities.setCapability("udid","a17767370e84fba960142a7d4d2e0e11c2b41299");
            capabilities.setCapability("clearSystemFiles","true");
            capabilities.setCapability("bundleId", bundleId);
        }
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    @BeforeScenario
    public void setUpSettings(){
        try {
            setUp();
        } catch (MalformedURLException e) {
            Assertions.fail("Fail due to the appium server error");
        }
    }

    @AfterScenario
    public static void tearDown(){
        getDriver().quit();
    }

}
