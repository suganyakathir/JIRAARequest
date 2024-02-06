package org.builder;

import java.io.PrintStream;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder {
 public static RequestSpecification getRequestSpecBuilder() {
	 PrintStream p=null;
	 PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	 auth.setUserName("suganya.iniya23@gmail.com");
	 auth.setPassword("ATATT3xFfGF01rYBh8qIDfB1KrnTzpml-Xiu2kMtAB8eHSC5tWjrJMUOdAJ0GsV6n46FrNEIusroUYJD6fBdnX9vyp6bKiCUkEk8YRNw0d08JCas8A_RYEIXGGkrZW7nuUvf_IbLfsYCYFE42SdDSPKJ8ufezBA1S9gZCn7W3bj2xbrg5Qh4GcY=8DAD80ED");
	try {
		if(p==null) {
		p=new PrintStream("log.txt");
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	 return new RequestSpecBuilder().setBaseUri("https://suganyakathir.atlassian.net/").setContentType(ContentType.JSON).setAuth(auth)
			     .addFilter(RequestLoggingFilter.logRequestTo(p)).addFilter(ResponseLoggingFilter.logResponseTo(p)).build();
	}
 public static ResponseSpecification getResponseSpecBuilder(int code) {
	return new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(code).build();
}
}