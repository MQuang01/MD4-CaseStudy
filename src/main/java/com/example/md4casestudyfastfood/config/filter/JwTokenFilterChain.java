package com.example.md4casestudyfastfood.config.filter;

import com.example.md4casestudyfastfood.service.auth.AuthService;
import com.example.md4casestudyfastfood.util.JwTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwTokenFilterChain extends OncePerRequestFilter {

    private JwTokenProvider jwtTokenProvider;

    AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String jwt = extractToken(request);
        if (jwt == null || !jwtTokenProvider.validateToken(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtTokenProvider.getUsernameFromToken(jwt);
        var userInfo = authService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userInfo, null, userInfo.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        //Bearer
        String jwtWithBarer = request.getHeader("Authorization");
        if (jwtWithBarer == null) return null;
        return jwtWithBarer.substring(7);
    }

}

