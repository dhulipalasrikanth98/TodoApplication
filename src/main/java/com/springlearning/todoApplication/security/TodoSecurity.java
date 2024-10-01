package com.springlearning.todoApplication.security;

import com.springlearning.todoApplication.entity.Todo;
import static org.springframework.security.config.Customizer.withDefaults;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Configuration
public class TodoSecurity {
   
	@Bean
	public InMemoryUserDetailsManager createUser() {
		//UserDetails user = User.withDefaultPasswordEncoder().username("srikanth").password("1234").build();
		UserDetails user = createUser("srikanth", "1234");
		UserDetails user1 = createUser("valli","1234");
				    
		return new InMemoryUserDetailsManager(user,user1);
	}
	private UserDetails createUser(String username, String password) {
		return User.builder()
				           .passwordEncoder(input -> passwordEncoder().encode(input))
				           .username(username)
		                   .password(password)
		                   .roles("USER","ADMIN").build();
	}
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
	    http.formLogin(withDefaults());
	    http.csrf().disable();
	    http.headers().frameOptions().disable();
		return http.build();
	}
}
