package com.ibm.devops.ssportal;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.org.lightcouch.CouchDbException;
import com.google.gson.JsonParser;
import com.ibm.devops.scm.services.RtcScmBuild;
import com.ibm.devops.scm.util.RtcConfig;
import com.ibm.team.repository.common.TeamRepositoryException;


@Path("datasvc")
public class DataServices {
	
	/*private String host;
	private String username;
	private String password;

	public void dbCall(){
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
		try {
			URL url = new URL("https://10f8d340-da27-4164-a833-7077a6c4f010-bluemix.cloudant.com/toolsdata/_all_docs");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(jsonObject.toString());
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			while (in.readLine() != null) {
			}
			System.out.println("\nDevops cloudant Service Invoked Successfully..");
			in.close();
		} catch (Exception e) {
			System.out.println("\nError while calling Devops cloudant Service");
			System.out.println(e);
		}

		br.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}*/
	/*@GET
	@Path("tools")
	@Resource(name = "couchdb/cloudant-sample")
	public String getDBConnection(){
		String tools = "";
		InputStream toolsInputStream;
		try {
			toolsInputStream = new FileInputStream("C:/Users/IBM_ADMIN/Desktop/tools.txt");
			InputStreamReader toolReader = new InputStreamReader(toolsInputStream);
			BufferedReader br = new BufferedReader(toolReader);
			String line;
			Details details;
			try {
				while ((line = br.readLine()) != null) {
					tools += line + "\n";
				}
				JSONObject jsonObject;
				try {
					jsonObject = new JSONObject(tools);
					System.out.println(jsonObject);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Pattern match to find the first instance of a Cloudant service in
		// VCAP_SERVICES. If you know your service key, you can access the
		// service credentials directly by using the vcapServices object.
		return tools;
		
	}*/
	/*@Resource(name = "couchdb/cloudant-sample")
	protected CouchDbInstance _db;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String dbname = "my_database";
	try {
	//creates a database with the specified name
	CouchDbConnector dbc = _db.createConnector(dbname, true);
	response.getWriter().println("Created database: " + dbname);
	//create a simple doc to place into your new database
	Map<String, Object> doc = new HashMap<String, Object>();
	doc.put("_id", UUID.randomUUID().toString());
	doc.put("season", "summer");
	doc.put("climate", "arid");
	dbc.create(doc);
	response.getWriter().println("Added a simple doc!");
	} catch (Exception e) {
	response.getWriter().println(e.getMessage());
	}*/
	
	
	
	/*@POST
	@Path("jsp")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createProduct(@FormParam("id") String id,
			@FormParam("productname") String name,
			@FormParam("productcategory") String category,
			@Context HttpServletResponse servletResponse) throws IOException {
		//Product product = new Product(id, name, category);
		//productService.createProduct(product);
		servletResponse.sendRedirect("../SSD_Devops_Home/");
	}*/
	
	private String host;
	private String username;
	private String password;

