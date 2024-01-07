package com.bank.accounts.config;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

/*    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(antMatcher("/sayHello"), antMatcher("/sayBye")).hasRole("ACCOUNTS")
                            .requestMatchers(antMatcher("/actuator/**"),
                                    antMatcher("/v3/api-docs/**"),
                                    antMatcher("/swagger-ui/**"),
                                    antMatcher("/h2-console/**"),
                                    antMatcher("/**"),
                                    antMatcher("/api/**")).permitAll()
                            .anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth2ResourceServerCustomizer ->
                        oauth2ResourceServerCustomizer.jwt(jwtCustomizer -> jwtCustomizer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }*/
}
