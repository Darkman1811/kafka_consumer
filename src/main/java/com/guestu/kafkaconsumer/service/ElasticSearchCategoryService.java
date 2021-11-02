package com.guestu.kafkaconsumer.service;

import com.guestu.kafkaconsumer.model.Category;
import com.guestu.kafkaconsumer.repository.CategoryRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ElasticSearchCategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    public void save( Map<String,Category> categoryParam){
        Category category=categoryParam.get("category");
        Category parent= categoryParam.get("parent");
        System.out.println("parent: "+parent);
        category.setParent(parent);
        categoryRepository.save(category);
    }

    public void update( Map<String,Category> categoryParam){
        Category category=categoryParam.get("category");
        Category parent= categoryParam.get("parent");
        category.setParent(parent);
        Category active= categoryRepository.findById(category.getId()).get();
        BeanUtils.copyProperties(category,active);
        categoryRepository.save(active);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
        return  ;
    }


}
