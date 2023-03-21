package com.m2i.tp.appliSpring.dto;

//@Getter @Setter @ToString @NoArgsConstructor
//@AllArgsConstructor
public class ErrorDto {
	protected String message;
	protected String detail;
	
	
	
	@Override
	public String toString() {
		return "ErrorDto [message=" + message + ", detail=" + detail + "]";
	}


	public ErrorDto() {
		super();
	}


	public ErrorDto(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
