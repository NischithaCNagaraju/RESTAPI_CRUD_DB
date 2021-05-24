package com.cmdb.democmdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
	private static InventoryDAO instance;
    private static List<Inventory> data = new ArrayList<Inventory>();
      
    static {
    	data.add(new Inventory(1, "hostname1", "255.255.0.1", "ios1", "ename1"));
    	data.add(new Inventory(2, "hostname2", "255.255.0.2", "ios2", "ename2"));
    }
    
    private InventoryDAO() {
    	
    }
    
    public static InventoryDAO getInstance() {
    	if(instance==null) {
    		instance = new InventoryDAO();
    	}
    	return instance;
    	
    }
    public List<Inventory> listAll() {
        return new ArrayList<Inventory>(data);
    }
    
    public static Connection conn = null; 
    
    public static void getConnection()
    {
    	String dbURL = "jdbc:mysql://localhost:3306/inventory";
		String username = "root";
		String password = "password";
		
		try{
			conn = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException ex) {
			System.out.println("cannot Connect to the database");
			ex.printStackTrace();			
		}
    }
    
    public void add(Inventory inv) throws SQLException {
        
    	getConnection();     	
    	String query = "INSERT INTO users(HostName,PrimaryKey, IPAddress, ApplicationName, EnvironmentName) "
        		+ "values(\""+ inv.getHostname()+"\", + \"" +inv.getPrimaryKey()+"\", +\"" +inv.getIPAddress()+"\", +\"" + inv.getApplicationName()+"\", +\"" + inv.getEnvironmentName()+"\")";
        Statement statement = conn.createStatement();
        statement.execute(query);
             
    }
    
    /*
    public String add(Inventory inventory) {
        int newId = data.size()+1; 
    	String newhostname = "hostname"+ String.valueOf(newId);   
        inventory.setHostname(newhostname);
        data.add(inventory);
         
        return newhostname;
    }
    */
     
    public Inventory get(String hostname) {
        Inventory productToFind = new Inventory(hostname);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }
     
    public boolean delete(String hostname) {
        Inventory productToFind = new Inventory(hostname);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }
         
        return false;
    }
     
    public boolean update(Inventory inventory) {
        int index = data.indexOf(inventory);
        if (index >= 0) {
            data.set(index, inventory);
            return true;
        }
        return false;
    }
    
    
}
