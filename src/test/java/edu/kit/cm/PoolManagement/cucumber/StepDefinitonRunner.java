package edu.kit.cm.PoolManagement.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue="edu/kit/cm/PoolManagement/cucumber/stepDefinitions")
public class StepDefinitonRunner {
	
}
