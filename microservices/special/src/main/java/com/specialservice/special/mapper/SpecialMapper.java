package com.specialservice.special.mapper;

import com.specialservice.special.domain.Special;
import com.specialservice.special.domain.SpecialDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by siphokazi on 2017/09/14.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SpecialMapper {

    Special specialDTOToSpecial(SpecialDTO specialDTO);
    List<Special> specialDTOsToSpecials(List<SpecialDTO> specialDTOS);
    SpecialDTO specialToSpecialDTO(Special special);
    List<SpecialDTO> specialsToSpecialDTOs(List<Special> specials);
}
