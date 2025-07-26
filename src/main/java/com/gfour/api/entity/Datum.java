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
 * Entity representing reference data
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// @Table(name = "DATUM")
@Table(name = "DATUM")
public class Datum extends Audit {
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    
    @NotNull
    @Column(name = "type_id")
    private Integer typeId;
    
    @NotNull
    @Column(name = "table_name", length = 50)
    private String tableName;
    
    @NotNull
    @Column(name = "column_name", length = 50)
    private String columnName;
    
    @NotNull
    @Column(name = "code", length = 10)
    private String code;
    
    @NotNull
    @Column(name = "description", length = 100)
    private String description;
}