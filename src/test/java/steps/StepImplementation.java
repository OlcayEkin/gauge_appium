package steps;

import com.thoughtworks.gauge.Step;
import pageObjects.ios.EmailPage;
import pageObjects.ios.HomePage;
import pageObjects.ios.ProfilePage;

public class StepImplementation {

    @Step("I am in the home page")
    public void waitHomePage() {
        new HomePage().iAmInTheHomePage();
    }

    @Step("I want to use my email")
    public void emailSection() {
        new EmailPage().emailSection();
    }

    @Step("Set my personal email <table>")
    public void setEmail(String mail) {
        new EmailPage().setEmail(mail);
    }

    @Step("Set my personal password <password>")
    public void setPass(String pass) {
        new EmailPage().setPass(pass);
    }

    @Step("I expect to see the home page")
    public void checkHomePage() {
        new HomePage().checkHomePage();
    }

    @Step("Check the profile page")
    public void checkProfilePage() {
        new ProfilePage().checkProfilePage();
    }
}
