package com.vsnu.market.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ItemDto {
    private Integer id;
    private String name;

    private String description;

    private Integer category;

    private List<VariationDto> variations;

    private Integer discount;

    private LocalDateTime discountExpiry;

    private String imageUrl;

}
