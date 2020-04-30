package br.com.lojaOnline.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class Autor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTOR", nullable = false)
	private Long idAutor;
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "NOME")
	private String nome;
	
	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros;

	/*
	 * ---------------------------
	 * Getters and Setters
	 * ---------------------------
	 * 
	 */

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Autor)) {
			return false;
		}
		Autor other = (Autor) obj;
		if (idAutor != null) {
			if (!idAutor.equals(other.idAutor)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutor == null) ? 0 : idAutor.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (idAutor != null)
			result += "id: " + idAutor;
		return result;
	}
}