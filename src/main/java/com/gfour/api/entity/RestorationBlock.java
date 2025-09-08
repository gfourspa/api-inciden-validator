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
 * Entidad que representa un bloque de reposición
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BLOQUE_REPOSICION")
public class RestorationBlock extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "empresa_id", length = 3)
    private String empresaId;
    
    @NotNull
    @Column(name = "periodo_star", length = 6)
    private String periodoStar;
    
    @NotNull
    @Column(name = "incidencia_id")
    private Integer incidenciaId;
    
    @NotNull
    @Column(name = "interrupcion_id", length = 18)
    private String interrupcionId;
    
    @NotNull
    @Column(name = "bloque_reposicion_id")
    private Integer bloqueReposicionId;
    
    @Column(name = "evento_red")
    private Integer eventoRed;
    
    @Column(name = "fecha_inicio_bloque")
    private String fechaInicioBloque;
    
    @Column(name = "fecha_fin_bloque")
    private String fechaFinBloque;
    
    @Column(name = "numero_clientes_repuestos")
    private Integer numeroClientesRepuestos;
    
    @Column(name = "energia_no_suministrada")
    private Double energiaNoSuministrada;
}
