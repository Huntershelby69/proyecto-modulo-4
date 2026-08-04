# SmartTask

## Descripción
SmartTask es una aplicación de consola en Java para administrar tareas personales.
Permite agregar tareas normales o urgentes, listarlas separadas en activas y
completadas, marcarlas como completadas y eliminarlas. El proyecto sigue el
paradigma de programación orientada a objetos, utilizando herencia
(`Tarea` → `TareaNormal` / `TareaUrgente`) y una interfaz (`Accionable`)
implementada por `GestorTareas`, que administra la lista de tareas y la
asignación autoincremental de IDs.

## Cómo compilar
El proyecto utiliza Maven. Desde la raíz del repositorio:

```bash
mvn clean compile
```

Para compilar y además ejecutar las pruebas unitarias:

```bash
mvn clean test
```

## Cómo ejecutar
Para ejecutar la aplicación de consola con Maven:

```bash
mvn compile exec:java -Dexec.mainClass="com.smarttask.Main"
```

Alternativamente, generando el .jar y ejecutándolo directamente:

```bash
mvn clean package
java -jar target/smarttask.jar
```

Una vez iniciado, el programa muestra un menú interactivo:

```
1. Agregar tarea
2. Listar tareas
3. Marcar tarea como completada
4. Eliminar tarea
5. Salir
```

## Estructura de clases

```
com.smarttask
├── Main.java                  # Punto de entrada, maneja el menú por consola
├── model
│   ├── Tarea.java              # Clase base: id, nombre, completado
│   ├── TareaNormal.java        # Hereda de Tarea, sin atributos adicionales
│   └── TareaUrgente.java       # Hereda de Tarea, agrega diasLimite y estaVencida()
└── service
    ├── Accionable.java         # Interfaz con las operaciones del gestor
    └── GestorTareas.java       # Implementa Accionable, administra List<Tarea> e IDs
```

- **Tarea**: clase base con `id`, `nombre` y `completado` (inicia en `false`),
  con sus getters y setters.
- **TareaNormal**: extiende `Tarea`, sobrescribe `toString()` mostrando `[NORMAL]`.
- **TareaUrgente**: extiende `Tarea`, agrega `diasLimite` y el método
  `estaVencida()` (`true` cuando `diasLimite <= 0`), sobrescribe `toString()`
  mostrando `[URGENTE]`.
- **Accionable**: interfaz de servicio con `agregarTarea`, `listarTareas`,
  `eliminarTarea` y `marcarComoCompletada`.
- **GestorTareas**: implementa `Accionable`, almacena las tareas en una
  `List<Tarea>` y asigna IDs autoincrementales de forma definitiva al agregar
  una tarea (los IDs eliminados no se reutilizan).
- **Main**: contiene el menú interactivo mediante `Scanner`, con lectura de
  datos dentro de bloques `try-catch` que muestran `Entrada inválida.
  Intente nuevamente.` ante errores, sin cerrar el programa.

## Enlace al repositorio
https://github.com/tu-usuario/smarttask
