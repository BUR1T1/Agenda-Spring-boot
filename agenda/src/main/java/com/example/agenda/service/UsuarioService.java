package com.example.agenda.service;

import com.example.agenda.DTO.AcessoDto;
import com.example.agenda.DTO.UsuarioDto;
import com.example.agenda.models.Acesso;
import com.example.agenda.models.Usuario;
import com.example.agenda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario criarUsuario(UsuarioDto usuarioDto, AcessoDto acessoDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.nome());
        usuario.setCpf(usuarioDto.cpf());
        usuario.setEmail(usuarioDto.email());
        usuario.setNumeroTelefone(usuarioDto.numeroTelefone());

        Acesso acesso = new Acesso();
        acesso.setUserName(acessoDto.userName());
        acesso.setSenha(passwordEncoder.encode(acessoDto.senha()));
        acesso.setRoles(com.example.agenda.UTIL.AcessoRole.ACESSO);

        acesso.setUsuario(usuario);
        usuario.setAcesso(acesso);

        return usuarioRepository.save(usuario);
    }


}
