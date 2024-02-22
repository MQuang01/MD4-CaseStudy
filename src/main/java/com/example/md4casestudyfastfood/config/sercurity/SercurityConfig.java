package com.example.md4casestudyfastfood.config.sercurity;

import com.example.md4casestudyfastfood.config.bean.AppConfig;
import com.example.md4casestudyfastfood.config.filter.JwTokenFilterChain;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SercurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwTokenFilterChain JwTokenFilterChain;
    private final AppConfig appConfig;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/api/auths/**").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/products").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api/categories").permitAll()
                                .anyRequest().authenticated())
                .formLogin(
                        form -> form
                                .defaultSuccessUrl("/")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                ).addFilterBefore(JwTokenFilterChain, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(appConfig.passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
