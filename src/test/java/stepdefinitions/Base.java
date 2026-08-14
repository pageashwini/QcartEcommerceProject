package stepdefinitions;
import CommonUtility.ConfigFileReader;
import CommonUtility.Constant;
import CommonUtility.Context;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.apache.log4j.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Base {
    protected WebDriver driver;
    protected Context context;
    public static Logger logger;
    public Base(Context context){
        this.context = context;
        driver = context.getWebDriverController().getDriver();
        logger = Logger.getLogger("QcartAutomation script");
        DOMConfigurator.configure("log4j.xml");
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
 public static void LogFormat(){
        logger.info("=============================================");
 }
}
