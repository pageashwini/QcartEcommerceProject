import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = {"stepdefinitions",
         "hooks"},
        tags ="@scenario2",
        monochrome=true,
        plugin = {
               //"pretty",
                //"html:target/cucumber-report.html",
               // "json:target/cucumber-report.json",
               "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        }

)
public class MainTestRunner {
        /*
        @BeforeClass
        public void deleteLog(){
                File file =new File("logs/automation.log");
                if(file.delete()){
                        System.out.println("Log deleted successfully");
                }else{
                        System.out.println("Failed to delete log");
                }
        }
        */

}