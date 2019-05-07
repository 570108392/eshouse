package it.qsbl.com.domain;

import lombok.Data;

@Data
public class ProductCategory {
    private String categoryId;

    private String categoryName;

    private String parentId;
}