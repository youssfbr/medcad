package com.github.youssfbr.medcad.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_doctor")
public class Doctor implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Date birthDate;
	private boolean isActive;	
	
	@ManyToMany
	@JoinTable(name = "tb_doctor_specialty",
		joinColumns = @JoinColumn(name = "doctor_id"),
		inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	Set<Specialty> specialties = new HashSet<>();
	
	public Doctor() {	
	}

	public Doctor(Long id, String name, Date birthDate, boolean isActive) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.isActive = isActive;
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
		return isActive;
	}	
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}	

	public Set<Specialty> getSpecialties() {		
		return specialties;
	}

	@PrePersist
	public void prePersist() {
		isActive = true;		 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
