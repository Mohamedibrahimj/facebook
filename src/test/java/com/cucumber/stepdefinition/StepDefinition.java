package com.cucumber.stepdefinition;

import static org.junit.Assert.assertEquals;

import com.cucumber.functionallibrary.BaseClass;
import com.cucumber.pom.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition extends BaseClass{
	
	@Given("^we are in the homepage$")
	public void we_are_in_the_homepage() throws Throwable {
		browserlaunch("chrome", "http://automationpractice.com/");    
	}

	@Then("^validating whether the logo is present$")
	public void validating_whether_the_logo_is_present() throws Throwable {
		HomePage hp = new HomePage();
		elementIsDisplayed(hp.getLogo());
	
	    
	}

	@Then("^Also validating whether the contactus tab and contact number is displayed$")
	public void also_validating_whether_the_contactus_tab_and_contact_number_is_displayed() throws Throwable {
	HomePage hp = new HomePage();
	elementIsDisplayed(hp.getContactusTab());
	assertEquals("0123-456-789", hp.getContactnumber().getText());
	}

	@Then("^check search box is enabled or not$")
	public void check_search_box_is_enabled_or_not() throws Throwable {
		
	
	    
	}

	@Then("^check the dressestab tshirtstab womenstab are present or not$")
	public void check_the_dressestab_tshirtstab_womenstab_are_present_or_not() throws Throwable {
	
	    
	}

	@Then("^check and click the signin button$")
	public void check_and_click_the_signin_button() throws Throwable {
	
	    
	}

}
