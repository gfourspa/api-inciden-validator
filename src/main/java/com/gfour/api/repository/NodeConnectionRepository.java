package com.gfour.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfour.api.entity.NodeConnection;


@Repository
public interface NodeConnectionRepository extends JpaRepository<NodeConnection, UUID> {
    
    List<NodeConnection> findByCompanyIdAndPeriodStar(String companyId, String periodStar);
    
    List<NodeConnection> findByCompanyIdAndPeriodStarAndIncidentId(String companyId, String periodStar, Integer incidentId);
    
    List<NodeConnection> findByNodeId(Integer nodeId);
    
    List<NodeConnection> findByAdjacentNodeId(Integer adjacentNodeId);
    
    Optional<NodeConnection> findByNodeIdAndAdjacentNodeIdAndIncidentId(
            Integer nodeId, Integer adjacentNodeId, Integer incidentId);
    
    List<NodeConnection> findByConnectionTypeId(Integer connectionTypeId);
}