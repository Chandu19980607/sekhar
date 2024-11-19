package com.kishore.sekhar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

    @Entity
	@Table(name = "affl_instructural_area")
	public class AfflInstructuralAreaEntity {

	    @Id
	    private Integer id; // Assuming you have an ID for the entity

	    private Integer coll_code;
	    private String ac_year;
	    private String instructional_area;
	    private String admin_area;
	    private String amenities_area;
	    private String access_circul_area;

	    // Getters and Setters

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
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

	    public String getInstructional_area() {
	        return instructional_area;
	    }

	    public void setInstructional_area(String instructional_area) {
	        this.instructional_area = instructional_area;
	    }

	    public String getAdmin_area() {
	        return admin_area;
	    }

	    public void setAdmin_area(String admin_area) {
	        this.admin_area = admin_area;
	    }

	    public String getAmenities_area() {
	        return amenities_area;
	    }

	    public void setAmenities_area(String amenities_area) {
	        this.amenities_area = amenities_area;
	    }

	    public String getAccess_circul_area() {
	        return access_circul_area;
	    }

	    public void setAccess_circul_area(String access_circul_area) {
	        this.access_circul_area = access_circul_area;
	    }
	}


