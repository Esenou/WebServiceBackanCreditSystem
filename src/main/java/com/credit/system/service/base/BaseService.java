package com.credit.system.service.base;

import com.credit.system.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    T create(T dto);

    T findById(Long id);

    T update(T dto);

    void deleteById(Long id);

    List<T> findAll();
}
