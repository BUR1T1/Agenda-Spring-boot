package com.example.agenda.models;

import com.example.agenda.UTIL.StatusModels;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "REGISTRO")
public class Registro extends BaseEntity{


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "TITULO" , nullable = false)
    private String titulo;

    @Column(name = "DESCRIPTION" , nullable = false)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DT_AGENDA", nullable = false)
    private LocalDate dataAgenda;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "HR_AGENDA", nullable = false)
    private LocalTime horaAgenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "SIT_AGENDAMENTO", nullable = false)
    private StatusModels status = StatusModels.ATIVO;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(LocalDate dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalTime getHoraAgenda() {
        return horaAgenda;
    }

    public void setHoraAgenda(LocalTime horaAgenda) {
        this.horaAgenda = horaAgenda;
    }

    public StatusModels getStatus() {
        return status;
    }

    public void setStatus(StatusModels status) {
        this.status = status;
    }
}
