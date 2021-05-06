package edu.unbosque.persistence;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
public class Duenio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Expose
    String nombre = "";
    @Expose
    String fecha = "";
    @Expose
    String descripcion ="";
    @Expose
    String foto = "";
    public Duenio(){

    }

    public Duenio(String nombre, String fecha, String descripcion, String foto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
