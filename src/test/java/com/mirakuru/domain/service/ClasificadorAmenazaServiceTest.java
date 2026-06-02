package com.mirakuru.domain.service;

import com.mirakuru.domain.model.NivelAmenaza;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClasificadorAmenazaServiceTest {

    private final ClasificadorAmenazaService service = new ClasificadorAmenazaService();

    @Test
    void clasificaNivelesDeAmenazaCorrectamente() {
        assertThat(service.clasificar(0)).isEqualTo(NivelAmenaza.BAJA);
        assertThat(service.clasificar(20)).isEqualTo(NivelAmenaza.BAJA);
        assertThat(service.clasificar(30)).isEqualTo(NivelAmenaza.MEDIA);
        assertThat(service.clasificar(59)).isEqualTo(NivelAmenaza.MEDIA);
        assertThat(service.clasificar(60)).isEqualTo(NivelAmenaza.ALTA);
        assertThat(service.clasificar(80)).isEqualTo(NivelAmenaza.ALTA);
        assertThat(service.clasificar(81)).isEqualTo(NivelAmenaza.CRITICA);
        assertThat(service.clasificar(null)).isEqualTo(NivelAmenaza.BAJA);
    }
}
