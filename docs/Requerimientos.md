# Ingeniería de Requerimientos #

----------
### 1. Prefacio  ###
Los lectores esperados en este documento son:

- Cliente
- Administrador del equipo de desarrollo

***Control de Versiones***<br>
	- **Version 0.1** -  Autor:Agustin Trombotto - Fecha:15/06/2016 - Descripcion: Primera version del documento<br>
	- **Version 0.2** -  Autor:Matthew Aguerreberry - Fecha:16/06/2016 - Descripcion: Modificaciones Ortograficas y de Organizacion <br>
	- **Version 0.3** - Autor: Agustin Trombotto - Fecha: 19/06/2016- Descripcion: Se añade Diagramas y Se completa el documento
### 2. Indice  ###

1. Prefacio
2. Indice
3. Introduccioin
4. Glosario
5. Requerimientos del usuario
6. Arquitectura del sistema
7. Requerimientos funcionales
8. Requerimientos no funcionales
9. Diagramas de actividad
10. Matriz de trazabilidad
11. Diagramas de secuencia
12. Evolucion del sistema

### 3. Introducción  ###
En este documento se describen los requerimientos tanto del sistema como del usuario. Además, se detallan los requerimientos funcionales y no funcionales a los fines de establecer el plan de trabajo a seguir por los desarrolladores.


### 4. Glosario  ###

**RX:** Hace referencia a un requerimiento de usuario citado. Éste será usado en diversas secciones. Por ej: R1 (Requerimiento 1)

**MVC:** Se refiere al patron de arquetictura usado: Modelo - Vista - Controlador

### 5. Requerimientos del usuario ###


- Generar dos ventanas: una que muestre un piano y otra que se modifique según las notas presionadas en la ventana del piano. (R1)
- Crear una ventana que permita intercambiar de modelo en tiempo de ejecución de mi aplicación. (R2)
- Ejecución de la aplicacion para ver los tres modelos andando a la vez. (R3)

### 6. Arquitectura del Sistema  ###

![Diagrama Arquitectura a Implementar](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Imagenes%20Adicionales/MVC.JPG?raw=true)
Para satisfacer los requerimientos citados por el usuario se implementará el patron de arquitectura MVC el cual nos permitirá separar los datos a mostrar de la logica del modelo implementado. Tendremos una interfaz comun que se actualizará segun los eventos y las comunicaciones que se den en el controlador y el modelo


### 7. Requerimientos del Sistema ###

- Implementación de un patrón observer para actualizar la ventana que muestra las modificaciones en las teclas. (R4)
- Realizar un test unitario a cada terea realizada. Test de Actualización de datos. Test de funcionamiento de botones. (R5)
- Implementar el patrón de arquitectura Model View Controller (MVC) para cambiar de forma dinámica los modelos y las vistas. Generar interfaces que permitan la comunicación entre dichas partes del sistema. (R6)

### 8. Requerimientos Funcionales ###

- El usuario debe poder presionar diversas teclas del piano (en la vista del modelo 'MusicalNotes') y generar una respuesta en otra ventana.
- El sistema debe dar la opción en la Interfaz Grafica para elegir el modelo a implementar.
- El sistema debe mostrar vistas diferentes dependiendo del modelo y de un caso de uso determinado.

### 9. Requerimientos No Funcionales ###

- Archivo comprimido con los ejecutables correspondientes a los requerimientos solicitados.
- Peso del archivo menor a 100kb.
- Respuesta del sistema no mayor a 5 segundos a la hora de recibir una entrada.
- El teclado del piano debe ser lo más semejante a la realidad posible.

### 10. Diagramas de Actividad ###
A continuacion se detalla un diagrama de activadad correspondiente a cada caso de uso:

*6.1 Requerimiento funcional 1*
![Diagrama de Actividad R1](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%UML/Diagrama%20de%20Actividades-MusicalNotes.jpg?raw=true)

*6.2 Requerimiento funcional 2*

![Diagrama de Actividad R2](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%UML/Diagrama%20de%20Actividades-DynamicView.jpg?raw=true)

*6.3 Requerimiento funcional 3*
![Diagrama de Actividad R3](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%UML/Diagrama%20de%20Actividades-AllTestDrive.jpg?raw=true)

### 11. Matriz de Trazabilidad ###

![Matriz de Trazabilidad](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/Requerimientos/docs/DiagramasUML/Matriz%20de%20Trazabilidad.JPG?raw=true)

### 12. Diagramas de Secuencias ###
Para cada requerimiento existe su correspondiente caso de uso para su satisfaccion. Se incorpora un diagrama de secuencia para cada uno a los fines de entender mejor su funcionamiento:

8.1 Caso de Uso: *AllModelsTestDrive*

![MyMusicalNotesTestDrive](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%20UML/AllModelsTestDrive.jpg?raw=true)

8.2 Caso de Uso: *DynamicViewChanceTestDrive*

![MyMusicalNotesTestDrive](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%20UML/DynamicViewChangeTestDrive.jpg?raw=true)

8.3 Caso de Uso: *MyMusicalNotesTestDrive*

![MyMusicalNotesTestDrive](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/Diagramas%20UML/MyMusicalNotesTestDrive.jpg?raw=true)

### 13. Evolucion del Sistema ###


- Este software puede contar con actualizaciones referidas a la optimizacion del funcionamiento del piano y la implementacion de nuevas funcionalidades en la Interfaz del usuario
- Ademas se podrán realizar cambios en el software segun lo establecido en el [Plan de Configuraciones](https://github.com/matthew44/IngSoft_TrabajoFinal_BurningTeam/blob/master/docs/CM_Plan.md) en la seccion 3: Administracion de cambios.




