package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects extends PageFactory{

    public LoginPageObjects(AppiumDriver<MobileElement>driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidBy(id = "app.beamuae.stg:id/alternatives")
    @iOSXCUITFindBy(id = "Beam")
    public MobileElement LOGIN;

    @AndroidBy(id = "app.beamuae.stg:id/entry")
    @iOSXCUITFindBy(id = "Email")
    public MobileElement EMAIL;

    @AndroidBy(id = "app.beamuae.stg:id/entry")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Beam STG\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement EMAIL_TEXTAREA;

    @iOSXCUITFindBy(id = "Next")
    public MobileElement EMAIL_NEXT;

    @iOSXCUITFindBy(id = "Continue to log in")
    public MobileElement EMAIL_CONTINUE;

    @iOSXCUITFindBy(id = "profile")
    public MobileElement PROFILE;

    @iOSXCUITFindBy(id = "ProfileImage")
    public MobileElement PROFILE_IMAGE;

    @iOSXCUITFindBy(id = "Log out")
    public MobileElement PROFILE_LOGOUT;

}
