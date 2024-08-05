package com.javaweb.api;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResonseDTO;
import com.javaweb.service.BuildingService;

import java.sql.Statement ; 

@RestController // Đây là Annotation để đánh dấu rằng lớp BuildingAPI là một controller trong Spring MVC
public class BuildingAPI {
	
	@Autowired 
	private BuildingService buildingService;
    @GetMapping(value = "/api/building/")
    // c2 @RequestMapping(value = "/api/building/" , method = RequestMethod.GET)
    public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false, defaultValue = "") String name ,
    									 @RequestParam(name = "districtid", required = false, defaultValue = "") Long districtid ,
    									 @RequestParam(name = "typeCode", required = false, defaultValue = "") List<String> typeCode) {
    	List<BuildingDTO> result = buildingService.findAll(name , districtid) ; 
        return result;
    }
	
//	public void valiDate(BuildingDTO buildingDTO) {
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumbers() == null) {
//			throw new FieldRequiredException("name or numbers is null") ; 
//		}
//	}
	
//	@PostMapping(value = "/api/building/")
//	//c2 @RequestMapping(value = "/api/building/" , method = RequestMethod.POST) ngoài ra nhiều @khác tương tự
//	public void getBuilding2(@RequestBody BuildingDTO buildingDTO ) {
//		System.out.print("ok") ; 
//	}
	
//	@DeleteMapping(value = "/api/building/{id}/{name}/")
//	public void deleteBuilding(@PathVariable Integer id,
//							   @PathVariable String name, 
//							   @RequestParam (value = "numbers" , required = false) Integer numbers) {
//		System.out.println("Da Xoa Roi") ; 
//	}
}  