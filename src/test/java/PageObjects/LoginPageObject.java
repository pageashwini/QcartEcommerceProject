package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class=\"css-vb6e92\"]//button[text()='Login']")
    WebElement loginButton;
    public void clickLoginButton() {
        loginButton.click();
    }

   @FindBy(xpath="//h2[text()='Login']")
   WebElement loginTitleName;
    public String getLoginTitleName() {
        return loginTitleName.getText();
    }

    @FindBy(xpath="//*/button[text()=\"Back to explore\"]")
    WebElement backToExploreButton;
    public void clickBackToExploreButton() {
        backToExploreButton.click();
    }

    @FindBy(xpath="//*/button[text()=\"Register\"]")
    WebElement registerButton;
    public void clickRegisterButton() {
        registerButton.click();
    }

    @FindBy(xpath="//button[text()='Register Now']")
    WebElement registerNowButton;
    public void clickRegisterNowButton() {
            registerNowButton.click();
    }

    public boolean isRegisterButtonDisplayed() {
        return registerNowButton.isDisplayed();
    }
    @FindBy(xpath="(//input[@name=\"search\" and @type=\"text\"])[1]")
    WebElement searchField;
    public String getSearchField() {
        return searchField.getText();
    }
    public boolean isSearchFieldDisplayed() {
        return searchField.isDisplayed();
    }
}

