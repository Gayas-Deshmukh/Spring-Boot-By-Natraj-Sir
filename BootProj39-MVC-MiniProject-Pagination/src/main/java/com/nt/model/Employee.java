package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "empl_soft_deletion")
@Data
@AllArgsConstructor
@SQLDelete(sql="UPDATE empl_soft_deletion SET status='inactive' where empno=?")
@SQLRestriction(value = "status !='inactive'")
public class Employee 
{
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_id_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Nonnull
	private String ename;
	
	@Nonnull
	private String deg;
	
	@Nonnull
	private Float sal;
	
	private String status = "active";
	
	public Employee()
	{
		System.out.println("Employee constructor");
	}
}
