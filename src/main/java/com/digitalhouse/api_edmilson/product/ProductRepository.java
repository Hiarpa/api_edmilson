package com.digitalhouse.api_edmilson.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT s FROM Product s WHERE s.id = ?1")
    Optional<Product> findProductById(Integer id);
}
