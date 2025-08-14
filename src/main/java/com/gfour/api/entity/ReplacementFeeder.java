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
 * Entity representing a replacement feeder
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ALIMENTADOR_REPOSICION")
//@Table(name = "REPLACEMENT_FEEDER")
public class ReplacementFeeder extends Audit {
    
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
    @Column(name = "replacement_block_id")
    private Integer replacementBlockId;
    
    @NotNull
    @Column(name = "replaced_kva_r1", nullable = false)
    private Double replacedKvaR1;
    
    @NotNull
    @Column(name = "replaced_kva_u", nullable = false)
    private Double replacedKvaU;
    
    @NotNull
    @Column(name = "replaced_kva_r2", nullable = false)
    private Double replacedKvaR2;
}