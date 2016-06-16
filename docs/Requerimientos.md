# Ingeniería de Requerimientos #

----------


### 1. Introducción  ###
En este documento se describen los requerimientos tanto del sistema como del usuario. Además, se detallan los requerimientos funcionales y no funcionales a los fines de establecer el plan de trabajo a seguir por los desarrolladores.

*Se destaca la abreviatura de cada requerimiento, el cual será utilizado en diversas secciones (por ejemplo en la Matriz de Trazabilidad)*


### 2. Requerimientos del usuario ###

- Generar dos ventanas: una que muestre un piano y otra que se modifique según las notas presionadas en la ventana del piano. (R1)
- Crear una ventana que permita intercambiar de modelo en tiempo de ejecución de mi aplicación. (R2)
- Ejecución de la aplicacion para ver los tres modelos andando a la vez. (R3)
- Generar una forma de mostrar como funciona el sistema para evaluar su correcto funcionamiento. (R4)


### 3. Requerimientos del Sistema ###

- Implementación de un patrón observer para actualizar la ventana que muestra las modificaciones en las teclas.
- Realizar un test unitario a cada terea realizada. Test de Actualización de datos. Test de funcionamiento de botones.
- Implementar el patrón de arquitectura Model View Controller (MVC) para cambiar de forma dinámica los modelos y las vistas. Generar interfaces que permitan la comunicación entre dichas partes del sistema.

### 4. Requerimientos Funcionales ###

- El usuario debe poder presionar diversas teclas del piano y mostrar su ejecución en otra ventana.
- El sistema debe dar la opción en la Interfaz Grafica para elegir el modelo a implementar.
- El sistema debe mostrar vistas diferentes dependiendo del modelo y según un caso de uso determinado.

### 5. Requerimientos no Funcionales ###


 