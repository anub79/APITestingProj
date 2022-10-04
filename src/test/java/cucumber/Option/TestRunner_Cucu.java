package cucumber.Option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/placeValidations.feature",
        glue={"stepDefinitions"},
        plugin="json:target/jsonReports/cucumber-report.json"
        // tags= "@AddPlace"
)
public class TestRunner_Cucu extends AbstractTestNGCucumberTests {

}
