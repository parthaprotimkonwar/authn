package controllers.responsedto;

import java.util.List;

public class ListsAddressResponseDto extends BaseResponseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<AddressDto> address;
	
	public ListsAddressResponseDto() {}
	
	public ListsAddressResponseDto(String token, List<AddressDto> address, String status) {
		super(token, status);
		this.address = address;
	}
	
	public ListsAddressResponseDto(String token, List<AddressDto> address, String status, ErrorResponse errorResponse) {
		super(token, status, errorResponse);
		this.address = address;
	}
}
