package com.javaweb.responsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.model.BuildingDTO;
import com.javaweb.responsitory.BuildingReponsitory;
import com.javaweb.responsitory.entity.BuildingEntity;


@Repository
public class BuildingReponsitoryImpl implements BuildingReponsitory{
	
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic" ; 
	static final String USER = "root" ; 
	static final String PASS = "huy123" ; 
	
	@Override
	public List<BuildingEntity> findAll(String name , Long districtid) {
		 StringBuilder sql = new StringBuilder("SELECT * FROM estatebasic.building AS B WHERE 1 = 1");
		 	if(name != null && !name.equals("")) {
		 		sql.append(" AND B.name LIKE '%" + name + "%' ") ; 
		 	}
		 	
		 	if(districtid != null) {
		 		sql.append(" AND B.districtid =" + districtid + " ") ; 
		 	}
	        List<BuildingEntity> result = new ArrayList<>();
	       
	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement pstmt = conn.createStatement() ;   
	        	 ResultSet rs = pstmt.executeQuery(sql.toString()) ;
	        	  ) {
	           
	             
	                while (rs.next()) {
	                	BuildingEntity buildingEntity = new BuildingEntity();
	                	buildingEntity.setName(rs.getString("name"));
	                	buildingEntity.setWard(rs.getString("ward"));
	                	buildingEntity.setStreet(rs.getString("street"));
	                	buildingEntity.setNumbersOfBasement(rs.getInt("numberofbasement"));

	                    result.add(buildingEntity);
	                }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return result;
	}

}
