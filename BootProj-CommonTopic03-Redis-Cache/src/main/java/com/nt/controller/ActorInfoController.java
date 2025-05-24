package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.ActorInfo;
import com.nt.service.IActorInfoMgmtService;

@RestController
@RequestMapping("/actor-api")
public class ActorInfoController
{
	@Autowired
	private IActorInfoMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<ActorInfo> saveActor(@RequestBody ActorInfo actor)
	{
		ActorInfo actorInfo = service.register(actor);
		
		return new ResponseEntity<ActorInfo>(actorInfo, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ActorInfo> updateActor(@RequestBody ActorInfo actor)
	{
		ActorInfo actorInfo = service.updateActor(actor);
		
		return new ResponseEntity<ActorInfo>(actorInfo, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ActorInfo> findByActorId(@PathVariable("id") int id)
	{
		ActorInfo actorInfo = service.findActorInfoByInfo(id);
		
		return new ResponseEntity<ActorInfo>(actorInfo, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ActorInfo>> showAllActors()
	{
		List<ActorInfo> allActors = service.getAllActors();
		
		return new ResponseEntity<List<ActorInfo>>(allActors, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByActorId(@PathVariable("id") int id)
	{
		String msg = service.deleteActorInfo(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
