package org.zerock.myapp.exception;


public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	public ServiceException(String message) {
		super(message);
	} // Constructor#1
	
	public ServiceException(Exception originalException) {
		super(originalException);
	} // Constructor#2

} // end class
