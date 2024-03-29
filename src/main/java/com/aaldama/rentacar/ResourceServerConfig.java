package com.aaldama.rentacar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                    }
                })
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/swagger.ui.html/**").permitAll()
                .antMatchers("/roles/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/location/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/manufacturer/**").permitAll()
                .antMatchers("/menus/**").permitAll()
                .antMatchers("/model/**").permitAll()
                .antMatchers("/rental-status/**").permitAll()
                .antMatchers("/tokens/**").permitAll()
                .antMatchers("/users/**").hasAuthority("ROLE_USER")
                .antMatchers("/users/resume/{id}**").hasAuthority("ROLE_USER")
                .antMatchers(HttpMethod.GET,"/vehicles/**").permitAll()
                .antMatchers("/vehicles/**").permitAll()
                .antMatchers("/vehicle-rented/**").authenticated()
                .antMatchers("/vehicle-rented/rentados/**").authenticated()
                .antMatchers("/vehicle-rented/rentados/{id}").authenticated()

        ;
    }
}