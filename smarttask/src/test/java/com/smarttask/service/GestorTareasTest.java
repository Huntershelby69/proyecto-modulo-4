package com.smarttask.service;

import com.smarttask.model.Tarea;
import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GestorTareasTest {

    private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    void testAgregarTarea() {
        Tarea tarea1 = new TareaNormal(0, "Comprar pan");
        Tarea tarea2 = new TareaUrgente(0, "Pagar impuestos", 3);

        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);

        assertEquals(1, tarea1.getId());
        assertEquals(2, tarea2.getId());
        assertEquals(2, gestor.getTareas().size());
    }

    @Test
    void testListarTareas() {
        Tarea tarea1 = new TareaNormal(0, "Estudiar Java");
        Tarea tarea2 = new TareaUrgente(0, "Entregar informe", 1);
        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);

        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        gestor.listarTareas();

        System.setOut(salidaOriginal);
        String salida = salidaCapturada.toString();

        assertTrue(salida.contains("TAREAS ACTIVAS"));
        assertTrue(salida.contains("TAREAS COMPLETADAS"));
        assertTrue(salida.contains("Estudiar Java"));
        assertTrue(salida.contains("Entregar informe"));
    }

    @Test
    void testMarcarComoCompletada() {
        Tarea tarea1 = new TareaNormal(0, "Lavar el auto");
        gestor.agregarTarea(tarea1);

        gestor.marcarComoCompletada(1);

        assertTrue(tarea1.isCompletado());

        gestor.marcarComoCompletada(999);
        assertFalse(gestor.getTareas().isEmpty());
    }
}
