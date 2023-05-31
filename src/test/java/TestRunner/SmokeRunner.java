package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "StepDefinitions",
        dryRun= false,
        tags = "@smoke",
        plugin = {"pretty","html:target/Cucumber.html", "json:target/Cucumber.json"})
// plugin will make your console gives you more info about each test case
// you can add "or @testcase2" to run both test case ,
// if we add "and" it will only run the test case that has both tags.
// in glue, we copied file name of StepDefinitions
// we copied the absolute path from Login.feature & deleted before src and after Features package
// dry run = true is to check which step doesn't have the glue code, and it will generate one for you
// target folder is used for storing the test case execution reports generated using Cucumber
public class SmokeRunner {

}
