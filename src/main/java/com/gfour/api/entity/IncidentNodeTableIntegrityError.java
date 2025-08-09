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
 * Entity representing an integrity error in incident node tables
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ERR_INTEGRIDAD_TABLAS_NODO_INCIDENCIA")
//@Table(name = "INCIDENT_NODE_TABLE_INTEGRITY_ERROR")
public class IncidentNodeTableIntegrityError extends Audit {
    
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
    @Column(name = "node_id")
    private Integer nodeId;
    
    @NotNull
    @Column(name = "error_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date errorDate;
    
    @NotNull
    @Column(name = "error_description", length = 200)
    private String errorDescription;
}