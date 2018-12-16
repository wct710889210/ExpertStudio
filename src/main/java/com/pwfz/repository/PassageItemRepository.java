package com.pwfz.repository;

import com.pwfz.entity.NaviItem;
import com.pwfz.entity.PassageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/*@Transactional*/
public interface PassageItemRepository extends JpaRepository<PassageItem,Integer> {

    PassageItem findPassageItemByUserId( int userid);



    /*@Modifying
    @Query("update PassageItem p set p.content=:content where p.id=:id")
    int updatePassageItem(@Param("content")String content,@Param("id") int id);*/

}
