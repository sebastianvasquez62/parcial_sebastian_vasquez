package com.mirakuru.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirakuru.api.dto.ActualizarAfectadoRequest;
import com.mirakuru.api.dto.RegistrarAfectadoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AfectadoControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void registrarConsultarListarYActualizarAfectado() throws Exception {
        RegistrarAfectadoRequest request = new RegistrarAfectadoRequest();
        request.setNombre("Felicity Smoak");
        request.setNivelAgresividad(75);

        String json = objectMapper.writeValueAsString(request);

        String responseBody = mockMvc.perform(post("/api/afectados")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nombre").value("Felicity Smoak"))
                .andExpect(jsonPath("$.nivelAmenaza").value("ALTA"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        JsonNode created = objectMapper.readTree(responseBody);
        long id = created.get("id").asLong();

        mockMvc.perform(get("/api/afectados/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nombre").value("Felicity Smoak"));

        mockMvc.perform(get("/api/afectados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id));

        ActualizarAfectadoRequest updateRequest = new ActualizarAfectadoRequest();
        updateRequest.setNombre("Felicity S.");
        updateRequest.setNivelAgresividad(90);

        String updateJson = objectMapper.writeValueAsString(updateRequest);

        mockMvc.perform(put("/api/afectados/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Felicity S."))
                .andExpect(jsonPath("$.nivelAmenaza").value("CRITICA"));
    }
}
