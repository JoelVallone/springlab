package org.digitalpanda.springlab.config;

import org.digitalpanda.springlab.data.SpitterRepository;
import org.digitalpanda.springlab.spittr.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.
configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.
configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SpitterRepository spitterRepository;
    
    @Override
    //configure url access rights
    protected void configure(HttpSecurity http) throws Exception {
        /*http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin().and()
        .httpBasic();*/
        http
        .formLogin()
        // .loginPage("/login")
        .and()
        .rememberMe()
        .tokenValiditySeconds(7200)
            .key("spittrKey")
        .and()
        .httpBasic()
        .realmName("Spittr")
        .and()
        .authorizeRequests()
        /*
        .antMatchers("/presentation/main")
            .access("hasRole('ROLE_SPITTER') and hasIpAddress('127.0.0.1')")*/
        .antMatchers(HttpMethod.POST, "/springlab/**")
            .hasAuthority("ROLE_SPITTER")
        .anyRequest().permitAll()
        .and()
        .httpBasic()
        .and()
        .requiresChannel()
            .antMatchers("/springlab/**").requiresSecure(); 
        
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
                                                        throws Exception {
        //in-memory authentication
        /*
        auth.inMemoryAuthentication()
            .withUser("joel").password("joel").roles("USER").and()
            .withUser("angela").password("angela").roles("USER").and()
            .withUser("admin").password("admin").roles("USER", "ADMIN");*/
         
        //embedded LDAP service
        /*
        auth.ldapAuthentication()
            .userSearchBase("ou=people")
            .userSearchFilter("(uid={0})")
            .groupSearchBase("ou=groups")
            .groupSearchFilter("member={0}")
            .contextSource()
            .root("dc=habuma,dc=com")
            .ldif("classpath:users.ldif");*/
        
        //Custom authentication service
        auth.userDetailsService(
                new SpitterUserService(spitterRepository));
    }
}