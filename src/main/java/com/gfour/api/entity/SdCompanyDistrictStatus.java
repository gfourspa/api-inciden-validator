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
 * Entity representing the SD status of a company-commune relationship
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ESTADO_COMUNA_EMPRESA_SD")
//@Table(name = "SD_COMPANY_DISTRICT_STATUS")
public class SdCompanyDistrictStatus extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "company_id", length = 3)
    private String companyId;
    
    @NotNull
    @Column(name = "district_id", length = 6)
    private String districtId;
    
    @NotNull
    @Column(name = "sd_type", length = 30)
    private String sdType;
    
    @NotNull
    @Column(name = "status", length = 1)
    private String status;
    
    @Column(name = "description", length = 100)
    private String description;
}