package CommonUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

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
            ChromeOptions options = new ChromeOptions();
            System.setProperty(Constant.CHROME_DRIVER_PROPERTY,ConfigFileReader.getDriverPathChrome());
            //System.setProperty(Constant.CHROME_DRIVER_PROPERTY,"src/test/resources/drivers/chromedriver.exe");
            Map<String, Object> prefs = new HashMap<>();

            // Disable Chrome password manager
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            // Disable "Change your password" / password leak popup
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}

