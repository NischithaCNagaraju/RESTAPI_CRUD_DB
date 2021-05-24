package com.cmdb.democmdb;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement
public class Inventory {
    private int PrimaryKey;
    private String Hostname;
    private String IPAddress;
    private String ApplicationName;
    private String EnvironmentName;
	public Inventory() {
		
	}
	public Inventory(String hostname)
	{
		Hostname = hostname; 	
	}
	public Inventory(int primaryKey, String hostname, String iPAddress, String applicationName,
			String environmentName) {
		super();
		PrimaryKey = primaryKey;
		Hostname = hostname;
		IPAddress = iPAddress;
		ApplicationName = applicationName;
		EnvironmentName = environmentName;
	}
	public int getPrimaryKey() {
		return PrimaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		PrimaryKey = primaryKey;
	}
	public String getHostname() {
		return Hostname;
	}
	public void setHostname(String hostname) {
		Hostname = hostname;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	public String getEnvironmentName() {
		return EnvironmentName;
	}
	public void setEnvironmentName(String environmentName) {
		EnvironmentName = environmentName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Hostname == null) ? 0 : Hostname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (Hostname == null) {
			if (other.Hostname != null)
				return false;
		} else if (!Hostname.equals(other.Hostname))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + Hostname + "-" + IPAddress + "]";
	}
	
    
} 	 