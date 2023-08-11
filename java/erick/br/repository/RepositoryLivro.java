package erick.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import erick.br.model.Livro;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepositoryLivro extends JpaRepository<Livro, Long> {

	
	
	


}
