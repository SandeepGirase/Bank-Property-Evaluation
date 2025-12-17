package com.bankPropertyApplication.propertyEvaluation;

import com.bankPropertyApplication.propertyEvaluation.property.Property;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void fullCrudFlow() throws Exception {
        Property p = new Property("123 Main St","Alice", new BigDecimal("250000"),2,1,85.5);

        // Create
        String json = objectMapper.writeValueAsString(p);
        String created = mockMvc.perform(post("/api/properties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.address").value("123 Main St"))
                .andReturn().getResponse().getContentAsString();

        Property createdProp = objectMapper.readValue(created, Property.class);
        Long id = createdProp.getId();

        // Get
        mockMvc.perform(get("/api/properties/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.owner").value("Alice"));

        // Update
        createdProp.setOwner("Bob");
        String upd = objectMapper.writeValueAsString(createdProp);
        mockMvc.perform(put("/api/properties/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(upd))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.owner").value("Bob"));

        // Delete
        mockMvc.perform(delete("/api/properties/" + id))
                .andExpect(status().isNoContent());

        // Not found
        mockMvc.perform(get("/api/properties/" + id))
                .andExpect(status().isNotFound());
    }
}
