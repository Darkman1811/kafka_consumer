package com.guestu.kafkaconsumer.repository;


import com.guestu.kafkaconsumer.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product,String> {
}
