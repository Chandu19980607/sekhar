package com.kishore.sekhar.model;

import java.security.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="affl_buildingblock_dtls")
@IdClass(BuildingBlockSerial.class)
public class BuildingBlocksEntity {

	@Id
	@Column(name="coll_code")
	private Integer coll_code;
	
	@Id
	@Column(name="ac_year")
	private String ac_year;
	
	@Id
	@Column(name="build_block_name")
	private String build_block_name;
	
	@Id
	@Column(name="sl_no",nullable=false)
	private Integer sl_no;
	
	
	@Column(name="block_no")
	private Integer block_no;
	
	
	@Column(name="site_area")
	private float site_area;
	
	
	@Column(name = "campus_type")
	private String campus_type;;
	
	

	@Column(name = "no_of_floors")
	private Integer no_of_floors;
	
	
	@Column(name = "building_img")
	private String buildingimg;
	
	@Column(name = "ffca_status")
	private Boolean ffca_status;
	
	@Column(name = "ffca_deficiencies")
	private String ffca_deficiencies;
	
	
	@CreationTimestamp
	@Column(name="created_time")
	private LocalDateTime created_time;
	
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name="created_ip")
	private String created_ip;
	
	
	
	
	
}
