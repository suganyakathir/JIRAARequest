package org.serial;

import org.deserial.CreatedIssue;
import org.sample.Payload;
import org.sample.Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAserial extends Utilities {
	public static void main(String[] args) {
	RestAssured.baseURI="https://suganyakathir.atlassian.net/";
	System.out.println("=========GET============");
	Response get = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
	.queryParam("jql","assignee=Suganya").when().get("rest/api/2/search");
	System.out.println("Response Code......"+getResponseCode(get));
	System.out.println("Response Body......"+getResponseBody(get));
	
	System.out.println("=============POST==============");
	
	Response post = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
			   .body(Payload.createIssue2()).when().post("rest/api/2/issue/");
	System.out.println("Response Code......"+getResponseCode(post));
	System.out.println("Response Body......"+getResponseBody(post));
	
	CreatedIssue cr=post.as(CreatedIssue.class);
	String key=cr.getKey();
	
	System.out.println("================PUT==============");
	
//	Response put = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
//			   .body(Payload.updateIssue2()).when().post("rest/api/2/issue/SCRUM-18");
	
	Response put = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
			   .body(Payload.updateIssue2()).when().put("rest/api/2/issue/"+key);
	System.out.println("Response Code......"+getResponseCode(put));
	System.out.println("Response Body......"+getResponseBody(put));
	
	System.out.println("===============DELETE===============");
//	Response delete = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
//			   .when().delete("rest/api/2/issue/SCRUM-12");
	
	Response delete = RestAssured.given().header("Content-Type","application/json").auth().preemptive().basic("suganya.iniya23@gmail.com", "ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED")
			   .when().delete("rest/api/3/issue/"+key);
	System.out.println("Response Code......"+getResponseCode(delete));
	System.out.println("Response Body......"+getResponseBody(delete));
	
	
	
}
}