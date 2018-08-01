package com.Deloitte;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB_helper {
	 
public ArrayList getAllPassengers(String destination)
{   ArrayList al=new ArrayList();
	try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String uname="scott";
	String upass="tiger";
	Connection con=DriverManager.getConnection(url,uname,upass);
    PreparedStatement ps=con.prepareStatement("select * from passengers where destination=?");
    ps.setString(1, destination);
    ResultSet rs=ps.executeQuery();
   
    while(rs.next())
    {
    	String fname=rs.getString(1);
    	String lname=rs.getString(2);
    	String src=rs.getString(3);
    	String dest=rs.getString(4);
    	String gend=rs.getString(5);
    	PassengerVO pvo=new PassengerVO();
    	pvo.setFirstName(fname);
    	pvo.setLastName(lname);
    	pvo.setSource(src);
    	pvo.setDestination(dest);
    	pvo.setGender(gend);
    	al.add(pvo);
    }
   rs.close();
   ps.close();
   con.close();
	}

catch(SQLException se)
{
	System.out.println("SQL Exception");
}
catch(ClassNotFoundException cs)	
{
	System.out.println("Class Not Found Exception");
}
	System.out.println("Size"+al.size());
	return al;
	

}
}
