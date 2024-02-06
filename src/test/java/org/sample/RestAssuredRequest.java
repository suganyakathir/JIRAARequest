
package org.sample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredRequest extends Utilities {
public static void main(String[] args) {
	RestAssured.baseURI="https://suganyakathir.atlassian.net/";
	System.out.println("=========GET============");
	Response get = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
	.queryParam("jql","assignee=Suganya").when().get("rest/api/2/search");
	System.out.println("Response Code......"+getResponseCode(get));
	System.out.println("Response Body......"+getResponseBody(get));
	
	System.out.println("=============POST==============");
	Response post = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
			   .body(Payload.createIssue()).when().post("rest/api/2/issue/");
	System.out.println("Response Code......"+getResponseCode(post));
	System.out.println("Response Body......"+getResponseBody(post));
	
	System.out.println("============PUT=============");
	Response put = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF0hGUz2EiQ64xVnP4XEBOjTLp4fcM5N-ORkWJPX7lxI51qcKz-CenOJU9kpznE6WT-yHLNLIZlVWKtEhksIHRGHU2UB-T6gSUNyHVsvaV2kL-j3Krbp1zzcuYWPwQtczf8-CHTaFtMlVRpBXkGef9ZgC24L6qsIY5eBSwhcMCTtWo=9647862A")
			 .body(Payload.updateIssue()).when().put("rest/api/2/issue/SCRUM-9");
	System.out.println("Response Code......"+getResponseCode(put));
	System.out.println("Response Body......"+getResponseBody(put));
	
	System.out.println("===============DELETE===============");
	Response delete = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF0hGUz2EiQ64xVnP4XEBOjTLp4fcM5N-ORkWJPX7lxI51qcKz-CenOJU9kpznE6WT-yHLNLIZlVWKtEhksIHRGHU2UB-T6gSUNyHVsvaV2kL-j3Krbp1zzcuYWPwQtczf8-CHTaFtMlVRpBXkGef9ZgC24L6qsIY5eBSwhcMCTtWo=9647862A")
    .when().delete("rest/api/2/issue/SCRUM-18");
	System.out.println("Response Code......"+getResponseCode(delete));
	System.out.println("Response Body......"+getResponseBody(delete));
	}
}
