package com.nt.model.promotions;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
public class Offers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerid;
	
	private String offerName;
	
	private String offerCode;
	
	private Double discountPer;
	
	private LocalDateTime expDate;
}
