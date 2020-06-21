package ch.agilesolutions.msa.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/features" }, plugin = { "pretty", "json:target/cucumber.json" })

public class CucumberIT {

}
