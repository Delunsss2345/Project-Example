package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.responsitory.BuildingReponsitory;
import com.javaweb.responsitory.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	
	@Autowired // tìm tới những thằng không có hàm khởi tạo 
	private BuildingReponsitory buildingReponsitory;

	@Override
	public List<BuildingDTO> findAll(String name ,Long districtid) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntities = buildingReponsitory.findAll(name , districtid) ; 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ; 
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO() ; 
			building.setName(item.getName());
			building.setAddress(item.getStreet() + "," + item.getWard());
			building.setNumbersOfBasement(item.getNumbersOfBasement());
			result.add(building); 
		}
	
		
		return result;
	}
	
}
