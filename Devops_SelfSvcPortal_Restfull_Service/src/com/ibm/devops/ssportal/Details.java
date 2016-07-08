/**
 * 
 *//*
package com.ibm.devops.ssportal;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

*//**
 * @author kranthi
 *
 *//*
@XmlRootElement(name = "details")
public class Details implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   private int id;
	   private String toolName;
	   private ToolServices toolServicelist;
	   private String serviceType;
	   private ToolServices services;
	   private String serviceDescription;
	   private String icon;
	   
	*//**
	 * 
	 *//*
	public Details() {
		// TODO Auto-generated constructor stub
	}
	public Details(int id, String toolName, ToolServices toolServicelist,ToolServices services ,String serviceType,String serviceDescription){
	      this.id = id;
	      this.toolName = toolName;
	      this.toolServicelist = toolServicelist;
	      this.serviceType = serviceType;
	      this.services = services;
	      this.serviceDescription = serviceDescription;
	      

	   }
	 public int getId() {
	      return id;
	   }

	   @XmlElement
	   public void setId(int id) {
	      this.id = id;
	   }
	*//**
	 * @return the toolName
	 *//*
	public String getToolName() {
		return toolName;
	}
	*//**
	 * @param toolName the toolName to set
	 *//*
	 @XmlElement
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	*//**
	 * @return the toolServicelist
	 *//*
	public ToolServices getToolServicelist() {
		return toolServicelist;
	}
	*//**
	 * @param toolServicelist the toolServicelist to set
	 *//*
	 @XmlElement
	public void setToolServicelist(ToolServices toolServicelist) {
		this.toolServicelist = toolServicelist;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public ToolServices getServices() {
		return services;
	}
	public void setServices(ToolServices services) {
		this.services = services;
	}
	*//**
	 * @return the serviceDescription
	 *//*
	public String getServiceDescription() {
		return serviceDescription;
	}
	*//**
	 * @param serviceDescription the serviceDescription to set
	 *//*
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	*//**
	 * @return the icon
	 *//*
	public String getIcon() {
		return icon;
	}
	*//**
	 * @param icon the icon to set
	 *//*
	public void setIcon(String icon) {
		this.icon = icon;
	}
	  	
}
*/