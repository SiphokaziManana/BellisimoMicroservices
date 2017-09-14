package com.itemservice.bellisimo.controller;

import com.itemservice.bellisimo.domain.ItemDTO;
import com.itemservice.bellisimo.domain.ResponseDTO;
import com.itemservice.bellisimo.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */

@RestController
@RequestMapping("/api/item")
public class ItemController  {

    @Inject
    ItemService itemService;

    @CrossOrigin()
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO addItem(@RequestBody ItemDTO dto){
        itemService.addItem(dto);
        return new ResponseDTO("Item has been added");
    }

    @CrossOrigin()
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ItemDTO updateItem( @PathVariable Long id, @RequestBody ItemDTO dto){
        return  itemService.updateItem(id, dto);
    }

    @CrossOrigin()
    @RequestMapping(value = "/list/food", method = RequestMethod.GET)
    public List<ItemDTO> getFoodItems(){
        return itemService.getAllFoodItems();
    }

    @CrossOrigin()
    @RequestMapping(value = "/list/clothing", method = RequestMethod.GET)
    public List<ItemDTO> getClothingItems(){
        return itemService.getAllClothingItems();
    }

    @CrossOrigin()
    @RequestMapping(value = "/find/{id}" , method = RequestMethod.GET)
    public ItemDTO getItem(@PathVariable Long id){
        return  itemService.getItem(id);
    }

    @CrossOrigin()
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseDTO deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return new ResponseDTO("Item has been deleted");
    }

    @CrossOrigin()
    @RequestMapping(value = "/add/special", method = RequestMethod.POST)
    public ItemDTO addSpecialToItem(@RequestBody ItemDTO dto){
        System.out.println("\n \n adding special to item \n " + dto + " \n \n");
        return itemService.addSpecialToItem(dto);
    }
}
