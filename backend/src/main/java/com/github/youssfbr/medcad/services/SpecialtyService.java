package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.SpecialtyDTO;
import com.github.youssfbr.medcad.entities.Specialty;
import com.github.youssfbr.medcad.repositories.SpecialtyRepository;
import com.github.youssfbr.medcad.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialtyService {

	private SpecialtyRepository repository;
	
	public SpecialtyService(final SpecialtyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<SpecialtyDTO> findAll() {
		final List<Specialty> list = repository.findAllByActiveTrue();
		return list.stream().map(sp -> new SpecialtyDTO(sp)).collect(Collectors.toList());
	}	
	
	@Transactional(readOnly = true)
	public SpecialtyDTO findById(Long id) {		
		
		Specialty entity = repository.findByIdAndActiveTrue(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não encontrado!"));
		
		return new SpecialtyDTO(entity);
	}
		
}
