package com.gfour.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Generic base service interface following the Template Method pattern
 * @param <T> entity type
 */
public interface BaseService<T> {
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(UUID id);
    void deleteById(UUID id);
    boolean existsById(UUID id);
    long count();
}