package me.anisimov.teachingAccounting.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Slf4j
@Transactional(propagation = Propagation.MANDATORY)
public class EntityRepositoryImpl implements EntityRepository {

    private static final int LOCK_TIMEOUT = 1000 * 60;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public <E, ID extends Serializable> ID persist(E entity) {
        log.debug("Persisting entity {}", entity);
        return (ID) sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public <E, ID extends Serializable> E getRequired(Class<E> entityClass, ID id) {
        E entity = sessionFactory.getCurrentSession().get(entityClass, id);
        if (entity == null) {
            throw new IllegalArgumentException("Entity " + entityClass.getName() + " not found by id " + id);
        }
        return entity;
    }

    @Override
    public <E> void delete(E entity) {
        log.debug("Deleting entity {}", entity);
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public <E> void merge(E entity) {
        log.debug("merging entity {}", entity);
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Nullable
    @Override
    public <E, ID extends Serializable> E getOptional(Class<E> entityClass, ID id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public <E> List<E> list(Class<E> entityClass) {
        return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
    }
}
