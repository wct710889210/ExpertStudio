package com.pwfz.repository;

import com.pwfz.entity.NaviItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NaviItemRepository extends JpaRepository<NaviItem,Integer> {
    @Query("select n from NaviItem n where n.moduleId = :moduleId and n.fatherId is null")
    List<NaviItem> findAllFirstNavi(@Param("moduleId")int id);
}
