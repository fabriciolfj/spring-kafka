package com.course.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.kafkaproducer.entity.FoodOrder;
import com.course.kafkaproducer.producer.FoodOrderProducer;

@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Autowired
	private FoodOrderProducer producer;

	@Override
	public void run(String... args) throws Exception {
		var chickenOrder = new FoodOrder(3, "Chicken");
		var fishOrder = new FoodOrder(10, "Fish");
		var pizzaOrder = new FoodOrder(5, "Pizza");

		producer.send(chickenOrder);
		producer.send(fishOrder);
		producer.send(pizzaOrder);
	}

}
