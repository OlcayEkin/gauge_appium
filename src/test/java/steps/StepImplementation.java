package steps;

import base.Browser;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IOSPageObjects;
import pageObjects.LoginPageObjects;

import java.util.HashMap;

public class StepImplementation {
    protected static final Logger log = LogManager.getLogger(StepImplementation.class);
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
    LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());
    IOSPageObjects iosPageObjects = new IOSPageObjects(Browser.getDriver());
    AppiumDriver driver = Browser.getDriver();


    @Step("I am in the home page")
    public void waitHomePage() {
        wait.until(ExpectedConditions
                .visibilityOf(loginPageObjects.LOGIN));
        Assertions.assertTrue(loginPageObjects.LOGIN.isDisplayed());
    }

    @Step("I want to use my email")
    public void emailSection() {
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.LOGIN)).click();
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL));
        if (Browser.isAndroid.equals(false))
            wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL)).click();
    }

    @Step("Set my personal email <table>")
    public void setEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_TEXTAREA)).sendKeys(mail);
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_NEXT)).click();
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_CONTINUE)).click();
    }

    @Step("Set my personal password <password>")
    public void setPass(String pass) {
        String[] digits = pass.split("");
        for (int i = 0; i < digits.length; i++) {
            String var = digits[i];
            String path = String.format("//XCUIElementTypeButton[@name='%s']", var);
            driver.findElement(By.xpath(path)).click();
        }

    }

    @Step("I expect to see the home page")
    public void chekHomePage() {
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.PROFILE));
    }

    @Step("Check the profile page")
    public void checkProfilePage() {
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
