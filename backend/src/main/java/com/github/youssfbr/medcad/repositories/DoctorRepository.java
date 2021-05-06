package com.github.youssfbr.medcad.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.youssfbr.medcad.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findAllByActiveTrue();
	Optional<Doctor> findByIdAndActiveTrue(Long id);
}
