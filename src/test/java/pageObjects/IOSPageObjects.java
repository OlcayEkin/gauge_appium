package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class IOSPageObjects {

    public IOSPageObjects(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @iOSBy(id = "Allow")
    public MobileElement PERMISSION_ALLOW;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log out']")
    public MobileElement IOS_LOGOUT;

}
