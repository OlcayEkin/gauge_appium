package pageObjects.ios;

import base.Browser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.IOSPageObjects;
import pageObjects.LoginPageObjects;

import java.util.HashMap;

import static base.BaseMethod.*;

public class ProfilePage {

    private static final Logger log = LogManager.getLogger(EmailPage.class);
    private LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());
    private AppiumDriver driver = Browser.getDriver();
    private IOSPageObjects iosPageObjects = new IOSPageObjects(Browser.getDriver());

    public void checkProfilePage(){
        waitElement(loginPageObjects.PROFILE).click();
        JavascriptExecutor js = driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("predicateString", "value == 'Log out'");
        js.executeScript("mobile: scroll", scrollObject);
        waitElement(loginPageObjects.PROFILE_LOGOUT).click();
        //driver.context("NATIVE_APP");
        TouchAction touchAction = new TouchAction(getDriver());
        touchAction.press(ElementOption.element(iosPageObjects.IOS_LOGOUT)).perform();
        Assertions.assertTrue(waitElement(loginPageObjects.PROFILE).isDisplayed());

    }
}
