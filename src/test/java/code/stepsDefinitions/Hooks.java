package code.stepsDefinitions;

import code.pages.OrangeHRMLogin;
import code.utils.BrowserUtils;
import code.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BrowserUtils {
    private static final Logger logger = Logger.getLogger(Hooks.class);
    @Before //This will run before each run
    public void setup(){
        Driver.getDriver();
        logger.info("Driver is successfully started");
        // setWaitTime();
        Driver.getDriver().manage().window().maximize();


    }
    @After //This will run after each run
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            byte[] data=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        //Driver.closeDriver();
    }

    //We have hooks class because we need to have pre-setup of scenarios and closing driver. We have to have it
    //under stepsDefintions package so that we dont need to extend it to any other class. Since cucumber is present class/
    //Cucumber will automatically detect it.


}


/*
package code.stepsDefinitions;

import code.pages.OrangeHRMLogin;
import code.utils.BrowserUtils;
import code.utils.Driver;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BrowserUtils { // hooks import etmene gerek bunu zaten stepsdefinaitoon icinde tanicak
    // burdada kullandik logger i
    private static final org.apache.log4j.Logger logger = Logger.getLogger(Hooks.class);

    @Before //This will run before each run
    public void setup() {
        Driver.getDriver();
        logger.info("Driver is succesfully started ");
        setWaitTime();
        Driver.getDriver().manage().window().maximize();


    }

    @After //This will run after each run
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
 */