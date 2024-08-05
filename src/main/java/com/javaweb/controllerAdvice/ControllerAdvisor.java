package com.javaweb.controllerAdvice;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.ErrorResonseDTO;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            ArithmeticException ex, WebRequest request) {

		ErrorResonseDTO errorResponseDTO = new ErrorResonseDTO() ; 
		errorResponseDTO.setError(ex.getMessage()); 
		ArrayList<String> details = new ArrayList<>() ; 
		details.add("Số Nguyên làm sao chia cho 0") ;
		errorResponseDTO.setDetail(details);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(FieldRequiredException.class) //Định nghĩa ngoại lệ mà hàm dưới sẽ nhận 
    public ResponseEntity<Object> handleMethodArgumentNotValid( //đặt tên hàm có ý nghĩa nhất có thể , <> là giá trị mà hàm trả về
    		FieldRequiredException ex, WebRequest request) {// hàm nhận 2 giá trị biến 1 là tên exception hoặc exception tự định nghĩa , 2 là weberequest có thể có nhiều biến
		// có thể tra tên ở gg

		ErrorResonseDTO errorResponseDTO = new ErrorResonseDTO() ; //lớp beans error bạn tự định nghĩa chứ ai
		errorResponseDTO.setError(ex.getMessage());  //ex.getgetMessage có tác dụng get ra getMessage ở exception tự định nghĩa hoặc có sẳn
		ArrayList<String> details = new ArrayList<>() ; 
		details.add("Check Lai Vi Bi Null") ;
		errorResponseDTO.setDetail(details);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY); //trả về lỗi 
        //errorResponseDTO(đã được định nghĩa ở lớp) và httpstatus HttpStatus.BAD_GATEWAY (lỗi 502)
    }

}
