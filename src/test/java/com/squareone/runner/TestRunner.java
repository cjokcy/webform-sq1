package com.squareone.runner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber.html",   // HTML report
                "json:target/cucumber-report/cucumber.json"     // JSON report
        },
        monochrome = true
)
public class TestRunner {
}

