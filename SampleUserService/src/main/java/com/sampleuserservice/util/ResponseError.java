package com.sampleuserservice.util;

import com.sampleuserservice.util.Constant.ErrorType;

public class ResponseError {
	private int status;
	private ErrorType error;
	private Object message;	
	
	public ResponseError(int status, ErrorType error, Object message) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ErrorType getError() {
		return error;
	}
	public void setError(ErrorType error) {
		this.error = error;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
}
