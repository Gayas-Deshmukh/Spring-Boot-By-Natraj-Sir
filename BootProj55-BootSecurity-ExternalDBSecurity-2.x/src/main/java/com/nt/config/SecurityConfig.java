package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	DataSource ds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.jdbcAuthentication()
			.dataSource(ds)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("select UNAME,PWD,STATUS from users where UNAME=?")
			.authoritiesByUsernameQuery("select UNAME,ROLE from user_roles where UNAME=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests()
			.antMatchers("/").permitAll() // No authentication & No authorization
			.antMatchers("/offers").authenticated() // Only authentication
			.antMatchers("/balance").hasAnyAuthority("CUSTOMER", "MANAGER") // authentication & authorization for customer, manager user
			.antMatchers("/loanApprove").hasAuthority("MANAGER") // authentication & authorization for manager user
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
