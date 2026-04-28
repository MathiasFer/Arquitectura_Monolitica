# Sistema Académico (Versión Spaghetti)

## Descripción

Esta versión del proyecto implementa un sistema académico básico utilizando Spring Boot, donde se gestionan estudiantes, asignaturas y registros. Sin embargo, todo el código se encuentra desarrollado bajo un enfoque **monolítico desorganizado (spaghetti code)**.

## Características

* CRUD de Estudiantes
* CRUD de Asignaturas
* Registro de relación entre estudiantes y asignaturas
* Uso de listas en memoria (sin base de datos)
* Generación de vistas directamente desde el código

---

## Problemas de la arquitectura

### 1. Falta de separación de responsabilidades

Toda la lógica está concentrada en una sola clase o en pocas clases:

* Controlador
* Lógica de negocio
* Acceso a datos
* Generación de HTML

Esto provoca:

* Código difícil de mantener
* Alta probabilidad de errores
* Baja reutilización

---

### 2. Acoplamiento fuerte

Las diferentes partes del sistema dependen directamente entre sí, lo que significa que:

* Cambiar una parte afecta muchas otras
* No se pueden reutilizar componentes
* No existe independencia entre módulos

---

### 3. Falta de validaciones adecuadas

* No hay control de tipos (ej: ingresar texto en campos numéricos rompe la app)
* No hay validaciones de negocio centralizadas
* Los errores no se manejan correctamente

Ejemplo:

* Ingresar "ssss" en un campo numérico produce un error HTTP 400

---

### 4. Manejo deficiente de errores

* Los errores no son controlados
* La aplicación falla directamente
* No se muestran mensajes amigables al usuario

---

### 5. Uso de estructuras no tipadas

* Uso de `Map` o estructuras genéricas
* Falta de modelos claros
* Difícil trazabilidad de datos

---

### 6. Generación de HTML en Java

* Código HTML embebido en controladores
* Difícil de leer y mantener
* No reutilizable

---

## Conclusión

Esta versión demuestra los problemas clásicos de una mala arquitectura:

* Baja escalabilidad
* Difícil mantenimiento
* Alta probabilidad de errores
* Código poco profesional

Sirve como base para comparar con una versión mejor estructurada.

---

## Propósito académico

Esta implementación se utiliza como punto de partida para evidenciar la necesidad de aplicar principios de arquitectura de software y buenas prácticas.
# Arquitectura_Monolitica