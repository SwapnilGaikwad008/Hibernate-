package org.swapnil.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

	@ElementCollection(fetch=FetchType.EAGER)// it will tell the hibernate its the collection of
						// object of entity table we can add multiple address
						// for single id
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	/*@GenericGenerator(name = "sequence-gen", strategy = "sequence") // its a
																	// hibernate
																	// generator
																	// similar is hilo-gen and @CollectionId is also a hibernate  Annotaion.
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type = "long"))
*/	
	
	private Collection<Address> listofAddress = new ArrayList<Address>();

	public Collection<Address> getListofAddress() {
		return listofAddress;
	}

	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
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
