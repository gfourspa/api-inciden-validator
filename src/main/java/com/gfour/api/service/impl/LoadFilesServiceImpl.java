package com.gfour.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.gfour.api.dto.ValidationResultDTO;
import com.gfour.api.entity.LoadFiles;
import com.gfour.api.repository.LoadFilesRepository;
import com.gfour.api.service.LoadFilesService;


public class LoadFilesServiceImpl extends BaseServiceImpl<LoadFiles, LoadFilesRepository> implements LoadFilesService {
    
    @Autowired
    public LoadFilesServiceImpl(LoadFilesRepository repository) {
        super(repository);
    }
    
    @Override
    public ValidationResultDTO validateConnectivity() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO validateTableIntegrity() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO validateIncidenceModel() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO validateAlimentadorConsistency() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO validateCommuneStatus() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO validateKvaZeroCommuneZero() {
        // Implementation code here
        return null;
    }

    @Override
    public ValidationResultDTO processFiles(MultipartFile[] files) {
        // Implementation code here
        return null;
    }

    @Override
    public void cleanTables() {
        // Implementation code here
    }
    
}
