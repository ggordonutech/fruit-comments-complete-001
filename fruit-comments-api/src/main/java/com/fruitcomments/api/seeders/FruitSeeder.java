package com.fruitcomments.api.seeders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.fruitcomments.api.entities.Fruit;
import com.fruitcomments.api.repositories.IFruitRepository;

@Component
public class FruitSeeder {

	private Fruit[] defaultData = new Fruit[] {
			new Fruit(1, "Banana", "They are usually yellow",
					"http://www.pngall.com/wp-content/uploads/2016/04/Banana-PNG.png"),
			new Fruit(2, "Apple", "An apple is a sweet, edible fruit produced by an apple tree.",
					"https://images.freshop.com/00852201002228/ad2f58915e3267700906f1025ef8917f_medium.png") };
	@Autowired
	protected IFruitRepository fruitRepo;

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		System.out.println("----------- Seeding Fruits -------");
		try {
			for (Fruit defaultFruit : defaultData) {
				Example<Fruit> fruitExample = Example.of(defaultFruit);
				Optional<Fruit> fruitResult = fruitRepo.findOne(fruitExample);

				if (fruitResult.isPresent()) {
					System.out.println("Fruit already exists in database " + defaultFruit);
				} else {
					System.out.println("Inserting fruit in database " + defaultFruit);
					fruitRepo.save(defaultFruit);
				}
			}
			System.out.println("----------- Completed Seeding Fruits -------");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----------- Unable to Fruits -------");
		}

	}

}
