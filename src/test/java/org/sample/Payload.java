package org.sample;

import org.serial.Fields;
import org.serial.IssueCreate;
import org.serial.IssueType;
import org.serial.IssueUpdate;
import org.serial.Project;
import org.serial.UpdateFields;

public class Payload {
	public static String createIssue() {
		String s="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"SCRUM\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"";
		return s;
		
	}
	public static String updateIssue() {
		return "{\r\n" + 
			 		"	\"fields\": {\r\n" + 
			 		"		\"summary\": \"Summaries\",\r\n" + 
			 		"		\"description\": \"Description\"\r\n" + 
			 		"	}\r\n" + 
			 		"}";
		
	}
	public static String createUser() {
		return "{\r\n" + 
	    		"    \"name\": \"morpheus\",\r\n" + 
	    		"    \"job\": \"leader\"\r\n" + 
	    		"}";
			}
	public static String updateUser() {
		return "{\r\n" + 
    		"    \"name\": \"morpheus\",\r\n" + 
    		"    \"job\": \"Manager\"\r\n" + 
    		"}";
		
	}
	public static IssueCreate createIssue2(String summary, String description) {
		IssueType issueType=new IssueType();
		issueType.setName("Bug");
		
		Project project=new Project();
		project.setKey("SCRUM");
		
		//fields
		Fields fields =new Fields();
		fields.setProject(project);
		fields.setSummary("Login was not working");
		fields.setDescription("Due to the otp issue the user cant login to the app");
		fields.setIssuetype(issueType);
		
		IssueCreate create = new IssueCreate();
		create.setFields(fields);
		return create;
		}
	
	public static IssueUpdate updateIssue2() {
		UpdateFields fields2=new UpdateFields();
		fields2.setSummary("Updated Login was not working");
		fields2.setDescription("Updated-Due to the otp issue the user cant login to the app");
		IssueUpdate issueUpdate= new IssueUpdate();
		issueUpdate.setFields(fields2);
		return issueUpdate;
		
		
	}
	}


