package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/featureFiles/" },
glue = {"stepDefinitions" },
monochrome = true, 
//tags = "@googleSearch",
plugin = { "pretty",
		"html:target/cucumber",
		"json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class MainTestRunner extends AbstractTestNGCucumberTests {
	
}
