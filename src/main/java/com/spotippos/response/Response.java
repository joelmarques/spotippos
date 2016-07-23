package com.spotippos.response;

public class Response {

	ResponseStatusEnum status;
	String message;

	public Response(ResponseStatusEnum status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusEnum status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static final Response SUCCESS() {
		return new Response(ResponseStatusEnum.SUCCESS, "Operation was successful");
	}
	
	public static final Response ERROR(String message) {
		return new Response(ResponseStatusEnum.ERROR, message);
	}

}