package models;

import static utilities.Constants.SCHEMA_NAME_AUTHORIZATION;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USERS_GUEST", schema=SCHEMA_NAME_AUTHORIZATION)
public class UsersGuest {

	public UsersGuest() {}
	
	public UsersGuest(Long userId, String emailId, Date lastLogin, Date createdOn, String phoneNo, String status, String firstName, String lastName) {
		this.userId = userId;
		this.emailId = emailId;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.phoneNo = phoneNo;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Id
	@Column(name="USER_ID", length=100, nullable=false)
	public Long userId;
	
	@Column(name="FIRST_NAME", length=20)
	public String firstName;
	
	@Column(name="LAST_NAME", length=20)
	public String lastName;
	
	@Column(name="EMAIL_ID", length=30, unique=true, nullable=false)
	public String emailId;
	
	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastLogin;
	
	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdOn;
	
	@Column(name="PHONE_NO", length=15)
	public String phoneNo;
	
	@Column(name="STATUS", length=30)
	public String status;
}
