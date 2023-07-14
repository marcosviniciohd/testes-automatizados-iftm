package com.iftm.client.tests.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.Instant;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientResourcesTestsIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void insertShouldReturnClientDTOCreated() throws Exception {
        ClientDTO cliente = new ClientDTO(new Client(null, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0));
        String json = objectMapper.writeValueAsString(cliente);

        ResultActions result = mockMvc.perform(post("/clients")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.name").value(cliente.getName()))
                .andExpect((ResultMatcher) jsonPath("$.cpf").value(cliente.getCpf()));
    }

    @Test
    public void deleteIdShouldExists() throws Exception {
        long id = 1L;

        ResultActions result = mockMvc.perform(delete("/clients/{id}", id));

        result.andExpect(status().isNoContent());
    }

    @Test
    public void deleteIdShouldNotExists() throws Exception {
        long id = -1L;

        ResultActions result = mockMvc.perform(delete("/clients/{id}", id));

        result.andExpect(status().isNotFound());
    }

    @Test
    public void findByIncomeExists() throws Exception {
        String income = "1500";

        ResultActions result = mockMvc.perform(get("/clients/income").param("income", income));

        result.andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.content").exists())
                .andExpect((ResultMatcher) jsonPath("$.content").isArray())
                .andExpect((ResultMatcher) jsonPath("$.content[?(@.id == '%s')]", 10L).exists())
                .andExpect((ResultMatcher) jsonPath("$.content[?(@.id == '%s')]", 1L).exists())
                .andExpect((ResultMatcher) jsonPath("$.content[?(@.id == '%s')]", 9L).exists());
    }

    @Test
    public void updateExists() throws Exception {
        ClientDTO cliente = new ClientDTO(new Client(1L, "Conceição Evaristo", "999999", 1500D, Instant.parse("2020-07-13T20:50:00Z"), 2));
        String json = objectMapper.writeValueAsString(cliente);

        ResultActions result = mockMvc.perform(put("/clients/{id}", cliente.getId())
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name").value(cliente.getName()))
                .andExpect((ResultMatcher) jsonPath("$.cpf").value(cliente.getCpf()));
    }

}