	@GET
	@Path("tools")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTools() throws JSONException{
		String tools = "";
		String dbDetails = "";
		InputStream toolsInputStream;
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");

		Object port;
		String host;
		String username;
		String password;
		Object name;
		Object dbc;
		try {
				JSONObject vcap;
				/*System.out.println("VCAP_SERVICES"+VCAP_SERVICES.toString());
				JsonParser jsonParser= new JsonParser();
				Object obj =jsonParser.parse(new FileReader(VCAP_SERVICES));
				vcap = (JSONObject) obj;

				
				    JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
				    JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
				    JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");*/
				vcap = new JSONObject(VCAP_SERVICES);
				 JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
			        JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
			        JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");
				    host = (String) cloudantCredentials.get("host");
				    System.out.println("host"+host);
				    username = (String) cloudantCredentials.get("username");
				    System.out.println("username"+username);

				    password = (String) cloudantCredentials.get("password");
				    System.out.println("password"+password);
				    /*host = "d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix.cloudant.com";
				    System.out.println("host"+host);
				    username = "d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix";
				    System.out.println("username"+username);

				    password = "1f0aa702970db23972f4757d06c6bcf4ddce36a123e70d9038becdb12bd7e783";
				    String url = "https://d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix:1f0aa702970db23972f4757d06c6bcf4ddce36a123e70d9038becdb12bd7e783@d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix.cloudant.com";
				    		System.out.println("url@@@@"+url);
				    System.out.println("password"+password);*/
				    CloudantClient client = ClientBuilder.account(username)
				            .username(username)
				            .password(password)
				            .build();
				    List<String> clientDb = client.getAllDbs();			    
				    for (String string : clientDb) {
				    	if(string.equalsIgnoreCase("toolsdata")){
				    	}   	 
				    }
					Database db = client.database("toolsdata", false);

				    InputStream inputStream = null;	
				    try{
					     inputStream = db.find("tools");
					     InputStreamReader toolRelist = new InputStreamReader(inputStream);
						BufferedReader br1 = new BufferedReader(toolRelist);
						String line1;
						
							while ((line1 = br1.readLine()) != null) {
								tools += line1 + "\n";
							}
							System.out.println("tools"+tools);
					     //do stuff with the stream
					 } finally {
					     //close the input stream
					     inputStream.close();
					 }
				//System.out.println(vcap);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//String toolList="Testing";
		
		return tools;
	}
	
	@GET
	@Path("sum/{a}/{b}")
	@Produces (MediaType.TEXT_PLAIN)
	public String sum(@PathParam("a") int a, @PathParam("b") int b){
		return String.valueOf(a+b);
	}
	
	
	@GET
	@Path("requestBuild/{id}")
	@Produces (MediaType.TEXT_PLAIN)
	public String requestBuild(@PathParam("id") String id){
		String tools = "";
		String dbDetails = "";
		InputStream toolsInputStream;
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");

		Object port;
		String host;
		String username;
		String password;
		Object name;
		Object dbc;
		try {
				JSONObject vcap;
				/*System.out.println("VCAP_SERVICES"+VCAP_SERVICES.toString());
				JsonParser jsonParser= new JsonParser();
				Object obj =jsonParser.parse(new FileReader(VCAP_SERVICES));
				vcap = (JSONObject) obj;

				
				    JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
				    JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
				    JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");*/
				try {
					vcap = new JSONObject(VCAP_SERVICES);
					JSONArray cloudant = (JSONArray) vcap.get("cloudantNoSQLDB");
			        JSONObject cloudantInstance = (JSONObject) cloudant.get(0);
			        JSONObject cloudantCredentials = (JSONObject) cloudantInstance.get("credentials");
				    host = (String) cloudantCredentials.get("host");
				    System.out.println("host"+host);
				    username = (String) cloudantCredentials.get("username");
				    System.out.println("username"+username);

				    password = (String) cloudantCredentials.get("password");
				    System.out.println("password"+password);
				    /*host = "d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix.cloudant.com";
				    System.out.println("host"+host);
				    username = "d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix";
				    System.out.println("username"+username);

				    password = "1f0aa702970db23972f4757d06c6bcf4ddce36a123e70d9038becdb12bd7e783";
				    String url = "https://d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix:1f0aa702970db23972f4757d06c6bcf4ddce36a123e70d9038becdb12bd7e783@d2ae8506-7956-45e3-a704-a49900f1ddf1-bluemix.cloudant.com";
				    		System.out.println("url@@@@"+url);
				    System.out.println("password"+password);*/
				    CloudantClient client = ClientBuilder.account(username)
				            .username(username)
				            .password(password)
				            .build();
				    List<String> clientDb = client.getAllDbs();			    
				    for (String string : clientDb) {
				    	if(string.equalsIgnoreCase("toolsdata")){
				    	}   	 
				    }
					Database db = client.database("toolsdata", false);

				    InputStream inputStream = null;	
				    try{
					     inputStream = db.find("tools");
					     //inputStream = db.findByIndex(("\"selector\": {\"id}"), DataServices.class, new FindByIndexOptions() )("tools");

					     InputStreamReader toolRelist = new InputStreamReader(inputStream);
						BufferedReader br1 = new BufferedReader(toolRelist);
						String line1;
						
							while ((line1 = br1.readLine()) != null) {
								tools += line1 + "\n";
								if(tools =="1"){
									
								}
							}
							System.out.println("tools"+tools);
					     //do stuff with the stream
					 } finally {
					     //close the input stream
					     inputStream.close();
					 }
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				//System.out.println(vcap);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//String toolList="Testing";
		
		return tools;
		/*RtcScmBuild buildController = new RtcScmBuild();
		return String.valueOf(buildController.triggerBuild("https://9.109.122.193:9443/ccm/", "Pavan", "passw0rd", "jke.dev"));*/
	}
	
	@POST 
	@Consumes (MediaType.APPLICATION_JSON)
	@Path("triggerBuild")
	@Produces (MediaType.TEXT_PLAIN)
	public String triggerBuild(final RtcConfig config){
		RtcScmBuild buildController = new RtcScmBuild();
		return String.valueOf(buildController.triggerBuild(config.repositoryUri, config.user, config.password, config.buildDefinitionId));
	}
	
	@POST 
	@Consumes (MediaType.APPLICATION_JSON)
	@Path("requestBuildState/{id}")
	@Produces (MediaType.TEXT_PLAIN)
	public String requestBuildState(@PathParam("id") String id,final RtcConfig config){
		
		RtcScmBuild buildController = new RtcScmBuild();
		try {
			return String.valueOf(buildController.checkState(config.repositoryUri, config.user, config.password,id));
		} catch (TeamRepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR FETCHING STATE";
		}
	}
}
