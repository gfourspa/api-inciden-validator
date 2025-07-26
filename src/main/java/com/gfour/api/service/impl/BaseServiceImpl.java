package com.gfour.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gfour.api.service.BaseService;

/**
 * Abstract base service implementation providing common functionality
 * Implements Template Method pattern
 * @param <T> entity type
 * @param <R> repository type
 */
public abstract class BaseServiceImpl<T, R extends JpaRepository<T, UUID>> implements BaseService<T> {
    
    protected final R repository;
    
    protected BaseServiceImpl(R repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(UUID id) {
        return repository.findById(id);
    }
    
    @Override
    @Transactional
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public long count() {
        return repository.count();
    }
    
}