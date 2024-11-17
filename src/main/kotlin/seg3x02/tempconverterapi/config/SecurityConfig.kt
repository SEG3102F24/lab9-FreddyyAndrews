package seg3x02.tempconverterapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authz -> authz.anyRequest().authenticated() }.httpBasic()
        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user1 =
                User.withDefaultPasswordEncoder()
                        .username("user1")
                        .password("pass1")
                        .roles("USER")
                        .build()

        val user2 =
                User.withDefaultPasswordEncoder()
                        .username("user2")
                        .password("pass2")
                        .roles("USER")
                        .build()

        return InMemoryUserDetailsManager(user1, user2)
    }
}
