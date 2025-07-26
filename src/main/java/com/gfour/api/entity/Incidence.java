package com.gfour.api.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// @Table(name = "INCIDENCIA")
@Table(name = "INCIDENCE")
public class Incidence {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @Column(name = "incidence_d")
    private String incidenceId;
    
    @Column(name = "empresa_id")
    private String companyId;
    
    @Column(name = "periodo_star")
    private String period;
    
    @Column(name = "referencia_cliente")
    private String customerReference;
    
    @Column(name = "fecha_inicio")
    private LocalDateTime startDate;
    
    @Column(name = "fecha_fin")
    private LocalDateTime endDate;
    
}
