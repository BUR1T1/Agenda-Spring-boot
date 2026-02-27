package com.example.agenda.controlers;

import com.example.agenda.DTO.AcessoDto;
import com.example.agenda.DTO.CadastroDto;
import com.example.agenda.DTO.UsuarioDto;
import com.example.agenda.models.Usuario;
import com.example.agenda.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/teste")
    public String cadastrar() {
        return "ok";
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> criaUsuario(@Valid @RequestBody CadastroDto cadastroDto){
        Usuario usuario = usuarioService.criarUsuario(cadastroDto.usuarioDto(),cadastroDto.acessoDto());
        return ResponseEntity.ok(usuario);
    }
}


