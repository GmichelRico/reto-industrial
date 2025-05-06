# Proyecto Full Stack - Gestión de Usuarios

### Examen de Evaluación - Reto Industrial 2025

---

## 🔧 Tecnologías utilizadas

### Backend (Spring Boot)
- Spring Boot 3.x
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Swagger (springdoc-openapi)
- Lombok

### Frontend (Angular)
- Angular 17+
- Bootstrap 5
- Reactive Forms
- SweetAlert2
- HttpClientModule

---

## 📌 Funcionalidades

### Backend
- API RESTful para la entidad `User`
- Operaciones CRUD (`GET`, `POST`, `PUT`, `DELETE`)
- Seguridad con Spring Security (modo desarrollo: endpoints abiertos)
- Configuración global de CORS
- Documentación de endpoints vía Swagger en `/swagger-ui.html`

### Frontend
- Visualización de usuarios en tabla
- Formulario de registro y edición con validaciones
- Mensajes de éxito/error con SweetAlert2
- Consumo completo de API usando HttpClient

---

## 🚀 Cómo ejecutar

### Backend
1. Clonar el repositorio y ejecutar:
   ```bash
   ./mvnw spring-boot:run
   ```
2. Accede a: `http://localhost:8080/swagger-ui.html`

### Frontend
1. Clonar el frontend y ejecutar:
   ```bash
   npm install
   ng serve
   ```
2. Accede a: `http://localhost:4200`

---

## 🗃️ Base de datos

- Base de datos: MySQL
- Script de carga: `import.sql`
- Nombre de la base: `userDB`

---

## ✍️ Autor

**Gerardo Michel Rico Rodarte**  
Proyecto para evaluación técnica de desarrollo Full Stack.
