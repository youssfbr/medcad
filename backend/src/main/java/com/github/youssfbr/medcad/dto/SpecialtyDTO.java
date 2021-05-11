package com.github.youssfbr.medcad.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.youssfbr.medcad.entities.Specialty;

public class SpecialtyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;	

	@JsonInclude(Include.NON_DEFAULT)	
	private List<DoctorDTO> doctors = new ArrayList<>();
	
	public SpecialtyDTO() {	
	}

	public SpecialtyDTO(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;		
	}
	
	public SpecialtyDTO(final Specialty entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();		
		doctors = entity.getDoctors().stream().map(x -> new DoctorDTO(x)).collect(Collectors.toList());
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
	
	public List<DoctorDTO> getDoctors() {
		return doctors;
	}	
		
}
