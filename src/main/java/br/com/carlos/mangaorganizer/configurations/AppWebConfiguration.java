package br.com.carlos.mangaorganizer.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import br.com.carlos.mangaorganizer.controllers.MangasController;
import br.com.carlos.mangaorganizer.controllers.RolesController;
import br.com.carlos.mangaorganizer.controllers.UserAccountsController;
import br.com.carlos.mangaorganizer.controllers.UsersController;
import br.com.carlos.mangaorganizer.models.UserAccount;
import br.com.carlos.mangaorganizer.models.daos.MangaDAO;
import br.com.carlos.mangaorganizer.models.daos.RoleDAO;
import br.com.carlos.mangaorganizer.models.daos.UserDAO;
import br.com.carlos.mangaorganizer.models.daos.UserMangaDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = { UserAccount.class, MangasController.class, UsersController.class, RolesController.class,
	UserAccountsController.class, RoleDAO.class, UserDAO.class, MangaDAO.class, UserMangaDAO.class, UserDetailsService.class, 
	DataSourceConfigurationDev.class, PropertiesConfigurationDev.class, CacheManagerConfiguration.class, MessageSourceConfiguration.class,
	 ViewResolverConfiguration.class })
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd-MM-yyyy"));
		registrar.registerFormatters(conversionService);

		return conversionService;
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
}
