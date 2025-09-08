package com.gfour.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla err_kva_comuna_cero
 * Contiene información sobre errores de KVA en cero por comuna
 */
@Entity
@Table(name = "err_kva_comuna_cero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(KvaCommuneZeroErrorPK.class)
public class KvaCommuneZeroError extends Audit {

    @Id
    @Column(name = "tabla", length = 50, nullable = false)
    private String tabla;

    @Id
    @Column(name = "campo", length = 50, nullable = false)
    private String campo;

    @Id
    @Column(name = "empresa", length = 5, nullable = false)
    private String empresa;

    @Id
    @Column(name = "periodo_star", length = 6, nullable = false)
    private String periodoStar;

    @Id
    @Column(name = "id", length = 25, nullable = false)
    private String id;

    @Column(name = "veces", nullable = false)
    private Integer veces;
}

/**
 * Clase para la clave primaria compuesta de KvaCommuneZeroError
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class KvaCommuneZeroErrorPK extends Audit {
    private String tabla;
    private String campo;
    private String empresa;
    private String periodoStar;
    private String id;
}
