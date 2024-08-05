package com.javaweb.customException;

public class FieldRequiredException extends RuntimeException { // tương tự như exception nhưng không cần dùng throws ở void 

	public FieldRequiredException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
}
