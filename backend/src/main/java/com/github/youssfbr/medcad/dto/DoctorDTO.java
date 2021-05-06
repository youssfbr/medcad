package com.github.youssfbr.medcad.dto;

import java.io.Serializable;
import java.util.Date;

import com.github.youssfbr.medcad.entities.Doctor;

public class DoctorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date birthDate;
	private boolean active;
	
	public DoctorDTO() {	
	}	
	
	public DoctorDTO(Long id, String name, Date birthDate, boolean active) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.active = active;
	}
	
	public DoctorDTO(Doctor entity) {
		id = entity.getId();
		name = entity.getName();
		birthDate = entity.getBirthDate();
		active = entity.isActive();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	
}
