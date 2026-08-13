package CommonUtility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public static Properties property;
    private final static String propertyfilePath ="src//test//java//tests//Configuration.properties";

    public static Properties readConfigFile(){
        BufferedReader reader;
        try{
            if(property == null){
                reader = new BufferedReader(new FileReader(propertyfilePath));
                property = new Properties();
                try{
                    property.load(reader);
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return property;
    }

    public static String getDriverPathChrome(){
        String driverPath2;
        driverPath2= readConfigFile().getProperty("driverPathChrome");
        System.out.println("Path "+driverPath2);
        return driverPath2;

    }

}
