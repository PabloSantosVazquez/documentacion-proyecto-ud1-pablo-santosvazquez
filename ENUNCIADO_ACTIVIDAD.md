


# Actividad — Documentar un proyecto Java

Se proporciona una aplicación Java de consola para consultar y gestionar un pequeño listado de incidencias de soporte de un centro educativo.

El código funciona, pero **carece de documentación técnica**, el código fuente no contiene documentación Javadoc y el archivo README.md está sin completar.

El objetivo de esta práctica es transformar el proyecto inicial en un proyecto correctamente documentado y publicar su documentación técnica mediante GitHub Pages.

## Parte 1 — Analizar el proyecto

Antes de modificar nada:

1. compila y ejecuta el proyecto;

con maven en el PATH del equipo:
```bash
mvn clean compile exec:java
```
o con el wrapper de maven
```bash
.\mvnw.cmd clean compile exec:java

```

2. identifica las clases;
3. identifica qué métodos reciben parámetros;
4. identifica qué métodos devuelven valores;
5. identifica qué métodos pueden lanzar excepciones;
6. identifica el método obsoleto.

## Parte 2 - Preparación del repositorio

Crea un repositorio público con el proyecto en tu cuenta de GitHub con el siguiente nombre:

```documentacion-proyecto-ud1-nombre-apellidos```

Sube al respositorio el proyecto proporcionado y realiza la práctica sobre él.

No deben subirse al repositorio carpetas o archivos generados por el IDE o por el proceso de compilación

```
.idea/
out/
target/
*.class
```

La carpeta docs/ sí deberá subirse, ya que contendrá la documentación Javadoc que se publicará mediante GitHub Pages.

## Parte 2 — Javadoc

Documenta las clases y sus métodos públicos

Debes utilizar, cuando tenga sentido:

- descripción de clase;
- `@author`;
- `@version`;
- `@since`;
- `@param`;
- `@return`;
- `@throws`;
- `@see`;
- `@deprecated`;
- `{@code}`;
- `{@link}`.

No es obligatorio colocar todas las etiquetas en todos los elementos. Debes utilizarlas donde sean semánticamente adecuadas.

El método obsoleto ya está marcado con `@Deprecated`. Su Javadoc debe explicar por qué no se recomienda y enlazar con los métodos que deben utilizarse en su lugar.

## Parte 3 — Generación

Genera la documentación:

con maven en el PATH del equipo:

```bash
mvn javadoc:javadoc
```

o con el wrapper de maven
```bash
.\mvnw.cmd javadoc:javadoc

```

Revisa los avisos y corrige la documentación cuando sea necesario.

## Parte 4 - Publicación en GitHub Pages
Sube las modificaciones a GitHub y publica la documentaión Javadoc mediante GitHub Pages.

GitHub Pages no ejecutará la aplicación Java. Lo que se publicará será el sitio HTML estático generado por Javadoc.

En el repositorio de GitHub:

1. Accede a Settings;
2. sSelecciona Pages;
3. En Build and deployment, selecciona Deploy from a branch;
4. Selecciona la rama main;
5. Selecciona la carpeta donde se encuentre el archivo index.html generado;

GitHub iniciará el proceso de publicación. Puede tardar unos minutos en mostrar la URL definitiva.

## Parte 5 - Elaboración del README.md
Completa el archivo README.md utilizando Markdown.

Debe contener, como mínimo, los siguientes apartados:

- Nombre, finalidad y descripción breve del proyecto;
- Versión de java que utiliza
- listado de funcionalidades que permite realizar la aplicación;
- compilación y ejecución;
- generación y consulta de Javadoc;
- una tabla con las clases principales y su responsabilidad general.
- estructura de archivos
- enlace a la documentación Javadoc publicada mediante GitHub Pages

El README debe utilizar correctamente encabezados, párrafos, negrita, listas, tablas, código en línea, bloques de código y enlaces.

Actualiza el repositorio con los cambios en el README.md

## Entrega
La entrega se realizará a través del aula virtual

Debes entregar:
- URL del repositorio de GitHub
- URL de la documentación Javadoc publicada mediante GitHub Pages.
