package erick.br.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role implements GrantedAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String role;
	
	public Long getId() {
		return id;
	
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}

	

}
