package erick.br.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().requestMatchers(HttpMethod.GET, "/login").permitAll()

		         .requestMatchers("/home" , "/livro/**" , "/categoria/**").hasRole("ADMIN")
				 .requestMatchers("/home").hasRole("USER").anyRequest()
				.authenticated().and().formLogin().permitAll()
				

				.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("erick@yahoo").password("123")
				.roles("USER")
				
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}
