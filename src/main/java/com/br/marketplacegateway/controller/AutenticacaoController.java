package com.br.marketplacegateway.controller;

import com.br.marketplacegateway.dto.AutenticacaoDto;
import com.br.marketplacegateway.service.AutenticacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @Operation(summary = "Autenticar um usuário",
            description = "Autentica um usuário com base no DTO de autenticação fornecido e retorna um token de autenticação.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autenticação bem-sucedida, retorna o token de autenticação"),
            @ApiResponse(responseCode = "400", description = "Dados de autenticação inválidos")
    })
    @PostMapping
    public ResponseEntity<String> autenticacao(@Valid @RequestBody AutenticacaoDto autenticacaoDto) {
        String token = service.autenticacao(autenticacaoDto);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
