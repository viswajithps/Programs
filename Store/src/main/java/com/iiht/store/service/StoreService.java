package com.iiht.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.store.Repository.BreadRepository;
import com.iiht.store.Repository.EggRepository;
import com.iiht.store.Repository.MilkRepository;
import com.iiht.store.entity.Bread;
import com.iiht.store.entity.Egg;
import com.iiht.store.entity.Milk;

@Service
public class StoreService {
	
	@Autowired
	EggRepository egg;
	
	@Autowired
	MilkRepository milk;
	
	@Autowired
	BreadRepository bread;
	
	
	public Egg saveEgg(Egg egg1) {
		return egg.save(egg1);
	}
	
	public Optional<Egg> getEggbyId(long id) {
		return egg.findById(id);
	}
	
	public List<Egg> findEgg() {
		return egg.findAll();
	}
	
	public Milk saveMilk(Milk milk1) {
		return milk.save(milk1);
	}
	
	public Optional<Milk> getMilkbyId(long id) {
		return milk.findById(id);
	}
	
	public List<Milk> findMilk() {
		return milk.findAll();
	}
	
	
	public Bread saveBread(Bread bread1) {
		return bread.save(bread1);
	}
	
	public Optional<Bread> findBreadbyId(long id) {
		return bread.findById(id);
	}
	
	public List<Bread> findBread() {
		return bread.findAll();
	}

}
