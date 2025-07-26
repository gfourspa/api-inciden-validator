package com.gfour.api.service;

import org.springframework.web.multipart.MultipartFile;

import com.gfour.api.dto.ValidationResultDTO;
import com.gfour.api.entity.LoadFiles;

public interface LoadFilesService extends BaseService<LoadFiles> {
    ValidationResultDTO validateConnectivity();
    ValidationResultDTO validateTableIntegrity();
    ValidationResultDTO validateIncidenceModel();
    ValidationResultDTO validateAlimentadorConsistency();
    ValidationResultDTO validateCommuneStatus();
    ValidationResultDTO validateKvaZeroCommuneZero();
    ValidationResultDTO processFiles(MultipartFile[] files);
    void cleanTables();
    
}
