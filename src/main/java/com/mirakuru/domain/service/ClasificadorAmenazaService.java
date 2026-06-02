package com.mirakuru.domain.service;

import com.mirakuru.domain.model.NivelAmenaza;
import org.springframework.stereotype.Component;

@Component
public class ClasificadorAmenazaService {

    public NivelAmenaza clasificar(Integer agresividad) {
        if (agresividad == null || agresividad < 0) {
            return NivelAmenaza.BAJA;
        }
        if (agresividad > 80) {
            return NivelAmenaza.CRITICA;
        }
        if (agresividad >= 60) {
            return NivelAmenaza.ALTA;
        }
        if (agresividad >= 30) {
            return NivelAmenaza.MEDIA;
        }
        return NivelAmenaza.BAJA;
    }
}
