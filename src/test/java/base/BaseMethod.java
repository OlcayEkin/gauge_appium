package base;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethod extends Browser{
    public static WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 10);

    public static MobileElement waitElement(MobileElement element){
        return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
    }
}
