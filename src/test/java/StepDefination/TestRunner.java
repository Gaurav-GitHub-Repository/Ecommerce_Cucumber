package StepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\CucumberTest.feature",
                 glue={"StepDefination"}
                )


public class TestRunner {

}
