package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.SpecialtyDTO;
import com.github.youssfbr.medcad.entities.Specialty;
import com.github.youssfbr.medcad.repositories.SpecialtyRepository;

@Service
public class SpecialtyService {

	private SpecialtyRepository repository;
	
	public SpecialtyService(final SpecialtyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<SpecialtyDTO> findAll() {
		List<Specialty> list = repository.findAllByActiveTrue();
		return list.stream().map(sp -> new SpecialtyDTO(sp)).collect(Collectors.toList());
	}
	
	
}
