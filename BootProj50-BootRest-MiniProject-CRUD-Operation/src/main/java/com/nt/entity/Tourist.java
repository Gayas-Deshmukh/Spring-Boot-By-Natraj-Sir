package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="rest_tourist")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Tourist 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	
	@NonNull
	@Column(length = 20)
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String city;
	
	@NonNull
	@Column(length = 20)
	private String packageType;
	
	@NonNull
	private Double budget;
}
