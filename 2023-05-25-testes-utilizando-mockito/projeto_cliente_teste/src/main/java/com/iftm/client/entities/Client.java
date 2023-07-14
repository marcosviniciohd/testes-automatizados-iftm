package com.iftm.client.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(cpf, client.cpf) && Objects.equals(income, client.income) && Objects.equals(birthDate, client.birthDate) && Objects.equals(children, client.children);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cpf, income, birthDate, children);
	}
}
