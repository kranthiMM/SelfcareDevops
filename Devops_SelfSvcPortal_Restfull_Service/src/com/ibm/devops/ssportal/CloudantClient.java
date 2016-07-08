/*package com.ibm.devops.ssportal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CloudantClient {

	
	private Object port;
	private String host;
	private String username;
	private String password;
	private Object name;
	private Object dbc;

	public  CloudantClient(){
		String dbDetails = "";
		InputStream toolsInputStream;
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		try {
			toolsInputStream = new FileInputStream("C:/Users/IBM_ADMIN/Desktop/tools.txt");
			InputStreamReader toolReader = new InputStreamReader(toolsInputStream);
			BufferedReader br = new BufferedReader(toolReader);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					dbDetails += line + "\n";
				}
				JSONObject vcap;
				try {
					vcap = new JSONObject(VCAP_SERVICES);			
				        JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
				        JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
				        JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");
					    this.host = (String) cloudantCredentials.get("host");
					    this.username = (String) cloudantCredentials.get("username");
					    this.password = (String) cloudantCredentials.get("password");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
*/