package enicar.soc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration

public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity.authorizeExchange()
                .pathMatchers("/actuator/**")
                .permitAll()
                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Login();
        serverHttpSecurity.csrf().disable();
        return serverHttpSecurity.build();

    }
}
