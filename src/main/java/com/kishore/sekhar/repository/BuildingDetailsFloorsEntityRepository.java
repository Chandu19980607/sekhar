package com.kishore.sekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.sekhar.model.BuildingBlocksFloorsserial;
import com.kishore.sekhar.model.BuildingDetailsFloorsEntity;

@Repository
public interface BuildingDetailsFloorsEntityRepository extends JpaRepository<BuildingDetailsFloorsEntity, BuildingBlocksFloorsserial> {

}
