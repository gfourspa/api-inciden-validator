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
 * Entity representing the consistency of an incident
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// @Table(name = "CONSISTENCIA_INCIDENCIA")
@Table(name = "INCIDENT_CONSISTENCY")
public class IncidentConsistency extends Audit {
    
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
    @Column(name = "incident_id")
    private Integer incidentId;
    
    @NotNull
    @Column(name = "consistency_type", length = 30)
    private String consistencyType;
    
    @NotNull
    @Column(name = "is_consistent", nullable = false)
    private Boolean isConsistent;
    
    @Column(name = "message", length = 200)
    private String message;
}