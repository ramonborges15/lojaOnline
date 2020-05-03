package br.com.lojaOnline.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.com.lojaOnline.entity.Autor;

@Stateful
public class AutorDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void salvarAutor(Autor autor) {
		em.merge(autor);
	}

}
