package com.example.agenda.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "DT_INIT")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate datadecriacao;

    @Column(name = "DT_LAST_ATL")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate(){
        this.datadecriacao = LocalDate.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.dataAtualizacao = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDatadecriacao() {
        return datadecriacao;
    }

    public void setDatadecriacao(LocalDate datadecriacao) {
        this.datadecriacao = datadecriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
