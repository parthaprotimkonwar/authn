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
@Table(name="USERS_FRUGAL", schema=SCHEMA_NAME_AUTHORIZATION)
public class UsersFrugal {

	public UsersFrugal() {
	}
	
	public UsersFrugal(Long userId, String name, String password, Date lastLogin, Date createdOn, String emailId, String phoneNo, String status) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.lastLogin = lastLogin;
		this.createdOn = createdOn;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.status = status;
	}
	
	@Id
	@Column(name="USER_ID", length=100, nullable=false)
	public Long userId;
	
	@Column(name="NAME", length=30)
	public String name;
	
	@Column(name="PASSWORD", length=50, nullable=false)
	public String password;
	
	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	public Date lastLogin;

	@Column(name="CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	public Date createdOn;
	
	@Column(name="EMAIL_ID", length=30, nullable=false, unique=true)
	public String emailId;
	
	@Column(name="PHONE_NO", length=15)
	public String phoneNo;
	
	@Column(name="STATUS", length=30)
	public String status;
	
}
