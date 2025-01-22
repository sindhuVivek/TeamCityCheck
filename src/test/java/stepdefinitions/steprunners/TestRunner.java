package stepdefinitions.steprunners;

// Selenium imports
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepdefinitions", "features"},
        tags = "@create_verifiedclaim_im",
        plugin =  {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber.html",
                "rerun:target/failedrerun.txt","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class TestRunner extends AbstractTestNGCucumberTests {

    //Parallel is always on but thread count is set to 1 so tests run one after one
    //Change thread count in POM for test suite runs using maven
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();

    }

}