# Plan de administracion de configuraciones #
## Implementacion del patron de arquitectura MVC ##

- Control de Versiones
	- **Version 0.1** -  Autor:Natasha Tomattis - Fecha:04/06/2016 - Descripcion: Primera verson del documento



### 1. Introducción  ###
Este documento describe el plan de administración de la configuración para el proyectofinal de la matria Ingeniería de Software. El proceso de Administración de la Configuración  asegura el control  de
las distintas versiones de los documentos entregables, los responsables de cada uno, el tiempo y los recursos generados durante el ciclo de vida del proyecto.

#### 1.1 Propósito  ####
El propósito de este documento es establecer los elementos necesarios para administrar los documentos y las fuentes que son elaborados por el equipo del proyecto. 

- Coordinar el uso y actualización de los módulos que se encuentren en línea base del 
proyecto.
- Asegurar que todos estén trabajando en las mismas versiones de cambios.
- Controlar que ninguno de estos cambios se pierda.
- Proveer criterios y dirección necesarios para el desempeño del proceso de 
administración de la configuración.

#### 1.2 Glosario ####
 
Los siguentes téminos serán frecuentemente mencionados a lo largo del documento por lo tanto se considera necesario dejar en evidencia sus definiciones:


**Repositorio:** Lugar donde se almacenan los datos actualizados e históricos, a menudo en un
servidor. Puede ser un sistema de archivos en un disco duro, un banco de datos, etc.


**Rama-Módulo (“Branch”):** Conjunto de directorios y/o archivos dentro del repositorio que
pertenecen a un proyecto común.


**Revisión ("version"):** Una revisión es una versión determinada de un      archivo.


**Cambio**: Representa una modificación específica a un documento bajo control de versiones. 

**Comité de Control de Cambios (“Change Control Board”):** Grupo de personas responsables
de evaluar y aprobar determinados cambios propuestos sobre un ítem de configuración.
Además verifican la implementación de los cambios aprobados.


**Línea Base:** Conjunto de productos de trabajo que han sido revisados y aprobados, y que
serán utilizados luego como base para la realización de cambios. Dichos cambios solo
podrán realizarse a través de un proceso formal de control de cambios.

#### 1.3 Herramientas de la administración de configuraciones  ####
Las herramientas a continuacion serán utilizadas para facilitar el desarrollo del proyecto y asegurar una correcta integracion del trabajo de los desarrollladores.

- **Herramienta de control de versiones (GitHub)**: Se creará un repositorio en el servidor con el
nombre del proyecto, al cual podrán acceder
todos los miembros del equipo de desarrollo como
colaboradores. (*link*)

- **Herramienta de integración contínua (TravisCI/Gradle)**:A medida que los desarrolladores modifiquen 
algún ítem de configuración, esta herramienta
correrá automáticamente los test corroborando
que no existan errores. En caso de errores la herramienta se encargará de notificar a todos los desarrolladores.

- **Herramienta de control de defectos (Issues/GitHub)**

### 2. Administración de la configuración ###
#### 2.1 Roles y responsabilidades ####

Las actividades de la gestión de las configuraciones dentro del proyecto serán coordinadas por 3 integrantes, los cuales se encuentran en el mismo nivel jerárquico. Sin embargo cada uno posee funciones específicas detalladas a continuación: 

- **Administador de la configuración:** Supervisar que el equipo de desarrollo utilice el repositorio durante el ciclo
de vida del proyecto. Controlará también que se respeten los lineamientos establecidos a la hora de evluar el proceso de cambio.(*Tomattis,Natasha*)

- **Administrador de Versiones:** Controlar que el producto cumpla con todos los requerimentos establecidos y su funcionamiento sea correcto.(*Aguerreberry,Matthew *)

- **Administardor del equipo de desarrollo:** Interactuará con el repositorio operando sobre los ítems de configuración generados durante el proyecto. Principal consumidor de la información puesta bajo elcontrol de configuraciones.(*Trombotto, Agustín*) 




