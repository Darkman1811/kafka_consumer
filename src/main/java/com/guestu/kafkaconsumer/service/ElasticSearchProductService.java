package com.guestu.kafkaconsumer.service;


import com.guestu.kafkaconsumer.model.Product;
import com.guestu.kafkaconsumer.repository.ProductRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticSearchProductService {

    @Autowired
    private ProductRepository productRepository;


    public void save( Product product){
        productRepository.save(product);
    }

    public void update( Product product){
        Product active= productRepository.findById(product.getId()).get();
        BeanUtils.copyProperties(product,active);
        productRepository.save(active);
    }

    public void delete(Product product){
        productRepository.delete(product);
        return  ;
    }



}
