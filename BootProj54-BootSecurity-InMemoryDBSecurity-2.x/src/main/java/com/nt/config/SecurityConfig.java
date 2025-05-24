package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.inMemoryAuthentication()
			.withUser("testUser")
			.password("{noop}test@123")
			.roles("CUSTOMER");
		
		auth.inMemoryAuthentication()
			.withUser("mangr")
			.password("{noop}mgr@123")
			.roles("MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll() // No authentication & No authorization
			.antMatchers("/offers").authenticated() // Only authentication
			.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER") // authentication & authorization for customer, manager user
			.antMatchers("/loanApprove").hasRole("MANAGER") // authentication & authorization for manager user
			.anyRequest().authenticated()
			.and()
//			.httpBasic() // specify authentication mode - browser dialog
			.formLogin() // specify authentication mode - default 
			.and().logout()
			//.and().rememberMe() // Does not work in this version
			.and().exceptionHandling().accessDeniedPage("/denied")
			.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}
