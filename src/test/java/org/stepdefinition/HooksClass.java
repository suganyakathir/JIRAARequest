package org.stepdefinition;

import org.builder.Builder;
import org.sample.Utilities;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class HooksClass extends Utilities {
  static RequestSpecification reqSpec;
  @Before(order=1)
  public void beforeScanario1() {
	reqSpec=RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder());
  }
  @Before(order=2,value="@updateissue or @deleteissue")
  public void beforeScanario2() {
	  JIRASteps j=new JIRASteps();
	  j.to_add_the_payload_for_create_api_and("Login not working", "cant able to login");
	  j.to_call_the_create_issue_api_with_request("createissue", "post");
	
}

}

