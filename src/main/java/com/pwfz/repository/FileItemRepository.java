package com.pwfz.repository;

import com.pwfz.entity.FileItem;
import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.NaviItem;
import com.pwfz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileItemRepository extends JpaRepository<FileItem,Integer> {
    @Query("select f from FileItem f where f.moduleItem.id =:Id ")
    List<FileItem> findAllFileItem(@Param("Id") int id);

    FileItem findFileItemById(int id);

    /*@Query("update FileItem f set FileItem =:fileitem where f.uploadUser.id=:userid")
    void addfile(@Param("fileitem") FileItem fileItem, @Param("userid")int userid);*/

}
