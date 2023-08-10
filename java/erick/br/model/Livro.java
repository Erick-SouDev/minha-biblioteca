package erick.br.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 100, name = "seq_id_livro")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_livro")
	private Long id;

	@NotBlank(message = "informe  o titulo")
	@Column(name = "titulo", length = 150)
	private String titulo;
	
	@NotBlank(message = "informe o subtitulo")
	@Column(name = "subtitulo", length = 150)
	private String subTitulo;
	
	@NotBlank(message = "informe a url ")
	@Column(name = "urlcapalivro", columnDefinition = "text")
	private String urlCapaLivro;
	
	@Column(name = "totalpaginas", length = 3000)
	private Long totalPagina;

	@NotBlank(message = "informe a descricao")
	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = false)
	@NotNull(message = "selecione uma categoria")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public String getUrlCapaLivro() {
		return urlCapaLivro;
	}

	public void setUrlCapaLivro(String urlCapaLivro) {
		this.urlCapaLivro = urlCapaLivro;
	}

	public Long getTotalPagina() {
		return totalPagina;
	}

	public void setTotalPagina(Long totalPagina) {
		this.totalPagina = totalPagina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", subTitulo=" + subTitulo + ", urlCapaLivro=" + urlCapaLivro
				+ ", totalPagina=" + totalPagina + ", descricao=" + descricao + ", categoria=" + categoria + "]";
	}

}
