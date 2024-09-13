package com.br.marketplacegateway.service;


import com.br.marketplacegateway.dto.AutenticacaoDto;
import com.br.marketplacegateway.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String autenticacao(@Valid AutenticacaoDto autenticacaoDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(autenticacaoDto.email(), autenticacaoDto.senha())
        );
        return jwtUtil.generateToken(autenticacaoDto.email());
    }
}
