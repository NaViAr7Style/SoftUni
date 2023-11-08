package org.softuni.mobilele.config;

import org.softuni.mobilele.models.enums.UserRoleEnum;
import org.softuni.mobilele.repositories.UserRepository;
import org.softuni.mobilele.services.impl.MobileleUserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final String rememberMeKey;

    public SecurityConfiguration(@Value("${mobilele.remember.me.key}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(
                // Define which URLs are visible by which users
                authorizeRequests -> authorizeRequests
                        // All static resources which are situated in js, images, css are available to anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow anyone to see the home page, the registration page and the login form
                        .requestMatchers("/","/users/register").permitAll()
                        .requestMatchers("/users/login","/users/login-error").permitAll()
                        .requestMatchers("/offers/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/offer/**").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("brands").hasRole(UserRoleEnum.ADMIN.name())
                        // All other requests are authenticated
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> formLogin
                        // Redirect here when we try to access something which requires authentication
                        // Also this is the page where we perform login
                        .loginPage("/users/login")
                        // The names of the input fields (in our case in auth-login.html)
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                        // Should be handled in login controller -> separate URL in order to preserve input data.
                        .failureForwardUrl("/users/login-error")
        ).logout(
                logout -> logout
                        // The URL where we should POST something in order to perform the logout
                        .logoutUrl("/users/logout")
                        // Where to go when logged out?
                        .logoutSuccessUrl("/")
                        // Invalidate the HTTP session
                        .invalidateHttpSession(true)
        ).rememberMe(
                rememberMe -> {
                    rememberMe
                            .key(rememberMeKey)
                            .rememberMeParameter("rememberme")
                            .rememberMeCookieName("rememberme")
                            .tokenValiditySeconds(1800);
                }
        ).build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        // This service translates the Mobilele users and roles to representation which Spring Security understands
        return new MobileleUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
