package com.kishore.sekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.sekhar.model.AfflInstructuralAreaEntity;

@Repository
public interface AfflInstructuralAreaRepository extends JpaRepository<AfflInstructuralAreaEntity, Integer> {

}
