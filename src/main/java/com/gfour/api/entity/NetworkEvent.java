package com.gfour.api.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity representing a network event
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EVENTO_RED")
//@Table(name = "NETWORK_EVENT")
public class NetworkEvent extends Audit {
    
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
    @Column(name = "event_id", length = 18)
    private String eventId;
    
    @NotNull
    @Column(name = "event_type_id")
    private Integer eventTypeId;
    
    @NotNull
    @Column(name = "event_effect_id")
    private Integer eventEffectId;
    
    @NotNull
    @Column(name = "event_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    
    @Column(name = "detection_type", length = 2)
    private String detectionType;
    
    @Column(name = "cause_type_id")
    private Integer causeTypeId;
    
    @Column(name = "location_description", length = 100)
    private String locationDescription;
}