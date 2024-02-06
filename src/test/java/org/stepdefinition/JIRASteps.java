package org.stepdefinition;

import static org.junit.Assert.*;

import org.builder.Builder;
import org.deserial.CreatedIssue;
import org.junit.Assert;
import org.sample.Payload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JIRASteps {
	RequestSpecification reqSpec;
	Response res;
	static String key;
	
	@Given("To Add the Baseuri")
	public void to_add_the_Baseuri() {
		reqSpec = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder());  
	}

	@Given("To add the payload for create api {string} and {string}")
	public void to_add_the_payload_for_create_api_and(String summary, String description) {
		System.out.println("=============POST================");
	    reqSpec = reqSpec.body(Payload.createIssue2(summary,description)) ;
	}

	@When("To call the {string} api with {string} request")
	public void to_call_the_create_issue_api_with_request(String resource,String request) {
	  ApiResources apiResources=ApiResources.valueOf(resource);
	  String resources = apiResources.getResources();
	  if(request.equalsIgnoreCase("post")) {
		  res=reqSpec.when().post(resources);
		  CreatedIssue create=res.as(CreatedIssue.class);
		  key=create.getKey();
	  }
	  else if(request.equalsIgnoreCase("put")) {
		  res=reqSpec.when().put(resources + key);
	  }
	  else if(request.equalsIgnoreCase("get")) {
		//res=reqSpec.queryParam("jql", "assignee=Suganya").when().get(resources);
		  res=HooksClass.reqSpec.queryParam("jql", "assignee=Suganya").when().get(resources);
	  }
	  else if(request.equalsIgnoreCase("delete")) { 
		 // res=reqSpec.when().delete(resources + key);
		  res=HooksClass.reqSpec.when().delete(resources + key);
	  }
	}

	@Then("The response code should be {int}")
	public void the_response_code_should_be(int expectedCode) {
		assertEquals("Verify the status code",expectedCode,res.getStatusCode());
	    res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response(); 
	}
	@Then("The self should contain the {string}")
	public void the_self_should_contain_the(String expectedValue) {
	    CreatedIssue create = res.as(CreatedIssue.class);
	    String self = create.getSelf();
	    key = create.getKey();
	    Assert.assertTrue("The response body self should contains suganyakathir",self.contains(expectedValue));
	}

	@Given("To add payload for update issue api")
	public void to_add_payload_for_update_issue_api() {
   // = reqSpec.body(Payload.updateIssue2());
		reqSpec=HooksClass.reqSpec.body(Payload.updateIssue2());

	}

	@Then("The reponse code should be {int}")
	public void the_reponse_code_should_be(int expectedCode) {
		assertEquals("Verify the status code",expectedCode,res.getStatusCode());
	    res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response();    
	   }
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Given("To add the Baseuri and Payload")
//	public void to_add_the_baseuri_and_payload() {
//		System.out.println("=============POST================");
//	    reqSpec = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).body(Payload.createIssue2());
//	    }
//	@When("To call the create issue api with POST request")
//	public void to_call_the_create_issue_api_with_post_request() {
//	  res=reqSpec.when().post("rest/api/2/issue");
//	}
//	@Then("The status code should be {int}")
//	public void the_status_code_should_be(int expectedCode) {
//	    assertEquals("Verify the status code should be 201",expectedCode,res.getStatusCode());
//	    res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response();
//	    }
//	@Then("The self should contain the {string}")
//	public void the_self_should_contain_the(String expectedValue) {
//	    CreatedIssue create = res.as(CreatedIssue.class);
//	    String self = create.getSelf();
//	    key = create.getKey();
//	    Assert.assertTrue("The response body self should contains suganyakathir",self.contains(expectedValue));
//	}
//
//	@Given("To add the Baseuri and Payload for update issue api")
//	public void to_add_the_baseuri_and_payload_for_update_issue_api() {
//	 System.out.println("=============PUT=============");  
//	 reqSpec=RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).body(Payload.updateIssue2());
//	}
//	
//	@When("To call the update issue api with PUT request")
//	public void to_call_the_update_issue_api_with_put_request() {
//	   res=reqSpec.when().put("rest/api/2/issue/" + key);
//	}
//	@Then("The status code for update api should be {int}")
//	public void the_status_code_for_update_api_should_be(int expectedCode) {
//	    assertEquals("Verify the status code should be 204",expectedCode,res.getStatusCode());
//	    res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response();
//	}
//	
//    @Given("To add the Baseuri for get issue api")
//	public void to_add_the_baseuri_for_get_issue_api() {
//	 reqSpec=RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder())
//			 .queryParam("jql", "assignee=Suganya");  
//    }
//	@When("To call the get issue api with GET request")
//	public void to_call_the_get_issue_api_with_get_request() {
//	  res=reqSpec.when().get("rest/api/2/search");
//	}
//	@Then("The status code for get api should be {int}")
//	public void the_status_code_for_get_api_should_be(int expectedCode) {
//	   assertEquals("Verify the status code should be 200",expectedCode,res.getStatusCode());
//	   res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response();
//	}
//	
//
//	@Given("To add the Baseuri for delete issue api")
//	public void to_add_the_baseuri_for_delete_issue_api() {
//	  reqSpec=RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder());  
//	}
//	@When("To call the delete issue api with DELETE request")
//	public void to_call_the_delete_issue_api_with_delete_request() {
//	   res=reqSpec.when().delete("rest/api/3/issue/"+key) ;
//	}
//	@Then("The status code for delete api should be {int}")
//	public void the_status_code_for_delete_api_should_be(int expectedCode) {
//	    assertEquals("Verify the status code should be 200",expectedCode,res.getStatusCode());
//	    res=res.then().log().all().spec(Builder.getResponseSpecBuilder(expectedCode)).extract().response();
//	}
//
//}
