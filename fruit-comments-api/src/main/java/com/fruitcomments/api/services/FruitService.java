package com.fruitcomments.api.services;

import com.fruitcomments.api.repositories.IFruitRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fruitcomments.api.entities.Fruit;

@Component
public class FruitService {
	
	@Autowired
	protected IFruitRepository fruitRepo;
	
	public List<Fruit> getAll(){
		return fruitRepo.findAll();
	}
	
	public Fruit create(Fruit fruit) {
		return fruitRepo.save(fruit);
	}
	
	public Fruit get(int id) {
		Optional<Fruit> result = fruitRepo.findById(id);
		return result.isPresent() ? result.get() : null;
	}
	
	public Fruit update(int id, Fruit data) {
		Optional<Fruit> result = fruitRepo.findById(id);
		if(result.isPresent()) {
			Fruit original = result.get();
			original.setName(data.getName());
			original.setDescription(data.getDescription());
			original.setPhotoUrl(data.getPhotoUrl());
			
			return fruitRepo.save(original);
		}
        return null;
	}
	
	public boolean delete(int id) {
		Optional<Fruit> result = fruitRepo.findById(id);
		if(result.isPresent()) {
			Fruit original = result.get();
			fruitRepo.delete(original);
			return true;
		}
        return false;
	}

}
