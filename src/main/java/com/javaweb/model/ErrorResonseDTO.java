package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResonseDTO {
	private String error ; 
	private List<String> Detail = new ArrayList<String>() ;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetail() {
		return Detail;
	}
	public void setDetail(List<String> detail) {
		Detail = detail;
	}
	
	
}
