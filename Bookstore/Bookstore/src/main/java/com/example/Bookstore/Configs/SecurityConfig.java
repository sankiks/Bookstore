package com.example.Bookstore.Configs;

import javax.security.sasl.AuthorizeCallback;

import org.hibernate.jdbc.Expectations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("Uncle_Bob_1337")
				.password("TomCruiseIsUnder170cm").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers("/admin/").authenticated().anyRequest().permitAll())
				.httpBasic();
		
		return http.build();

	}

}
