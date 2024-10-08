# **Spring Boot CRUD API con MongoDB**

Este proyecto implementa una API CRUD utilizando Spring Boot y MongoDB como base de datos. Se utilizan los verbos HTTP más comunes: `GET`, `POST`, `PUT`, `PATCH`, `DELETE`, y `HEAD`.

## **Verbos HTTP Utilizados**

### **1. GET**

- **Descripción**: El método `GET` se utiliza para obtener datos de un servidor en la forma de un recurso. Es un método seguro y no destructivo, ya que no modifica el estado del recurso en el servidor.
- **Ejemplo**: Obtener todos los ítems en la colección.
    ```http
    GET /item/getAll
    ```

### **2. POST**

- **Descripción**: El método `POST` se utiliza para enviar datos al servidor para crear un nuevo recurso. A diferencia de `GET`, `POST` puede cambiar el estado en el servidor y no es idempotente (llamadas repetidas pueden tener diferentes efectos).
- **Ejemplo**: Insertar un nuevo ítem en la colección.
    ```http
    POST /item/insert
    ```

### **3. PUT**

- **Descripción**: El método `PUT` se utiliza para actualizar un recurso existente. Si el recurso no existe, el servidor puede crearlo (dependiendo de la implementación). Es idempotente, lo que significa que múltiples llamadas con los mismos datos tendrán el mismo efecto.
- **Ejemplo**: Actualizar un ítem existente.
    ```http
    PUT /item/update/{id}
    ```

### **4. PATCH**

- **Descripción**: El método `PATCH` se utiliza para realizar actualizaciones parciales en un recurso existente. A diferencia de `PUT`, `PATCH` solo modifica los campos específicos en lugar de reemplazar todo el recurso.
- **Ejemplo**: Actualizar solo la cantidad de un ítem.
    ```http
    PATCH /item/update/{id}/quantity
    ```

### **5. DELETE**

- **Descripción**: El método `DELETE` se utiliza para eliminar un recurso en el servidor. Es idempotente, lo que significa que si eliminas un recurso que ya no existe, la respuesta será la misma que si lo hubieras eliminado la primera vez.
- **Ejemplo**: Eliminar un ítem por su ID.
    ```http
    DELETE /item/delete/{id}
    ```

### **6. HEAD**

- **Descripción**: El método `HEAD` es similar a `GET`, pero solo devuelve los encabezados de la respuesta, sin el cuerpo. Es útil para comprobar si un recurso existe o para verificar sus metadatos.
- **Ejemplo**: Verificar la existencia de recursos.
    ```http
    HEAD /item/getAll
    ```

## **Anotaciones de Spring Boot Utilizadas**

### **1. `@RestController`**

- **Descripción**: Marca la clase como un controlador donde cada método maneja una solicitud HTTP. Combina las funcionalidades de `@Controller` y `@ResponseBody`, lo que significa que los métodos devolverán datos en formato JSON o XML directamente en el cuerpo de la respuesta.
- **Uso en el proyecto**: La clase `ItemController` está anotada con `@RestController`, lo que indica que es un controlador que maneja solicitudes HTTP y responde con datos JSON.

### **2. `@RequestMapping("items")`**

- **Descripción**: Esta anotación se utiliza para mapear las solicitudes HTTP a métodos de controlador específicos. Puedes usarla a nivel de clase para definir una URL base y a nivel de método para definir subrutas.
- **Uso en el proyecto**: En `ItemController`, `@RequestMapping("/item")` se utiliza para definir la URL base `/item` para todos los métodos de la clase.

### **3. `@Autowired`**

- **Descripción**: Se utiliza para la inyección automática de dependencias en Spring. Con esta anotación, Spring se encargará de resolver e inyectar el objeto necesario cuando sea necesario.
- **Uso en el proyecto**: En `ItemController`, `@Autowired` se utiliza para inyectar una instancia de `ItemService`, lo que permite usar los métodos del servicio sin necesidad de crear una nueva instancia manualmente.

### **4. `@Override`**

- **Descripción**: Se utiliza para indicar que un método está sobrescribiendo un método de la superclase o implementando un método de una interfaz.
- **Uso en el proyecto**: En este proyecto, `@Override` se usa para sobrescribir métodos en clases de servicio o controlador. Es importante mencionar que se está utilizando Lombok en este proyecto, una biblioteca que ayuda a reducir el código repetitivo como constructores, getters y setters.
  
### **Lombok en el Proyecto**

Lombok es una biblioteca que se integra con el compilador Java para generar automáticamente código repetitivo como getters, setters, constructores, y más. Esto facilita y simplifica la escritura de clases modelo en Java.

- **Ejemplo**: En la clase `GroceryItem`, Lombok se usa con las anotaciones:
    - `@Data`: Genera automáticamente getters, setters, `toString()`, `equals()`, y `hashCode()` para todos los campos.
    - `@AllArgsConstructor`: Genera un constructor con un parámetro para cada campo en la clase.
    - `@NoArgsConstructor`: Genera un constructor sin parámetros.
    - `@Builder`: Proporciona un patrón de construcción para la clase, permitiendo la creación de instancias de manera más flexible.

## **Requisitos Previos**

- **Java 8 o superior**
- **Maven**
- **MongoDB**

## **Cómo Ejecutar el Proyecto**

1. Clona el repositorio:
    ```bash
    git clone <URL del repositorio>
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd <nombre-del-directorio>
    ```

3. Ejecuta el proyecto con Maven:
    ```bash
    mvn spring-boot:run
    ```

4. Prueba la API utilizando Postman o cualquier otra herramienta similar.
