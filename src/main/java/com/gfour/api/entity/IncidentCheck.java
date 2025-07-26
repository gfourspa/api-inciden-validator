package com.gfour.api.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity representing an incident check
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// @Table(name = "Chequeo_incidencia")
@Table(name = "INCIDENT_CHECK")
public class IncidentCheck extends Audit {
    
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
    @Column(name = "check_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkDate;
    
    @NotNull
    @Column(name = "check_type", length = 50)
    private String checkType;
    
    @NotNull
    @Column(name = "check_result", nullable = false)
    private Boolean checkResult;
    
    @Column(name = "description", length = 200)
    private String description;
}