package com.alissonpedrina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alissonpedrina.service.PostgresUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PostgresUserDetailsService userDetailService;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailService);
//		auth.inMemoryAuthentication()
//		  .withUser("john").password(passwordEncoder.encode("123")).roles("USER").and()
//		  .withUser("tom").password(passwordEncoder.encode("111")).roles("ADMIN").and()
//		  .withUser("user1").password(passwordEncoder.encode("pass")).roles("USER").and()
//		  .withUser("admin").password(passwordEncoder.encode("nimda")).roles("ADMIN");

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/oauth/token/revokeById/**").permitAll()
				.antMatchers("/tokens/**").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf()
				.disable();

	}

}
