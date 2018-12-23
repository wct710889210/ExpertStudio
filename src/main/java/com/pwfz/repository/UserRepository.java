package com.pwfz.repository;

import com.pwfz.entity.ModuleItem;
import com.pwfz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUsername(String username);
}
