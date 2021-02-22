package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource ds;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().
		dataSource(ds).
		usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?").
		authoritiesByUsernameQuery("SELECT UNAME, ROLE FROM USER_ROLE WHERE UNAME=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").access("permitAll()")
			.antMatchers("/country").access("hasAnyRole('ROLE_MANAGER','ROLE_CLERK')").and().
			formLogin().and().logout().logoutSuccessUrl("/logout.jsp").and().
			exceptionHandling().
			accessDeniedPage("/access_denied.jsp").and().
			rememberMe().and().
			sessionManagement().
			maximumSessions(1).
			maxSessionsPreventsLogin(true);
	}
}
