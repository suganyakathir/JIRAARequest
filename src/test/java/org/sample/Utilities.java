package org.sample;

import io.restassured.response.Response;

public class Utilities {
	public static int getResponseCode(Response res) {
		return res.getStatusCode();
		
	}
public static String getResponseBody(Response res) {
	return res.getBody().asString();
	
}
}
