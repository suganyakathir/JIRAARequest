package org.builder;

import org.deserial.CreatedIssue;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.sample.Payload;
import org.sample.Utilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JIRABuilder extends Utilities {
	static String key;
	@Test
	public void test1() {
		
		System.out.println("=========GET============");
		Response get = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).queryParam("jql","assignee=Suganya").when().get("rest/api/2/search").then()
				.log().all().spec(Builder.getResponseSpecBuilder(200)).extract().response();
		get.then().body("total", Matchers.equalTo(7));
		System.out.println("Response Code......"+getResponseCode(get));
		System.out.println("Response Body......"+getResponseBody(get));
		Assert.assertEquals("The status code should be 200",200, getResponseCode(get));
		JsonPath jp=new JsonPath(getResponseBody(get));
		String total = jp.get("total").toString();
		Assert.assertEquals("The total issue should be 7",7, Integer.parseInt(total));
		
	}
	@Test
	public void test2() {
		System.out.println("=============POST==============");
		Response post = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).body(Payload.createIssue2()).when().post("rest/api/2/issue/").then()
				.log().all().spec(Builder.getResponseSpecBuilder(201)).extract().response();

		System.out.println("Response Code......"+getResponseCode(post));
		System.out.println("Response Body......"+getResponseBody(post));
		
		CreatedIssue cr=post.as(CreatedIssue.class);
		key=cr.getKey();
		Assert.assertEquals("The status code should be 201",201, getResponseCode(post));
		
		Assert.assertTrue("The key should contain SCRUM",key.contains("SCRUM"));
		Assert.assertTrue("The self should contain suganyakathir",cr.getSelf().contains("suganyakathir"));

	}
	
	@Test
	public void test3() {
		
		System.out.println("============PUT=============");
		Response put = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).body(Payload.updateIssue2()).when().put("rest/api/2/issue/"+key).then()
				         .log().all().spec(Builder.getResponseSpecBuilder(204)).extract().response();
		System.out.println("Response Code......"+getResponseCode(put));
		System.out.println("Response Body......"+getResponseBody(put));
		Assert.assertEquals("The status code should be 204",204, getResponseCode(put));
	}
	@Test
	public void test4() {
		System.out.println("===============DELETE===============");
		Response delete = RestAssured.given().log().all().spec(Builder.getRequestSpecBuilder()).when().delete("rest/api/2/issue/"+key).then().log().all()
				     .spec(Builder.getResponseSpecBuilder(204)).extract().response();
		System.out.println("Response Code......"+getResponseCode(delete));
		System.out.println("Response Body......"+getResponseBody(delete));
		Assert.assertEquals("The status code should be 204",204, getResponseCode(delete));
	}
	
	
	
	
	
	
	
	
	
}
