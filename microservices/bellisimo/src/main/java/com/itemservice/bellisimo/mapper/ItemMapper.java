package com.itemservice.bellisimo.mapper;

import com.itemservice.bellisimo.domain.Item;
import com.itemservice.bellisimo.domain.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper {

    Item itemDTOToItem(ItemDTO itemDTO);
    List<Item> itemDTOsToItems(List<ItemDTO> itemDTOS);

    ItemDTO itemToItemDTO(Item item);
    List<ItemDTO> itemsToItemDTOs(List<Item> items);
}
