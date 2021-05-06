package com.github.youssfbr.medcad.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.youssfbr.medcad.dto.DoctorDTO;
import com.github.youssfbr.medcad.services.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	private DoctorService service;
	
	public DoctorController(final DoctorService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<DoctorDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
