package pageObjects.ios;

import base.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPageObjects;

public class HomePage {

   protected static final Logger log = LogManager.getLogger(HomePage.class);
   WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);
   LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());

   public void iAmInTheHomePage(){
      wait.until(ExpectedConditions
              .visibilityOf(loginPageObjects.LOGIN));
      Assertions.assertTrue(loginPageObjects.LOGIN.isDisplayed());
      log.info("HomePage checking is successfull");
   }

   public void checkHomePage(){
      wait.until(ExpectedConditions.visibilityOf(loginPageObjects.PROFILE));
   }
}
