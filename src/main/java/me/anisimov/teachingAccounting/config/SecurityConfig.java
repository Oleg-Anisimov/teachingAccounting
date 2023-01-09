package me.anisimov.teachingAccounting.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.anisimov.teachingAccounting.dto.AuthResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/")
                .successHandler(successHandler())
                .failureHandler(((request, response, exception) -> {
                    response.setStatus(401);
                }))
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessHandler(((request, response, authentication) -> {
                    response.setStatus(200);
                }));

        return http.build();
    }
        @Bean
        public AuthenticationSuccessHandler successHandler() {
            return (request, response, authentication) -> {
                response.setStatus(200);

                StringBuilder sb = new StringBuilder();
                authentication.getAuthorities().forEach(sb::append);
                String principal = ((UserDetails) authentication.getPrincipal()).getUsername();
                AuthResultDto authResultDto = new AuthResultDto(principal,sb.toString());
                response.getOutputStream().println(mapper.writeValueAsString(authResultDto));
            };
        }
}
