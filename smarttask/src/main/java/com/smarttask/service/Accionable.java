package com.smarttask.service;

import com.smarttask.model.Tarea;

public interface Accionable {

    void agregarTarea(Tarea tarea);

    void listarTareas();

    void eliminarTarea(int id);

    void marcarComoCompletada(int id);
}
