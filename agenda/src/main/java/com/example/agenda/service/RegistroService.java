package com.example.agenda.service;

import com.example.agenda.DTO.RegistroDto;
import com.example.agenda.models.Acesso;
import com.example.agenda.models.Registro;
import com.example.agenda.models.Usuario;
import com.example.agenda.repository.ResgistroRepository;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
public class RegistroService {

    private final ResgistroRepository resgistroRepository;

    public RegistroService(ResgistroRepository resgistroRepository) {
        this.resgistroRepository = resgistroRepository;
    }

    public Registro salvarRegistro(RegistroDto registroDto) {

        Usuario usuarioLogado = getUsuarioLogado();

        Registro registro = new Registro();

        registro.setTitulo(registroDto.titulo());
        registro.setDescription(registroDto.description());
        registro.setDataAgenda(registroDto.dataAgenda());
        registro.setHoraAgenda(registroDto.horaAgenda());

        registro.setUsuario(usuarioLogado);

        return resgistroRepository.save(registro);
    }

    public List<Registro> listarMeusRegistros() {
        Usuario usuarioLogado = getUsuarioLogado();
        return resgistroRepository.findByUsuario(usuarioLogado);
    }

    private Usuario getUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        com.example.agenda.models.Acesso acesso = (com.example.agenda.models.Acesso) authentication.getPrincipal();

        return acesso.getUsuario();
    }
}

