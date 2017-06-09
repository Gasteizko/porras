package es.ucm.fdi.porras.config;

import java.io.IOException;

import es.ucm.fdi.porras.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private Environment env;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        		.antMatchers("/static/**", "/logout", "/403", "/registro*", "/registration").permitAll()
				.mvcMatchers("/admin").hasRole("ADMIN")
        		.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
	            .loginPage("/")
				.usernameParameter("user")
				.passwordParameter("pass")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/dash")
	            .and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
	            .permitAll()
			.and()
				.sessionManagement()
				.maximumSessions(1);
	}



	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

	/*@Bean
	public CustomUserDetailsService springDataUserDetailsService() {
		return new CustomUserDetailsService();
	}*/

	//Si eliminas el "Bean" anterior, esto funciona sin BD ni nada:

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER")
				.and()
				.withUser("paco").password("password").roles("USER", "ADMIN")
				.and()
				.withUser("juan").password("password").roles("USER", "ADMIN");
	}*/

/*
	@Order(2)
	public class SecurityWebApplicationInitializer extends
			AbstractSecurityWebApplicationInitializer {

		@Override
		protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
			// see http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf-multipartfilter
			insertFilters(servletContext, new MultipartFilter());
		}

		@Bean(name="multipartResolver")
		public CommonsMultipartResolver getResolver() throws IOException {
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			resolver.setMaxUploadSizePerFile(5 * 1024 * 1024);// 5 MB
			resolver.setMaxInMemorySize(10 * 1024 * 1025); // zip-bomb protection
			return resolver;
		}
	}*/
}
