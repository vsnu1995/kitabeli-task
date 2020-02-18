package com.vsnu.market.mappers;

import com.vsnu.market.dtos.CategoryDto;
import com.vsnu.market.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper( CategoryMapper.class );

    CategoryDto toCategoryDTO(Category category);

    List<CategoryDto> toCategoryDTOs(Iterable<Category> categories);

    Category toCategory(CategoryDto categoryDto);
}
