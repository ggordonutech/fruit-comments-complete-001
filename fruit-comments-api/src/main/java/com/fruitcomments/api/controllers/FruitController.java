package com.fruitcomments.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruitcomments.api.entities.Fruit;
import com.fruitcomments.api.exceptions.ResourceNotFoundException;
import com.fruitcomments.api.services.FruitService;

@CrossOrigin
@RestController
@RequestMapping("/api/fruits") 
public class FruitController {
	
	@Autowired
	protected FruitService fruitService;
	
	@GetMapping("")
	public List<Fruit> getAll() {
		return fruitService.getAll();
	}
	
	@GetMapping("/{id}")
	public Fruit get(@PathVariable("id") int id) {
		Fruit data  = fruitService.get(id);
		if(data == null) {
			throw new ResourceNotFoundException("Fruit", "id", id);
		}
		return data;
	}
	
	@PostMapping("")
	public Fruit create( @Valid @RequestBody Fruit data  ) {
		return fruitService.create(data);
	}
	
	@PutMapping("/{id}")
	public Fruit update(  
			@PathVariable("id") int id,
			@RequestBody Fruit data 
			) {
		return fruitService.update(id, data);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		//fruitService.delete(id);
		if(fruitService.delete(id))
		    return ResponseEntity.ok(true);
		else
			return ResponseEntity.status(400).body(false);
	}

}
