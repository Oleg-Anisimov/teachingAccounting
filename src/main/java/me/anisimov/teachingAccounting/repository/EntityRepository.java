package me.anisimov.teachingAccounting.repository;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

public interface EntityRepository {

    <E, ID extends Serializable> ID persist(E entity);

    /*
     * @return null if entity not found
     */
    @Nullable
    <E, ID extends Serializable> E getOptional(Class<E> entityClass, ID id);

    /*
     * Gets requested entity by ID.
     * @param entityClass class for enity mapping.
     * @param id id of the requested entity.
     * @param <E> entity type.
     * @param <ID> entity id type.
     * @return the requested entity.
     * @throws IllegalArgumentException if requested entity was not found.
     */
    <E, ID extends Serializable> E getRequired(Class<E> entityClass, ID id);

    <E> void delete(E entity);

    <E> void merge(E entity);

    <E> List<E> list(Class<E> entityClass);
}
