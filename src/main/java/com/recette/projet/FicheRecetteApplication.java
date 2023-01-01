package com.recette.projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class FicheRecetteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicheRecetteApplication.class, args);
	}
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
		return container -> {
			ErrorPage[] errs = new ErrorPage[3];
			errs[0] = new ErrorPage(HttpStatus.NOT_FOUND,"/notFound");
			errs[1] = new ErrorPage(HttpStatus.BAD_GATEWAY,"/badGateway");
			errs[2] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error");
			container.addErrorPages(errs);
		};
	}
}
