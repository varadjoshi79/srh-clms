package com.srh.clms.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "ATTENDANCE")
public class Attendance implements Serializable {
	@Id
	@Column(name = "ATTENDENCE_ID")
	private String attendence_id;	
	

	@Column(name = "IN_TIME")
	private Date inTime;
	@Column(name = "OUT_TIME")
	private Date outTime;
	@Column(name = "CARD_ID")
	private long cardId;
	@Column(name = "STATUS")
	private String status;
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LABOURER_ID_INFO")
	private Labourer labour;
	public Labourer getLabour() {
		return labour;
	}

	public Attendance() 
	{

	}
	public String getAttendence_id() {
		return attendence_id;
	}
	
	public void setAttendence_id(String attendence_id) {
		this.attendence_id = attendence_id;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}
	public void setLabour(Labourer labour) {
		this.labour = labour;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}