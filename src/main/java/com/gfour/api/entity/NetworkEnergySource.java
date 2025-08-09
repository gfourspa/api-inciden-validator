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
 * Entity representing a network energy source
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FUENTE_ENERGIA_RED")
//@Table(name = "NETWORK_ENERGY_SOURCE")
public class NetworkEnergySource extends Audit {
    
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
    @Column(name = "energy_source_id")
    private Integer energySourceId;
    
    @NotNull
    @Column(name = "energy_source_type_id")
    private Integer energySourceTypeId;
    
    @NotNull
    @Column(name = "source_name", length = 100)
    private String sourceName;
    
    @Column(name = "description", length = 200)
    private String description;
    
    @Column(name = "coordinates_x", precision = 10, scale = 6)
    private Double coordinatesX;
    
    @Column(name = "coordinates_y", precision = 10, scale = 6)
    private Double coordinatesY;
}