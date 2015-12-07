package controllers.requestdto;

import java.io.Serializable;

import validations.Fields;

public class LoginRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String emailId;
	public String phoneNo;
	public String password;
	public String userType;
	public String name;
	
	
	public enum LoginRequestFields implements Fields {
		emailId,
		phoneNo,
		password,
		userType,
		name;

		@Override
		public String getStringValue() {
			return this.name();
		}
	}
}
