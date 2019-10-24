package com.springmvc.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Repairlist")
public class Repairlist {
	
	
	@Id
	@Column(name="Fullname")
	private String Fullname;
	
	
	@Column(name="Type")
	private String Type;
	
	@Column(name="Problem")
	private String Problem;
	
	@Column(name="Attachment")
	private String Attachment;
	

	@Column(name="Start")
	private String Start;

	@Column(name="End")
	private String End;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name = "BuildingID")
	private Building buliding;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name = "UserID")
	private ListUser listuser;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn (name = "RoomID")
	private Room room;


	public Repairlist(){
		
	}
	public Repairlist(String fullname, String type, String problem, String attachment, Building buliding,
			ListUser listuser, Room room) {
		super();
		this.Fullname = fullname;
		this.Type = type;
		this.Problem = problem;
		this.Attachment = attachment;
		this.buliding = buliding;
		this.listuser = listuser;
		this.room = room;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getProblem() {
		return Problem;
	}

	public void setProblem(String problem) {
		Problem = problem;
	}

	public String getAttachment() {
		return Attachment;
	}

	public void setAttachment(String attachment) {
		Attachment = attachment;
	}

	public String getStart() {
		return Start;
	}

	public void setStart(String start) {
		Start = start;
	}

	public String getEnd() {
		return End;
	}

	public void setEnd(String end) {
		End = end;
	}

	public Building getBuliding() {
		return buliding;
	}

	public void setBuliding(Building buliding) {
		this.buliding = buliding;
	}
	public ListUser getListuser() {
		return listuser;
	}
	public void setListuser(ListUser listuser) {
		this.listuser = listuser;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	} 

	
}
