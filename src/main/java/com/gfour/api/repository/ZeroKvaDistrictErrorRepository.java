package com.gfour.api.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.ZeroKvaDistrictError;


@Repository
public interface ZeroKvaDistrictErrorRepository extends JpaRepository<ZeroKvaDistrictError, UUID> {
    
    List<ZeroKvaDistrictError> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<ZeroKvaDistrictError> findByCommuneId(String districtId);
    
    List<ZeroKvaDistrictError> findByErrorDateBetween(Date startDate, Date endDate);
    
    List<ZeroKvaDistrictError> findByCompanyIdAndCommuneId(String companyId, String communeId);

    @Procedure(name = "spa_scs_KVA_Comuna_Cero_EGA")
    void validateKvaDistrictZero();
}