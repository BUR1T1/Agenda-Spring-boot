package com.example.agenda.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcessoDto(
            @NotBlank(message = "Username é obrigatório")
            String userName,
            @NotBlank(message = "Senha é obrigatória")
            @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
            String senha
    ) {}


