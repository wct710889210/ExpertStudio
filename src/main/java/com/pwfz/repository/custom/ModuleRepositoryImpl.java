package com.pwfz.repository.custom;

import com.pwfz.entity.ModuleItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class ModuleRepositoryImpl implements ModuleRepsitoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void saveForMultiPhotos(ModuleItem item) {
        entityManager.merge(item);
    }
}
