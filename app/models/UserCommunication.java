package models;

import static utilities.Constants.SCHEMA_NAME_AUTHORIZATION;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_COMMUNICATION", schema=SCHEMA_NAME_AUTHORIZATION)
public class UserCommunication {

	@Id
	@Column(name="USER_ID", length=100, nullable=false)
	public Long userId;
	
	@Column(name="COMMUNICATION_ID", length=100, nullable=false)
	public Long communicationId;
	
}
