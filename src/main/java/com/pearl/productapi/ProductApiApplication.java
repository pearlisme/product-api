package com.pearl.productapi;

import com.pearl.productapi.model.Product;
import com.pearl.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository){
		return args -> {

			Flux<Product> productFlux = Flux.just(
			new Product(null,"cake",3.0),
			new Product(null,"Coco",4.0),
			new Product(null,"Mocha",6.0))
					.flatMap(productRepository::save);

				productFlux.thenMany(productRepository.findAll())
						.subscribe(System.out::println);

		};


	}

}
