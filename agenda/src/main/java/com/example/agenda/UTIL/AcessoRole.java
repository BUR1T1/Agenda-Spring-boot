package com.example.agenda.UTIL;

public enum AcessoRole {

    ADMIN("admin"),
    ACESSO("acesso");

    private String role;
     AcessoRole (String role){
        this.role = role;
    }

    public String getRole(){
         return role;
    }
}
