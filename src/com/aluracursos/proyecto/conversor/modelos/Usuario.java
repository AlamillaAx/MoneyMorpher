package com.aluracursos.proyecto.conversor.modelos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private int numeroConversiones;
    private List<Conversion> listaConversiones;

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.numeroConversiones = 0;
        this.listaConversiones = new ArrayList<>();
    }

    public boolean realizarConversion(Conversion conversion){
        this.numeroConversiones += 1;
        this.listaConversiones.add(conversion);
        return true;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public List<Conversion> getListaConversiones() {
        return listaConversiones;
    }

    public int getNumeroConversiones() {
        return numeroConversiones;
    }
}
