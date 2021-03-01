package br.com.grupowl.desafio_unidac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Colaborador {
	
	
	private Long id;

	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Id
    @SequenceGenerator(name = "colaboradorSeq", sequenceName = "colaborador_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "colaboradorSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
