package pageObjects.ios;

import base.Browser;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        loginPageObjects.PROFILE_LOGOUT.click();
        iosPageObjects.IOS_LOGOUT.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
