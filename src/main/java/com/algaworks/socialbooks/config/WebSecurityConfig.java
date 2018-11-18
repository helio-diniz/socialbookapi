package com.algaworks.socialbooks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		//permite configuração básica do mecanismo de autenticação
		auth.inMemoryAuthentication().withUser("algaworks").password("s3nh4").roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().
		    antMatchers("/h2-console/**").permitAll(). // bypass
		    antMatchers(HttpMethod.OPTIONS, "/**").permitAll(). //permite qualquer chamada de Options sem autenticacao. Options é necessário para o browser.
			anyRequest().authenticated().
			and().httpBasic().
			and().csrf().disable(); // proteção para evitar ataque
	}
}
