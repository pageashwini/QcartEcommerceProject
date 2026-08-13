package CommonUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverController {
    WebDriver driver;
    public WebDriver getDriver() {
        if(driver == null) {
            try {
                driver = createLocalDriver();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
    public WebDriver createLocalDriver(){
        String browser=ConfigFileReader.readConfigFile().getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(Constant.CHROME_DRIVER_PROPERTY,ConfigFileReader.getDriverPathChrome());
            //System.setProperty(Constant.CHROME_DRIVER_PROPERTY,"src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}

