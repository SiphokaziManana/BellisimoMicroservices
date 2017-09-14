package com.specialservice.special.service;

import com.specialservice.special.domain.Special;
import com.specialservice.special.domain.SpecialDTO;
import com.specialservice.special.exception.CustomException;
import com.specialservice.special.mapper.SpecialMapper;
import com.specialservice.special.repository.SpecialRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */
@Service
public class SpecialService {

    @Inject
    SpecialRepository specialRepository;

    @Inject
    SpecialMapper specialMapper;

    public SpecialDTO add(SpecialDTO dto){
        try {
            dto.setStartDate(LocalDateTime.now());
            dto.setEndDate(LocalDateTime.now().plus(20, ChronoUnit.DAYS));
            Special special = specialMapper.specialDTOToSpecial(dto);
            Special obj = specialRepository.save(special);
            SpecialDTO result = specialMapper.specialToSpecialDTO(obj);
            return result;
        }catch (Exception e){
            throw new CustomException("Could not ADD SPECIAL into the database. Error: " + e.toString());
        }
    }

    public SpecialDTO update(SpecialDTO dto){
        Special obj = specialRepository.findOne(dto.getId());
        try{
            if ( obj != null){

                return specialMapper.specialToSpecialDTO(specialRepository.save(obj));
            }
            else{
                throw new CustomException("Special Could not be found");
            }
        }catch (Exception e){
            throw new CustomException("Could not UPDATE SPECIAL in the database. Error: " + e.toString());
        }
    }

    public List<SpecialDTO> getAll(){
        return specialMapper.specialsToSpecialDTOs(specialRepository.findAll());
    }

    public SpecialDTO get(Long id){
        return specialMapper.specialToSpecialDTO(specialRepository.findOne(id));
    }

    public void delete(Long id){
        specialRepository.delete(id);
    }
}
