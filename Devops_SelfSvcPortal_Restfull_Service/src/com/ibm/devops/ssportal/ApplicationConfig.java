package com.ibm.devops.ssportal;

import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@javax.ws.rs.ApplicationPath("ssportal")
public class ApplicationConfig extends Application {
@Context
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResouceClasses(resources);
		return resources;
	}

	private void addRestResouceClasses(Set<Class<?>> resources) {
		// TODO Auto-generated method stub
		resources.add(com.ibm.devops.ssportal.DataServices.class);
	}
}