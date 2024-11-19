package com.kishore.sekhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kishore.sekhar.model.BuildingBlocksEntity;
import com.kishore.sekhar.model.BuildingBlocksReqBody;
import com.kishore.sekhar.model.BuildingDetailsFloorsEntity;
import com.kishore.sekhar.service.BuildingBlockService;

@RestController
@RequestMapping("blocks")
public class BuildingBlockController {
	@Autowired
	
	BuildingBlockService bbservice;
	
	@PostMapping("buildingBlock")
    public ResponseEntity<?> saveBuildingBlockDetails(@RequestBody BuildingBlocksReqBody reqBody) {
		  return bbservice.saveBuildingBlockDetails(reqBody);
	}
	


		
	
	

	

}

