package com.github.youssfbr.medcad.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.youssfbr.medcad.entities.Doctor;
import com.github.youssfbr.medcad.entities.Specialty;

public class DoctorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Date birthDate;	
		
	@JsonInclude(Include.NON_DEFAULT)	
	private List<SpecialtyDTO> specialties = new ArrayList<>();
		
	public DoctorDTO() {	
	}	
	
	public DoctorDTO(Long id, String name, Date birthDate, boolean isActive) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;			
	}

	public DoctorDTO(Doctor entity) {
		id = entity.getId();
		name = entity.getName();
		birthDate = entity.getBirthDate();				
	}
	
	public DoctorDTO(Doctor entity, Set<Specialty> specialties) {
		this(entity);
		specialties.forEach(sp -> this.specialties.add(new SpecialtyDTO(sp)));		
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

	public List<SpecialtyDTO> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(List<SpecialtyDTO> specialties) {
		this.specialties = specialties;
	}	
	
}
