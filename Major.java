package com.springmvc.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Major")
public class Major {
	@Column(name="MajorID")
	@Id
	
	private String MajorID;
	
	
	@Column(name="MajorName")
	private String MajorName;

	@OneToMany (cascade=CascadeType.ALL, mappedBy = "major")
	private Set<ListUser> listuser = new HashSet<>();
	
	public Major(String majorID, String majorName) {
		super();
		MajorID = majorID;
		MajorName = majorName;
	}
	public Major(){
		
	}

	public String getMajorID() {
		return MajorID;
	}


	public void setMajorID(String majorID) {
		MajorID = majorID;
	}


	public String getMajorName() {
		return MajorName;
	}


	public void setMajorName(String majorName) {
		MajorName = majorName;
	}
	
	
	
}
