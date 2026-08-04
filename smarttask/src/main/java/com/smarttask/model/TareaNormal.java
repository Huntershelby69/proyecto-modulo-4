package com.smarttask.model;

public class TareaNormal extends Tarea {

    public TareaNormal(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public String toString() {
        return "[NORMAL] ID: " + getId() + " | Nombre: " + getNombre()
                + " | Completado: " + isCompletado();
    }
}
