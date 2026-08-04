package com.smarttask;

import com.smarttask.model.Tarea;
import com.smarttask.model.TareaNormal;
import com.smarttask.model.TareaUrgente;
import com.smarttask.service.GestorTareas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scanner.nextLine().trim());

                switch (opcion) {
                    case 1:
                        agregarTarea(scanner, gestor);
                        break;
                    case 2:
                        gestor.listarTareas();
                        break;
                    case 3:
                        marcarComoCompletada(scanner, gestor);
                        break;
                    case 4:
                        eliminarTarea(scanner, gestor);
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Entrada inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
    }

    private static void agregarTarea(Scanner scanner, GestorTareas gestor) throws Exception {
        System.out.println("Nombre de la tarea:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Tipo de tarea:");
        System.out.println("1. Normal");
        System.out.println("2. Urgente");
        int tipo = Integer.parseInt(scanner.nextLine().trim());

        Tarea tarea;
        if (tipo == 1) {
            tarea = new TareaNormal(0, nombre);
        } else if (tipo == 2) {
            System.out.println("Días límite:");
            int diasLimite = Integer.parseInt(scanner.nextLine().trim());
            tarea = new TareaUrgente(0, nombre, diasLimite);
        } else {
            throw new IllegalArgumentException("Tipo de tarea inválido.");
        }

        gestor.agregarTarea(tarea);
    }

    private static void marcarComoCompletada(Scanner scanner, GestorTareas gestor) throws Exception {
        System.out.println("ID de la tarea:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        gestor.marcarComoCompletada(id);
    }

    private static void eliminarTarea(Scanner scanner, GestorTareas gestor) throws Exception {
        System.out.println("ID de la tarea:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        gestor.eliminarTarea(id);
    }
}
