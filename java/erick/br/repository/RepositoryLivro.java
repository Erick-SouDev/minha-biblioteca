package erick.br.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import erick.br.model.Livro;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepositoryLivro extends JpaRepository<Livro, Long> {

	default Page<Livro> findPagableLivro(String titulo, Pageable pageable) {
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withMatcher("titulo",
				GenericPropertyMatcher.of(StringMatcher.CONTAINING, false).contains().ignoreCase());
		Example<Livro> example = Example.of(livro, exampleMatcher);
		return findAll(example, pageable);

	}

}
