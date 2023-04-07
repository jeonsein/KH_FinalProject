package org.zerock.myapp.exception;


public class AException extends Exception {
	private static final long serialVersionUID = 1l;
	
	public AException(String message) {
		super(message);
	} // constructor1
	
	public AException(Exception e) {
		super(e);
	} // constructor2


} // AException