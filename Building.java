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
@Table(name="Building")
public class Building {
	@Id
	@Column(name="BuildingID")
	private String BuildingID;
	
	@Column(name="BuildingName")
	private String BuildingName;
	
	@Column(name="Description")
	private String Description;
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "buliding")
	private Set<Repairlist> repairlist = new HashSet<>();
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "buliding")
	private Set<Room> room = new HashSet<>();

	public Building(String buildingID, String buildingName, String description) {
		super();
		BuildingID = buildingID;
		BuildingName = buildingName;
		Description = description;
	}
	public Building(){
		
	}
	public String getBuildingID() {
		return BuildingID;
	}

	public void setBuildingID(String buildingID) {
		BuildingID = buildingID;
	}

	public String getBuildingName() {
		return BuildingName;
	}

	public void setBuildingName(String buildingName) {
		BuildingName = buildingName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
}
