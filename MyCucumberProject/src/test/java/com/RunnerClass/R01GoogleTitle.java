package com.RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F01GoogleTitle.feature",
					glue = "com.StepDefinition")
public class R01GoogleTitle {
	/*
	 * features --> Contains name of feature file along with the path
	 * glue --> Contains name of the package where you have implemented the steps from feature file
	 */
}
