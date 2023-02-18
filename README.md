#  java api ticket
Api Rest de Java creada usando Spring Boot

la aplicacion creara la base de datos y recibira las solicitudes de manera local por el puerto 8080


Primero debe cambiar los datos de la base de datos en el application.properties

luego ejecutar usando:

Windows:  mvnw.cmd spring-boot:run
Unix :   mvwn spring-boot:run 




rutas:


Url base: http://localhost:8080/



Consultar todos los tickets:
    Url:  (get) ticket/all



Consultar ticket por id:
    Url:  (get) ticket/{id}



Guardar ticket:

    Url:  (post) ticket/save

    body:

            {
                "user":"",
                "status":"abierto" / "cerrado"
            }



Editar ticket:

    Url:  (post) ticket/edit

    body:

            {
                "id": {id de ticket a modificar},
                "user":"",
                "status":"abierto" / "cerrado"
            }



Eliminar ticket:

    Url:  (delete) ticket/delete/{id}
