package com.gfour.api.entity;

import java.math.BigDecimal;
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
 * Entity representing an affected feeder in an incident
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ALIMENTADOR_AFECTADO")
//@Table(name = "AFFECTED_FEEDER")
public class AffectedFeeder extends Audit {
    
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
    @Column(name = "feeder_id")
    private Integer feederId;
    
    @NotNull
    @Column(name = "interruption_id", length = 18)
    private String interruptionId;
    
    @NotNull
    @Column(name = "interrupted_kva_u", precision = 10, scale = 2, nullable = false)
    private BigDecimal interruptedKvaU;
    
    @NotNull
    @Column(name = "interrupted_kva_r1", precision = 10, scale = 2, nullable = false)
    private BigDecimal interruptedKvaR1;
    
    @NotNull
    @Column(name = "total_transfo_int_u", nullable = false)
    private Integer totalTransfoIntU;
    
    @NotNull
    @Column(name = "total_interrupted_clients", nullable = false)
    private Integer totalInterruptedClients;
    
    @NotNull
    @Column(name = "total_transfo_int_r1", nullable = false)
    private Integer totalTransfoIntR1;
    
    @NotNull
    @Column(name = "interrupted_kva_r2", precision = 10, scale = 2, nullable = false)
    private BigDecimal interruptedKvaR2;
    
    @NotNull
    @Column(name = "total_transfo_int_r2", nullable = false)
    private Integer totalTransfoIntR2;
}