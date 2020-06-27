package br.com.lojaOnline.entity;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LAUDO", nullable = false)
	private Long idLivro;
	private static final long serialVersionUID = 1L;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "PRECO")
	private Float preco;

	@Column(name = "QUANTIDADE_PAGINAS")
	private Integer quantidadePaginas;

	@Column(name = "DESCRICAO_LIVRO")
	private String descricaoLivro;

	@Column(name = "ANO_PUBLICACAO")
	private Integer anoPublicacao;

	@ManyToMany
	private List<Autor> autores;

	public Livro() {
		this.autores = new LinkedList<Autor>();
	}

	/*
	 * ---------------------------------- Getters and Setters
	 * ----------------------------------
	 */

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(Integer quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getDescricaoLivro() {
		return descricaoLivro;
	}

	public void setDescricaoLivro(String descricaoLivro) {
		this.descricaoLivro = descricaoLivro;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Livro)) {
			return false;
		}
		Livro other = (Livro) obj;
		if (idLivro != null) {
			if (!idLivro.equals(other.idLivro)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (idLivro != null)
			result += "id: " + idLivro;
		return result;
	}
}