package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, 
features = {"./featurefile/OrangeHrm.feature"},monochrome = true,
glue = {"stepDefenation"},tags = {"@loginwithvalid,@multipledata"}
,plugin= {"pretty","html:target/report/cucumber.html"})

public class AdminLogin {

}
