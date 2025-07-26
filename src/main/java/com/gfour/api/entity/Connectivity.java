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
 * Entity representing connectivity between nodes
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CONECTIVIDAD")
//@Table(name = "CONNECTIVITY")
public class Connectivity extends Audit {
    
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
    @Column(name = "node_id")
    private Integer nodeId;
    
    @NotNull
    @Column(name = "adjacent_node_id")
    private Integer adjacentNodeId;
    
    @NotNull
    @Column(name = "connection_type_id")
    private Integer connectionTypeId;
    
    @NotNull
    @Column(name = "normalized", nullable = false)
    private Boolean normalized;
}