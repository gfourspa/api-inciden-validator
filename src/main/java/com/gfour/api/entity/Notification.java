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
 * Entity representing a notification about an incident
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AVISO")
//@Table(name = "NOTIFICATION")
public class Notification extends Audit {
    
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
    @Column(name = "interruption_id", length = 18)
    private String interruptionId;
    
    @NotNull
    @Column(name = "notification_id")
    private Integer notificationId;
    
    @NotNull
    @Column(name = "notification_type_id", nullable = false)
    private Integer notificationTypeId;
    
    @Column(name = "supply_point_id", length = 30)
    private String supplyPointId;
    
    @NotNull
    @Column(name = "notification_description", length = 200, nullable = false)
    private String notificationDescription;
    
    @Column(name = "presentation_id", length = 25)
    private String presentationId;
}