### 3. Administarcion de cambios ###
Se entiende como cambio todo aquello que afecte la línea base del sistema.
Los cambios pueden proceder tanto a mejora como a la corrección de errores, eprocedimiento para el manejo de cambios se realizara de la siguiente manera: cada vez quse realiza una solicitud de cambio es deber llenar un formulario el cual debe ser entregada los responsables para que procesen la solicitud, esta llegara a un estado final en el que será aceptada e implementada o postergada.

#### 3.1 Solicitud de cambio ####

Los pasos necesarios para realizar una petición de cambio son:

1. Definir la información necesaria para aprobar el cambio.
2. Identificar las áreas afectadas por el cambio requerido.
3. Describir el proceso de modificación en la documentación usada al procesar cambios.
4. Describir el procedimiento para los cambios en el código y la implementación del 
programa 

#### 3.2 Comité de Control de Cambios (CCC)  ####
El comité de control de cambios estará integrado por un grupo de especialistas en Administración de proyectos, métricas, riesgos y requerimientos, cuya función será la de
analizar el impacto y los costos de los cambios, y un aprobador, quien será el encargado de aprobar o no un cambio en base al análisis del grupo de analistas. 


*Integrantes del CCC*


- **Administrador del proyecto:** Realizará la planeación de las actividades del diseño del proyecto, reportará oportunamente los cambios que haya en cuanto a duración, planeación de costos y recursos.(*Tomattis, Natasha*)

- **Especificacion de requerimientos:** Planeará, identificará, analizará y proporcionará las bases para poder hacer cambios en el  desarrollo e implementación de los requerimientos.(*Trombotto, Agustín*)

- **Adeministrador de riesgos:** Identificará los posibles riesgos que se presentarán al aprobar los cambios solicitados.
Y presentará los posibles costos que llevará a cabo el cambio.(*Aguerreberry, Matthew*)

- **Administrador de desarrolladores:**Se encargará de todo lo relacionado al desarrollo de la aplicación aportando
estimaciones más reales y los posibles productos que se afectaría si el cambio es aprobado.(*Trombotto, Agustín*)

- **Aprobador:** Se encargará de aprobar o no un cambio con
base al análisis del resto del equipo. (*Aguerreberry, Matthew*)

*Reuniones:* Se realizarán reuniones semanales para evaluar el estado actual del proyecto, cada unode los miembros presentará sus peticiones de cambio.  Se contactará a los miembros
del comité vía mail y, en caso de emergencias se llamará por teléfono. Será de gran importancia la presencia de los tres miembros de la CCC en todas las reuniones.

#### 3.3 Proceso de control de cambios ####
### 4. Normas de nombramiento de archivos ###
### 5 Equipos en ProyectoFinal ###
**Equipos Scrum:** encargados de desarrollar nuevas funcionalidades de forma ágil y rápida.
Actualizan el código frecuentemente, evitando problemas a la hora de unir las partes
desarrolladas por cada uno. Tambien pueden estar encargados de corregir bugs en el
programa.

**Administración de etiquetas:** Serán los encargados de establecer y verificar 
el cumplimiento
de las normas de etiquetado. Deberán verificar que estos releases cumplan con los
estándares de calidad establecidos en el proyecto


**Equipos de rápida reacción:** Se encargan de solucionar los errores urgentes, los cuales los
clientes no pueden esperar a la próxima versión para que sean corregidos. Este equipo
también se dedica a tareas de desarrollo y corrección de errores en casos en los que se  vean
comprometidas las ramas en las que trabajan.

**Equipo de documentación:** deberán crear y mantener actualizada la documentación del
producto que será entregada al cliente. Esta documentación ayudará al cliente a entender
las funcionalidades del proyecto y su implementación. Por ejemplo: archivos README, Guía
de usuario, respuestas a preguntas frecuentes, etc.

**Equipos de nuevos desarrollos:** El objetivo de este equipo será descubrir e identificar las
diferentes aplicaciones y los módulos que se pueden integrar al proyecto. Trabajaran en
repositorios ficticios hasta que se decida presentar la petición de cambio y esta se apruebe,
entonces se añadirá el proyecto al repositorio principal.


