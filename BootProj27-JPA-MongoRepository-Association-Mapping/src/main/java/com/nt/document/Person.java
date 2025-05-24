package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Person
{
	@Id
	@Nonnull
	private Integer pid;
	
	@Nonnull
	private String name;
	
	@Nonnull
	private String addrs;
	
	private DrivingLicence licence;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", addrs=" + addrs + "]";
	}
}
