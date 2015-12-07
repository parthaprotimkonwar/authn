package controllers.requestdto;

import java.io.Serializable;

import controllers.responsedto.ErrorResponse;

public class LoginResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public LoginResponseDto(String token) {
		this.token = token;
	}
	
	public LoginResponseDto(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	public String token;
	public ErrorResponse errorResponse;
	
}
