package com.cg.mypaymentapp.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.mypaymentapp.exception.WalletException;

public class DBConnection {
	
	private static Connection con;
	public static Connection getConection() throws WalletException{
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "rishabh";
		String password = "rishabh";
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class Loaded !!!! ");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to db .... ");
		}
		catch (SQLException e) {
			// TODO: handle exception
			throw new WalletException(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new WalletException(e.getMessage());
		}
		return con;
	}
	
	
}
