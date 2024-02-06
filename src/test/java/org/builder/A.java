package org.builder;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.stepdefinition.ApiResources;

public class A {
	public static void main(String[] args) throws IOException {
		ApiResources cr=ApiResources.createissue;
		System.out.println(cr.getResources());
		
		ApiResources cc = ApiResources.valueOf("createissue");
		System.out.println(cc.getResources());
		Properties p=new Properties();
		FileReader loc=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	    p.load(loc);
	    String pv = p.getProperty("baseuri");
	    System.out.println(pv);
	    
	    Object on = p.get("baseuri");
	    System.out.println(on.toString());
	}

}
