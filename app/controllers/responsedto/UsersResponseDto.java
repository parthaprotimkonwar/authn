package controllers.responsedto;

import java.io.Serializable;

public class UsersResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;

	public UsersResponseDto()
	{
	}
	
	/**
	 * Constructor for sending Success Response
	 * @param userId
	 * @param status
	 */
	public UsersResponseDto(Long userId, String token, String status) {
		this.userId = userId;
		this.token = token;
		this.status = status;
	}
	
	public Long getUserId()
	{
		return userId;
	}
	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String status;
	public String token;
	private Long userId;
	
}
