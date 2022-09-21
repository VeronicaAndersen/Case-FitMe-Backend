package com.example.casefitmebackend.services;

import java.util.Collection;

public interface CrudService <T, ID>{

    /**
     * Find entity in by its id.
     * @param id is the id of the entity that you want to get.
     * @return the entity which id matches the parameters.
     */
    T findById(ID id);

    /**
     * Find all entities in the repository.
     * @return the entities in the repository.
     */
    Collection<T> findAll();

    /**
     * Add an entity to the repository.
     * @param entity is the entity which should be added.
     * @return the saved entity.
     */
    T add(T entity);

    /**
     * Update an existing entity.
     * @param entity is the entity you want to replace the current one with.
     * @return is the new, saved entity.
     */
    T update(T entity);

    /**
     * Delete an entity by its id.
     * @param id is the id of the entity you want to delete.
     */
    void deleteById(ID id);
}
