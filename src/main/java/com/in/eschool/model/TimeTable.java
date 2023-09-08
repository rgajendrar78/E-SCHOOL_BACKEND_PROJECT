package com.in.eschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TimeTable")
public class TimeTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String classs;
	private String sem;
	private String subject;
	private String starttime;
	private String endtime;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getClasss() {
		return classs;
	}


	public void setClasss(String classs) {
		this.classs = classs;
	}


	public String getSem() {
		return sem;
	}


	public void setSem(String sem) {
		this.sem = sem;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public TimeTable(Integer id, String classs, String sem, String subject, String starttime, String endtime) {
		super();
		this.id = id;
		this.classs = classs;
		this.sem = sem;
		this.subject = subject;
		this.starttime = starttime;
		this.endtime = endtime;
	}


	public TimeTable() {
		// TODO Auto-generated constructor stub
	}

}
