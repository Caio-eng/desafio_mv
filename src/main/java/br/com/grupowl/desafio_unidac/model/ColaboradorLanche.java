package br.com.grupowl.desafio_unidac.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ColaboradorLanche {
	
	private Long id;
	
	@Id
    @SequenceGenerator(name = "colaboradorLancheSeq", sequenceName = "colaborador_lanche_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "colaboradorLancheSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "colaborador_id", nullable = false)
	private Long colaboradorId;
	
	@Column(name = "lanche_id", nullable = false)
	private Long lancheId;

	public Long getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Long colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public Long getLancheId() {
		return lancheId;
	}

	public void setLancheId(Long lancheId) {
		this.lancheId = lancheId;
	}
	
	
	
	
}
