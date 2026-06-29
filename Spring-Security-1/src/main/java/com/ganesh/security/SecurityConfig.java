package com.ganesh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public BCryptPasswordEncoder endoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService createUsers() {
		
		UserDetails user1 = User.
				withUsername("Ganesh")
				.password(endoder().encode("0152"))
				.roles("USER")
				.build(); 
		
		
		UserDetails user2 = User.
				withUsername("Ram")
				.password(endoder().encode("716"))
				.roles("ADMIN")
				.build(); 
		
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
	
	@Bean
	public SecurityFilterChain securityLogic(HttpSecurity http) {
		
		http.authorizeHttpRequests(auth->{
			
			auth.requestMatchers("/welcome").hasRole("USER")
			.requestMatchers("/greet").hasRole("ADMIN");
			auth.anyRequest().authenticated();
		}).formLogin(form->form.permitAll());
		
		return http.build();
	}
	
	
	
	

}
