package PageObjects;

import CommonUtility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QcartPageObject {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public QcartPageObject(WebDriver driver) {
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

    public String getSearchFieldValuePlaceHolder() {
        return searchField.getAttribute("placeholder");
    }
    @FindBy(tagName = "img")
    List<WebElement> imagesCount;
    public int getImageCount(){
        return imagesCount.size();
    }
    @FindBy(tagName = "a")
    List<WebElement> linkCount;
    public int getLinkCount(){
        return linkCount.size();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyUrlContaindHttps(){
        return driver.getCurrentUrl().split(":")[0].equals("https");
    }
    @FindBy(xpath="//input[@name='username']")
    WebElement userName;
    public void sendUserName(String name){
        userName.sendKeys(name);
    }

    @FindBy(xpath="//input[@name='password']")
    WebElement userPassword;
    public void sendUserPassword(String password){
        userPassword.sendKeys(password);
    }

    @FindBy(xpath="//button[text()='Login to QKart']")
    WebElement loginToQKartBttn;
    public void clickOnLoginToQKartBttn() {
        loginToQKartBttn.click();

    }
    @FindBy(xpath="//div[@id=\"notistack-snackbar\"]")
    WebElement successMsg;
    public String getSuccessMsg() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOf(successMsg));
        String test = msg.getText();
        return test;
    }

    @FindBy(xpath="//button[text()='Logout']")
    WebElement logoutButton;
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPassword;
    public void sendConfirmPassword(String password){
        confirmPassword.sendKeys(password);
    }

    @FindBy(xpath="//button[text()='Register Now']")
    WebElement registerNowBttn;
    public void clickOnRegisterNowBttn() {
        registerNowBttn.click();
    }

    @FindBy(xpath="//p[text()='YONEX Smash Badminton Racquet']/following::button[1]")
    WebElement yonexSmashBadmintonRacquet;
    public void clickOnYonexSmashBadmintonRacquet() {
        Utility.scrollDownByJS(driver);
        yonexSmashBadmintonRacquet.click();
    }

    @FindBy(xpath="//button[text()='Checkout']")
    WebElement checkoutButton;
    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }
    public boolean isCheckoutButtonDisplayed() {
        Utility.scrollUpByJS(driver);
        return checkoutButton.isDisplayed();
    }

    @FindBy(xpath="//p[text()='Roadster Mens Running Shoes']/following::select[1]")
    WebElement selectSHoeSize;
    public void clickOnSelectSHoeSize() {
        Select sizeDropdown = new Select(selectSHoeSize);
        sizeDropdown.selectByValue("8");
    }
}

