package org.serial;


import org.sample.CreateUser;
import org.sample.Utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleSerial extends Utilities {
public static void main(String[] args) {
	System.out.println("===============GET=================");
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification given = RestAssured.given().header("Content-Type","application/json").queryParam("page", "2");
			Response resGet = given.when().get("api/users");
			System.out.println("Response code......" + getResponseCode(resGet));
		    String body=getResponseBody(resGet);
		    System.out.println("Response Body......" +body);
		    
		    System.out.println("===============POST===============");
		    UserDetails user=new UserDetails();
		    user.setName("Suganya");
		    user.setJob("Manager");
		    Response post = RestAssured.given().header("Content_Type","application/json").body(user).when().post("api/users");
			   System.out.println("Response Code....."+ getResponseCode(post));
			   System.out.println("Response Body....."+ getResponseBody(post));
			//deserial   
			   CreateUser createUser = post.as(CreateUser.class);
			   String name=createUser.getName();
			 
		//API Chaining---->req----response-get data and given to next req input body	   
			   
			System.out.println("=============PUT==============");
		    UserDetails updateuser=new UserDetails();
		    
		    //get the name from previous response body and given as input in this request
		    updateuser.setName(name); 
		    updateuser.setJob("Leader");
			   Response put = RestAssured.given().header("Content-Type","application/json").body(updateuser).when()
			       .put("api/users/2");
			   System.out.println("Response Code....."+ getResponseCode(put));
			   System.out.println("Response Body....."+ getResponseBody(put));
			   
			   
		    System.out.println("=============DELETE===============");
			   Response delete = RestAssured.given().header("Content-Type","application/json").when().delete("api/users/2");
			   System.out.println("Response Code....."+ getResponseCode(delete));
			   System.out.println("Response Body....."+ getResponseBody(delete));
}	

}
