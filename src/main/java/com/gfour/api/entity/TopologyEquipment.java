package com.gfour.api.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity representing equipment in the topology
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EQUIPO_TOPOLOGIA")
//@Table(name = "TOPOLOGY_EQUIPMENT")
public class TopologyEquipment extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "company_id", length = 3)
    private String companyId;
    
    @NotNull
    @Column(name = "period_star", length = 6)
    private String periodStar;
    
    @NotNull
    @Column(name = "equipment_id", length = 20)
    private String equipmentId;
    
    @NotNull
    @Column(name = "equipment_type_id")
    private Integer equipmentTypeId;
    
    @Column(name = "equipment_name", length = 100)
    private String equipmentName;
    
    @Column(name = "normalizing_status", length = 1)
    private String normalizingStatus;
    
    @Column(name = "operational_status", length = 1)
    private String operationalStatus;
}