package com.doctor.exception;

public class DoctorNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException(String msg) {
		super(msg);
	}

}
