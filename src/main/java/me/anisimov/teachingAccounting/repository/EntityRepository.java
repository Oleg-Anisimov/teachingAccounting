package me.anisimov.teachingAccounting.repository;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.BaseEntity;
import me.anisimov.teachingAccounting.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SuppressWarnings("unchecked")
@Slf4j
@Repository
public class EntityRepository {

    private static final int LOCK_TIMEOUT = 1000 * 60;

    @Autowired
    private EntityManager entityManager;

//    @SuppressWarnings("SpringJavaAutowiringInspection")
//    @Autowired
//    protected SessionFactory sessionFactory;
//
//    public <E extends BaseEntity, ID extends Serializable> ID persist(E entity) {
//        log.debug("Persisting entity {}", entity);
//        return (ID) sessionFactory.getCurrentSession().save(entity);
//    }
//
//    public <E extends BaseEntity, ID extends Serializable> E getRequired(Class<E> entityClass, ID id) {
//        E entity = sessionFactory.getCurrentSession().get(entityClass, id);
//        if (entity == null) {
//            throw new IllegalArgumentException("Entity " + entityClass.getName() + " not found by id " + id);
//        }
//        return entity;
//    }
    public <E extends BaseEntity> void delete(E entity) {
        log.debug("Deleting entity {}", entity);
        entityManager.find()
    }
//
//    public <E extends BaseEntity> void merge(E entity) {
//        log.debug("merging entity {}", entity);
//        sessionFactory.getCurrentSession().merge(entity);
//    }
//    public <E extends BaseEntity, ID extends Serializable> E getOptional(Class<E> entityClass, ID id) {
//        return sessionFactory.getCurrentSession().get(entityClass, id);
//    }
//
//    public <E extends BaseEntity> List<E> list(Class<E> entityClass) {
//        return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
//    }

    public <E extends BaseEntity> List<E> listForUser(Class<E> entityClass, User user) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(entityClass);
        Root<E> entity = cq.from(entityClass);
        Predicate authorNamePredicate = builder.equal(entity.get("user"), user);
        cq.where(authorNamePredicate);

        TypedQuery<E> query = entityManager.createQuery(cq);
        return query.getResultList();
    }


    public <E extends BaseEntity> List<E> list(Class<E> entityClass) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = builder.createQuery(entityClass);
        Root<E> entity = cq.from(entityClass);
        TypedQuery<E> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

}

