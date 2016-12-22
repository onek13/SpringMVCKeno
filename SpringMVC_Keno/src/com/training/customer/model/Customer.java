/**
 * 
 */
package com.training.customer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Keno San Pedro
 *
 */

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name="tbl_customer")
public class Customer {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="creation_date")
	Date creationDate;
	
	@Column(name="last_update_date")
	Date lastUpdateDate;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="id_type")
	String idType;
	
	@Column(name="id_number")
	String idNumber;
	
	@Column(name="contact_number")
	String contactNumber;

	public Customer() {
		super();
	}

	public Customer(int id, Date creationDate, Date lastUpdateDate, String firstName, String lastName, String idType,
			String idNumber, String contactNumber) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.idNumber = idNumber;
		this.contactNumber = contactNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	

}
