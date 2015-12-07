package controllers.responsedto;

public class AddressResponseDto extends BaseResponseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Long addressId;
	
	public AddressResponseDto() {}
	
	public AddressResponseDto(String token, Long addressId, String status) {
		super(token, status);
		this.addressId = addressId;
	}
	
	public AddressResponseDto(String token, Long addressId, String status, ErrorResponse errorResponse) {
		super(token, status, errorResponse);
		this.addressId = addressId;
	}
	

	
}
