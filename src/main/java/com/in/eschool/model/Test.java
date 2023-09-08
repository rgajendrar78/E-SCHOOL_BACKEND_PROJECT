package com.in.eschool.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String sub;
	private String mark;
	private String testdate;
	private String classs;
	private String sem;
	private String result;
	@ManyToOne(fetch = FetchType.EAGER)
	 private User user;
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(Integer id, String sub, String mark, String testdate, String classs, String sem, String result,
			User user) {
		super();
		this.id = id;
		this.sub = sub;
		this.mark = mark;
		this.testdate = testdate;
		this.classs = classs;
		this.sem = sem;
		this.result = result;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}