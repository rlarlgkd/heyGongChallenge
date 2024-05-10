package com.challenge.heyGongChallenge.auth.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.StringUtils;
import java.util.Collections;

public class JwtAuthenticationConverter implements AuthenticationConverter {

    private final JWTUtil jwtUtil;

    public JwtAuthenticationConverter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication convert(HttpServletRequest request) {
        String jwt = extractJwtFromRequest(request);
//        if (StringUtils.hasText(jwt) && !jwtUtil.isExpired(jwt)) {
//            if ("user".equals(jwtUtil.getClaimFromToken(jwt, "type"))) {
//                return new UsernamePasswordAuthenticationToken(jwtUtil.getUsername(jwt), null,
//                        Collections.singletonList(new SimpleGrantedAuthority(jwtUtil.getRole(jwt))));
//            } else if ("device".equals(jwtUtil.getClaimFromToken(jwt, "type"))) {
//                Jwt parsedJwt = jwtUtil.parseJwt(jwt);
//                return new JwtAuthenticationToken(parsedJwt, Collections.emptyList());
//            }
//        }
        return null;
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}
