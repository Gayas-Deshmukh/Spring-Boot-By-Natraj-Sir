package com.nt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@RequiredArgsConstructor
@Setter
@Getter
public class PhoneNumber 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private Long number;
	
	@Nonnull
	private String provider;

//	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	      // OR
	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "person_id", referencedColumnName = "pid")
	private Person personInfo;

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", number=" + number + ", provider=" + provider + "]";
	}
	
	public PhoneNumber()
	{
		System.out.println("PhoneNumberObj : " + getClass().getName());
	}
}
