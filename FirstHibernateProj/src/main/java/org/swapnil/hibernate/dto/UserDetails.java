package org.swapnil.hibernate.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // it declare the class as an entity class And we can even change the
		// database name is not compulsory it should be same as class name
@Table(name = "USER_DETAILS") // to define the table name if needed
public class UserDetails {

	@Id // it will the define id as the primary
	@GeneratedValue(strategy = GenerationType.AUTO) // It will generate value we
													// no need to assign the
													// value it should be int
													// not string
	private int userId;

	@Column(name = "USER_NAME")
	// @Transient it is use to skip or ignore the field
	private String userName;

	@Temporal(TemporalType.DATE) // It will only save the date
	private Date joinedDate; // datatype bydefault will be timestamp format will
								// be 2017-05-17 21:28:17.903

	@Embedded 
	@AttributeOverrides({ 
	@AttributeOverride (name="street", column=@Column(name="HOME_STREET_NAME" )),
	@AttributeOverride (name="city", column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state", column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode", column=@Column(name="HOME_PIN_CODE"))})
	private Address homeAddress;
	
	@Embedded // it will tell it is embedded
	private Address officeAddress;

	


	@Lob // huge amount of byte or string use Lob
	private String Description;

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return Description;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
