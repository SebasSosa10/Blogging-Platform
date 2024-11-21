## Project Description

This project involves building a *blogging platform* using *Spring Boot*. The platform enables users to manage their blogs, interact with other users, and provides a role-based system with different permission levels, ensuring efficient and secure administration.

### Key Features:
- User management and authentication.
- Creation, editing, and deletion of blog posts.
- User interaction through comments, likes/dislikes.
- Management of categories and tags.
- Content search and filtering.
- Admin panel for platform moderation.

---

## Functional Requirements

### 1. User Management
- **User Registration**: Users can sign up by providing a username, email, and password.
- **Authentication**: Users can log in and log out securely.
- **User Roles**: There are two primary roles:
  - **ADMIN**: Manages platform content and users.
  - **AUTHOR**: Creates and manages their own posts.
- **User Profile**: Users can view and edit their personal profile.

### 2. Blog Management
- **Post Creation**: Authors can create posts with a title, content, tags, and category.
- **Post Editing**: Authors can update their published posts.
- **Post Deletion**: Authors can delete their own posts, and admins can delete any post.
- **Publish/Unpublish**: Authors can publish or unpublish their posts.
- **Post View**: Published posts are visible to everyone, including guests.

### 3. User Interaction
- **Comments**: Registered users can comment on posts. Admins moderate comments.
- **Likes/Dislikes**: Users can rate posts with "like" or "dislike."
- **Follow Authors**: Users can follow specific authors to get notifications for new posts.

### 4. Categories and Tags
- **Category Management**: Admins can create, edit, and delete categories.
- **Tags**: Authors can tag their posts with keywords for easier searchability.

### 5. Search and Filters
- **Search**: Users can search posts by title, content, tags, and categories.
- **Filters**: Posts can be filtered by author, category, publication date, and popularity.

### 6. Security
- **JWT Authentication**: Secure token-based authentication using JWT.
- **Access Control**: API endpoints are protected based on user roles.

### 7. Administration
- **Admin Panel**: A dashboard for admins to manage users, posts, comments, and categories.
- **Comment Moderation**: Admins can approve or reject comments.

---

## Technologies Used

- **Java** (with Spring Boot) for backend development.
- **Spring Security** for authentication and role management.
- **JWT** for secure session handling.
- **JPA/Hibernate** for database management.
- **MySQL/PostgreSQL** as the relational database.
- **Thymeleaf/React.js** for frontend development (optional depending on the scope).
