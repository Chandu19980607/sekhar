package com.kishore.sekhar.service;


import org.springframework.http.ResponseEntity;

import com.kishore.sekhar.model.BuildingBlocksEntity;
import com.kishore.sekhar.model.BuildingBlocksReqBody;
import com.kishore.sekhar.model.BuildingDetailsFloorsEntity;

public interface BuildingBlockService  {



	
	  ResponseEntity<?> saveBuildingBlockDetails(BuildingBlocksReqBody reqBody);



}
