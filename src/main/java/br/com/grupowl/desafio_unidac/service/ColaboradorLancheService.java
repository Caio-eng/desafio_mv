package br.com.grupowl.desafio_unidac.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.arjuna.ats.arjuna.recovery.Service;

import br.com.grupowl.desafio_unidac.model.Colaborador;
import br.com.grupowl.desafio_unidac.model.ColaboradorLanche;
import br.com.grupowl.desafio_unidac.model.Lanche;
import br.com.grupowl.desafio_unidac.model.PedidoLanche;

@ApplicationScoped
public class ColaboradorLancheService {

	@Inject
	EntityManager em;

	@Inject
	ColaboradorService colaboradorService;

	@Inject
	LancheService lancheService;

	@Transactional
	public ColaboradorLanche criar(ColaboradorLanche colaboradorLanche) throws Exception {

		Colaborador colaborador;
		Lanche lanche;

		colaborador = colaboradorService.buscar(colaboradorLanche.getColaboradorId());

		lanche = lancheService.buscar(colaboradorLanche.getLancheId());

		if (lanche == null || colaborador == null) {
			throw new Exception("Deve informar o colaborador ou um lanche");
		}

		if (colaboradorLanche.getId() != null) {
			colaboradorLanche.setId(null);
		}

		em.persist(colaboradorLanche);

		System.out.println(String.format("Criado colaborador id: %s, nome: %s, cpf: %s\nCriado com sucesso",
				colaboradorLanche.getId(), colaboradorLanche.getColaboradorId(), colaboradorLanche.getLancheId()));
		return colaboradorLanche;
	}

	@Transactional
	public List<PedidoLanche> listar() {

		List<ColaboradorLanche> colaboradoresLanches = new ArrayList();
		List<PedidoLanche> pedidoLanches = new ArrayList();
		List<Object[]> result =			em.createNativeQuery("SELECT * FROM colaboradorlanche")
				.getResultList();
		for (Object[] linha : result) {
			ColaboradorLanche colaboradorLanche = new ColaboradorLanche();
			colaboradorLanche.setId(((BigInteger)linha[0]).longValue());
			colaboradorLanche.setColaboradorId(((BigInteger)linha[1]).longValue());
			colaboradorLanche.setLancheId(((BigInteger)linha[2]).longValue());
			colaboradoresLanches.add(colaboradorLanche);
		}
		if (colaboradoresLanches.isEmpty()) {
			return pedidoLanches;
		}
		for (ColaboradorLanche cl : colaboradoresLanches) {

			Colaborador colaborador;
			Lanche lanche;
			colaborador = colaboradorService.buscar(cl.getColaboradorId());

			lanche = lancheService.buscar(cl.getLancheId());
			
			PedidoLanche pd = new PedidoLanche(cl.getId(), colaborador, lanche);
			pedidoLanches.add(pd);
		}
		return pedidoLanches;
	}

//	@Transactional
//	public ColaboradorLanche atualizar(ColaboradorLanche colaboradorLanche) {
//
//		ColaboradorLanche colaboradorLancheAtual = em.find(ColaboradorLanche.class, colaboradorLanche.getId());
//		System.out.println(String.format("Colaborador atual id: %s, nome: %s, cpf: %s\nCriado com sucesso",
//				colaboradorLancheAtual.getId(), colaboradorLancheAtual.getColaboradorId(),
//				colaboradorLancheAtual.getLancheId()));
//		colaboradorLancheAtual.setColaboradorId(colaboradorLanche.getColaboradorId());
//		colaboradorLancheAtual.setId(colaboradorLanche.getId());
//		em.merge(colaboradorLancheAtual);
//		em.flush();
//		colaboradorLanche = colaboradorLancheAtual;
//		System.out.println(String.format("Atualizado colaborador id: %s, nome: %s, cpf: %s\nCriado com sucesso",
//				colaboradorLanche.getId(), colaboradorLanche.getColaboradorId(), colaboradorLanche.getLancheId()));
//		return colaboradorLanche;
//	}
//
//	@Transactional
//	public ColaboradorLanche deletar(Integer id) {
//
//		ColaboradorLanche colaboradorLancheAtual = em.find(ColaboradorLanche.class, id);
//		System.out.println(String.format("Colaborador a ser excluido id: %s, nome: %s, cpf: %s\nCriado com sucesso",
//				colaboradorLancheAtual.getId(), colaboradorLancheAtual.getColaboradorId(),
//				colaboradorLancheAtual.getColaboradorId()));
//
//		em.remove(colaboradorLancheAtual);
//
//		System.out
//				.println(String.format("Colaborador excluido com sucesso id: %s, nome: %s, cpf: %s\nCriado com sucesso",
//						colaboradorLancheAtual.getId(), colaboradorLancheAtual.getColaboradorId(),
//						colaboradorLancheAtual.getLancheId()));
//
//		return colaboradorLancheAtual;
//	}
//
//	@Transactional
//	public ColaboradorLanche buscar(Integer id) {
//
//		ColaboradorLanche colaboradorLancheAtual = em.find(ColaboradorLanche.class, id);
//		if (colaboradorLancheAtual != null) {
//			System.out.println(String.format("Colaborador encontrado id: %s, nome: %s, cpf: %s\nCriado com sucesso",
//					colaboradorLancheAtual.getId(), colaboradorLancheAtual.getColaboradorId(),
//					colaboradorLancheAtual.getLancheId()));
//		} else {
//			System.out.println("Não existe colaborador com id = " + id);
//		}
//
//		return colaboradorLancheAtual;
//	}

}
