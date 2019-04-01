package com.cgi.fic.api.exceptions;

public class FicApiException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4084469028531589930L;
	
	
	private final ErrorResource errorResource;
	/**
	 * 
	 * @param errorResource
	 */
	public FicApiException(ErrorResource errorResource) {
		super();
		this.errorResource = errorResource;
	}


	public ErrorResource getErrorResource() {
		return errorResource;
	}

}
