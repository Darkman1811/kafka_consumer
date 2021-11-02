package com.guestu.kafkaconsumer.repository;

import com.guestu.kafkaconsumer.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepository extends ElasticsearchRepository<Category,String> {

}
