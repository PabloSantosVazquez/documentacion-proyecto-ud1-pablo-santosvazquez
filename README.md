# Gestor de incidencias

Aplicación Java de consola para **consultar y gestionar el listado de incidencias**. Permite ver todas las incidencias, filtrar las abiertas, buscarlas por texto y consultar una concreta por su identificador.



## Requisitos

- **Java 21** (`maven.compiler.release` en el `pom.xml`): se necesita un JDK 21 o superior.
- **Maven**: no hace falta instalarlo, porque el proyecto incluye el *wrapper* (`mvnw` y `mvnw.cmd`).

Comprueba la instalación de Java:

```bash
java --version
javac --version
```

## Funcionalidades

- Listar todas las incidencias.
- Listar únicamente las incidencias **abiertas**.
- Buscar incidencias por identificador o título, sin distinguir mayúsculas de minúsculas.
- Consultar el detalle de una incidencia por su identificador.
- Usar la aplicación mediante un **menú interactivo** o mediante **argumentos de línea de comandos**.

## Compilación y ejecución

Desde la raíz del proyecto. En Windows se usa el wrapper `mvnw.cmd`.

Compilar y ejecutar el menú interactivo:

```bash
.\mvnw.cmd clean compile exec:java
```

Si tienes Maven instalado en el `PATH`, también puedes usar:

```bash
mvn clean compile exec:java
```

Una vez compilado, se puede ejecutar una operación directamente pasando argumentos:

```bash
java -cp target/classes es.centro.incidencias.App listar
java -cp target/classes es.centro.incidencias.App buscar red
java -cp target/classes es.centro.incidencias.App detalle INC-001
```

| Operación | Descripción |
|---|---|
| `listar` | Muestra todas las incidencias |
| `abiertas` | Muestra las incidencias abiertas |
| `buscar <texto>` | Busca por identificador o título |
| `detalle <id>` | Muestra una incidencia |
| `ayuda` | Muestra la ayuda |

Sin argumentos se abre el menú interactivo.

## Generación y consulta de Javadoc

Para generar la documentación:

```bash
.\mvnw.cmd javadoc:javadoc
```

El proyecto está configurado para que el HTML se genere en la carpeta `docs/apidocs/`. Para consultarla en local, abre en el navegador:

```text
docs/apidocs/index.html
```

La documentación generada se publica con GitHub Pages y se puede consultar en línea aquí:

**[Documentación Javadoc publicada]()**



## Clases principales

| Clase | Responsabilidad |
|---|---|
| `App` | Punto de entrada: gestiona el menú interactivo y los argumentos de línea de comandos |
| `GestorIncidencias` | Almacena las incidencias y ofrece listado, filtrado de abiertas, búsqueda por texto y búsqueda por identificador |
| `Incidencia` | Representa una incidencia con identificador, título, prioridad y estado (abierta o cerrada); sabe si un texto aparece en su identificador o título |
| `IncidenciaNoEncontradaException` | Excepción comprobada que se lanza cuando no existe una incidencia con el identificador buscado |

## Estructura de archivos

```text
proyecto-base-maven-gestor-incidencias/
├── .mvn/
├── docs/                
├── src/
│   └── main/
│       └── java/
│           └── es/
│               └── centro/
│                   └── incidencias/
│                       ├── App.java
│                       ├── GestorIncidencias.java
│                       ├── Incidencia.java
│                       └── IncidenciaNoEncontradaException.java
├── .gitignore
├── ENUNCIADO_ACTIVIDAD.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

