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
@Table(name="Room")
public class Room {
	
	@Id
	@Column(name="RoomID")
	private String RoomID;
	
	
	@Column(name="Floor")
	private String Floor;
	
	@Column(name="RoomName")
	private String RoomName;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="StaffID")
	private String StaffID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name = "BuildingID")
	private Building buliding;
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "room")
	private Set<Repairlist> repairlist = new HashSet<>();
	
	public Room(String roomID, String floor, String roomName, String description, String staffID) {
		super();
		RoomID = roomID;
		Floor = floor;
		RoomName = roomName;
		Description = description;
		StaffID = staffID;
	}
	public Room(){
		
	}
	public String getRoomID() {
		return RoomID;
	}
	public void setRoomID(String roomID) {
		RoomID = roomID;
	}

	public String getFloor() {
		return Floor;
	}
	public void setFloor(String floor) {
		Floor = floor;
	}
	public String getRoomName() {
		return RoomName;
	}
	public void setRoomName(String roomName) {
		RoomName = roomName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	
}
