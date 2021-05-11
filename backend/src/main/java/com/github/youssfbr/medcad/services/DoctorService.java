package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.Objects;
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
public class DoctorService {

	private final DoctorRepository repository;
	
	private final SpecialtyRepository specialtyRepository;
	
	public DoctorService(final DoctorRepository repository, final SpecialtyRepository specialtyRepository) {
		this.repository = repository;
		this.specialtyRepository = specialtyRepository;
	}
	
	@Transactional(readOnly = true)
	public List<DoctorDTO> findAll() {
		final List<Doctor> list = repository.findAllByIsActiveTrue();
		return list.stream()
				.map(entity -> new DoctorDTO(entity, entity.getSpecialties())).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DoctorDTO findById(Long id) {		
		
		Doctor entity = repository.findByIdAndIsActiveTrue(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
				
		return new DoctorDTO(entity, entity.getSpecialties());
	}
	
	@Transactional
	public DoctorDTO insert(DoctorDTO dto) {
		
		Doctor entity = new Doctor();		
			
		copyDtoToEntity(dto, entity);	
				
		entity = repository.save(entity);
				
		return new DoctorDTO(entity, entity.getSpecialties());		
	}
	
	@Transactional
	public DoctorDTO update(Long id, DoctorDTO dto) {
		try {			
			
			Doctor entity = repository.getOne(id);
	
			copyDtoToEntity(dto, entity);								
			entity = repository.save(entity);
			
			return new DoctorDTO(entity,entity.getSpecialties());				
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
		
		
		entity.getSpecialties().clear();
		
		for (SpecialtyDTO sp : dto.getSpecialties()) {
					
			Specialty specialty = specialtyRepository.getOne(sp.getId());
					
			entity.getSpecialties().add(specialty);			
		}
		
		return entity;
	}
	
}
