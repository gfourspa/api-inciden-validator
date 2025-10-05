package com.gfour.api.service;

import java.util.List;
import java.util.Map;

public interface ValidationService {

    List<Map<String, Object>> scsValidaCarga();
    List<Map<String, Object>> scsValidaCargaConsistencia();
    List<Map<String, Object>> scsValidaIncidencias();
    List<Map<String, Object>> scsValidaTablasInterrupciones();
}
