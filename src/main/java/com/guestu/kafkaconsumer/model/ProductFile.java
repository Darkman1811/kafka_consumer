package com.guestu.kafkaconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "ecom",shards = 2,type= "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFile {
    @Id
    private Long id;
    private String url;
    private String filetype;
}
