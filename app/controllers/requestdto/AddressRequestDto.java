package controllers.requestdto;

import java.io.Serializable;

import validations.Fields;

public class AddressRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public String token;
	public String addressHeading;
	public String pincode;
	public String address;
	public String landmark;
	public String phoneNo;
	public String city;
	public String state;
	public String country;
	
	
	public enum AddressRequestDtoFields implements Fields {
		token,
		addressHeading,
		pincode,
		address,
		landmark,
		phoneNo,
		city,
		state,
		country;

		@Override
		public String getStringValue() {
			return this.name();
		}
	}

}
