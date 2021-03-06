package com.baruch.coupons.exceptionHandler;


import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.baruch.coupons.dataObjectsForPresentation.ErrorDataObject;
import com.baruch.coupons.enums.ErrorTypes;
import com.baruch.coupons.exceptions.ApplicationException;


@RestControllerAdvice
public class ExceptionsHandler {

	
	@ExceptionHandler
	@ResponseBody
	public ErrorDataObject toResponse(Throwable throwable, HttpServletResponse response) {
		
		if(throwable instanceof ApplicationException) {
		
			ApplicationException appException = (ApplicationException) throwable;

			ErrorTypes errorType = appException.getType(); 
			int errorNumber = errorType.getSerialNumber();
			String errorMessage = errorType.getMessage();
			String errorName = errorType.toString();
			response.setStatus(errorNumber);
			ErrorDataObject errorDataObject = new ErrorDataObject(errorNumber, errorMessage, errorName);
			if(errorType.shouldPrintStackTrace()){
				appException.printStackTrace();
				System.out.println(appException.getMessage());
			}
			return errorDataObject;
		}
		
		response.setStatus(332);

		ErrorDataObject errorDataObject = new ErrorDataObject(301, "General error", 
		"Sorry, our services are currently unavailable");
		
		throwable.printStackTrace();

		return errorDataObject;
	}

}

