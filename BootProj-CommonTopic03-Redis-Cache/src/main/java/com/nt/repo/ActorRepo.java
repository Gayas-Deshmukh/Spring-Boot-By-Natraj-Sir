package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ActorInfo;

public interface ActorRepo extends JpaRepository<ActorInfo, Integer>
{

}
