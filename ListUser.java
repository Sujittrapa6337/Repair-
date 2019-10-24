package com.springmvc.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ListUser")
public class ListUser {
	
	@Id
	@Column(name="UserID")
	private String UserID;
	
	@Column(name="Fullname")
	private String Fullname;
	
	@Column(name="Position")
	private String Position;
	
	
	@Column(name="Telephone")
	private String Telephone;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="Status")
	private String Status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name = "MajorID")
	private Major major;
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "listuser")
	private Set<Repairlist> repairlist = new HashSet<>();

	public ListUser(String userID, String fullname, String position, String telephone, String email,
			  String status) {
		super();
		UserID = userID;
		Fullname = fullname;
		Position = position;
		Telephone = telephone;
		Email = email;
		Status = status;
	}
	public ListUser(){
		
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Set<Repairlist> getRepairlist() {
		return repairlist;
	}
	public void setRepairlist(Set<Repairlist> repairlist) {
		this.repairlist = repairlist;
	}
	
	
}
