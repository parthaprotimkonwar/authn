package models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserIdAddressId implements Serializable{

	private static final long serialVersionUID = 1L;

	public UserIdAddressId(Users user, Address address) {
		this.user = user;
		this.address = address;
	}
	
	public UserIdAddressId() {}
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	public Users user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADDRESS_ID")
	public Address address;
	
}
