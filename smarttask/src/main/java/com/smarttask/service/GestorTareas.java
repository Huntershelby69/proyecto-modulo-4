package com.smarttask.service;

import com.smarttask.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Accionable {

    private List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.siguienteId = 1;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        tarea.setId(siguienteId);
        siguienteId++;
        tareas.add(tarea);
    }

    @Override
    public void listarTareas() {
        System.out.println("=== TAREAS ACTIVAS ===");
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletado()) {
                System.out.println(tarea.toString());
            }
        }

        System.out.println("=== TAREAS COMPLETADAS ===");
        for (Tarea tarea : tareas) {
            if (tarea.isCompletado()) {
                System.out.println(tarea.toString());
            }
        }
    }

    @Override
    public void eliminarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    @Override
    public void marcarComoCompletada(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null) {
            tarea.setCompletado(true);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    private Tarea buscarPorId(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                return tarea;
            }
        }
        return null;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }
}
