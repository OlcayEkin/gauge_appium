package pageObjects.ios;

import base.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LoginPageObjects;

import static base.BaseMethod.waitElement;
import static org.junit.jupiter.api.Assertions.*;

public class HomePage {

   private static final Logger log = LogManager.getLogger(EmailPage.class);
   private LoginPageObjects loginPageObjects = new LoginPageObjects(Browser.getDriver());

   public void iAmInTheHomePage(){
      waitElement(loginPageObjects.LOGIN);
      assertTrue(loginPageObjects.LOGIN.isDisplayed());
      log.info("HomePage checking is successfull");
   }

   public void checkHomePage(){
      waitElement(loginPageObjects.PROFILE);
   }
}
