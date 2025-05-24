package com.nt.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class DrivingLicence 
{
	@Id
	@Nonnull
	private Long licenceNo;
	
	@Nonnull
	private String type;
	
	@Nonnull
	private LocalDate expiryDate;
	
	private Person personDetails;

	@Override
	public String toString() {
		return "DrivingLicence [licenceNo=" + licenceNo + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}
}
