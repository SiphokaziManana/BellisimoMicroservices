package com.itemservice.bellisimo.service;

import com.itemservice.bellisimo.domain.Item;
import com.itemservice.bellisimo.domain.ItemDTO;
import com.itemservice.bellisimo.exception.CustomException;
import com.itemservice.bellisimo.mapper.ItemMapper;
import com.itemservice.bellisimo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */
@Service
public class ItemService {

    @Inject
    ItemRepository itemRepository;

    /*@Inject
    SpecialRepository specialRepository;*/

    @Inject
    ItemMapper itemMapper;

    public ItemDTO addItem(ItemDTO dto){
        if ( dto.getHasSpecial() == null){
            dto.setHasSpecial(false);
        }
        if (dto.getCategory() == null){
            dto.setCategory("UNKNOWN");
        }
        try {
            Item obj = itemRepository.save(itemMapper.itemDTOToItem(dto));
            ItemDTO result = itemMapper.itemToItemDTO(obj);
            return result;
        }catch (Exception e){
            throw new CustomException("Could not ADD ITEM into the database. Error: " + e.toString());
        }
    }

    public ItemDTO updateItem(Long id , ItemDTO dto){
        Item item;

        if ( id != null){
            item = itemRepository.findOne(id);
        }
        else{
            return addItem(dto);
        }
        try{
            /*if ( item != null){

                if (dto.getHasSpecial()){
                    Special special = specialRepository.getOne(dto.getSpecial());
                    item.setHasSpecial(true);
                    item.setSpecial(dto.getSpecial());
                    item.setSpecialPrice(item.getPrice() * (special.getPercentage()/100));
                }
                else{
                    item.setHasSpecial(false);
                }
                if ( dto.getImage() != null)
                    item.setImage(dto.getImage());
                if ( dto.getPrice() != null)
                    item.setPrice(dto.getPrice());
                if ( dto.getName() != null)
                    item.setName(dto.getName());
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;
            }
            else{
                throw new CustomException("Item Could not be found");
            }*/
        }catch (Exception e){
            throw new CustomException("Could not UPDATE ITEM in the database. Error: " + e.toString());
        }
        return null;
    }

    public List<ItemDTO> getAllFoodItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("FOOD"));
    }
    public List<ItemDTO> getAllClothingItems(){
        return itemMapper.itemsToItemDTOs(itemRepository.findByCategory("CLOTHING"));
    }
    public ItemDTO getItem(Long id){
        Item item = itemRepository.findOne(id);

        if ( item.getHasSpecial()){
            /*Special special = specialRepository.findOne(item.getSpecial());
            Double specialPrice = item.getPrice() * special.getPercentage();
            item.setPrice(specialPrice);*/
        }
        ItemDTO result = itemMapper.itemToItemDTO(item);
        return result;
    }

    public void deleteItem(Long id){
        itemRepository.delete(id);
    }

    public ItemDTO addSpecialToItem(ItemDTO dto){
        Item item = itemRepository.findOne(dto.getId());
        if (item != null){
            if (dto.getSpecial() != null){
                /*Special special = specialRepository.getOne(dto.getSpecial());
                item.setHasSpecial(true);
                item.setSpecial(dto.getSpecial());
                item.setSpecialPrice( item.getPrice() * (special.getPercentage()/100));
                ItemDTO result = itemMapper.itemToItemDTO(itemRepository.save(item));
                return result;*/

            }
            else{
                throw new CustomException("There is no special found to be applied to the item");
            }
        }
        else
        {
            throw new CustomException("A special cannot be applied to the item as the item does not exist");
        }
        return null;
    }

}
