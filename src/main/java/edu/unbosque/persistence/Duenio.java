package edu.unbosque.persistence;

import java.io.Serializable;

public class Duenio implements Serializable {
    private static final long serialVersionUID = 1L;

    String fecha = "";
    String descripcion ="";
    String foto = "";
    Duenio(){

    }

    public Duenio(String fecha, String descripcion, String foto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
