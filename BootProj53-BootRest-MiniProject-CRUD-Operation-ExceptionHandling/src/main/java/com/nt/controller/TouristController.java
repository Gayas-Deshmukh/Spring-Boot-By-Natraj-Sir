package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristController 
{
	@Autowired
	private ITouristMgmtService touristService;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrolTourist(@RequestBody Tourist tourist) throws Exception
	{
		String msg = touristService.registerTourist(tourist);
		
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/all-tourist")
	public ResponseEntity<List<Tourist>> getAllTourist() throws Exception
	{
		List<Tourist> tourists = touristService.fetchAllTourist();
		
		return new ResponseEntity<List<Tourist>>(tourists, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Tourist> getTouristById(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<Tourist>(touristService.fetchTouristById(id), HttpStatus.OK);
	}
	
	@GetMapping("/findbycities/{city1}/{city2}/{city3}")
	public ResponseEntity<List<Tourist>> getAllTouristByCities(@PathVariable(required = false, name = "city1") String city1,
													@PathVariable(required = false, name = "city2") String city2,
													@PathVariable(required = false, name = "city3") String city3) throws Exception
	{
		List<Tourist> tourists = touristService.fetchAllTouristByCities(city1, city2, city3);
		
		return new ResponseEntity<List<Tourist>>(tourists, HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist)
	{
		String msg = touristService.updateTouristDetails(tourist);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PatchMapping("/patchUpdate/{id}/{pertHike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("id") Integer id, @PathVariable("pertHike") Double perHike)
	{
		String msg = touristService.updateTouristBudgetById(id, perHike);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable("id") Integer id) throws Exception
	{
		String msg = touristService.removeTouristById(id);
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
