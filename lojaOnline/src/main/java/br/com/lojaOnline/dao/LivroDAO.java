package br.com.lojaOnline.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lojaOnline.entity.Livro;

@Stateful
public class LivroDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void salvarLivro(Livro livro) {
		this.em.merge(livro);
	}

}
