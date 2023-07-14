package com.iftm.client.repositories;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iftm.client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select c from Client c where upper(c.name) = upper(?1)")
	Optional<Client> findByNameIgnoreCase(String name);

	@Query("select c from Client c where upper(c.name) like upper(concat('%', ?1, '%'))")
	List<Client> findByNameContainsIgnoreCase(String name);

	@Query("select c from Client c where c.income > ?1")
	List<Client> findByIncomeGreaterThan(Double income);

	@Query("select c from Client c where c.income < ?1")
	List<Client> findByIncomeLessThan(Double income);

	@Query("select c from Client c where c.income between ?1 and ?2")
	List<Client> findByIncomeBetween(Double incomeStart, Double incomeEnd);

	@Query("select c from Client c where c.birthDate between ?1 and ?2")
	List<Client> findByBirthDateBetween(Instant birthDateStart, Instant birthDateEnd);

	Client getReferenceById(Long id);
}
