import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature",
        glue = "stepdefinitions",
        tags ="@run",
        monochrome=true,
        plugin = {
               "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
               // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        }

)
public class MainTestRunner {
}