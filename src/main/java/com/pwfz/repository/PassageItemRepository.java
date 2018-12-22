package com.pwfz.repository;

import com.pwfz.entity.NaviItem;
import com.pwfz.entity.PassageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@Transactional*/
public interface PassageItemRepository extends JpaRepository<PassageItem,Integer> {

    @Query("select f from PassageItem f where f.userId = :userid ")
    List<PassageItem> findAllByUserId(@Param("userid") int userid);

    @Query("select p from PassageItem p where p.moduleItem.id=:modleId")
    List<PassageItem> findpassageByModleId(@Param("modleId") int modleId);



    /*@Modifying
    @Query("update PassageItem p set p.content=:content where p.id=:id")
    int updatePassageItem(@Param("content")String content,@Param("id") int id);*/

}
