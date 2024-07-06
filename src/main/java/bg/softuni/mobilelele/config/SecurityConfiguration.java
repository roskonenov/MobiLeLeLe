package bg.softuni.mobilelele.config;

import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    private static final String[] AUTHORIZATION_LIST = {
            "/",
            "/users/login",
            "/users/register",
            "/api/convert"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       return http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers(AUTHORIZATION_LIST).permitAll()
                .anyRequest().authenticated())
                .formLogin( formLogin -> formLogin
                        .loginPage("/users/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/")
                        .failureForwardUrl("/users/login-error")
                ).logout(logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
