package com.nt.entity;

import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
//@RequiredArgsConstructor
@AllArgsConstructor
public class Person 
{
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "PER_SEQ", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private int pid;
	
	@Nonnull
	@Column(length = 20)
	private String pname;
	
	@Nonnull
	@Column(length = 20)
	private String paddrs;
	
	@OneToMany(targetEntity = PhoneNumber.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personInfo")
	private Set<PhoneNumber> numbers;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", numbers=" + numbers + "]";
	}
	
	public Person()
	{
		System.out.println("PersonObj : " + getClass().getName());
	}
}
