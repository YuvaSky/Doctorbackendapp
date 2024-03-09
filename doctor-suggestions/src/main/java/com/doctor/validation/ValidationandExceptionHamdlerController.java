package com.doctor.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.doctor.exception.DoctorNotFoundException;
import com.doctor.exception.PatientNotFoundException;

@RestControllerAdvice
public class ValidationandExceptionHamdlerController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		BindingResult res = ex.getBindingResult();
		List<ObjectError> error = res.getAllErrors();
		List<String> errorList = new ArrayList<String>();
		for(ObjectError errors:error) {
			errorList.add(errors.getDefaultMessage());
		}
		ExceptionMessage em = new ExceptionMessage();
		em.setErrorList(errorList);
		em.setMessage("Validation failed...");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
	}
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Object> handleDoctorNotFoundException(DoctorNotFoundException ex){
		ExceptionMessage errors = new ExceptionMessage();
		List<String> errorList=new ArrayList<String>();
		errorList.add(ex.getMessage());
		errors.setErrorList(errorList);
		errors.setMessage("DoctorNotFoundException...");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex){
		ExceptionMessage errors = new ExceptionMessage();
		List<String> errorList=new ArrayList<String>();
		errorList.add(ex.getMessage());
		errors.setErrorList(errorList);
		errors.setMessage("Eception occured...");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatientNotFoundException(PatientNotFoundException ex){
		ExceptionMessage em = new ExceptionMessage();
		List<String> errorList = new ArrayList<String>();
		errorList.add(ex.getMessage());
		em.setErrorList(errorList);
		em.setMessage("PatientNotFoundException...");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
}
