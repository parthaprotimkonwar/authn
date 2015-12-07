package models;

import static utilities.Constants.SCHEMA_NAME_AUTHORIZATION;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS", schema=SCHEMA_NAME_AUTHORIZATION)
public class Users {

	public Users(String userType) {
		this.userType = userType;
	}
	
	public Users(Long userId) {
		this.userId = userId;
	}
	
	public Users() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	public Long userId;
	
	@Column(name="USER_TYPE", length=15)
	public String userType;
	
	@OneToOne(mappedBy="user")
	public UserToken userToken;
	
	@OneToMany(mappedBy="userIdAddressId.user")
	public Set<UserAddress> userAddress;
}
