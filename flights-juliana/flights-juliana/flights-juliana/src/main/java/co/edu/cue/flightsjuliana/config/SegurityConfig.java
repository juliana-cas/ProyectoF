package co.edu.cue.flightsjuliana.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SegurityConfig {
    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("{noop}123")
                        .build()
        );
    }
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
        {
            return http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(authRequest ->
                            authRequest
                                    .requestMatchers("/public/**").permitAll() // Allow requests from "/public" path
                                    .requestMatchers("/login").permitAll()
                                    .anyRequest().authenticated()
                    )
                    .formLogin(form-> {
                        form.loginPage("/login");
                        form.successForwardUrl("/home");
                        form.permitAll();
                    })
                    .build();


        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
