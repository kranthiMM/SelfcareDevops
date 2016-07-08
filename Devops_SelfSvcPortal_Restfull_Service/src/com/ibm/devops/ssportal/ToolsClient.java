/*package com.ibm.devops.ssportal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


import java.util.List;

import javax.ws.rs.core.MediaType;




















import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;










import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class ToolsClient {
	public static void main(String[] args) throws JSONException {
		

public static void getTools(WebResource r) {
		
		// 1, get response as plain text
		String jsonRes = r.accept(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(jsonRes);
		
		String xmlRes = r.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlRes);				
				// 2, get response and headers etc, wrapped in ClientResponse
				ClientResponse response = r.get(ClientResponse.class);
				System.out.println( response.getStatus() );
				System.out.println( response.getHeaders().get("Content-Type") );
				String entity = response.getEntity(String.class);
				System.out.println(entity);
				// 3, get JAXB response
				GenericType<List<Contact>> genericType = new GenericType<List<Contact>>() {};
				List<Contact> contacts = r.accept(MediaType.APPLICATION_XML).get(genericType);
				System.out.println("No. of Contacts: " + contacts.size());
				Contact contact = contacts.get(0);
				System.out.println(contact.getId() + ": " + contact.getName());
		
		
	}
	String string = "";
	try {

		// Step1: Let's 1st read file from fileSystem
		// Change CrunchifyJSON.txt path here
		InputStream toolsInputStream = new FileInputStream("C:/Dst_Json/tools.txt");
		InputStreamReader toolReader = new InputStreamReader(toolsInputStream);
		BufferedReader br = new BufferedReader(toolReader);
		String line;
		while ((line = br.readLine()) != null) {
			string += line + "\n";
		}

		JSONObject jsonObject = new JSONObject(string);
		System.out.println(jsonObject);

		// Step2: Now pass JSON File Data to REST Service
		try {
			URL url = new URL("http://localhost:8080/Devops_SelfSvcPortal_Restfull_Service/datasvc/crunchifyService");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
			connection.setRequestProperty("Accept","*");
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObject.toString());
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while (in.readLine() != null) {
			}
			System.out.println("\nDevops REST Service Invoked Successfully..");
			in.close();
		} catch (Exception e) {
			System.out.println("\nError while calling Devops REST Service");
			System.out.println(e);
		}

		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		Object port;
		String host;
		String username;
		String password;
		Object name;
		Object dbc;
		String dbDetails = "";
		while ((line = br.readLine()) != null) {
				dbDetails += line + "\n";
			}
			//JSONObject vcap;
			//try {
				//vcap = new JSONObject(dbDetails);					
			       // JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
			       // JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
			      //  JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");
				    host = "10f8d340-da27-4164-a833-7077a6c4f010-bluemix.cloudant.com";
				    System.out.println("host"+host);
				    username = "10f8d340-da27-4164-a833-7077a6c4f010-bluemix";
				    System.out.println("username"+username);

				    password = "bd52bc59b8fbe548d0bdb842b02f487347c2ced9b558478f5debbac9956cd4eb";
				    String url = "https://10f8d340-da27-4164-a833-7077a6c4f010-bluemix:bd52bc59b8fbe548d0bdb842b02f487347c2ced9b558478f5debbac9956cd4eb@10f8d340-da27-4164-a833-7077a6c4f010-bluemix.cloudant.com";
				    		System.out.println("url@@@@"+url);
				    System.out.println("password"+password);
				    CloudantClient client = ClientBuilder.account(username)
			                .username(username)
			                .password(password)
			                .build();
				    List<String> clientDb = client.getAllDbs();
				    
				    System.out.println("client.getAllDbs()"+client.getAllDbs().size());
				    System.out.println("client.getAllDbs()"+client.getAllDbs().toString());
				    for (String string : clientDb) {
				    	if(string.equalsIgnoreCase("toolsdata")){
				    		System.out.println("tests loop");
				    		//client.getBaseUri().getQuery();
				    		//System.out.println("client.getBaseUri().getQuery();();"+client.getBaseUri().getRawQuery());
				    	}
				    	System.out.println("out");
				    				    	 
				    	
					}
			    	Database db = client.database("toolsdata", false);
			    	//db.save(new Test(true));
			    	//System.out.println("You have inserted the document");

			    	// Get an ExampleDocument out of the database and deserialize the JSON into a Java type
				    InputStream inputStream = null;	
				    try{
				    	 inputStream = db.find("tools");
			    	     InputStreamReader toolRelist = new InputStreamReader(inputStream);
			 			BufferedReader br1 = new BufferedReader(toolRelist);
			 			String line1;
			 			
			 				try {
								while ((line1 = br1.readLine()) != null) {
									dbDetails += line1 + "\n";
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			 				System.out.println("dbDetails"+dbDetails);
			    	     //do stuff with the stream
			    	 } finally {
			    	     //close the input stream
			    	     try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	 }
				//System.out.println(vcap);
	}

}				
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	

*/