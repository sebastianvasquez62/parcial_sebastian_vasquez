package com.mirakuru.domain.service;

import com.mirakuru.domain.model.NivelAmenaza;

public class ClasificadorAmenazaService {

    public NivelAmenaza clasificar(Integer agresividad){

        if(agresividad > 80)
            return NivelAmenaza.CRITICA;

        if(agresividad >= 60)
            return NivelAmenaza.ALTA;

        if(agresividad >= 30)
            return NivelAmenaza.MEDIA;

        return NivelAmenaza.BAJA;
    }
}