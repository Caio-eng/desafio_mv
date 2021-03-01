package br.com.grupowl.desafio_unidac.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.grupowl.desafio_unidac.model.Colaborador;

@ApplicationScoped
public class ColaboradorService {
	
	
	    @Inject
	    EntityManager em; 

	    @Transactional 
	    public Colaborador createColaborador(String nome, String cpf) {
	        Colaborador colaborador = new Colaborador();
	        colaborador.setNome(nome);
	        colaborador.setCpf(cpf);
	        em.persist(colaborador);
	        
	        System.out.println(String.format("Criado colaborador id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaborador.getId(), colaborador.getNome(), colaborador.getCpf()));
	        return colaborador;
	    }
	    @Transactional
	    public Colaborador criar(Colaborador colaborador) {
	        
	    	if (colaborador.getId() != null) {
	    		colaborador.setId(null);
	    	}
	    	
	        em.persist(colaborador);
	        
	        System.out.println(String.format("Criado colaborador id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaborador.getId(), colaborador.getNome(), colaborador.getCpf()));
	        return colaborador;
	    }
	    
	    @Transactional
	    public List<Colaborador> listar() {
	    	List<Colaborador> colaboradores = new ArrayList();
	    	
	    	colaboradores = em
            .createQuery("Select c from Colaborador c", Colaborador.class)
            .getResultList();
	    	return colaboradores;
	    }
	    
	    @Transactional
	    public Colaborador atualizar(Colaborador colaborador) {
	        
	    	Colaborador colaboradorAtual = em.find(Colaborador.class, colaborador.getId());
	    	System.out.println(String.format("Colaborador atual id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaboradorAtual.getId(), colaboradorAtual.getNome(), colaboradorAtual.getCpf()));
	    	colaboradorAtual.setNome(colaborador.getNome());
	    	colaboradorAtual.setCpf(colaborador.getCpf());
	        em.merge(colaboradorAtual);
	        em.flush();
	        colaborador = colaboradorAtual;
	        System.out.println(String.format("Atualizado colaborador id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaborador.getId(), colaborador.getNome(), colaborador.getCpf()));
	        return colaborador;
	    }
	    
	    @Transactional
	    public Colaborador deletar(Long id) {
	        
	    	Colaborador colaboradorAtual = em.find(Colaborador.class, id);
	    	System.out.println(String.format("Colaborador a ser excluido id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaboradorAtual.getId(), colaboradorAtual.getNome(), colaboradorAtual.getCpf()));
	 
	        em.remove(colaboradorAtual);
	        
	        System.out.println(String.format("Colaborador excluido com sucesso id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaboradorAtual.getId(), colaboradorAtual.getNome(), colaboradorAtual.getCpf()));
	        
	        return colaboradorAtual;
	    }
	    
	    @Transactional
	    public Colaborador buscar(Long id) {
	        
	    	Colaborador colaboradorAtual = em.find(Colaborador.class, id);
	    	if (colaboradorAtual != null) {
	    		System.out.println(String.format("Colaborador encontrado id: %s, nome: %s, cpf: %s\nCriado com sucesso", colaboradorAtual.getId(), colaboradorAtual.getNome(), colaboradorAtual.getCpf()));
	    	}
	    	else {
	    		System.out.println("Não existe colaborador com id = " + id);
	    	}
	 
	       
	        
	        return colaboradorAtual;
	    }

}
