package com.appril.cola.domain.repository;

import com.appril.cola.domain.model.Entity;

public interface DataRepository<ID, T extends Entity<ID>> {

    /**
     * 操作人
     *
     * @param entity
     * @param operator
     * @return
     */
    int save(T entity, String operator);

    T getById(ID id);

    T getByGlobalId(String globalId);
}
