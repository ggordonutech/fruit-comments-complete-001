package com.fruitcomments.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruitcomments.api.entities.Fruit;

public interface IFruitRepository 
   extends JpaRepository<Fruit,Integer>
{

}
