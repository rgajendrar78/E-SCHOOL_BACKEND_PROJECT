package com.in.eschool.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;
	private String attendancedate;
	private boolean ispresent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	 private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAttendancedate() {
		return attendancedate;
	}

	public void setAttendancedate(String attendancedate) {
		this.attendancedate = attendancedate;
	}

	public boolean isIspresent() {
		return ispresent;
	}

	public void setIspresent(boolean ispresent) {
		this.ispresent = ispresent;
	}

	public Attendance(Integer id, String attendancedate, boolean ispresent) {
		super();
		this.id = id;
		this.attendancedate = attendancedate;
		this.ispresent = ispresent;
	}

	public Attendance() {
	
	}

	public Attendance(Integer id, String attendancedate, boolean ispresent, User user) {
		super();
		this.id = id;
		this.attendancedate = attendancedate;
		this.ispresent = ispresent;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
