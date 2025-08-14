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
 * Entity representing a feeder involved in an incident
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ALIMENTADOR_INCIDENCIA")
//@Table(name = "INCIDENT_FEEDER")
public class IncidentFeeder extends Audit {
    
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
    @Column(name = "feeder_name", length = 60, nullable = false)
    private String feederName;
    
    @NotNull
    @Column(name = "nominal_voltage", nullable = false)
    private Double nominalVoltage;
    
    @NotNull
    @Column(name = "max_current", nullable = false)
    private Double maxCurrent;
    
    @Column(name = "max_current_datetime", length = 25)
    private String maxCurrentDateTime;
    
    @NotNull
    @Column(name = "automatic_reconnection", nullable = false)
    private Boolean automaticReconnection;
    
    @NotNull
    @Column(name = "voltage_regulator", nullable = false)
    private Boolean voltageRegulator;
    
    @NotNull
    @Column(name = "low_frequency_relay", nullable = false)
    private Boolean lowFrequencyRelay;
    
    @NotNull
    @Column(name = "relay_frequency", nullable = false)
    private Double relayFrequency;
    
    @NotNull
    @Column(name = "three_phase_short_circuit_current", nullable = false)
    private Double threePhaseShortCircuitCurrent;
    
    @NotNull
    @Column(name = "bt1_clients", nullable = false)
    private Integer bt1Clients;
    
    @NotNull
    @Column(name = "other_bt_clients", nullable = false)
    private Integer otherBtClients;
    
    @NotNull
    @Column(name = "at_clients", nullable = false)
    private Integer atClients;
    
    @NotNull
    @Column(name = "free_clients", nullable = false)
    private Integer freeClients;
    
    @NotNull
    @Column(name = "is_sub_feeder", nullable = false)
    private Boolean isSubFeeder;
    
    @Column(name = "supplier_feeder_id")
    private Integer supplierFeederId;
    
    @Column(name = "supplier_company_id")
    private Integer supplierCompanyId;
    
    @NotNull
    @Column(name = "installed_kva_u", nullable = false)
    private Double installedKvaU;

    @NotNull
    @Column(name = "installed_kva_r1", nullable = false)
    private Double installedKvaR1;

    @NotNull
    @Column(name = "installed_kva_r2", nullable = false)
    private Double installedKvaR2;
}