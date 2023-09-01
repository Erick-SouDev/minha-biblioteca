package erick.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import erick.br.model.Usuario;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepositoryUsuario extends JpaRepository<Usuario , Long>{
	
	@Query("select u from Usuario u where u.login = ?1")
	public Usuario buscarUsuarioPorLogin(String login);

}
