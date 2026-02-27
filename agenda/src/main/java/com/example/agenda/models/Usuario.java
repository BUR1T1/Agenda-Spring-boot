package com.example.agenda.models;

import com.example.agenda.UTIL.Notification;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class Usuario extends BaseEntity {
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF_USUARIO", nullable = false)
    private String cpf;

    @Column(name = "USUARIO_EMAIL", nullable = false)
    private String email;

    @Column(name = "NR_CONTATO")
    private String numeroTelefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "RECEBER_NOTF", nullable = false)
    private Notification receberNotificacao = Notification.ACEITA;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Acesso Acesso;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registro> registros = new ArrayList<>();

    public com.example.agenda.models.Acesso getAcesso() {
        return Acesso;
    }

    public void setAcesso(com.example.agenda.models.Acesso acesso) {
        Acesso = acesso;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Notification getReceberNotificacao() {
        return receberNotificacao;
    }

    public void setReceberNotificacao(Notification receberNotificacao) {
        this.receberNotificacao = receberNotificacao;
    }
}
