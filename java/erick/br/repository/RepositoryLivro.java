package erick.br.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import erick.br.model.Categoria;
import erick.br.model.Livro;
import jakarta.persistence.LockModeType;
import jakarta.persistence.OrderBy;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepositoryLivro extends JpaRepository<Livro, Long> {

	@Query("select l from Livro l where l.titulo like %?1% ")
	public List<Livro> pesquisarLivros(@Param("titulo") String titulo);

	@Query("select l from Livro l where l.categoria_id = ?1")

	public List<Livro> pesquisarLivros(@Param("id") Long titulo);


}
