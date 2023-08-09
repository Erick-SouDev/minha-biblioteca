package erick.br.model;

import java.io.Serializable;

import org.thymeleaf.expression.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue( strategy = GenerationType.AUTO)
	@Id
	
	private Long id;

	
	@NotEmpty(message = "Informe a Categoria "  )
	private String nomeCategoria;

	

	public Categoria() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return java.util.Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nomeCategoria=" + nomeCategoria + "]";
	}
 


}
