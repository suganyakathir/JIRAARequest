package org.stepdefinition;

public enum ApiResources {
	createissue("rest/api/2/issue/"),
	updateissue("rest/api/2/issue/"),
	getissue("rest/api/2/search/"),
	deleteissue("rest/api/3/issue/");
	
	String resources;
	ApiResources(String resources) {
		this.resources=resources;
	}
	public String getResources() {
		return resources;
	}

}
