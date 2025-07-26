package com.gfour.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.LoadFiles;

@Repository
public interface LoadFilesRepository extends JpaRepository<LoadFiles, UUID> {

    @Procedure(name = "spa_scs_valida_carga_EGA")
    void validateLoad();
    

}
