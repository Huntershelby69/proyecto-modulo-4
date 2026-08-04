package com.smarttask.model;

public class TareaUrgente extends Tarea {

    private int diasLimite;

    public TareaUrgente(int id, String nombre, int diasLimite) {
        super(id, nombre);
        this.diasLimite = diasLimite;
    }

    public int getDiasLimite() {
        return diasLimite;
    }

    public void setDiasLimite(int diasLimite) {
        this.diasLimite = diasLimite;
    }

    public boolean estaVencida() {
        return diasLimite <= 0;
    }

    @Override
    public String toString() {
        return "[URGENTE] ID: " + getId() + " | Nombre: " + getNombre()
                + " | Completado: " + isCompletado()
                + " | Dias limite: " + diasLimite;
    }
}