### 6 Administracion del código fuente ###
En esta sección se describen distintos ítems de configuración. Se tiene en cuenta desde elesquema de ramas, el etiquetado, la estrategia de unión de archivos y el cumplimiento de losniveles de calidad para el producto final. 
#### 6.1 Esquema de ramas ####
#### 6.2 Definición de etiquetas ####
Se etiquetará un commit sólo si su código cuenta con correcta sintaxis y existe al menos un
test unitario que compruebe el funcionamiento del mismo. El etiquetado debe ser
autorizado y revisado por los administradores de los equipos de desarrollo. También
deberán ser respetadas las reglas que aquí se establecen para el nombramiento de la
etiqueta. 
Las etiquetas estarán denominadas de la siguiente forma:



- **Primer dígito (N1):** Este release indicará un gran cambio en la funcionalidad del
proyecto agregando al menos dos características nuevas. Cada uno de estos
releases deberá contar con autorización de un miembro de un mayor escalón
jerárquico, ya que esta será una versión por la cual los clientes deberán pagar. 
- **Segundo dígito (N2):** En este caso las versiones contarán con solamente una
funcionalidad que difiere de la anterior, no estará disponible a los clientes a menos
que los administradores indiquen lo contrario. El caso general será que se espere a
algún otro release concretando así una versión más completa a brindarle al cliente.  
- **Tercer dígito (N3):** Incluirá la corrección de bugs, cambios mínimos en el diseño de
la interface que no afecten al funcionamiento. Esta versión será distribuida
gratuitamente como actualización de la versión anterior que el cliente adquirió. 

#### 6.3 Estrategia de fusión de archivos ####
Dado el modelo de ramas que se decidió utilizar, notamos que una vez cumplido el fin con
el que fue propuesta una rama, esta se da por finalizada y se una a la rama de integración
(master) para ser implementada en el proyecto principal. Esta estrategia permitiría que dos
equipos trabajen sobre el mismo proyecto en simultáneo sin molestar al otro.
El problema recae a la hora de unir los ítems de configuración, frecuentemente se
presentaran conflictos cuando se intente implementar el merge. Con la finalidad de resolver
estos conflictos de la forma más rápida y eficiente posible se establecen una serie de reglas
a la hora de implementar esta fusión de archivos:
 
- Se especificará la etiqueta de cierre (versión a la cual se quiere fusionar) y la
etiqueta inicial (versión donde nace la rama). 

- Se creara un archivo de texto .txt donde se especificará los detalles del estado actual
de la fusión, cada desarrollador que haga un avance en este proceso deberá
documentar los detalles aquí. 

- Una vez terminada la fusión será revisada por el administrador de configuraciones
para confirmar los cambios realizados en la rama de integración. 

- Si los conflictos persisten y se acudirá al equipo de scrum, el cual puede decidir aislar
algunos ítems en ambas ramas para lograr la correcta combinación. 

#### 6.4 Ramas por cliente ####
Para los cambios específicos de los clientes existirá una rama por cliente la cual evolucionará
por su propia cuenta, y según los requerimientos de este cliente.  Si estos requerimientos
son demasiados, se creara un equipo de desarrolladores exclusivamente dedicados a este
cliente.

### 7. Adminitración de builds ###
En el proyecto se utilizarán solo builds de integración continua. Estos se ejecutan cada vez
que un  desarrollador hace un commit, asegurando que este no rompa el código. Fuera ese
el caso deja registrado quien fue el desarrollador que lo hizo y dónde está el error, además
le envía un mail notificando de las fallas. En este casos se utilizara Travis CI, será el encargado
de ejecutar de forma automática los test unitarios, test de sintaxis y generar reportes acerca
de los resultados de los mismos.
Informalmente también los desarrolladores realizaran builds a nivel local para corroborar
que las funcionalidades nuevas que están aplicando son correctas, estos no se enviarán al
repositorio, sino que sólo estarán disponibles en el ordenador de desarrollador.


### 8 Backup ###
El código fuente del proyecto se encontrara alojado en los servidores de GitHub pero,
también existirá una versión de backup en un ordenador del proyecto, el cual copiará el
proyecto de GitHub a diario para evitar que algún problema en el servidor afecte al correcto
desarrollo del proyecto. 

