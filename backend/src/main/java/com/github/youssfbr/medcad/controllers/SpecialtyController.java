package com.github.youssfbr.medcad.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
