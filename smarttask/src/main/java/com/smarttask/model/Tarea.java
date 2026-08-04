package com.smarttask.model;

public class Tarea {

    private int id;
    private String nombre;
    private boolean completado;

    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.completado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
