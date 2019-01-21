package pageObjects.ios;

import base.Browser;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import pageObjects.LoginPageObjects;

import static base.BaseMethod.waitElement;

public class EmailPage {

    private static final Logger log = LogManager.getLogger(EmailPage.class);
    private LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());
    private AppiumDriver driver = Browser.getDriver();

    public void emailSection(){
        waitElement(loginPageObjects.LOGIN).click();
        waitElement(loginPageObjects.EMAIL);
        if (Browser.isAndroid.equals(false))
            waitElement(loginPageObjects.EMAIL).click();
        log.info("Email section is successfull");
    }

    public void setEmail(String mail){
        waitElement(loginPageObjects.EMAIL_TEXTAREA).sendKeys(mail);
        waitElement(loginPageObjects.EMAIL_NEXT).click();
        waitElement(loginPageObjects.EMAIL_CONTINUE).click();
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
