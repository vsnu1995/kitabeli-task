package com.vsnu.market.mappers;

import com.vsnu.market.dtos.ItemDto;
import com.vsnu.market.entities.Category;
import com.vsnu.market.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemMapper {
    ItemMapper MAPPER = Mappers.getMapper( ItemMapper.class );

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryObjectToCategoryName")
    ItemDto toItemDto(Item item);

    List<ItemDto> toItemDTOs(Iterable<Item> items);

    @Named("categoryObjectToCategoryName")
    public static Integer categoryObjectToCategoryName(Category category) {
        return category.getId();
    }


}
