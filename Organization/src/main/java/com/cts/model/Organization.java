package com.cts.model;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Organization {
	@Id
	private int id;
	private String name;
	private float turnover;
	private int branches;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTurnover() {
		return turnover;
	}
	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}
	public int getBranches() {
		return branches;
	}
	public void setBranches(int branches) {
		this.branches = branches;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Organization(int id, String name, float turnover, int branches, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.branches = branches;
		this.date = date;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", turnover=" + turnover + ", branches=" + branches
				+ ", date=" + date + "]";
	}
	

}
