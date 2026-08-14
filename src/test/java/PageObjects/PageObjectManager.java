package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private QcartPageObject loginPage;
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public QcartPageObject getLoginPage(){
        return (loginPage == null) ? new QcartPageObject(driver) : loginPage;
    }
}
