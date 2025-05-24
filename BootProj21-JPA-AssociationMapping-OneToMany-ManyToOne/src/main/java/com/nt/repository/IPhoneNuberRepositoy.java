package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PhoneNumber;

public interface IPhoneNuberRepositoy extends JpaRepository<PhoneNumber, Integer> 
{

}
