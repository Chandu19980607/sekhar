package com.kishore.sekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.sekhar.model.BuildingBlockSerial;
import com.kishore.sekhar.model.BuildingBlocksEntity;



@Repository
public interface BuildingBlockRepository extends JpaRepository<BuildingBlocksEntity, BuildingBlockSerial>{

	
}
