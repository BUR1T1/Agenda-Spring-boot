package com.example.agenda.UTIL;

public enum Notification {
    ACEITA(10),
    RECUSAR(20);

    private final int codigo;

    Notification(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
