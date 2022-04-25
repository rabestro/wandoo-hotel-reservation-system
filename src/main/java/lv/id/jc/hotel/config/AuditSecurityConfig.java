package lv.id.jc.hotel.config;

import lv.id.jc.hotel.model.User;
import lv.id.jc.hotel.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditSecurityConfig {

    /**
     * Lookup User instance corresponding to logged-in user
     *
     * @param userService user service implementation
     * @return Optional user
     */
    @Bean
    AuditorAware<User> auditorAware(UserService userService) {

        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getName)
                .flatMap(userService::findByEmail);
    }
}
