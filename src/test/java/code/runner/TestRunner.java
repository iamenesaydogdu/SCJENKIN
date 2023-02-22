package code.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources" ,// bu ise content rout copy yaptik
        glue ="code/stepsDefinitions", // bu soruce rout
        tags ="@Regression", // hangi tesi yapmak istersen buraya yaziyosun tagi de @smoke regression
        dryRun = false ,// buraya true yapip seneryoyu run yaparsan chrome acilir ve altta kirmizi oyle veirir yazilari ama false chrome acmaz direk verir
                    // off yani false dersem run edince google de seneryoyu acar test eder ..
  // TRUE YAPINCA CALISMAZ SADECE KIRMIZI VERIR
    plugin = {
            "pretty" , // This is to gave more understsandable console tags // yani log4j den ddaha fazla ayrinti veriyor
                       // conseloden goruceksin nerde hata oldugunu pretty sayesinde
            "rerun:target/rerun.txt" ,// This will help us to store failed scenarios in rerun.txt file so that we
            //can run them from FailedRunner class


            "html:target/default-cucumber-reports.html", // biri html olarak digeri ise json olarak rapor vericek
            "json:target/cucumber.json",
// kullanimi ; target , default-cucumber-report , right click , open in , browser , chrome

            // orda herseyi seneryolari gecenler gecmeyenler , (unknwon olanlari @ tag olarak yazmadik unutma )
            // failed olan yeride orda attached diye picture tiklayinca nerde fail oluyor gorebiliriz cucumber reports da

            }
)



public class TestRunner {   // burdan our classes run edebiliriz ..simdi tag koymadigim icin tum herseyi tes ediyor
}
