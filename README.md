# Saving Footprints

Esta es un Api RestFull Usando java reactivo, springboot 3.1.2, JDK 17, r2dbc y h2 la cual tiene como logica de negocio 
ayudar a los peluditos en condiciones vulnerables se compone de un funcionamiento simple en el cual posee las siguientes entidades
Pet (gato, perro o burro)
Picture (imagenes pertenecientes al animal)
User
Inicitiva (Es una recoleccion de fondos con un fin en especifico)
Donacion (conciste en la donacion de dinero de un usuario a una iniciativa).
Para mayor entebdimiento se anexa el modelo de base de datos

![Captura de Pantalla 2023-07-19 a la(s) 9.44.51 p.m..png](Captura%20de%20Pantalla%202023-07-19%20a%20la%28s%29%209.44.51%20p.m..png)

## Composicion

![Captura de Pantalla 2023-07-24 a la(s) 12.23.57 a.m..png](Captura%20de%20Pantalla%202023-07-24%20a%20la%28s%29%2012.23.57%20a.m..png)

se puede observar que se divide el proyecto en multiples paquetes
adapter que contendra todo aqueyo que tenga que ver con servicios externos a la logica de negocio, en este caso la configuracion de H2
config que posee las configuraciones de los bean requeridos al iniciar el proyecto
controllers que son donde ubicamos la configuracion de los endpoints
model que tendra todo aquello relacionado con las entidades de la logica de negocio
usecase que servira como logica operacional del negocion realizando cambios y haciendo de intermediario entre los controllers y los adaptadores
