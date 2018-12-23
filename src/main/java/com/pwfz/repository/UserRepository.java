package com.pwfz.repository;

import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    List<User> findAll();

    @Query("select module from User user join user.moduleItems module where user.id = :id")
    List<ModuleItem> findAllModuleById(@Param("id")int id);

    User findByUsername(String username);
}
