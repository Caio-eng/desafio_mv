package br.com.grupowl.desafio_unidac.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.grupowl.desafio_unidac.model.Lanche;

@ApplicationScoped
public class LancheService {
	
	 @Inject
	    EntityManager em; 
	 
	 @Transactional 
	    public Lanche createLanche(String nome) {
	        Lanche lanche = new Lanche();
	        lanche.setNome(nome);
	        em.persist(lanche);
	        
	        System.out.println(String.format("Criado lanche id: %s, nome: %s", lanche.getId(), lanche.getNome()));
	        return lanche;
	    }
	 
	 @Transactional
	    public Lanche criar(Lanche lanche) {
	        
	    	if (lanche.getId() != null) {
	    		lanche.setId(null);
	    	}
	    	
	        em.persist(lanche);
	        
	        System.out.println(String.format("Criado lanche id: %s, nome: %s\nCriado com sucesso", lanche.getId(), lanche.getNome()));
	        return lanche;
	    }
	 
	 @Transactional
	    public List<Lanche> listar() {
	    	List<Lanche> lanches = new ArrayList();
	    	
	    	lanches = em
         .createQuery("Select c from Lanche c", Lanche.class)
         .getResultList();
	    	return lanches;
	    }
	 
	 @Transactional
	    public Lanche atualizar(Lanche lanche) {
	        
	    	Lanche lancheAtual = em.find(Lanche.class, lanche.getId());
	    	System.out.println(String.format("Lanche atual id: %s, nome: %s\nCriado com sucesso", lancheAtual.getId(), lancheAtual.getNome()));
	    	lancheAtual.setNome(lanche.getNome());
	        em.merge(lancheAtual);
	        em.flush();
	        lanche = lancheAtual;
	        System.out.println(String.format("Atualizado lanche id: %s, nome: %s\nCriado com sucesso", lanche.getId(), lanche.getNome()));
	        return lanche;
	    }
	 
	 @Transactional
	    public Lanche deletar(Long id) {
	        
	    	Lanche lancheAtual = em.find(Lanche.class, id);
	    	System.out.println(String.format("Lanche a ser excluido id: %s, nome: %s\nCriado com sucesso", lancheAtual.getId(), lancheAtual.getNome()));
	 
	        em.remove(lancheAtual);
	        
	        System.out.println(String.format("Lanche excluido com sucesso id: %s, nome: %s\nCriado com sucesso", lancheAtual.getId(), lancheAtual.getNome()));
	        
	        return lancheAtual;
	    }
	 
	 @Transactional
	    public Lanche buscar(Long id) {
	        
	    	Lanche lancheAtual = em.find(Lanche.class, id);
	    	if (lancheAtual != null) {
	    		System.out.println(String.format("Lanche encontrado id: %s, nome: %s\nCriado com sucesso", lancheAtual.getId(), lancheAtual.getNome()));
	    	}
	    	else {
	    		System.out.println("Não existe lanche com id = " + id);
	    	}
	 
	       
	        
	        return  lancheAtual;
	    }

}
