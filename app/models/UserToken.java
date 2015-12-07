package models;

import static utilities.Constants.SCHEMA_NAME_AUTHORIZATION;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_TOKEN", schema=SCHEMA_NAME_AUTHORIZATION)
public class UserToken {

	public UserToken() {}
	
	public UserToken(String tokenId, Long expiryDateTime, Users user) {
		this.tokenId = tokenId;
		this.expiryDateTime = expiryDateTime;
		this.user = user;
	}
	
	@Id
	@Column(name="TOKEN_ID", length=100)
	public String tokenId;
	
	/*@Column(name="EXPIRY_DATETIME", length=20)
	@Temporal(TemporalType.TIMESTAMP)
	public Date expiryDateTime;*/
	
	@Column(name="EXPIRY_DATETIME", length=20)
	public Long expiryDateTime;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn
	public Users user;
}
