package com.pwfz.repository;

import com.pwfz.entity.ModuleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModuleRepository extends JpaRepository<ModuleItem,Integer> {
    @Query("select m from ModuleItem m where m.user.id = :userId")
    List<ModuleItem> findByUser(@Param("userId") int userId);

    @Query("select m from ModuleItem m where m.type=com.pwfz.enumeration.ModuleType.FILEDOWNLOAD" +
            " or m.type=com.pwfz.enumeration.ModuleType.PASAGELIST" +
            " or m.type=com.pwfz.enumeration.ModuleType.SINGLEPASAGE")
    List<ModuleItem> getAccessible();

}
