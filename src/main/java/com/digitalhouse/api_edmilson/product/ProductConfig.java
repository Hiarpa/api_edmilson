package com.digitalhouse.api_edmilson.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product p1 = new Product(1,"Escova de Dente","Colgate Escova de dente",7.00);
            Product p2 = new Product(2,"Shampoo","Palmovile Shampoo",15.00);
            repository.saveAll(
                    List.of(p1,p2)
            );
        };
    }
}
