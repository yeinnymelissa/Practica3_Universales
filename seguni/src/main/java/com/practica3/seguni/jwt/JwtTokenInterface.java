package com.practica3.seguni.jwt;

import java.util.Map;

import com.practica3.seguni.entity.Usuarios;


public interface JwtTokenInterface {
	Map<String, String> generateToken(Usuarios usuario);
}
