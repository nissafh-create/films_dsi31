package projet.dsi31.films_dsi31.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration cors = new CorsConfiguration();
                        cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        cors.setAllowedMethods(Collections.singletonList("*"));
                        cors.setAllowedHeaders(Collections.singletonList("*"));
                        cors.setExposedHeaders(Collections.singletonList("Authorization"));
                        return cors;
                    }
                }))
                .authorizeHttpRequests(requests -> requests
                        // Consult all films: ADMIN or USER
                        .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
                        // Consult film by id: ADMIN or USER
                        .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN", "USER")
                        // Consult films by genre or name: ADMIN or USER
                        .requestMatchers(HttpMethod.GET, "/api/filmsGenre/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/api/filmsByName/**").hasAnyAuthority("ADMIN", "USER")
                        // Genre Spring Data REST endpoints: allow GET to ADMIN & USER, modifications to ADMIN
                        .requestMatchers(HttpMethod.GET, "/genre/**").hasAnyAuthority("ADMIN", "USER")
                        .requestMatchers("/genre/**").hasAuthority("ADMIN")
                        // Add film: ADMIN
                        .requestMatchers(HttpMethod.POST, "/api/addfilm/**").hasAuthority("ADMIN")
                        // Update film: ADMIN
                        .requestMatchers(HttpMethod.PUT, "/api/updatefilm/**").hasAuthority("ADMIN")
                        // Delete film: ADMIN
                        .requestMatchers(HttpMethod.DELETE, "/api/delfilm/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

