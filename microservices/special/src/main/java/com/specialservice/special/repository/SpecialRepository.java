package com.specialservice.special.repository;

import com.specialservice.special.domain.Special;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by siphokazi on 2017/09/14.
 */
@Repository
public interface SpecialRepository extends JpaRepository<Special, Long> {

}
