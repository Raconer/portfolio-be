package com.portfolio.be.config

import com.portfolio.be.common.utils.JwtUtil
import com.portfolio.be.config.jwt.JwtAuthenticationEntryPoint
import com.portfolio.be.config.jwt.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint,
    private val jwtUtil: JwtUtil,
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain {
        http.csrf {
            it.disable()
        }
            .authorizeHttpRequests {
                it
                    .requestMatchers("/v1/sign/**").permitAll()
                    .requestMatchers("/api/swagger-ui/index.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                    .anyRequest().authenticated()
            }.exceptionHandling {
                it.authenticationEntryPoint(jwtAuthenticationEntryPoint)
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }.addFilterBefore(JwtRequestFilter(jwtUtil), UsernamePasswordAuthenticationFilter::class.java)


        return http.build()
    }

    // @Bean
    // fun corsConfigurationSource(): CorsConfigurationSource {
    //     val configuration = CorsConfiguration()
    //     configuration.allowedHeaders = listOf("*")
    //     configuration.allowedMethods = listOf("*")
    //     configuration.allowedOriginPatterns = listOf("http://localhost:8080") // ⭐️ 허용할 origin
    //     configuration.allowCredentials = true
    //
    //     val source = UrlBasedCorsConfigurationSource()
    //     source.registerCorsConfiguration("/**", configuration)
    //     return source
    // }
}