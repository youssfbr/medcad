package com.github.youssfbr.medcad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.youssfbr.medcad.entities.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long>{

	List<Specialty> findAllByActiveTrue();
}
