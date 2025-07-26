package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.CompanyDistrictError;


@Repository
public interface CompanyDistrictErrorRepository extends JpaRepository<CompanyDistrictError, UUID> {
    
    List<CompanyDistrictError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<CompanyDistrictError> findByCommuneId(String communeId);
    
    List<CompanyDistrictError> findByErrorDateBetween(Date startDate, Date endDate);
    
    List<CompanyDistrictError> findByCompanyIdAndCommuneId(String companyId, String communeId);

    @Procedure(name = "spa_scs_Comuna_Emprea_EGA")
    void validateDistrictCompany();

    
}