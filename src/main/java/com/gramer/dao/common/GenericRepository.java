package com.gramer.dao.common;

import java.util.List;

/**
 * Created by Administrator on 2014-06-26.
 */
public interface GenericRepository<E> {

    E insert(E e);

    E update(E e);

    void delete(E e);

    E findById(Object primaryKey);

    List<E> findAll();

}
