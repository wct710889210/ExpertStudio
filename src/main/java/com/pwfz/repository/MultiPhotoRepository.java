package com.pwfz.repository;

import com.pwfz.entity.MultiPhotoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MultiPhotoRepository extends JpaRepository<MultiPhotoItem,Integer> {
    @Query("select m from MultiPhotoItem m where m.moduleItem.id = :moduleId order by m.sequence")
    List<MultiPhotoItem> getByModuleId(@Param("moduleId") int moduleId);
}
