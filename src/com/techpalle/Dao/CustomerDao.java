package com.techpalle.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Customer;

public class CustomerDao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	

	public static void insertDetailes(Customer c) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer_Management","root","upendra");
			 String  qry="insert into customer(name,email,mobile) values(?,?,?)";
			 ps=con.prepareStatement(qry);

			 ps.setString(1,c.getName());
			 ps.setString(2,c.getEmail());
			 ps.setLong(3,c.getMobile());
			 ps.executeUpdate();
		 
			 
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
					
				ps.close();
			} 
				if(con!=null)
				{
					con.close();
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	public static void updateDetailes(Customer c) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer_Management","root","upendra");
			 String  qry="update customer set name=?,email=?,mobile=? where id=?";
			 ps=con.prepareStatement(qry);
			 ps.setString(1,c.getName());
			 ps.setString(2,c.getEmail());
			 ps.setLong(3,c.getMobile());
			 ps.setInt(4,c.getId());
			 
			 ps.executeUpdate();
		 
			 
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
					
				ps.close();
			} 
				if(con!=null)
				{
					con.close();
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	public static ArrayList<Customer> showAll()
	{
		ArrayList<Customer> a=new ArrayList<Customer>();
		try 
	    {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer_Management","root","upendra");
			String qry="select * from customer";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(qry);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				long mobile=rs.getLong("mobile");
				Customer s1=new Customer(id, name, email, mobile);
				a.add(s1);
			
			}
			
		 
			
		} 
	    catch (ClassNotFoundException e1) 
	    {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    finally
	    {
	    	try {
	    		if(ps!=null)
	    		{
				ps.close();
	    		}
	    		if(con!=null)
	    		{
	    			con.close();
	    		}
			} 
	    	
	    	catch (SQLException e1) {
				e1.printStackTrace();
			}
	    }
		return a;
		
	    
	}
	public static void deleteDetailes(int i) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer_Management","root","upendra");
			 String  qry="delete from customer where id=?";
			 
			 ps=con.prepareStatement(qry);
			 ps.setInt(1,i);
			 ps.executeUpdate();
		 
			 
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(ps!=null)
				{
					
				ps.close();
			} 
				if(con!=null)
				{
					con.close();
				}
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	

}
