package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyFirstStepDef {



	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("this is the first test");
	}

	@Given("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}

	@When("^some other action$")
	public void some_other_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}

	@When("^yet another action$")
	public void yet_another_action() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}

	@Then("^I validate the outcomes$")
	public void i_validate_the_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}

	@Then("^check more outcomes$")
	public void check_more_outcomes() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("this is the first test");
	}


}
