# Proyecto Libreta de Direcciones

### Sección A: Descripción
El sistema de libreta de direcciones está diseñado para gestionar entradas de contacto mediante operaciones de agregar, eliminar, buscar, y listar entradas. A continuación, se describen las partes que funcionan correctamente:
- **Agregar entradas:** El sistema permite al usuario agregar nuevas entradas de contacto proporcionando los datos requeridos.
- **Eliminar entradas:** El sistema permite eliminar entradas de contacto previamente agregadas.
- **Buscar entradas:** El sistema puede buscar entradas de contacto por el apellido o el inicio del apellido.
- **Listar entradas:** El sistema lista todas las entradas en orden alfabético por apellido.
- **Leer desde archivo:** El sistema puede leer entradas de contacto desde un archivo.

#### A.1) Estado del sistema

#### A.2) Lista de clases
#####AddressBook
- **Propósito: **Representa y contiene una lista de AddressEntry. Permite operaciones como agregar, eliminar, buscar, y listar entradas.
- **Estructura de datos:** Utiliza una lista (ArrayList) para almacenar las entradas. La elección de una lista se debe a su flexibilidad y facilidad de uso para agregar y eliminar elementos.
- **Eficiencia:** Las operaciones de agregar y eliminar son eficientes, aunque la búsqueda tiene una complejidad lineal debido a la necesidad de recorrer la lista.

##### AddressEntry
- **Propósito:** Representa una entrada individual de contacto en la libreta de direcciones.
- **Estructura de datos:** Contiene variables de clase para almacenar información como nombre, apellido, calle, ciudad, estado, código postal, correo electrónico, y teléfono.
- **Eficiencia:** Los métodos set y get tienen una complejidad constante.

##### AddressBookApplication
- **Propósito:** Contiene la clase principal de la aplicación. Maneja la interacción con el usuario a través del menú y llama a los métodos apropiados de AddressBook.
- **Eficiencia: **Maneja las operaciones de entrada/salida y coordina las acciones del usuario con las funciones de la libreta de direcciones.

##### Menu
- **Propósito:** Muestra las opciones de menú al usuario y captura sus entradas. Llama a los métodos de AddressBook según la opción seleccionada.
- **Eficiencia:** La eficiencia depende de las operaciones subyacentes que invoca en AddressBook.

### Sección B: URL de JavaDoc
La documentación JavaDoc del proyecto está disponible en el siguiente enlace:

### Sección C: UML/Diseño
#### C.1) Diagrama de jerarquía de clases UML


### Sección D: Capturas de pantalla del sistema
#### D.1) Evidencia 1: Leer entradas del archivo de datos seguidas de Mostrar listado

#### D.2) Evidencia 2: Agregar un nuevo objeto AddressEntry seguido de mostrar listado
Captura de pantalla:


#### D.3) Evidencia 3: Eliminar una entrada seguida de mostrar listado
Captura de pantalla:


#### D.4) Evidencia 4: Buscar entradas
Buscar entrada que debería recuperar al menos una entrada:


Buscar entrada que no debería recuperar ninguna entrada:


### Sección E: Historial de Commits
Capturas de pantalla del historial de commits
