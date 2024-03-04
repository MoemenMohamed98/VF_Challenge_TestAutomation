package vf.eshop.stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = "vf.eshop.stepDefinitions",
monochrome = true, plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
"html:target/cucumber-report/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
