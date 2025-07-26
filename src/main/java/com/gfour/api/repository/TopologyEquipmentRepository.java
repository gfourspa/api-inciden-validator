package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.TopologyEquipment;


@Repository
public interface TopologyEquipmentRepository extends JpaRepository<TopologyEquipment, UUID> {
    
    List<TopologyEquipment> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    Optional<TopologyEquipment> findByEquipmentId(String equipmentId);
    
    List<TopologyEquipment> findByEquipmentTypeId(Integer equipmentTypeId);
    
    List<TopologyEquipment> findByNormalizingStatus(String normalizingStatus);
    
    List<TopologyEquipment> findByOperationalStatus(String operationalStatus);
}