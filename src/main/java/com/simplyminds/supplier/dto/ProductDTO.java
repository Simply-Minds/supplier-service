package com.simplyminds.supplier.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) // Ignores unknown properties during deserialization
public class ProductDTO {

    @JsonProperty("id")
    private Integer productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantityInStock")
    private Integer quantityInStock;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("categoryId")
    private String category;

    @JsonProperty("productUnitId")
    private String productUnit;

    @JsonProperty("description")
    private String description;
}