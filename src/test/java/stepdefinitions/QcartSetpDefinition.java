package stepdefinitions;

import CommonUtility.ConfigFileReader;
import CommonUtility.Context;
import PageObjects.QcartPageObject;
import PageObjects.PageObjectManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.apache.log4j.*;

public class QcartSetpDefinition extends Base{
    WebDriver driver;
    QcartPageObject loginPageObject;
    PageObjectManager pageObjectManager;
    public QcartSetpDefinition(Context context){
        super(context);
        driver = context.getWebDriverController().getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPageObject = pageObjectManager.getLoginPage();
        logger = Logger.getLogger("QcartAutomation");
        LogFormat();
    }
    @Given("User launch the application")
    public void user_launch_the_application() {
        logger.info("User launch the application");
        launchApplication();
    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        logger.info("User click on the login button");
        loginPageObject.clickLoginButton();
    }
    @Then("user should be navigate to the login page")
    public void user_should_be_navigate_to_the_login_page() {
        logger.info("user should be navigate to the login page");
        Assert.assertEquals("Login",loginPageObject.getLoginTitleName());
        loginPageObject.clickBackToExploreButton();
    }

    @When("User click on the register button")
    public void userClickOnTheRegisterButton() {
        logger.info("User click on the register button");
      loginPageObject.clickRegisterButton();
    }
    @Then("user should be navigate to the register page")
    public void userShouldBeNavigateToTheRegisterPage() {
        logger.info("User click on the register button");
        Assert.assertTrue(loginPageObject.isRegisterButtonDisplayed());
        logger.info("User navigate back to the UI");
        loginPageObject.clickBackToExploreButton();
    }

    @And("Verify user is able to see search text field")
    public void verifyUserIsAbleToSeeSearchTextField() {
        logger.info("Verify user is able to see search text field");
        Assert.assertTrue(loginPageObject.isSearchFieldDisplayed());

    }

    @Then("Verify user is able to count the total number of images and link on UI")
    public void verifyUserIsAbleToCountTheTotalNumberOfImagesAndLinkOnUI() {
        loginPageObject.getImageCount();
        loginPageObject.getLinkCount();
        logger.info("Image count on UI- "+loginPageObject.getImageCount());
        logger.info("Link count on UI- "+loginPageObject.getLinkCount());
    }

    @And("Verify user is able to  see search text field placeholder")
    public void verifyUserIsAbleToSeeSearchTextFieldPlaceholder() {
       logger.info("Verify user is able to  see search text field placeholder");
       logger.info("search text field placeholder expected- Search for items/categories "+" Actual- "+loginPageObject.getSearchFieldValuePlaceHolder());
       Assert.assertEquals("Search for items/categories",loginPageObject.getSearchFieldValuePlaceHolder());
    }

    @And("Verify page title and URL contains https in URL after launching UI")
    public void verifyPageTitleAndURLContainsHttpsInURLAfterLaunchingUI() {
        logger.info("Verify page title and URL contains https in URL after launching UI");
        logger.info("page UI title expected -QKart"+"actual "+loginPageObject.getPageTitle());
        Assert.assertEquals("QKart",loginPageObject.getPageTitle());
        logger.info("Url contains https "+loginPageObject.verifyUrlContaindHttps());
        Assert.assertTrue(loginPageObject.verifyUrlContaindHttps());
    }

    @Then("Verify user is able to logged in successfully")
    public void verifyUserIsAbleToLoggedInSuccessfully() {
       logger.info("Verify user is able to looged in successfully");
       loginPageObject.sendUserName(ConfigFileReader.readConfigFile().getProperty("QKartUserName"));
       loginPageObject.sendUserPassword(ConfigFileReader.readConfigFile().getProperty("QKartPassword"));
       loginPageObject.clickOnLoginToQKartBttn();
       Assert.assertEquals("Logged in successfully",loginPageObject.getSuccessMsg());
       Assert.assertTrue(loginPageObject.isLogoutButtonDisplayed());
    }

    @Then("User should be able to register themself")
    public void userShouldBeAbleToRegisterThemself() {
        logger.info("User should be able to register themself");
        logger.info("new user ID "+ConfigFileReader.readConfigFile().getProperty("QKartRegUserName"));
        logger.info("Password provided "+ConfigFileReader.readConfigFile().getProperty("QKartRegPassword"));
        loginPageObject.sendUserName(ConfigFileReader.readConfigFile().getProperty("QKartRegUserName"));
        loginPageObject.sendUserPassword(ConfigFileReader.readConfigFile().getProperty("QKartRegPassword"));
        loginPageObject.sendConfirmPassword(ConfigFileReader.readConfigFile().getProperty("QKartRegPassword"));
        loginPageObject.clickOnRegisterNowBttn();
        Assert.assertEquals("Registered Successfully",loginPageObject.getSuccessMsg());
    }

    @And("Verify user is able to logged in successfully with new ID")
    public void verifyUserIsAbleToLoggedInSuccessfullyWithNewID() {
        logger.info("Verify user is able to logged in successfully with new ID");
        loginPageObject.sendUserName(ConfigFileReader.readConfigFile().getProperty("QKartRegUserName"));
        loginPageObject.sendUserPassword(ConfigFileReader.readConfigFile().getProperty("QKartRegPassword"));
        loginPageObject.clickOnLoginToQKartBttn();
        Assert.assertEquals("Logged in successfully",loginPageObject.getSuccessMsg());
        Assert.assertTrue(loginPageObject.isLogoutButtonDisplayed());
    }

    @And("Verify user is able to add the product in cart successfully")
    public void verifyUserIsAbleToAddTheProductInCartSuccessfully() {
        logger.info("Verify user is able to add the product in cart successfully");
        loginPageObject.clickOnYonexSmashBadmintonRacquet();
        Assert.assertTrue(loginPageObject.isCheckoutButtonDisplayed());
    }

    @And("Verify that user is not able to add same product again into cart")
    public void verifyThatUserIsNotAbleToAddSameProductAgainIntoCart() {
       logger.info("Verify that user is not able to add same product again into cart");
        loginPageObject.clickOnYonexSmashBadmintonRacquet();
        Assert.assertEquals("Item already in cart. Use the cart sidebar to update quantity or remove item.",loginPageObject.getSuccessMsg());
    }
}
