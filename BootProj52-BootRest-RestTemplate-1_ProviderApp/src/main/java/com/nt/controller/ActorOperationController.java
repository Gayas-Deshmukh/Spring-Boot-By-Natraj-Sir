package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationController 
{
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor)
	{
		return new ResponseEntity<String>("Actor Data :" + actor.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<Actor> getActorData()
	{
		Actor actor = new Actor(544, "Gokul", 35, "backActor");
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
	
	@GetMapping("/reportAll")
	public ResponseEntity<List<Actor>> getAllActorsData()
	{
		Actor actor1 = new Actor(544, "Gokul", 35, "backActor");
		Actor actor2 = new Actor(888, "Rahul", 88, "FronyActor");

		return new ResponseEntity<List<Actor>>(List.of(actor1, actor2), HttpStatus.OK);
	}
}
