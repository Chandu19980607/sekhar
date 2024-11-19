package com.kishore.sekhar.dtoDesignPattern;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
@Table(name="locationdto")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int locationId;
	private double latitude;
	private double longitude;
	private String placeName;
	
	
	
	
	

}
