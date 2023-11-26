package com.chanel.fsh.peps.nextgen.cms.util.security.jwt;


import com.auth0.jwt.algorithms.Algorithm;
import com.chanel.fsh.peps.nextgen.cms.util.security.bean.User;
import com.chanel.fsh.peps.nextgen.cms.util.security.common.SecurityParams;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private String jwtSecret;


    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        User userPrincipal = (User) authentication.getPrincipal();
        Collection<String> roles = new ArrayList<>();
        if (userPrincipal.getAuthorities() != null) {
            userPrincipal.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        }

        String jwt = Jwt.create()
                .withSubject(userPrincipal.getUsername())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                .sign(Algorithm.HMAC256(SecurityParams.SECRET));
        return jwt;
    }

}
