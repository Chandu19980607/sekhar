package com.kishore.sekhar.dtoDesignPattern;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name="usersdto")
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
//	private String email;
	private int phoneno;
	
	//@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="locationId")
	Location location;
	
}