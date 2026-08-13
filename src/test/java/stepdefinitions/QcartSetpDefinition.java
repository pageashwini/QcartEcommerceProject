package stepdefinitions;

import CommonUtility.Context;
import PageObjects.LoginPageObject;
import PageObjects.PageObjectManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
public class QcartSetpDefinition extends Base{
    WebDriver driver;
    LoginPageObject loginPageObject;
    PageObjectManager pageObjectManager;
    public QcartSetpDefinition(Context context){
        super(context);
        driver = context.getWebDriverController().getDriver();
        pageObjectManager = new PageObjectManager(driver);
        loginPageObject = pageObjectManager.getLoginPage();
    }
    @Given("User launch the application")
    public void user_launch_the_application() {
        launchApplication();
    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        loginPageObject.clickLoginButton();
    }
    @Then("user should be navigate to the login page")
    public void user_should_be_navigate_to_the_login_page() {
        Assert.assertEquals("Login",loginPageObject.getLoginTitleName());
        loginPageObject.clickBackToExploreButton();
    }

    @When("User click on the register button")
    public void userClickOnTheRegisterButton() {
      loginPageObject.clickRegisterButton();
    }
    @Then("user should be navigate to the register page")
    public void userShouldBeNavigateToTheRegisterPage() {
        Assert.assertTrue(loginPageObject.isRegisterButtonDisplayed());
        loginPageObject.clickBackToExploreButton();
    }

    @And("Verify user is able to see search text field")
    public void verifyUserIsAbleToSeeSearchTextField() {
        Assert.assertTrue(loginPageObject.isSearchFieldDisplayed());

    }
}
