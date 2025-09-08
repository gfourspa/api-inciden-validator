package com.gfour.api.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa la tabla log_errores
 * Contiene información sobre el log de errores del sistema
 */
@Entity
@Table(name = "log_errores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorLog extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tabla", length = 100)
    private String tabla;

    @Column(name = "causa")
    private Integer causa;

    @Column(name = "descripcion", length = 4000, nullable = false)
    private String descripcion;

    @Column(name = "query", length = 500)
    private String query;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
}
