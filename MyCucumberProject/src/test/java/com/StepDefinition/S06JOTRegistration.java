package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class S06JOTRegistration {
	
	@Given("Launch JOT Site using {string}")
	public void launch_jot_site_using(String string) {
	}

	@When("Enter the data as follows")
	public void enter_the_data_as_follows(io.cucumber.datatable.DataTable dataTable) {
		System.out.println(dataTable);
	}
}
