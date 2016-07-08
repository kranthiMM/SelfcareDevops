package com.ibm.devops.ssportal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Techincalstacks {
	private String id;
	   private String stackType;
	   
	/**
	 * @return the id
	 */
	   @JsonProperty("Id")
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	   @JsonProperty("Id")
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the stackType
	 */
	   @JsonProperty("tech_stack")
	public String getStackType() {
		return stackType;
	}
	/**
	 * @param stackType the stackType to set
	 */
	   @JsonProperty("tech_stack")
	public void setStackType(String stackType) {
		this.stackType = stackType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Techincalstacks [id=" + id + ", stackType=" + stackType + "]";
	}
	   
	   

}
