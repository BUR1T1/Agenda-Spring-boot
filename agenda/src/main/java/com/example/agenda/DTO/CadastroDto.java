package com.example.agenda.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CadastroDto(

        @Valid UsuarioDto usuarioDto,
        @Valid AcessoDto acessoDto
){
}
