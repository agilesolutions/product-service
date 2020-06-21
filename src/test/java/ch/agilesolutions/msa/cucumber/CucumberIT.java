package ch.agilesolutions.msa.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/features" }, plugin = { "pretty", "html:target/reports/cucumber/html",
		"json:target/cucumber.json", "usage:target/usage.jsonx", "junit:target/junit.xml" })

public class CucumberIT {

}
