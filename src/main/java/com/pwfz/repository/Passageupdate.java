package com.pwfz.repository;

import com.pwfz.entity.PassageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface Passageupdate  {
    int updatepassage(PassageItem passageItem);
}
