package com.zeuss.productservice.microservice.repository;
import com.zeuss.productservice.microservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String>{
}
