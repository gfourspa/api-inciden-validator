package com.gfour.api.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gfour.api.entity.IncidentFeeder;
import com.gfour.api.utils.MapperUtils;

@Component
public class IncidentFeederMapper implements EntityMapper<IncidentFeeder> {
    
    @Override
    public IncidentFeeder mapToEntity(String[] values, Map<String, Integer> columnMap) {
        return IncidentFeeder.builder()
                .companyId(MapperUtils.getString(values, columnMap, "company_id"))
                .periodStar(MapperUtils.getString(values, columnMap, "period_star"))
                .incidentId(MapperUtils.getInteger(values, columnMap, "incident_id"))
                .feederId(MapperUtils.getInteger(values, columnMap, "feeder_id"))
                .feederName(MapperUtils.getString(values, columnMap, "feeder_name"))
                .nominalVoltage(MapperUtils.getDouble(values, columnMap, "nominal_voltage"))
                .maxCurrent(MapperUtils.getDouble(values, columnMap, "max_current"))
                .maxCurrentDateTime(MapperUtils.getString(values, columnMap, "max_current_datetime"))
                .automaticReconnection(MapperUtils.getBoolean(values, columnMap, "automatic_reconnection"))
                .voltageRegulator(MapperUtils.getBoolean(values, columnMap, "voltage_regulator"))
                .lowFrequencyRelay(MapperUtils.getBoolean(values, columnMap, "low_frequency_relay"))
                .relayFrequency(MapperUtils.getDouble(values, columnMap, "relay_frequency"))
                .threePhaseShortCircuitCurrent(MapperUtils.getDouble(values, columnMap, "three_phase_short_circuit_current"))
                .bt1Clients(MapperUtils.getInteger(values, columnMap, "bt1_clients"))
                .otherBtClients(MapperUtils.getInteger(values, columnMap, "other_bt_clients"))
                .atClients(MapperUtils.getInteger(values, columnMap, "at_clients"))
                .freeClients(MapperUtils.getInteger(values, columnMap, "free_clients"))
                .isSubFeeder(MapperUtils.getBoolean(values, columnMap, "is_sub_feeder"))
                .supplierFeederId(MapperUtils.getInteger(values, columnMap, "supplier_feeder_id"))
                .supplierCompanyId(MapperUtils.getInteger(values, columnMap, "supplier_company_id"))
                .installedKvaU(MapperUtils.getDouble(values, columnMap, "installed_kva_u"))
                .installedKvaR1(MapperUtils.getDouble(values, columnMap, "installed_kva_r1"))
                .installedKvaR2(MapperUtils.getDouble(values, columnMap, "installed_kva_r2"))
                .build();
    }
}