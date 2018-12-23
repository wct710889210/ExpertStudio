package com.pwfz.repository;

import com.pwfz.entity.Singlepassage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinglePassageRepository extends JpaRepository<Singlepassage,Integer> {

    Singlepassage findSinglepassageByUserId(int UserId);
}
