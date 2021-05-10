package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.DoctorDTO;
import com.github.youssfbr.medcad.entities.Doctor;
import com.github.youssfbr.medcad.repositories.DoctorRepository;
import com.github.youssfbr.medcad.services.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {

	private final DoctorRepository repository;
	
	public DoctorService(final DoctorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<DoctorDTO> findAll() {
		final List<Doctor> list = repository.findAllByIsActiveTrue();
		return list.stream().map(doc -> new DoctorDTO(doc)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DoctorDTO findById(Long id) {		
		
		Doctor entity = repository.findByIdAndIsActiveTrue(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
		
		return new DoctorDTO(entity);
	}
	
	@Transactional
	public DoctorDTO insert(DoctorDTO dto) {
		
		Doctor entity = new Doctor();		
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate());		
		entity = repository.save(entity);
		
		return new DoctorDTO(entity);		
	}
	
	@Transactional
	public DoctorDTO update(Long id, DoctorDTO dto) {
		try {			
			Doctor entity = repository.getOne(id);
	
			copyDtoToEntity(dto, entity);								
			entity = repository.save(entity);
			
			return new DoctorDTO(entity);				
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " não encontrado!");
		}		
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			
			Doctor entity = repository.findByIdAndIsActiveTrue(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
			
			entity.setActive(false);
			
			repository.save(entity);
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " não encontrado!");
		} 		
	}
	
	private boolean validateDto(Object object) {
		return Objects.nonNull(object) && !object.toString().isEmpty();
	}
	
	private Doctor copyDtoToEntity(DoctorDTO dto, Doctor entity) {
		entity.setName(validateDto(dto.getName()) ? dto.getName() : entity.getName());
		entity.setBirthDate(validateDto(dto.getBirthDate()) ? dto.getBirthDate() : entity.getBirthDate());
		return entity;
	}
	
}
