package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "caller_tune_info")
@Data
@NoArgsConstructor
public class CallerTuneInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneId;
	
	@Nonnull
	private String tuneName;
	
	@Version
	private Integer updatedCount;
	
	@CreationTimestamp
	private LocalDateTime optedOn;
	
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
	
}
