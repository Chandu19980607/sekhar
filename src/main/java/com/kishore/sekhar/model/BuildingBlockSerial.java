package com.kishore.sekhar.model;

import java.io.Serializable;

public class BuildingBlockSerial implements Serializable {
	
	private String build_block_name;
	
	private Integer sl_no;
	
	private Integer coll_code;
	
	private String ac_year;
	
	

	public String getBuild_block_name() {
		return build_block_name;
	}

	public void setBuild_block_name(String build_block_name) {
		this.build_block_name = build_block_name;
	}

	public Integer getSl_no() {
		return sl_no;
	}

	public void setSl_no(Integer sl_no) {
		this.sl_no = sl_no;
	}

	public Integer getColl_code() {
		return coll_code;
	}

	public void setColl_code(Integer coll_code) {
		this.coll_code = coll_code;
	}

	public String getAc_year() {
		return ac_year;
	}

	public void setAc_year(String ac_year) {
		this.ac_year = ac_year;
	}

	
	
	

	
	
	

}
