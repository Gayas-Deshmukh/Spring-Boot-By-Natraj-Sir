package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class MarriageSeeker 
{
	@Id
	@GeneratedValue
	private Long id;
	
	@Nonnull
	@Column(length = 20)
	private String name;
	
	@Nonnull
	@Column(length = 20)
	private String adds;
	
	@Nonnull
	private LocalDateTime dob;
	
	@Nonnull
	@Lob
	private byte [] photo;
	
	@Nonnull
	@Lob
	private char [] biodata;
	
	@Nonnull
	private boolean isIndian;
}
