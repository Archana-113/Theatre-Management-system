package com.project.Theatre_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int staffId;
	private String staffName;
	private double staffSalary;
	private long staffPhone;
	private String staffEmail;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public double getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(double staffSalary) {
		this.staffSalary = staffSalary;
	}
	public long getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(long staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
}
