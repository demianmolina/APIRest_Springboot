# Employee REST API con Java y Spring Boot



## Tecnologías

- Java 17
- Spring Boot 3.3.0
- Maven

## Prerrequisitos

- JDK 17 o superior
- Maven 3.6 o superior

## Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/employee-api.git
cd employee-api
```

2. Compila el proyecto usando Maven:

```bash
mvn clean install
```

## Ejecución

Ejecuta la aplicación:

```bash
mvn spring-boot:run
```

La API estará disponible en http://localhost:8080.

## Endpoints

### Página de inicio

- GET /

Retorna un mensaje de bienvenida.

- Respuesta:

```json
"Esta es la página de inicio de la API de empleados."
```

### Obtener todos los empleados

- GET /employees

Retorna una lista de todos los empleados.

- Respuesta:

```json
[
  {
    "id": 1,
    "name": "Juan",
    "lastName": "Pérez",
    "position": "Developer"
  },
  {
    "id": 2,
    "name": "María",
    "lastName": "Gómez",
    "position": "Designer"
  },
  {
    "id": 3,
    "name": "Carlos",
    "lastName": "López",
    "position": "Manager"
  }
]
```

### Obtener un empleado por ID

- GET /employee/{id}

Retorna un empleado basado en su ID.

- Parámetros:
    id (Long): ID del empleado

- Respuesta:

```json
{
  "id": 1,
  "name": "Juan",
  "lastName": "Pérez",
  "position": "Developer"
}
```

### Añadir un nuevo empleado

- POST /employee/

Añade un nuevo empleado.

- Cuerpo de la solicitud:

```json
{
  "name": "Nuevo",
  "lastName": "Empleado",
  "position": "Tester"
}
```

- Respuesta:

```json
"Empleado añadido correctamente."
```
### Actualizar un empleado
- PUT /employee/{id}

Actualiza la información de un empleado basado en su ID.

- Parámetros:

id (Long): ID del empleado
- Cuerpo de la solicitud:

```json
{
  "name": "Nombre Actualizado",
  "lastName": "Apellido Actualizado",
  "position": "Nueva Posición"
}
```
- Respuesta:

```json
"Empleado actualizado correctamente."
```

### Eliminar un empleado
- DELETE /employee/{id}

Elimina un empleado basado en su ID.

- Parámetros:

id (Long): ID del empleado
- Respuesta:

```json
"Empleado eliminado correctamente."
```


