package com.example.agenda.controlers;

import com.example.agenda.DTO.AcessoDto;
import com.example.agenda.models.Acesso;
import com.example.agenda.service.TokenService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @RestController
    @RequestMapping("/teste")
    public class TesteController {

        @GetMapping
        public String teste() {
            return "ACESSO AUTORIZADO";
        }
    }

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AcessoDto dto) {

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.userName(), dto.senha())
        );

        var acesso = (Acesso) auth.getPrincipal();
        String token = tokenService.gerarToken(acesso);

        return ResponseEntity.ok(token);
    }
}
