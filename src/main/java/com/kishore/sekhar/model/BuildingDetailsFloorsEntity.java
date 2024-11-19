package com.kishore.sekhar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(BuildingBlocksFloorsserial.class)
public class BuildingDetailsFloorsEntity {
	
	@Id
	@Column(name="coll_code")
	private Integer coll_code;
	
	@Id
	@Column(name="ac_year", nullable=false)
	private String ac_year;
	
	
	@Id
	@Column(name="block_slno")
	private Integer block_slno;
	
	
	@Id
	@Column(name="floor_no")
	private Integer floor_no;
	
	
	@Column(name="site_area")
	private Float site_area;
	
	
	@Column(name="user_id")
	private String user_id;
	
	@Column(name="ip_address")
	private String ip_address;

}
