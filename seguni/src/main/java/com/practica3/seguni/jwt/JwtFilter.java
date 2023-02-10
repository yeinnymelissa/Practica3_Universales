package com.practica3.seguni.jwt;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JwtFilter extends GenericFilterBean{
	Logger loggerPrint = Logger.getLogger(JwtFilter.class.getName());
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String authHeader = request.getHeader("authorization");
        try {
	        final String token = authHeader.substring(7);
	        Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
	        request.setAttribute("claims", claims);
	        filterChain.doFilter(request, response);
        }catch(ExpiredJwtException e) {
        	loggerPrint.log(Level.SEVERE, "El token ha expirado.");
        	
        }catch(MalformedJwtException e) {
        	loggerPrint.log(Level.SEVERE, "El token no tiene la forma esperada.");
        	
        }catch (UnsupportedJwtException ex){
        	loggerPrint.log(Level.SEVERE, "El token no es soportado.");
        	
        }catch(Exception e) {
        	loggerPrint.log(Level.SEVERE, "Ocurrio un error");
        }
		
	}
}
