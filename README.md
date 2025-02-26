## Descripción del Proyecto  

Este proyecto consiste en desarrollar una *plataforma de blogs* con *Spring Boot*. La plataforma permite a los usuarios gestionar sus blogs, interactuar con otros y utilizar un sistema de roles con distintos niveles de permisos, garantizando una administración eficiente y segura.  

### Características Clave:  
- Gestión de usuarios y autenticación.  
- Creación, edición y eliminación de publicaciones.  
- Interacción mediante comentarios y reacciones.  
- Administración de categorías y etiquetas.  
- Búsqueda y filtrado de contenido.  
- Panel de administración para la moderación de la plataforma.  

---  

## Requisitos Funcionales  

### 1. Gestión de Usuarios  
- **Registro de Usuario**: Los usuarios pueden registrarse con un nombre de usuario, correo y contraseña.  
- **Autenticación**: Inicio y cierre de sesión seguro.  
- **Roles de Usuario**: Dos roles principales:  
  - **ADMIN**: Administra contenido y usuarios.  
  - **AUTHOR**: Crea y gestiona sus propias publicaciones.  
- **Perfil de Usuario**: Edición y visualización del perfil personal.  

### 2. Gestión de Blogs  
- **Creación de Publicaciones**: Los autores pueden crear publicaciones con título, contenido, etiquetas y categoría.  
- **Edición de Publicaciones**: Los autores pueden actualizar sus publicaciones.  
- **Eliminación de Publicaciones**: Los autores pueden eliminar sus publicaciones; los administradores pueden eliminar cualquier publicación.  
- **Publicar/Despublicar**: Los autores pueden publicar o despublicar sus publicaciones.  
- **Visualización de Publicaciones**: Las publicaciones publicadas son visibles para todos, incluidos los visitantes.  

### 3. Interacción de Usuarios  
- **Comentarios**: Los usuarios registrados pueden comentar publicaciones; los administradores moderan los comentarios.  
- **Reacciones**: Los usuarios pueden valorar publicaciones con "me gusta" o "no me gusta".  
- **Seguir Autores**: Los usuarios pueden seguir autores para recibir notificaciones sobre nuevas publicaciones.  

### 4. Categorías y Etiquetas  
- **Gestión de Categorías**: Los administradores pueden crear, editar y eliminar categorías.  
- **Etiquetas**: Los autores pueden etiquetar sus publicaciones para mejorar la búsqueda.  

### 5. Búsqueda y Filtros  
- **Búsqueda**: Los usuarios pueden buscar publicaciones por título, contenido, etiquetas y categorías.  
- **Filtros**: Se pueden filtrar publicaciones por autor, categoría, fecha de publicación y popularidad.  

### 6. Seguridad  
- **Autenticación JWT**: Seguridad basada en tokens mediante JWT.  
- **Control de Acceso**: Protección de los endpoints de la API según roles de usuario.  

### 7. Administración  
- **Panel de Administración**: Un dashboard para que los administradores gestionen usuarios, publicaciones, comentarios y categorías.  
- **Moderación de Comentarios**: Los administradores pueden aprobar o rechazar comentarios.  

---  

## Tecnologías Utilizadas  

- **Java** (con Spring Boot) para el desarrollo backend.  
- **Spring Security** para autenticación y gestión de roles.  
- **JWT** para manejo seguro de sesiones.  
- **JPA/Hibernate** para la gestión de bases de datos.  
- **MySQL/PostgreSQL** como base de datos relacional.  
- **Thymeleaf/React.js** para el frontend (opcional según el alcance).
