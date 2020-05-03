package br.com.lojaOnline.beans;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.atteo.moonshine.jta.Transactional;

import br.com.lojaOnline.dao.AutorDAO;
import br.com.lojaOnline.entity.Autor;

@ViewScoped
@Named(value="autorBean")
public class AutorBean {
	
	@Inject
	private AutorDAO autorDao;
	
	private Autor autor = new Autor();
	
	@Transactional
	public void salvarAutor() {
		System.out.println(this.autor.getNome());
		this.autorDao.salvarAutor(this.autor);
		System.out.println("Autor salvo com sucesso!");
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
}
