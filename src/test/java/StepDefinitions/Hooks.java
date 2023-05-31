package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {
    // Hooks will always execute first
    // make sure you pick Before io.cucumber.java & After io.cucumber.java
    @Before
    public void preCondition(){
     openBrowserAndLaunchApplication();
    }
    @After
    public static void postConditions(){
        closeBrowser();
    }

}
