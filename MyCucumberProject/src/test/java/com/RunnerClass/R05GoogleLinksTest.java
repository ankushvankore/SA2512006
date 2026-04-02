package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F05GoogleLinksTest.feature",
					glue = "com.StepDefinition",
					tags = "@GoogleLinks",
					publish = true)
public class R05GoogleLinksTest {
	/*
	 * Execute Single Scenario:		tags = "@SmokeTest"
	 * Execute Multiple Scenarios:	tags = "@SmokeTest or @GmailTest"
	 * Skip Single Scenario:		tags = "not @GmailTest"
	 * Skip Multiple Scenarios:		tags = "not @GmailTest and not @StoreTest"
	 */

}
