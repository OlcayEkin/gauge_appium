package pageObjects.ios;

import base.Browser;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IOSPageObjects;
import pageObjects.LoginPageObjects;

import java.util.HashMap;

public class ProfilePage {

    protected static final Logger log = LogManager.getLogger(HomePage.class);
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
    LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());
    IOSPageObjects iosPageObjects = new IOSPageObjects(Browser.getDriver());
    AppiumDriver driver = Browser.getDriver();

    public void checkProfilePage(){
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.PROFILE)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap<>();
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
