package org.asserts;

import org.junit.Test;
import org.sample.Payload;
import org.sample.Utilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.deserial.CreatedIssue;
import org.hamcrest.Matchers;
import org.junit.Assert;

public class JIRAAsserts extends Utilities {
static String key;
@Test
public void test1() {
	RestAssured.baseURI="https://suganyakathir.atlassian.net/";
	System.out.println("=========GET============");
	Response get = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
	.queryParam("jql","assignee=Suganya").when().get("rest/api/2/search").then().body("total", Matchers.equalTo("7")).assertThat().statusCode(200).extract().response();
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
	Response post = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
			   .body(Payload.createIssue2()).when().post("rest/api/2/issue/").then().assertThat().statusCode(201).extract().response();

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
	Response put = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF0hGUz2EiQ64xVnP4XEBOjTLp4fcM5N-ORkWJPX7lxI51qcKz-CenOJU9kpznE6WT-yHLNLIZlVWKtEhksIHRGHU2UB-T6gSUNyHVsvaV2kL-j3Krbp1zzcuYWPwQtczf8-CHTaFtMlVRpBXkGef9ZgC24L6qsIY5eBSwhcMCTtWo=9647862A")
			 .body(Payload.updateIssue2()).when().put("rest/api/2/issue/"+key).then()
			 .statusCode(204).extract().response();
	System.out.println("Response Code......"+getResponseCode(put));
	System.out.println("Response Body......"+getResponseBody(put));
	Assert.assertEquals("The status code should be 204",204, getResponseCode(put));

}
@Test
public void test4() {
	System.out.println("===============DELETE===============");
	Response delete = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF0hGUz2EiQ64xVnP4XEBOjTLp4fcM5N-ORkWJPX7lxI51qcKz-CenOJU9kpznE6WT-yHLNLIZlVWKtEhksIHRGHU2UB-T6gSUNyHVsvaV2kL-j3Krbp1zzcuYWPwQtczf8-CHTaFtMlVRpBXkGef9ZgC24L6qsIY5eBSwhcMCTtWo=9647862A")
    .when().delete("rest/api/2/issue/"+key).then().statusCode(204).extract().response();
	System.out.println("Response Code......"+getResponseCode(delete));
	System.out.println("Response Body......"+getResponseBody(delete));
	Assert.assertEquals("The status code should be 204",204, getResponseCode(delete));
}











}
