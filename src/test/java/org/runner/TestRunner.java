package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="org.stepdefinition",dryRun=false,monochrome=true,//tags="@deleteissue",
   strict=true,plugin= {"pretty","html:target","json:target/Jsonreport/report.json"},stepNotifications=true)
public class TestRunner {

}
