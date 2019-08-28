package Resuablecomponents;

public class Postreq {
	
	
	public static String getLoginBody(){
	String	body="{ \"username\": \"soumen\", \"password\": \"123456\" }";
	return body;
		
	}
	public static String getloginResource(){
		String res="/rest/auth/1/session";
		return res;
	}
	public static String getCreateIssueBody(){
		
		String res="{\r\n\"fields\": {\r\n   \"project\":\r\n   { \r\n      \"key\": \"QAR\"\r\n   },\r\n   \"summary\": \"REST EXAMPLE\",\r\n   \"description\": \"Creating an issue via REST API\",\r\n   \"issuetype\": {\r\n      \"name\": \"Bug\"\r\n   }\r\n  }\r\n}";
		return res;
	}
	public static String getReportComment(){
		String Com=" {\"visibility\": {\r\n    \"type\": \"role\",\r\n    \"value\": \"Administrators\"\r\n  },\r\n  \"body\": \"i have updated the comment.\"\r\n}";
	    return Com;
	}

}
