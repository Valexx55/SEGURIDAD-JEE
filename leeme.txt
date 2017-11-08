NOTAS SOBRE LA TEORÍA

La versión de la teoría contiene los apartados tanto de JEE "puro" como referencias a Spring Security, que por su similitud, 
se han decidido incluir conjuntamente. Además, se han corregido los fallos y añadida la información necesaria adicional 
identificada durante la impartición del curso.

GUÍA PRÁCTICA

Los proyectos adjuntos están listos para consumir e que ilustran las prácticas desarrolladas durante el curso:

1 servletapi

Proyecto maven demo de Spring Security, donde podemos ver la autenticación y autorización que ofrece Spring security
Recordad la base de datos Oracle XE debidamente configurada y con el esquema HR creado y las tablas de las credenciales listas

En este proyecto, también podemos exprimentar el soporte de Spring Security para combatir los ataques CSRF con la práctica de 
subir comentarios con POST y filtrar ataques XSS con un filtro estándar

También se puede jugar con los atributos del manejo de la sesión que ofrece Spring Security

Por último podemos observar/probar la gestión centralizada de errores con Spring

2 restfulljpa

Poryecto que ofrece una capa de servicios REST que son consumidos desde la web http://www.hrsanroque.com/nomeva.html
para ilustrar la problemática de las peticiones CORS. Filtro parametrizado en web.xml para permitir su uso

3 REALM

Proyecto que ilustra la autenticación y autorización de usuarios con REALM de Tomcat (JEE)

También se carga aquí un servlet para ilustrar la SQLInjection y su solución con PreparedStatement

Y también podemos observar la gestión de errores centralizada por medio de elementos en el web.xml


4 01-login Proyecto Gradle JWT

Crear una cuenta en Auth0 e importar el proyecto de ejemplo que se crea al seleccionar el cliente Java Spring Security Regular App
El proyecto es Gradle, con lo que debe instalarse el plugin Eclipse en caso de no estar visible
El usuario en auth es valexx55@gmail.com y la password Iberindra10
Podéis debuguear y ver el token de autorización, así como verficarlo 
Para ejecutar proyecto gradle recordad en run as --> gradle --> new config
y usad los parámetros clean bootRun
y debuguear se adjunta esta guía, bastante comprensible 

http://nixmash.com/post/debugging-a-gradle-spring-boot-application-in-eclipse
sección The Old School Way to Debug Gradle Spring Boot Apps in Eclipse

5 fortaleza

Proyecto JSE que demuestra el uso de ESAPI (librería de seguridad para JAVA)


