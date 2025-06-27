package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false,features= "./featurefile/Addemp.feature",
glue = "stepDefenation" 
)

public class Addemployee  {

}
