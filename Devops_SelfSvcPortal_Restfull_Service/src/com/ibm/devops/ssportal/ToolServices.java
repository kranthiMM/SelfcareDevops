package com.ibm.devops.ssportal;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ToolServices {
	 private String id;
	   private String type;
	   private String name;
	   private String version;
	   private List<Techincalstacks> techStacks= new ArrayList<Techincalstacks>();
	   private String devopsPhases;
	   private String description;
	/**
	 * @return the id
	 */
	   @JsonProperty("id")
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	   @JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	   @JsonProperty("type")
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	   @JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	   @JsonProperty("name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	   @JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the version
	 */
	   @JsonProperty("version")
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	   @JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the devopsPhases
	 */
	   @JsonProperty("devops_phases")
	public String getDevopsPhases() {
		return devopsPhases;
	}
	/**
	 * @param devopsPhases the devopsPhases to set
	 */
	   @JsonProperty("devops_phases")
	public void setDevopsPhases(String devopsPhases) {
		this.devopsPhases = devopsPhases;
	}
	/**
	 * @return the description
	 */
	   @JsonProperty("description")
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	   @JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the techStacks
	 */
	   @JsonProperty("tech_stack")
	public List<Techincalstacks> getTechStacks() {
		return techStacks;
	}
	/**
	 * @param techStacks the techStacks to set
	 */
	   @JsonProperty("tech_stack")
	public void setTechStacks(List<Techincalstacks> techStacks) {
		this.techStacks = techStacks;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToolServices [id=" + id + ", type=" + type + ", name=" + name
				+ ", version=" + version + ", techStacks=" + techStacks
				+ ", devopsPhases=" + devopsPhases + ", description="
				+ description + "]";
	}
	


	
}
