package com.example.agenda.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public record RegistroDto (
        String titulo,
        String description,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataAgenda,

        @JsonFormat(pattern = "HH:mm")
        LocalTime horaAgenda


){}
