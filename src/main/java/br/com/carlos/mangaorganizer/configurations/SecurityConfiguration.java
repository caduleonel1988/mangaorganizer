
package br.com.carlos.mangaorganizer.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(users).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		http.addFilterBefore(encodingFilter, CsrfFilter.class);

		http.authorizeRequests()
				.antMatchers("/mangas/form/").hasRole("ADMIN")
				.antMatchers("/mangas/form").hasRole("ADMIN")
				.antMatchers("/users/").hasRole("ADMIN")
				.antMatchers("/users").hasRole("ADMIN")
				.antMatchers("/users/form/").hasRole("ADMIN")
				.antMatchers("/users/form").hasRole("ADMIN")
				.antMatchers("/roles/").hasRole("ADMIN")
				.antMatchers("/roles").hasRole("ADMIN")
				.antMatchers("/roles/form/").hasRole("ADMIN")
				.antMatchers("/roles/form").hasRole("ADMIN")
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

	}
	
}
