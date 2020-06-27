package br.com.lojaOnline.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.atteo.moonshine.jta.Transactional;

import br.com.lojaOnline.dao.AutorDAO;
import br.com.lojaOnline.dao.LivroDAO;
import br.com.lojaOnline.entity.Autor;
import br.com.lojaOnline.entity.Livro;

@RequestScoped
@Named(value = "livroBean")
public class LivroBean {
	
	@Inject
	private LivroDAO livroDAO;
	
	@Inject
	private AutorDAO autorDAO;
	
	private Livro livro;
	private List<Autor> autores;
	
	@PostConstruct
	public void init() {
		this.livro = new Livro();
		this.autores = this.autorDAO.buscarTodosAutores();
	}
	
	@Transactional //Precisamos pedir essa transação para o JTA, o pedido é feito pela annotation @Transactional
	public void salvarLivro() {
		this.livroDAO.salvarLivro(this.livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
}
