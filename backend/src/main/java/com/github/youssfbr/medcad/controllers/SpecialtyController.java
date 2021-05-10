package com.github.youssfbr.medcad.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.youssfbr.medcad.dto.SpecialtyDTO;
import com.github.youssfbr.medcad.services.SpecialtyService;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
	
	private SpecialtyService service;
	
	public SpecialtyController(final SpecialtyService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<SpecialtyDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SpecialtyDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<SpecialtyDTO> insert(@RequestBody SpecialtyDTO dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
				
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SpecialtyDTO> update(@PathVariable Long id, @RequestBody SpecialtyDTO dto) {
		dto = service.update(id, dto);
				
		return ResponseEntity.ok(dto);
	}

}
