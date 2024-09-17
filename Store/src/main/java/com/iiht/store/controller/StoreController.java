package com.iiht.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.store.entity.Bread;
import com.iiht.store.entity.Egg;
import com.iiht.store.entity.Milk;
import com.iiht.store.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	StoreService service;
	
	
	@GetMapping("/egg")
	public ResponseEntity<?>getEgg(){
		return ResponseEntity.ok().body(service.findEgg());
	}
	
	@GetMapping("/milk")
	public ResponseEntity<?>getMilk(){
		return ResponseEntity.ok().body(service.findMilk());
	}
	
	
	@GetMapping("/bread")
	public ResponseEntity<?>getBread(){
		return ResponseEntity.ok().body(service.findBread());
	}
	
	
	@GetMapping("/bread/{id}")
	public ResponseEntity<?>getBreadById(@PathVariable long id){
		return ResponseEntity.ok().body(service.findBreadbyId(id));
	}
	
	
	@GetMapping("/milk/{id}")
	public ResponseEntity<?>getMilkById(@PathVariable long id){
		return ResponseEntity.ok().body(service.getMilkbyId(id));
	}
	
	
	@GetMapping("/egg/{id}")
	public ResponseEntity<?>getEggById(@PathVariable long id){
		return ResponseEntity.ok().body(service.getEggbyId(id));
	}
	
	@PostMapping("/egg")
	public ResponseEntity<?>saveEgg(@RequestBody Egg egg){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEgg(egg));
	}
	
	
	@PostMapping("/milk")
	public ResponseEntity<?>saveMilk(@RequestBody Milk milk){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMilk(milk));
	}
	
	@PostMapping("/bread")
	public ResponseEntity<?>saveBread(@RequestBody Bread bread){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveBread(bread));
	}
	
	
	/*
	 * @GetMapping() public ResponseEntity<?>getAll(){ ArrayList<?>l=new
	 * ArrayList<>(); l.append(service.findEgg()); }
	 */
}
