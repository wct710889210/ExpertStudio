package com.pwfz.repository;

import com.pwfz.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo,Integer> {
    @Query("select p from Photo p where p.user.id = :userId")
    List<Photo> getByUserId(@Param("userId") int userId);
}
