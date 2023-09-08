package com.in.eschool.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Assignment")
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String Description;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Assignment(Integer id, String title, String description, User user) {
		super();
		this.id = id;
		this.title = title;
		Description = description;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Assignment(Integer id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		Description = description;
	}

	public Assignment() {
		// TODO Auto-generated constructor stub
	}

}
