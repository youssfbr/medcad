package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.DoctorDTO;
import com.github.youssfbr.medcad.entities.Doctor;
import com.github.youssfbr.medcad.repositories.DoctorRepository;

@Service
public class DoctorService {

	private DoctorRepository repository;
	
	public DoctorService(final DoctorRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<DoctorDTO> findAll() {
		List<Doctor> list = repository.findAllByActiveTrue();
		return list.stream().map(doc -> new DoctorDTO(doc)).collect(Collectors.toList());
	}	
}
