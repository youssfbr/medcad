package com.github.youssfbr.medcad.dto;

import java.io.Serializable;

import com.github.youssfbr.medcad.entities.Specialty;

public class SpecialtyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private boolean active;
	
	public SpecialtyDTO() {	
	}

	public SpecialtyDTO(Long id, String name, String description, boolean active) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
	}
	
	public SpecialtyDTO(final Specialty entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	
}
