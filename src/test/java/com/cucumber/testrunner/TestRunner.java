package com.cucumber.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/cucumber/automationwebsite/feature",
   glue = "com.cucumber.stepdefinition")
public class TestRunner {

}
