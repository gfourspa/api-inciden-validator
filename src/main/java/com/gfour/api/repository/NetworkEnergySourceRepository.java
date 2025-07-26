package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NetworkEnergySource;


@Repository
public interface NetworkEnergySourceRepository extends JpaRepository<NetworkEnergySource, UUID> {
    
    List<NetworkEnergySource> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    Optional<NetworkEnergySource> findByEnergySourceId(Integer energySourceId);
    
    List<NetworkEnergySource> findByEnergySourceTypeId(Integer energySourceTypeId);
    
    List<NetworkEnergySource> findBySourceNameContaining(String namePattern);
}