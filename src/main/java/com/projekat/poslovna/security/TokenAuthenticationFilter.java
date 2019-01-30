package com.projekat.poslovna.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Filter koji ce presretati svaki zahtev klijenta ka serveru
//Sem nad putanjama navedenim u WebSecurityConfig.configure(WebSecurity web)
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenHelper tokenHelper;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService) {
        this.tokenHelper = tokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String email;
        String authToken = tokenHelper.getToken(request);

        if (authToken != null) {
            //uzmi email iz tokena
        	email = tokenHelper.getUsernameFromToken(authToken);
            if (email != null) {
                // uzmi user-a na osnovu emaila-a
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                System.out.println("Employee " + email + " is accessing with token");
                //proveri da li je prosledjeni token validan
                if (tokenHelper.validateToken(authToken, userDetails)) {
                    // kreiraj autentifikaciju
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(authToken, userDetails);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("Employee " + email + " accessed with valid token");
                }
                else {
                	System.out.println("Employee " + email + " tried to access with invalid token");
                }
            }
            else{
            	System.out.println("AuthToken has no email");
            }
        }
        else {
        	System.out.println("Request without AuthToken");
        }
        chain.doFilter(request, response);
    }
}