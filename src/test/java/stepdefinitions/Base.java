package stepdefinitions;
import CommonUtility.ConfigFileReader;
import CommonUtility.Constant;
import CommonUtility.Context;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Base {
    protected WebDriver driver;
    protected Context context;
    public Base(Context context){
        this.context = context;
        driver = context.getWebDriverController().getDriver();
    }
 public void launchApplication(){
        //used to extecue scripts on different environment
     String env = ConfigFileReader.readConfigFile().getProperty("environment");
     switch(env){
         case "SIT":
             driver.get(ConfigFileReader.readConfigFile().getProperty("baseUrl"));
             break;
     }
 }
}
