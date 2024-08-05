package com.javaweb.responsitory;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.responsitory.entity.BuildingEntity;

public interface BuildingReponsitory{
	List<BuildingEntity> findAll(String name, Long districtid) ; 
}
