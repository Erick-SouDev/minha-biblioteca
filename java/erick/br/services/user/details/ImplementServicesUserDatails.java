package erick.br.services.user.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import erick.br.model.Usuario;
import erick.br.repository.RepositoryUsuario;

@Service
public class ImplementServicesUserDatails implements UserDetailsService {

	@Autowired
	private RepositoryUsuario repositoryUsuario;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repositoryUsuario.buscarUsuarioPorLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario Não foi encontrado");
		}
		return usuario;
	}

}
