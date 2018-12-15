package com.pwfz.repository.custom;

import com.pwfz.entity.NaviItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class NaviItemRepositoryImpl implements NaviItemRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void updateNaviItems(List<NaviItem> naviItems) {
        for(NaviItem naviItem:naviItems){
            entityManager.merge(naviItem);
        }
    }
}
