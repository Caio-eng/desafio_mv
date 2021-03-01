package br.com.grupowl.desafio_unidac.model;

public class PedidoLanche {
	
	private Long idColaboradorLanche;
	
	private Colaborador colaborador;
	
	private Lanche lanche;

	public Long getIdColaboradorLanche() {
		return idColaboradorLanche;
	}

	public void setIdColaboradorLanche(Long idColaboradorLanche) {
		this.idColaboradorLanche = idColaboradorLanche;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	public PedidoLanche(Long idColaboradorLanche, Colaborador colaborador, Lanche lanche) {
		super();
		this.idColaboradorLanche = idColaboradorLanche;
		this.colaborador = colaborador;
		this.lanche = lanche;
	}

	public PedidoLanche() {
		super();
	}
	
	
	

}
