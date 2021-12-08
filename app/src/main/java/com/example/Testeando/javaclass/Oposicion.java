package com.example.Testeando.javaclass;

import java.util.Objects;

public class Oposicion {

    private int foto;
    private String titulo;

    public Oposicion(){
    }

    public Oposicion(int foto, String titulo) {
        this.foto = foto;
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oposicion oposicion = (Oposicion) o;
        return foto == oposicion.foto && Objects.equals(titulo, oposicion.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foto, titulo);
    }
}
