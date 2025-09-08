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
 * Entidad que representa la demanda por nodo
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DEMANDA_NODO")
public class NodeDemand extends Audit {
    
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
    @Column(name = "nodo_codigo", length = 12)
    private String nodoCodigo;
    
    @Column(name = "demanda_maxima")
    private Double demandaMaxima;
    
    @Column(name = "demanda_media")
    private Double demandaMedia;
    
    @Column(name = "numero_clientes")
    private Integer numeroClientes;
    
    @Column(name = "energia_media")
    private Double energiaMedia;
}
