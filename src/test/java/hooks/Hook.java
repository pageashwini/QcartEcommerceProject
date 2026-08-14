package hooks;

import CommonUtility.Utility;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.io.File;

public class Hook {

    @BeforeAll
    public static void deleteExistingLogFile() {

        String logFilePath = "logs/automation.log";

        File logFile = new File(logFilePath);

        if (logFile.exists()) {

            if (logFile.delete()) {
                System.out.println("Existing log file deleted successfully.");
            } else {
                System.out.println("Unable to delete existing log file.");
            }

        } else {

            System.out.println("Log file does not exist. Starting fresh.");
        }
    }
    @AfterAll
    public static void closeDriver() throws Exception{
        //Utility.closeBrowser();
    }
}