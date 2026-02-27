package com.example.agenda.UTIL;

import java.security.PrivilegedAction;

public enum StatusModels {
        ATIVO(10),
    CANCELADO(20),
    FINALIZADO(30);

        private final int codigo;

        StatusModels(int codigo){
            this.codigo = codigo;
        }

        public int getCodigo(){
            return codigo;
        }
}
