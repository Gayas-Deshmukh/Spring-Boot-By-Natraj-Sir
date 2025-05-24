package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig 
{
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(request -> {
			request.requestMatchers("/bank/welcome").permitAll()
					.requestMatchers("/bank/balance","/bank/loan_approve","/bank/offers").authenticated();
			})
		.formLogin(Customizer.withDefaults()); // return SecurityFilterChain obj which is impl class obj SecurityFilterChain(I)
		
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService()
	{
		/*
		 * Approach 1 - Use DefaultPasswordEncoder which us deprecated
		UserDetails manager		=	User.withDefaultPasswordEncoder()
										.username("suresh")
										.password("mgr123")
										.authorities("MANAGER")
										.build();
	
		UserDetails customer	=	User.withDefaultPasswordEncoder()
										.username("amol")
										.password("amol123")
										.authorities("CUSTOMER")
										.build();
		*/
		
		/*
		 * Approach 2 - BCryptPasswordEncoder 
		 */
		
		UserDetails manager		=	User.withUsername("suresh")
										.password(getEncoder().encode("mgr123"))
										.authorities("MANAGER")
										.build();

		UserDetails customer	=	User.withUsername("amol")
										.password(getEncoder().encode("amol123"))
										.authorities("CUSTOMER")
										.build();


		return new InMemoryUserDetailsManager(manager, customer);
	}
	
	@Bean
	public PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
