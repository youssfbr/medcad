package com.github.youssfbr.medcad.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.youssfbr.medcad.dto.SpecialtyDTO;
import com.github.youssfbr.medcad.entities.Specialty;
import com.github.youssfbr.medcad.repositories.SpecialtyRepository;
import com.github.youssfbr.medcad.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialtyService {

	private final SpecialtyRepository repository;	
	
	public SpecialtyService(final SpecialtyRepository repository) {
		this.repository = repository;		
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
			
		entity = repository.save(entity);
		
		return new SpecialtyDTO(entity);
	}
	
	@Transactional
	public SpecialtyDTO update(Long id, SpecialtyDTO dto) {
		try {
			
			Specialty entity = repository.getOne(id);
			
			copyDtoToEntity(dto, entity);								
			
			entity = repository.save(entity);
			
			return new SpecialtyDTO(entity);				
		} 
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " não encontrado!");
		}		
	}
	
	public void delete(Long id) {
		try {
				
				Specialty entity = repository.findByIdAndIsActiveTrue(id)
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
	
	private Specialty copyDtoToEntity(SpecialtyDTO dto, Specialty entity) {
		
		entity.setName(validateDto(dto.getName()) ? dto.getName() : entity.getName());
		entity.setDescription(validateDto(dto.getDescription()) ? dto.getDescription() : entity.getDescription());		
		
		return entity;
	}	
		
}
