package org.swapnil.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Vehicle {
	@Id // it will the define id as the primary
	@GeneratedValue(strategy = GenerationType.AUTO) 	private int userId;

	private int vehicleId;
	private String vehicleName;
	@ManyToMany
	//@NotFound(action=NotFoundAction.IGNORE) if we get any exception to handle or ignore particular exception
	private Collection<UserDetails> userList = new ArrayList();
	
	public Collection<UserDetails> getUserList() {
		return userList;
	}
	public void setUserList(Collection<UserDetails> userList) {
		this.userList = userList;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

}
