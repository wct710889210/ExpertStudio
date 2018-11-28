package com.pwfz.repository.custom;

import com.pwfz.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        List<User> users = (List<User>) entityManager.createQuery("select u from User u").getResultList();
        return users;
    }
}
