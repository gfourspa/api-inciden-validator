package com.gfour.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.Datum;

@Repository
public interface DatumRepository extends JpaRepository<Datum, UUID> {
    
    List<Datum> findByTypeId(Integer typeId);
    
    List<Datum> findByTableName(String tableName);
    
    List<Datum> findByColumnName(String columnName);
    
    List<Datum> findByCode(String code);
    
    List<Datum> findByTableNameAndColumnName(String tableName, String columnName);
}