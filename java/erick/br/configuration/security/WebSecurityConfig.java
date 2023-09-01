package erick.br.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import erick.br.services.user.details.ImplementServicesUserDatails;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	
	
	@Autowired
	ImplementServicesUserDatails datailsUserServices;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().requestMatchers(HttpMethod.GET, "/").permitAll()
				.requestMatchers(HttpMethod.GET, "/home" , "/**" ).permitAll().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/home").failureUrl("/login?error=true").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		        
		
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("static/**", "imagens/**");
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception {
		return security.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(datailsUserServices)
				.passwordEncoder(bCryptPasswordEncoder()).and().build();
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
