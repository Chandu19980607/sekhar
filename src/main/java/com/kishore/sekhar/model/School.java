package com.kishore.sekhar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Data
@Entity
@Table(name="schooldtls")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long schoolId;
	private String schoolFName;
	private String schoolLName;
	private String fullname;
	private int strength;
	private String village;
	public String name;
	
	@PrePersist
	public void prepersist() {
		if (schoolId==null) {
			schoolId=1L;
			
		}
	}
	

}
