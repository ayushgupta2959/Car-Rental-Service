package carRentalService.common;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
	private static Database jdbc;
	
	private Database() {  }  
    public static Database getInstance() {    
    	if (jdbc==null) {  
    		jdbc=new  Database();  
        }  
        return jdbc;  
    } 
    
    private static Connection getConnection()throws ClassNotFoundException, SQLException  {  
          
        Connection con=null;  
        Class.forName("org.mariadb.jdbc.Driver");  
        con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/carService", "root", "home");  
        return con;      
    }
         
    public int insertDriver(int id,String licenceNo,String name,String address,String contactNo, String dateOfJoin,String statusFlag,double salary) throws SQLException {
    	Connection connection = null;
    	PreparedStatement ps = null;
    	int recordCounter = 0;
    	try {  
            
    		connection=Database.getConnection();  
            ps=connection.prepareStatement("insert into Driver values(?,?,?,?,?,?,?,?)"); 
            ps.setInt(1,id);
            ps.setString(2,licenceNo);
            ps.setString(3,name);
            ps.setString(4,address);
            ps.setString(5,contactNo);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(dateOfJoin); 
            Date date  = new Date(parsed.getTime());
            ps.setDate(6,date);
            ps.setString(7,statusFlag);
            ps.setDouble(8,salary);
            recordCounter=ps.executeUpdate();  
    	} catch (Exception e) { 
    		e.printStackTrace();
    	} finally{  
    		if (ps!=null)
				ps.close();  
    		if(connection!=null)  
    			connection.close();  
    	}     
    	return recordCounter;  
    }
    
    /*public void insertEmployee() {
    	
    }
    */
    
    /*public void insertLogin() {
    	
    }
    */
    
    public int insertSchedule(int driverID,String plateNo,int custID,Date hireDate,Date dateToReturn,String returnStatus) throws SQLException {
    	Connection connection = null;
    	PreparedStatement ps = null;
    	int recordCounter = 0;
    	try {  
    		connection=Database.getConnection();  
            ps=connection.prepareStatement("insert into Schedule values(?,?,?,?,?,?)"); 
            ps.setInt(1,driverID);
            ps.setString(2,plateNo);
            ps.setInt(3,custID);
            ps.setDate(4,hireDate);
            ps.setDate(5,dateToReturn);
            ps.setString(6,returnStatus);
            recordCounter=ps.executeUpdate();  
    	} catch (Exception e) { 
    		e.printStackTrace();
    	} finally{  
    		if (ps!=null)
				ps.close();  
    		if(connection!=null)  
    			connection.close();  
    	}     
    	return recordCounter;  
    }
    
    public int insertVehicle(String plateNo,String name,String statusFlag,String category,double rate_perKM,String registrationNo) throws SQLException {
    	Connection connection = null;
    	PreparedStatement ps = null;
    	int recordCounter = 0;
    	try {  
            
    		connection=Database.getConnection();  
            ps=connection.prepareStatement("insert into Vehicle values(?,?,?,?,?,?)"); 
            ps.setString(1,plateNo);
            ps.setString(2,name);
            ps.setString(3,statusFlag);
            ps.setString(4,category);
            ps.setDouble(5,rate_perKM);
            ps.setString(6,registrationNo);
            recordCounter=ps.executeUpdate();  
    	} catch (Exception e) { 
    		e.printStackTrace();
    	} finally{  
    		if (ps!=null)
				ps.close();  
    		if(connection!=null)  
    			connection.close();  
    	}     
    	return recordCounter;
    }
    
    public void updateSchedule() {
    	
    }
    
    public void updateDriver() {
    	
    }
    
    public String[] getVehicle(String category) {
    	String vehicle[] = null;
    	return vehicle;
    	
    }
    
    public String[] getDriver() {
    	String driver[] = null;
    	return driver;
    }
    
    public char[] getPassword(int username) throws SQLException {
    	Connection con = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;
        char[] password = null;
        	try {  
                    con=Database.getConnection();  
                    ps=con.prepareStatement("select password from Login where userid=?");  
                    ps.setInt(1,username);  
                    rs=ps.executeQuery(); 
                    if(rs.next())
                    	password = rs.getString(1).toCharArray();       
                } catch (Exception e) {
                	e.printStackTrace();
                } finally{  
                	if(rs!=null){  
                       rs.close();  
                   }if (ps!=null){  
                	   ps.close();  
                   }if(con!=null){  
                       con.close();  
                   }   
                } 
        	return password;
      }
    
    public String getTag(int username) throws SQLException {
    	Connection con = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;
        String tag = null;
        	try {  
                    con=Database.getConnection();  
                    ps=con.prepareStatement("select tag from Login where userid=?");  
                    ps.setInt(1,username);  
                    rs=ps.executeQuery();   
                    if(rs.next())
                    	tag = rs.getString(1);       
                } catch (Exception e) {
                	e.printStackTrace();
                } finally{  
                	if(rs!=null){  
                       rs.close();  
                   }if (ps!=null){  
                	   ps.close();  
                   }if(con!=null){  
                       con.close();  
                   }   
                } 
        	return tag;
      }
}
