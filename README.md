# Sistema Académico (Arquitectura en Capas)

## Descripción

Esta versión del sistema académico implementa una arquitectura monolítica organizada en capas, mejorando significativamente la estructura, mantenibilidad y escalabilidad del proyecto.

Se basa en la separación clara de responsabilidades siguiendo el patrón:

* Controller
* Service
* Repository
* Model

---

## Arquitectura implementada

### 1. Model

Representa las entidades del sistema:

* Estudiante
* Asignatura
* Registro

Se utilizan objetos tipados (POJOs), mejorando la claridad y consistencia de los datos.

---

### 2. Repository

Encargado del acceso a datos:

* Manejo de listas en memoria
* Operaciones CRUD
* Encapsulación de la lógica de persistencia

Responsabilidad única: **gestionar datos**

---

### 3. Service

Encargado de la lógica de negocio:

* Validaciones de datos (nombre, email, créditos, etc.)
* Conversión de tipos
* Reglas del sistema (ej: evitar registros duplicados)
* Manejo de errores controlados

Responsabilidad clave: **centralizar la lógica**

---

### 4. Controller

Encargado de la interacción con el usuario:

* Recibe peticiones HTTP
* Llama a los servicios
* Devuelve vistas

Responsabilidad: **flujo de entrada/salida**

---

## Mejoras respecto a la versión Spaghetti

### ✔ Separación de responsabilidades

Cada capa tiene una función específica, evitando mezclar lógica.

---

### ✔ Código más mantenible

* Cambios localizados
* Menor impacto entre módulos
* Mayor claridad

---

### ✔ Validaciones centralizadas

Toda la lógica de validación se encuentra en el Service:

* Tipos de datos
* Reglas de negocio
* Control de errores

---

### ✔ Manejo de errores controlado

* Uso de excepciones
* Evita caídas del sistema
* Permite mostrar mensajes al usuario

---

### ✔ Uso de vistas (Thymeleaf)

* Separación entre backend y frontend
* HTML limpio y organizado
* Mejor experiencia visual

---

### ✔ Tipado fuerte

* Uso de clases en lugar de estructuras genéricas
* Mayor seguridad en tiempo de compilación
* Código más claro

---

### ✔ Implementación de relaciones (N a M)

* Registro entre Estudiantes y Asignaturas
* Validaciones cruzadas entre entidades
* Simulación de comportamiento relacional

---

## Flujo de la aplicación

Usuario → Controller → Service → Repository → Datos

---

## Tecnologías utilizadas

* Java
* Spring Boot
* Thymeleaf
* Maven
* Listas en memoria (sin base de datos)

---

## Conclusión

Esta versión demuestra cómo una correcta arquitectura:

* Mejora la calidad del código
* Facilita el mantenimiento
* Permite escalar el sistema
* Reduce errores

---

## Propósito académico

El proyecto muestra la evolución desde un sistema desorganizado (spaghetti) hacia una arquitectura en capas, evidenciando las ventajas de aplicar buenas prácticas de ingeniería de software.
