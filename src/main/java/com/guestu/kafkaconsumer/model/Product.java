package com.guestu.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.List;

@Document(indexName = "ecom",shards = 2,type= "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private Date creationDate ;
    private String description;
    private Category category;
    private List<ProductTag> productTags;
    private List<ProductDetails> productDetails;
    private List<ProductFile> productFiles;
}
