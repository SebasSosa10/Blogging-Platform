## Descripción del Proyecto

Este proyecto consiste en la construcción de una *plataforma de blogging* utilizando *Spring Boot*. La plataforma permite a los usuarios gestionar sus blogs, interactuar con otros usuarios, y ofrece un sistema de roles con diferentes niveles de permisos, asegurando que la administración de la plataforma sea eficiente y segura. 

### Funcionalidades principales:
- Gestión de usuarios y autenticación.
- Creación, edición y eliminación de posts de blog.
- Interacción con los posts mediante comentarios, likes/dislikes.
- Administración de categorías y etiquetas.
- Búsqueda y filtrado de contenido.
- Panel de administración para moderar la plataforma.

## Requerimientos Funcionales

### 1. Gestión de Usuarios
- *Registro de Usuarios*: Los usuarios pueden registrarse proporcionando un nombre de usuario, correo electrónico y contraseña.
- *Autenticación*: Los usuarios pueden iniciar sesión y cerrar sesión.
- *Roles de Usuario*: Hay dos roles principales:
  - *ADMIN*: Gestiona el contenido y a los usuarios.
  - *AUTHOR*: Crea y gestiona sus propios posts.
- *Perfil de Usuario*: Los usuarios pueden ver y editar su perfil personal.

### 2. Gestión de Blogs
- *Creación de Posts*: Los autores pueden crear posts con título, contenido, etiquetas y categoría.
- *Edición de Posts*: Los autores pueden modificar sus posts ya publicados.
- *Eliminación de Posts*: Los autores pueden eliminar sus posts, y los administradores pueden eliminar cualquier post.
- *Publicación/Despublicación*: Los autores pueden publicar o despublicar sus posts.
- *Vista de Posts*: Los posts publicados son visibles para todos, tanto usuarios registrados como invitados.

### 3. Interacción de Usuarios
- *Comentarios*: Los usuarios registrados pueden comentar en los posts. Los administradores moderan los comentarios.
- *Likes/Dislikes*: Los usuarios pueden calificar los posts con "me gusta" o "no me gusta".
- *Seguimiento de Autores*: Los usuarios pueden seguir a autores específicos para recibir notificaciones de nuevos posts.

### 4. Categorías y Etiquetas
- *Gestión de Categorías*: Los administradores pueden crear, editar y eliminar categorías.
- *Etiquetas*: Los autores pueden etiquetar sus posts con palabras clave para facilitar la búsqueda.

### 5. Búsqueda y Filtros
- *Búsqueda*: Los usuarios pueden buscar posts por título, contenido, etiquetas y categorías.
- *Filtros*: Los posts se pueden filtrar por autor, categoría, fecha de publicación y popularidad.

### 6. Seguridad
- *Autenticación JWT*: Implementación de autenticación basada en tokens JWT para asegurar las APIs.
- *Control de Acceso*: Los endpoints están protegidos según el rol del usuario.

### 7. Administración
- *Panel de Administración*: Un panel para que los administradores gestionen usuarios, posts, comentarios y categorías.
- *Moderación de Comentarios*: Los administradores pueden aprobar o rechazar comentarios.

## Tecnologías Utilizadas

- *Java* (con Spring Boot) para la creación del backend.
- *Spring Security* para la autenticación y control de roles.
- *JWT* para la gestión de sesiones seguras.
- *JPA/Hibernate* para la gestión de la base de datos.
- *MySQL/PostgreSQL* como base de datos relacional.
- *Thymeleaf/React.js* para el frontend (opcional dependiendo del alcance).
