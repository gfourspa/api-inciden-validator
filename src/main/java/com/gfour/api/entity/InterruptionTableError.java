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
 * Entity representing an error in interruption tables
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ERR_TABLAS_INTERRUPCION")
//@Table(name = "INTERRUPTION_TABLE_ERROR")
public class InterruptionTableError extends Audit {
    
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
    @Column(name = "interruption_id", length = 18)
    private String interruptionId;
    
    @NotNull
    @Column(name = "table_name", length = 50)
    private String tableName;
    
    @NotNull
    @Column(name = "error_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date errorDate;
    
    @NotNull
    @Column(name = "error_description", length = 200)
    private String errorDescription;
}