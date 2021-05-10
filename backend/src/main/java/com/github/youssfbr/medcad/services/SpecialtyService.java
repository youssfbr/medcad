package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.DoctorDTO;
import com.github.youssfbr.medcad.dto.SpecialtyDTO;
import com.github.youssfbr.medcad.entities.Doctor;
import com.github.youssfbr.medcad.entities.Specialty;
import com.github.youssfbr.medcad.repositories.DoctorRepository;
import com.github.youssfbr.medcad.repositories.SpecialtyRepository;
import com.github.youssfbr.medcad.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialtyService {

	private SpecialtyRepository repository;
	private DoctorRepository doctorRepository;
	
	public SpecialtyService(final SpecialtyRepository repository, final DoctorRepository doctorRepository) {
		this.repository = repository;
		this.doctorRepository = doctorRepository;
	}
	
	@Transactional(readOnly = true)
	public List<SpecialtyDTO> findAll() {
		final List<Specialty> list = repository.findAllByIsActiveTrue();
		return list.stream().map(sp -> new SpecialtyDTO(sp)).collect(Collectors.toList());
	}	
	
	@Transactional(readOnly = true)
	public SpecialtyDTO findById(Long id) {		
		
		Specialty entity = repository.findByIdAndIsActiveTrue(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
		
		return new SpecialtyDTO(entity);
	}
	
	@Transactional
	public SpecialtyDTO insert(SpecialtyDTO dto) {
		
		Specialty entity = new Specialty();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		
		for (DoctorDTO d : dto.getDoctors()) {
			Doctor doctor = doctorRepository.getOne(d.getId());
			entity.getDoctors().add(doctor);
		}		
		entity = repository.save(entity);
		
		return new SpecialtyDTO(entity);
	}
	
	@Transactional
	public SpecialtyDTO update(Long id, SpecialtyDTO dto) {
		try {
			Specialty entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());		
			entity = repository.save(entity);
			
			return new SpecialtyDTO(entity);				
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " não encontrado!");
		}		
	}
		
}
