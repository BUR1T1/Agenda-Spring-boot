package com.example.agenda.controlers;


import com.example.agenda.DTO.RegistroDto;
import com.example.agenda.models.Registro;
import com.example.agenda.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final RegistroService service;

    public RegistroController(RegistroService service) {
        this.service = service;
    }

    @PostMapping("/criar-registro")
    public ResponseEntity<String> criar(@RequestBody RegistroDto dto) {
        service.salvarRegistro(dto);
        return ResponseEntity.ok("Registro criado com sucesso!");
    }

    @GetMapping("/listar-registro")
    public List<Registro> listar() {
        return service.listarMeusRegistros();
    }

}
