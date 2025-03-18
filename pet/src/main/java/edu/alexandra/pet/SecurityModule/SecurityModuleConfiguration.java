package edu.alexandra.pet.SecurityModule;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.modulith.ApplicationModule;

import java.security.Key;

@ApplicationModule
@Configuration
public class SecurityModuleConfiguration {

    @Value("${jwt.secret}")
    private String secretKey;

    @Bean
    public Key jwtSigningKey()    {
        byte[] keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
