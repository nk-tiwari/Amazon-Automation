package com.amazonautomation.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features", 
		glue= {"com.amazonautomation.steps"}, 
		monochrome=true,
		dryRun = false
	)
public class TestRunner {

}
