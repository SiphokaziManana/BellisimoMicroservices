package com.specialservice.special.controller;

import com.specialservice.special.domain.ResponseDTO;
import com.specialservice.special.domain.SpecialDTO;
import com.specialservice.special.service.SpecialService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/special")
public class SpecialController {

    @Inject
    SpecialService specialService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseDTO add(@RequestBody SpecialDTO dto){
        System.out.println("creating special");
        specialService.add(dto);
        return new ResponseDTO("The special was created successfully");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO update( @RequestBody SpecialDTO dto){
        specialService.update(dto);
        return  new ResponseDTO("The special was updated successfully");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SpecialDTO> list(){
        return specialService.getAll();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public SpecialDTO find(@PathVariable Long id){
        return  specialService.get(id);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseDTO deleteItem(@PathVariable Long id){
        specialService.delete(id);
        return new ResponseDTO("The special was deleted successfully");
    }
}
