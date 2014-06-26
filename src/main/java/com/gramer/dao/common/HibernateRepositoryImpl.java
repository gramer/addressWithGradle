package com.gramer.dao.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2014-06-26.
 */
public abstract class HibernateRepositoryImpl<E> implements GenericRepository<E> {

    private Class<E> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public HibernateRepositoryImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type type = genericSuperclass.getActualTypeArguments()[0];
        if (type instanceof ParameterizedType) {
            this.entityClass = (Class) ((ParameterizedType) type).getRawType();
        } else {
            this.entityClass = (Class) type;
        }
    }

    @Override
    public E insert(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public E update(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }

    @Override
    public E findById(Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteria = builder.createQuery(entityClass);
        Root<E> root = criteria.from(entityClass);
        criteria.select(root);
        return entityManager.createQuery( criteria ).getResultList();
    }
}
