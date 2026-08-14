package CommonUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utility {
    public static void closeBrowser() throws Exception{
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
    }
    public static void scrollDownByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void scrollUpByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
    }
}
