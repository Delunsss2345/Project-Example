package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.model.BuildingDTO;


public interface BuildingService {
	List<BuildingDTO> findAll(String name , Long districtid) ; 
}
