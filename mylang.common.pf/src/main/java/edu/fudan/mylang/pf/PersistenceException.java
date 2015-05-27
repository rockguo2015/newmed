package edu.fudan.mylang.pf;

public class PersistenceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersistenceException(Exception e) {
		super(e);
	}
	
	public PersistenceException(String message){
		super(message);
	}
}
