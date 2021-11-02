package com.guestu.kafkaconsumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guestu.kafkaconsumer.model.Category;
import com.guestu.kafkaconsumer.model.Product;
import com.guestu.kafkaconsumer.service.ElasticSearchCategoryService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.JacksonUtils;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KafkaConsumer {
    @Autowired
    ElasticSearchCategoryService elasticSearchCategoryService;

    @KafkaListener(topics = "TestTopic",groupId = "test-consumer-group")
    public void consume(String message){
        System.out.println("Consumed message:" +message);
    }

/*
    @KafkaListener(topics = "topic.product.save",groupId = "category-consumer-group")
    public void consumeSaveProduct(Category category){
        System.out.println("saving :" +category);
    }
*/
@KafkaListener(topics = "topic.product.save",groupId = "test-consumer-group")
    public void consumeSaveTest(String category) throws JsonProcessingException {
        System.out.println("saving :" +category);
    ObjectMapper objectMapper=new ObjectMapper();
    Category product1=objectMapper.readValue(category,Category.class);
    //TODO: shiit waiting for hashmap with category and his parent
    //elasticSearchCategoryService.save();
    System.out.println(product1);
    }


}
