package com.kishore.sekhar.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BuildingBlocksFloorsserial implements Serializable {

	private Integer block_slno;
	
	private Integer floor_no;
	

	private Integer coll_code;
	
	private String ac_year;

}
