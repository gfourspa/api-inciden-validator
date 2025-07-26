package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.SdCompanyDistrictStatus;


@Repository
public interface SdCompanyDistrictStatusRepository extends JpaRepository<SdCompanyDistrictStatus, UUID> {
    
    List<SdCompanyDistrictStatus> findByCompanyId(String companyId);
    
    List<SdCompanyDistrictStatus> findByCommuneId(String districtId);
    
    List<SdCompanyDistrictStatus> findBySdType(String sdType);
    
    List<SdCompanyDistrictStatus> findByStatus(String status);
    
    Optional<SdCompanyDistrictStatus> findByCompanyIdAndCommuneIdAndSdType(
            String companyId, String communeId, String sdType);
}