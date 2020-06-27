package br.com.lojaOnline.dao;

import java.util.List;

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

	public List<Autor> buscarTodosAutores() {
		String query = "SELECT a FROM Autor a ORDER BY a.nome";
		return em.createQuery(query, Autor.class).getResultList();
	}

}
