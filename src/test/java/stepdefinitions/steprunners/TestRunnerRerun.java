package stepdefinitions.steprunners;

// Selenium imports
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failedrerun.txt",
        glue = {"stepdefinitions", "features"},
        plugin =  {"pretty",
                "rerun:target/failedrerun.txt"})

public class TestRunnerRerun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();

    }

}