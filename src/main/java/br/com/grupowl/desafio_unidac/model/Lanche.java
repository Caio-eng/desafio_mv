package br.com.grupowl.desafio_unidac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Lanche {
	
	private Long id;
		
	@Column(unique = true)
	private String nome;
	
	@Id
    @SequenceGenerator(name = "lancheSeq", sequenceName = "lanche_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "lancheSeq")
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
	
	
	
}
