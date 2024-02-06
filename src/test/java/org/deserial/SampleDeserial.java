package org.deserial;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.sample.CreateUser;
import org.sample.Payload;
import org.sample.UpdateUser;
import org.sample.Utilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleDeserial extends Utilities {

	public static void main(String[] args) throws ParseException {
		System.out.println("==============GET==============");
		RestAssured.baseURI="https://reqres.in/";
RequestSpecification given = RestAssured.given().header("Content-Type","application/json").queryParam("page", "2");
		Response resGet = given.when().get("api/users");
		System.out.println("Response code......" + getResponseCode(resGet));
	    String body=getResponseBody(resGet);
	    System.out.println("Response Body......" +body);
	    
	    //way1 using JSONParser
	    JSONParser p=new JSONParser();
	    Object obj = p.parse(body);
	    
	  JSONObject jb=(JSONObject)obj;
	  String page = jb.get("page").toString();
	  System.out.println(page);
	  System.out.println("Per Page....."+jb.get("per_page").toString());
	  System.out.println("Total....."+jb.get("total").toString());
	  System.out.println("total_pages....."+jb.get("total_pages").toString());
	  Object data = jb.get("data");
	  System.out.println(data);
	  
	  //JSON Array
	  JSONArray ar= (JSONArray)data;
	  Object o1 = ar.get(1);
	  System.out.println(o1);
	  
	  JSONObject jo=(JSONObject)o1;
	  System.out.println("Id....."+jo.get("id").toString());
	  System.out.println("FirstName......."+jo.get("first_name").toString());
	  
	  for(Object x:ar) {
		  JSONObject j=(JSONObject)x;
		  System.out.println(j.get("id"));
		  System.out.println(j.get("first_name"));
		  System.out.println(j.get("last_name"));
		  System.out.println(j.get("email"));
		  System.out.println(j.get("avatar"));
		  Object support = jb.get("support");
		  System.out.println(support);
		  
		  //way2 using Deserialization POJO Classes
		  GetUserDetails get=resGet.as(GetUserDetails.class);
		  System.out.println(get.getPage());
		  System.out.println(get.getPer_page()); 
		  System.out.println(get.getTotal());
		  System.out.println(get.getTotal_pages());
		  
		  List<Data> datas = get.getData();
		  for(Data x1:datas) {
			  System.out.println(x1.getId());
			  System.out.println(x1.getFirst_name());
			  System.out.println(x1.getLast_name());
			  System.out.println(x1.getEmail());
			  System.out.println(x1.getAvatar());
			  System.out.println();
		  }
		  Support sup = get.getSupport();
		  System.out.println(sup.getUrl());
		  System.out.println(sup.getText());
		  
		  //way3 using JSONPath
		  System.out.println("=============JSON Path=============");
		  JsonPath path=new JsonPath(body);
		   String pg = path.get("page").toString();
		   System.out.println(pg);
		   System.out.println(path.get("per_page"));
		   System.out.println(path.get("total"));
		   System.out.println(path.get("total_pages"));
		   System.out.println(path.get("data"));
		   System.out.println(path.get("data[0]"));
		   System.out.println(path.get("data[0].id"));
		   System.out.println(path.get("data.id[0]"));
		   System.out.println(path.get("support"));
		   System.out.println(path.get("support.url"));
		   System.out.println(path.get("support.text"));
		   
		   System.out.println("===============POST================");
		   Response post = RestAssured.given().header("Cpntent_Type","application/json").body(Payload.createUser()).when().post("api/users");
		   System.out.println("Response Code....."+getResponseCode(post));
		   System.out.println("Response Body....."+getResponseBody(post));
		   
		   //deserial
		   CreateUser createUser = post.as(CreateUser.class);
		   System.out.println(createUser.getName());
		   System.out.println(createUser.getJob());
		   System.out.println(createUser.getId());
		   System.out.println(createUser.getCreatedAt());
		   
		   System.out.println("=============PUT==============");
		   Response put = RestAssured.given().header("Content-Type","application/json").body(Payload.updateUser()).when()
		       .put("api/users/2");
		   System.out.println("Response Code....."+getResponseCode(put));
		   System.out.println("Response Body....."+getResponseBody(put));
		   
		   //deserial
		   UpdateUser updateUser = put.as(UpdateUser.class);
		   System.out.println(updateUser.getName());
		   System.out.println(updateUser.getJob());
		   System.out.println(updateUser.getUpdatedAt());
		   
		   System.out.println("=============DELETE===============");
		   Response delete = RestAssured.given().header("Content-Type","application/json").when().delete("api/users/2");
		   System.out.println("Response Code....."+getResponseCode(delete));
		   System.out.println("Response Body....."+getResponseBody(delete));
		   }
	    }
	}
