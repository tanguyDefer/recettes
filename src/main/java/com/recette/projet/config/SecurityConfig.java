package com.recette.projet.config;

import com.recette.projet.service.UserService;
import com.recette.projet.service.security.AppAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    UserService userDetailsService;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/projet/**",
                        "/images/**",
                        "/src/**",

                        "/src/main/resources/templates/images/images-recto/**",
                        "/css/**",
                        "/js/**")
                .addResourceLocations(
                        "classpath:/src/main/resources",
                        "/src/main/resources/templates/images/images-recto/**",
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String internalSecretKey = "internalSecretKey";
        http.csrf()
                .disable()
                .rememberMe()
                .key("myUniqueKey")
                .rememberMeCookieName("recette-login-remember-me")
                .tokenValiditySeconds(10000000)
                .and()
                .exceptionHandling()
                .and()
                .authenticationProvider(getProvider())
                .formLogin()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/logout").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/images/images-recto/**").permitAll()
                .antMatchers("/recettes/hellofresh/all").permitAll()
                .antMatchers("/**/*.css", "/**/*.js").permitAll()
                .antMatchers("/**/**", "/**/*.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login");
    }

    private static class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
        @Autowired
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication, AuthenticationManagerBuilder auth)
                throws Exception {
            response.setStatus(HttpServletResponse.SC_OK);
            auth
                    .inMemoryAuthentication();
        }
    }

    private static class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Bean
    public AuthenticationProvider getProvider() {
        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("websparrow").password("{noop}web123");
//    }
}