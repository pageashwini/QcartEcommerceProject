package CommonUtility;

import org.openqa.selenium.WebDriver;

public class Context {
    public WebDriverController webDriverController;
    public WebDriverController getWebDriverController(){
        return  (webDriverController == null) ?webDriverController=new WebDriverController():webDriverController;
    }
}
