# Robot Maze con Finch Robot (Java, Eclipse)

Este proyecto fue realizado como parte de una asignatura de Java en el Grado Superior de Desarrollo de Aplicaciones Multiplataforma.  
El objetivo era programar un **Finch Robot** para que pudiera recorrer un laberinto físico, controlando sus movimientos desde un script en Java.

---

## Descripción

- **Robot:** Finch Robot
- **Lenguaje:** Java
- **IDE original:** Eclipse (compatible con PyCharm u otros IDEs de Java)
- **Control:** El robot se conectaba por USB y recibía instrucciones desde el código Java.
- **Tipo de recorrido:** El laberinto era físico y el recorrido se programaba manualmente, es decir, el código contenía instrucciones secuenciales para avanzar, girar y detenerse según el diseño del laberinto.
- **Trabajo en equipo:** El proyecto fue desarrollado en equipo como parte de una práctica de clase.

---

## ¿Cómo funciona?

El script de Java contiene instrucciones como:
- Avanzar durante X segundos
- Girar a la izquierda o derecha
- Detenerse en ciertos puntos

Estas instrucciones se ajustaban según la forma y longitud de los tramos del laberinto físico.

---

## Gestión y ejecución de acciones del robot

El proyecto incluye una clase llamada **FinchActionList** que gestiona una lista de acciones para el Finch Robot. Sus funciones principales son:

- **importOrders:** Importa una serie de órdenes desde un archivo de texto, donde cada línea puede ser un movimiento (`MOVE`) o una acción de nariz (`NOSE`). Cada orden se desglosa y se añade a la lista de acciones.
- **exportOrders:** Exporta la lista actual de acciones a un archivo de texto, permitiendo guardar y reutilizar secuencias de movimientos.
- **displayOrders:** Muestra en consola todas las órdenes actualmente cargadas en la lista.
- **removeOrders:** Limpia todas las órdenes de la lista.
- **execute:** Ejecuta todas las acciones cargadas, esperando los segundos indicados entre cada acción.
- **executeOrder:** Permite ejecutar una orden individual directamente desde una cadena de texto.

El flujo típico sería:
1. Importar las órdenes desde un archivo (`importOrders`).
2. Visualizarlas o modificarlas si es necesario.
3. Ejecutar la secuencia sobre el Finch Robot conectado por USB.

Esto permite automatizar recorridos o pruebas en el laberinto físico de forma sencilla, facilitando la programación y la depuración.

---

## Estructura del proyecto

- `src/` — Código fuente en Java
- `lib/` — Librerías necesarias para el Finch Robot
- `bin/` — Archivos compilados (no incluidos en el control de versiones)
- `javadoc/` — Documentación generada automáticamente
- `.project`, `.classpath`, `.settings/` — Archivos de configuración de Eclipse

---

## Cómo ejecutar el proyecto

1. Conecta el Finch Robot al ordenador por USB.
2. Abre el proyecto en PyCharm, Eclipse u otro IDE compatible con Java.
3. Asegúrate de tener las librerías necesarias del Finch Robot (pueden estar en la carpeta `lib`).
4. Ejecuta la clase principal desde el IDE o desde la terminal.

> **Nota:** Este proyecto fue desarrollado hace tiempo y puede que requiera ajustar rutas de librerías o configuración según la versión de Java y el sistema operativo.

---

## Créditos

Proyecto realizado en equipo para la asignatura de programación en Java en el Grado Superior.

---

Si tienes dudas o quieres más detalles de cómo se hizo, puedes abrir un issue o contactarme.