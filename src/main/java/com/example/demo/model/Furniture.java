package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "furnitures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Furniture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable= false, name="name")
	private String name;
	@Column(nullable= false, name="image")
	private String image;
	@Column(nullable= true, name="furniture_type")
	private String furnitureType;
	@Column(nullable= false, name="price")
	private double price;
}
