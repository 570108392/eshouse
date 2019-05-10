package it.qsbl.com.domain.search;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "goodsinfos",type = "goodsCommoditySearch",replicas = 0,shards = 1,createIndex = true)
@Data
public class GoodsInfo implements Serializable {

    @Id
    private Integer id;

    @Field(type = FieldType.Integer)
    private Integer categoryId;

    @Field(type = FieldType.Integer)
    private Integer sellCount;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Double)
    private double weight;

    @Field(type = FieldType.Text)
    private String productImage;

    @Field(type = FieldType.Text)
    private String productDesc;

    @Field(type = FieldType.Integer)
    private Integer productStatus;

    @Field(type = FieldType.Auto)
    private String name;

    @Field(type = FieldType.Text)
    private String goodsHtml;

    @Field(type = FieldType.Date)
    private Date createTime;

    @Field(type = FieldType.Text)
    private String productUser;

    private String suggestName;
}
