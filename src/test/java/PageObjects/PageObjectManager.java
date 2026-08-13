package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPageObject loginPage;
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public LoginPageObject getLoginPage(){
        return (loginPage == null) ? new LoginPageObject(driver) : loginPage;
    }
}
