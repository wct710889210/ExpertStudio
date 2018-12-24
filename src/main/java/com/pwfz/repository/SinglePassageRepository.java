package com.pwfz.repository;

import com.pwfz.entity.Singlepassage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SinglePassageRepository extends JpaRepository<Singlepassage,Integer> {

    @Query("select s from Singlepassage s where s.moduleItem.id=:moduleId")
    Singlepassage findSinglepassageByModuleId(@Param("moduleId") int moduleId);

    Singlepassage findSinglepassageById(int id);
}
