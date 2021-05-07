package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.DoctorDTO;
import com.github.youssfbr.medcad.entities.Doctor;
import com.github.youssfbr.medcad.repositories.DoctorRepository;
import com.github.youssfbr.medcad.services.exceptions.ResourceNotFoundException;

@Service
public class DoctorService {

	private DoctorRepository repository;
	
	public DoctorService(final DoctorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<DoctorDTO> findAll() {
		final List<Doctor> list = repository.findAllByActiveTrue();
		return list.stream().map(doc -> new DoctorDTO(doc)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DoctorDTO findById(Long id) {		
		
		Doctor entity = repository.findByIdAndActiveTrue(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
		
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
}
