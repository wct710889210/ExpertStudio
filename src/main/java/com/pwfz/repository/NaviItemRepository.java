package com.pwfz.repository;

import com.pwfz.entity.NaviItem;
import com.pwfz.repository.custom.NaviItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NaviItemRepository extends JpaRepository<NaviItem,Integer>,NaviItemRepositoryCustom {
//    @Query("select distinct n from NaviItem n join fetch n.sons s where n.moduleId = :moduleId and n.fatherId=-1 order by n.sequence,s.sequence")
//    List<NaviItem> findAllFirstNavi(@Param("moduleId")int id);

    @Query("select n from NaviItem n where n.moduleId = :moduleId and n.fatherId=-1 order by n.sequence")
    List<NaviItem> findAllFirstNavi(@Param("moduleId")int id);
}
