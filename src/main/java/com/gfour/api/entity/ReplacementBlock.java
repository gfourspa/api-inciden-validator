package com.gfour.api.entity;

import java.time.LocalDateTime;
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
 * Entity representing a block of replacements
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BLOQUE_REPOSICION")
//@Table(name = "REPLACEMENT_BLOCK")
public class ReplacementBlock extends Audit {
    
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
    @Column(name = "interruption_id", length = 18)
    private String interruptionId;
    
    @NotNull
    @Column(name = "replacement_block_id")
    private Integer replacementBlockId;
    
    @NotNull
    @Column(name = "replacement_datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime replacementDatetime;
    
    @NotNull
    @Column(name = "replacement_type", length = 1, nullable = false)
    private String replacementType;
    
    @NotNull
    @Column(name = "replaced_clients", nullable = false)
    private Integer replacedClients;
}