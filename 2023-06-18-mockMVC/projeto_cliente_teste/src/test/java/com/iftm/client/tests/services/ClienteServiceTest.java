package com.iftm.client.tests.services;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {
	@InjectMocks
	private ClientService servico;

	@Mock
	private ClientRepository repositorio;

	@Test
	public void deletarIdExistente() {
		long id = 1;
		Mockito.doNothing().when(repositorio).deleteById(id);

		Assertions.assertDoesNotThrow(() -> servico.delete(id));

		Mockito.verify(repositorio, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void deletarIdInexistente() {
		long id = 100;
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repositorio).deleteById(id);

		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> servico.delete(id));

		Mockito.verify(repositorio, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void encontrarTudoPaginado() {
		List<Client> clients = List.of(
				new Client(1L, "Conceição Evaristo", "10619244881", 1500.0, Instant.parse("2020-07-13T20:50:00Z"), 2),
				new Client(2L, "Lázaro Ramos", "10619244881", 2500.0, Instant.parse("1996-12-23T07:00:00Z"), 2),
				new Client(3L, "Clarice Lispector", "10919444522", 3800.0, Instant.parse("1960-04-13T07:50:00Z"), 2),
				new Client(4L, "Carolina Maria de Jesus", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0),
				new Client(5L, "Gilberto Gil", "10419344882", 2500.0, Instant.parse("1949-05-05T07:00:00Z"), 4),
				new Client(6L, "Djamila Ribeiro", "10619244884", 4500.0, Instant.parse("1975-11-10T07:00:00Z"), 1),
				new Client(7L, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0),
				new Client(8L, "Toni Morrison", "10219344681", 10000.0, Instant.parse("1940-02-23T07:00:00Z"), 0),
				new Client(9L, "Yuval Noah Harari", "10619244881", 1500.0, Instant.parse("1956-09-23T07:00:00Z"), 0),
				new Client(10L, "Chimamanda Adichie", "10114274861", 1500.0, Instant.parse("1956-09-23T07:00:00Z"), 0),
				new Client(11L, "Silvio Almeida", "10164334861", 4500.0, Instant.parse("1970-09-23T07:00:00Z"), 2),
				new Client(12L, "Jorge Amado", "10204374161", 2500.0, Instant.parse("1918-09-23T07:00:00Z"), 0)
		);
		PageRequest pageRequest = PageRequest.of(0, 4);
		Page<Client> clientPage = new PageImpl<>(clients, pageRequest, 4);
		Mockito.when(repositorio.findAll(pageRequest)).thenReturn(clientPage);

		Page<Client> result = servico.findAllPaged(pageRequest).map(ClientDTO::toEntity);

		Assertions.assertEquals(clientPage, result);
		Mockito.verify(repositorio, Mockito.times(1)).findAll(pageRequest);
	}

	@Test
	public void encontrarPorIdExistente() {
		long id = 1;
		Optional<Client> client = Optional.of(new Client(1L, "Conceição Evaristo", "10619244881", 1500.0, Instant.parse("2020-07-13T20:50:00Z"), 2));
		Mockito.when(repositorio.findById(id)).thenReturn(client);

		Client entity = servico.findById(id).toEntity();

		Assertions.assertEquals(client.get(), entity);
		Mockito.verify(repositorio, Mockito.times(1)).findById(id);
	}

	@Test
	public void encontrarPorIdInexistente() {
		long id = 99;
		Optional<Client> client = Optional.empty();
		Mockito.when(repositorio.findById(id)).thenReturn(client);

		Assertions.assertThrows(ResourceNotFoundException.class, () -> servico.findById(id));
		Mockito.verify(repositorio, Mockito.times(1)).findById(id);
	}

	@Test
	public void inserir() {
		Client client = new Client(1L, "Conceição Evaristo", "10619244881", 1500.0, Instant.parse("2020-07-13T20:50:00Z"), 2);
		Mockito.when(repositorio.save(client)).thenReturn(client);

		Client entity = servico.insert(new ClientDTO(client)).toEntity();

		Assertions.assertEquals(client, entity);
		Mockito.verify(repositorio, Mockito.times(1)).save(client);
	}
}
