package org.asserts;

import org.deserial.GetUserDetails;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.sample.CreateUser;
import org.sample.Utilities;
import org.serial.UserDetails;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Assertss extends Utilities {
	public static void main(String[] args) throws ParseException {
		System.out.println("===============GET=================");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification given = RestAssured.given().header("Content-Type","application/json").queryParam("page", "2");
				Response resGet = given.when().get("api/users");
				System.out.println("Response code......" + getResponseCode(resGet));
			    String body=getResponseBody(resGet);
			    System.out.println("Response Body......" +body);
			//verification    
	    Assert.assertEquals("The status code should be 200", 200,getResponseCode(resGet));
	    GetUserDetails as=resGet.as(GetUserDetails.class);
	    String first_name=as.getData().get(0).getFirst_name();
	    Assert.assertTrue("verify the first name", first_name.equals("Michael"));
	    
	    System.out.println("=============POST==============");
	    UserDetails user=new UserDetails();
	    user.setName("suganya");
	    user.setJob("Manager");
	    Response post = RestAssured.given().header("Content_Type","application/json").body(user).when().post("api/users");
		   System.out.println("Response Code....."+getResponseCode(post));
		   System.out.println("Response Body....."+getResponseBody(post));
		 //deserial   
		   CreateUser createUser = post.as(CreateUser.class);
		   String name=createUser.getName();
		   Assert.assertEquals("The status code should be 201", 201,getResponseCode(post)); 
			    
		System.out.println("===============PUT=============");
		UserDetails updateuser=new UserDetails();
		updateuser.setName(name);
		updateuser.setJob("Leader");
		 Response put = RestAssured.given().header("Content-Type","application/json").body(updateuser).when()
			       .put("api/users/2");
			   System.out.println("Response Code....."+getResponseCode(put));
			   System.out.println("Response Body....."+getResponseBody(put));
			   Assert.assertEquals("The status code should be 200", 200,getResponseCode(put)); 	 
			   
	  System.out.println("=============DELETE===============");
			   Response delete = RestAssured.given().header("Content-Type","application/json").when().delete("api/users/2");
			   System.out.println("Response Code....."+ getResponseCode(delete));
			   System.out.println("Response Body....."+ getResponseBody(delete));
			Assert.assertEquals("The status code should be 204", 204, getResponseCode(delete));
			  
	
	}

}
