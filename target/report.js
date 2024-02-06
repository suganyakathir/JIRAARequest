$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/JIRAApi.feature");
formatter.feature({
  "name": "To validate the jira api\u0027s",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "To validate the create api issue with post call",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createissue"
    }
  ]
});
formatter.step({
  "name": "To Add the Baseuri",
  "keyword": "Given "
});
formatter.step({
  "name": "To add the payload for create api \"\u003csummary\u003e\" and \"\u003cdescription\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "To call the \"create issue\" api with \"POST\" request",
  "keyword": "When "
});
formatter.step({
  "name": "The response code should be 201",
  "keyword": "Then "
});
formatter.step({
  "name": "The self should contain the \"suganyakathir\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "summary",
        "description"
      ]
    },
    {
      "cells": [
        "Login not working",
        "Otp cant received"
      ]
    }
  ]
});
formatter.scenario({
  "name": "To validate the create api issue with post call",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@createissue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "To Add the Baseuri",
  "keyword": "Given "
});
formatter.match({
  "location": "JIRASteps.to_add_the_Baseuri()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To add the payload for create api \"Login not working\" and \"Otp cant received\"",
  "keyword": "And "
});
formatter.match({
  "location": "JIRASteps.to_add_the_payload_for_create_api_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To call the \"create issue\" api with \"POST\" request",
  "keyword": "When "
});
formatter.match({
  "location": "JIRASteps.to_call_the_create_issue_api_with_request(String,String)"
});
formatter.result({
  "error_message": "java.lang.IllegalArgumentException: No enum constant org.stepdefinition.ApiResources.create issue\r\n\tat java.lang.Enum.valueOf(Enum.java:238)\r\n\tat org.stepdefinition.ApiResources.valueOf(ApiResources.java:1)\r\n\tat org.stepdefinition.JIRASteps.to_call_the_create_issue_api_with_request(JIRASteps.java:35)\r\n\tat ✽.To call the \"create issue\" api with \"POST\" request(file:src/test/resources/features/JIRAApi.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "The response code should be 201",
  "keyword": "Then "
});
formatter.match({
  "location": "JIRASteps.the_response_code_should_be(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The self should contain the \"suganyakathir\"",
  "keyword": "And "
});
formatter.match({
  "location": "JIRASteps.the_self_should_contain_the(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "To validate the update api issue with put call",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@updateissue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "java.lang.NullPointerException\r\n\tat org.stepdefinition.JIRASteps.to_add_the_payload_for_create_api_and(JIRASteps.java:30)\r\n\tat org.stepdefinition.HooksClass.beforeScanario2(HooksClass.java:19)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:42)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$WithStepDescriptions.run(PickleRunners.java:97)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "To Add the Baseuri",
  "keyword": "Given "
});
formatter.match({
  "location": "JIRASteps.to_add_the_Baseuri()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "To add payload for update issue api",
  "keyword": "And "
});
formatter.match({
  "location": "JIRASteps.to_add_payload_for_update_issue_api()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "To call the \"updateissue\" api with \"PUT\" request",
  "keyword": "When "
});
formatter.match({
  "location": "JIRASteps.to_call_the_create_issue_api_with_request(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The response code should be 204",
  "keyword": "Then "
});
formatter.match({
  "location": "JIRASteps.the_response_code_should_be(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "To validate the get api issue with get call",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@getissue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "To Add the Baseuri",
  "keyword": "Given "
});
formatter.match({
  "location": "JIRASteps.to_add_the_Baseuri()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To call the \"getissue\" api with \"GET\" request",
  "keyword": "When "
});
formatter.match({
  "location": "JIRASteps.to_call_the_create_issue_api_with_request(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The reponse code should be 200",
  "keyword": "Then "
});
formatter.match({
  "location": "JIRASteps.the_reponse_code_should_be(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To validate the create api issue with delete call",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@deleteissue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "java.lang.NullPointerException\r\n\tat org.stepdefinition.JIRASteps.to_add_the_payload_for_create_api_and(JIRASteps.java:30)\r\n\tat org.stepdefinition.HooksClass.beforeScanario2(HooksClass.java:19)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:42)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$WithStepDescriptions.run(PickleRunners.java:97)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "To Add the Baseuri",
  "keyword": "Given "
});
formatter.match({
  "location": "JIRASteps.to_add_the_Baseuri()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "To call the \"deleteissue\" api with \"DELETE\" request",
  "keyword": "When "
});
formatter.match({
  "location": "JIRASteps.to_call_the_create_issue_api_with_request(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The response code should be 204",
  "keyword": "Then "
});
formatter.match({
  "location": "JIRASteps.the_response_code_should_be(int)"
});
formatter.result({
  "status": "skipped"
});
});