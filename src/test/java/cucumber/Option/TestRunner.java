package cucumber.Option;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/placeValidations.feature",
        glue={"stepDefinitions"},
        plugin="json:target/jsonReports/cucumber-report.json"
        // tags= "@AddPlace"
)
public class TestRunner {



}
