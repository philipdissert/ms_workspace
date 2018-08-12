package edu.kit.cm.WorkspaceManagement.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue= "edu/kit/cm/WorkspaceManagement/cucumber/stepDefinitions")
public class StepDefinitonRunner {
	
}
