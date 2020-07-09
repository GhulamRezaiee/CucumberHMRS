package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class storingData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc: driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	
	@Test
	public void getAndStoreData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location");
			
		List<Map<String, String>> listOfData = new ArrayList<>();
		
		Map<String, String> mapData;
		
		while(rs.next()) {
			mapData = new LinkedHashMap<>();
			mapData.put("Location ID", rs.getObject("id").toString());
			System.out.println(mapData);
			mapData.put("Office Name", rs.getObject("name").toString());
			System.out.println(mapData);
			mapData.put("Country Code", rs.getObject("country_code").toString());
			System.out.println(mapData);
			listOfData.add(mapData);
		}
		
		System.out.println(listOfData);
		rs.close();
		st.close();
		conn.close();
		
	}
	
	@Test
	public void retrieveAndStoreDataEnhanced() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		
			
		List<Map<String, String>> listOfData = new ArrayList<>();
		
		Map<String, String> mapData;
		
		while(rs.next()) {
			mapData = new LinkedHashMap<>();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
			mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			listOfData.add(mapData);
		}
		System.out.println(listOfData);
		
		rs.close();
		st.close();
		conn.close();
	}
}