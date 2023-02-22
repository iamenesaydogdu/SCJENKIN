package code.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( // wrong olan yanlis olan senryonu sadece run edicektir failedRunner .. // wrong olanlar reun.txt yazilcak otomatik olarak
        features ="@target/rerun.txt" ,
        glue ="code/stepsDefinitions",
        //tags ="@Smoke",  unutma failed seneryoda icin tags koymuyoruz
        dryRun = false ,
        plugin = {
                "pretty" ,
                "rerun:target/rerun.txt",
                //we can run them from FailedRunner class.
                //Rerun logic in Failed runner will help us to rerun failed scenarios after running failed scenarios from TestRunner class
                "html:target/default-cucumber-reports.html",
                "json:target/cucumber.json",



        }
)



public class FailedRunner {

}
