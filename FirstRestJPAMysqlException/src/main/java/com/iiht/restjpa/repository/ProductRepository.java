package com.iiht.restjpa.repository;
import com.iiht.restjpa.entity.Product;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public interface ProductRepository extends JpaRepository<Product, Long> {

}