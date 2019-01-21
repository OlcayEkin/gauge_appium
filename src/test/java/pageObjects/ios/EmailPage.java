package pageObjects.ios;

import base.Browser;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPageObjects;

public class EmailPage {

    protected static final Logger log = LogManager.getLogger(HomePage.class);
    WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
    LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());
    AppiumDriver driver = Browser.getDriver();

    public void emailSection(){
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.LOGIN)).click();
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL));
        if (Browser.isAndroid.equals(false))
            wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL)).click();
        log.info("Email section is successfull");
    }

    public void setEmail(String mail){
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_TEXTAREA)).sendKeys(mail);
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_NEXT)).click();
        wait.until(ExpectedConditions.visibilityOf(loginPageObjects.EMAIL_CONTINUE)).click();
    }

    public void setPass(String pass){
        String[] digits = pass.split("");
        for (int i = 0; i < digits.length; i++) {
            String var = digits[i];
            String path = String.format("//XCUIElementTypeButton[@name='%s']", var);
            driver.findElement(By.xpath(path)).click();
        }
    }
}
