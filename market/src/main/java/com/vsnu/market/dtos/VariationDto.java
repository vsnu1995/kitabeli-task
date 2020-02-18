package com.vsnu.market.dtos;

import lombok.Data;

import java.util.Map;

@Data
public class VariationDto {
    private Integer id;

    private Integer stock;

    private Integer price;

    private Map<String, Object> variations;
}
