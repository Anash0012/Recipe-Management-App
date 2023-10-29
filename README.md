# Recipe Management System

This is the README file for the Recipe Management System project. It provides a comprehensive overview of the project structure, components, and configuration.

## Table of Contents

- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Project Dependencies](#project-dependencies)
- [Model Classes](#model-classes)
- [Repository Interfaces](#repository-interfaces)
- [Data Transfer Object (DTO) Classes](#data-transfer-object-dto-classes)
- [Service Classes](#service-classes)
- [Utility Classes](#utility-classes)
- [Controller Classes](#controller-classes)
- [Application Properties](#application-properties)

## Project Overview

The Recipe Management System is a Java application designed to manage and organize recipes. It includes various components for managing recipes, ingredients, comments, steps, users, and user authentication tokens. These components work together to create a comprehensive recipe management system.

## Project Structure

The project follows a standard Java project structure with the following key directories:

- `src/main/java`: Contains the Java source code for your project.
- `src/main/resources`: Can be used for storing resource files, such as configuration files.

## Project Dependencies

Your project uses Maven for dependency management. Here are the key dependencies and plugins defined in your `pom.xml`:

- **Spring Boot Starter Parent**
  - Parent project for Spring Boot.
  - Ensures consistency across Spring Boot dependencies.
  - Version: `3.1.5`

- **Spring Boot Starter Data JPA**
  - Starter for using Spring Data JPA for data access.

- **Spring Boot Starter Validation**
  - Starter for validation and data binding.
  - Provides validation support for your project.

- **Spring Boot Starter Web**
  - Starter for building web applications, including RESTful services.
  - Enables web development in your project.

- **MySQL Connector/J**
  - MySQL JDBC connector for connecting to MySQL databases.

- **Project Lombok**
  - Provides code simplification and generation of boilerplate code.
  - Enhances the readability of your code.

- **Spring Boot Starter Test**
  - Starter for testing Spring Boot applications.
  - Enables the testing of your project.

- **Java Mail**
  - Provides the JavaMail API for sending emails.

- **SpringDoc OpenAPI**
  - Allows the generation of OpenAPI documentation for your RESTful services.
  - Version: `2.1.0`

- **Spring Boot Maven Plugin**
  - A Maven plugin for packaging Spring Boot applications.
  - Excludes Lombok during the build process.

These dependencies and plugins are crucial for the functionality of your project. Make sure you have the correct versions and configurations in your `pom.xml`.

You can update or add more dependencies as needed for your specific project requirements.

## Model Classes

The project includes the following model classes:

- `Recipe`: Represents a recipe with details such as name, instructions, cooking time, servings, author, type, ingredients, and steps.
- `Ingredient`: Represents an ingredient with name, quantity, price, and category.
- `Comment`: Represents a comment with text, recipe association, user association, and creation time.
- `Step`: Represents a step in a recipe with a description and recipe association.
- `User`: Represents a user with user ID, username, password, email, contact, and associated recipes.
- `UserAuthenticationToken`: Represents an authentication token with user association, token value, and creation time.

## Repository Interfaces

The project includes repository interfaces for data access:

- `CommentRepo`: Manages comments and provides methods to find comments by recipe.
- `IngredientRepo`: Manages ingredients.
- `RecipeRepo`: Manages recipes and provides methods to find recipes by type or ID.
- `StepRepo`: Manages recipe steps.
- `TokenRepo`: Manages user authentication tokens and provides methods to find tokens by value.
- `UserRepo`: Manages users and provides methods to find users by email.

## Data Transfer Object (DTO) Classes

The project includes DTO classes for data transfer:

- `AddCommentDto`: Represents the input for adding a comment, including authentication information and a comment.
- `AddRecipeDto`: Represents the input for adding a recipe, including a recipe and authentication information.
- `AuthenticationInputDto`: Represents authentication input with an email and token value.
- `DetailChangeDto`: Represents the input for changing user details, including authentication information and user details.
- `SignInInputDto`: Represents the input for user sign-in with an email and password.
- `StepAuthenticationDto`: Represents the input for step-related operations, including authentication information and a step.

## Service Classes

The project includes service classes responsible for business logic:

- `CommentService`: Manages comments, including adding comments and retrieving comments by recipe.
- `RecipeService`: Manages recipes, including creating, updating, and deleting recipes, and retrieving recipes by type or all recipes.
- `StepService`: Manages recipe steps, including creating, updating, and deleting steps, and retrieving steps by recipe and step ID.
- `TokenService`: Manages user authentication tokens, including creating, deleting, and authenticating tokens.
- `UserService`: Manages user-related operations, including user sign-up, sign-in, sign-out, changing user details, and retrieving all users.

## Utility Classes

The project includes utility classes:

- `EmailService`: Provides functionality for sending emails, including SMTP configuration.
- `PasswordEncrypter`: Encrypts user passwords using the MD5 algorithm.

## Controller Classes

The project includes controller classes for handling HTTP requests:

- `CommentController`: Handles requests related to comments, including adding comments and retrieving comments by recipe.
- `RecipeController`: Handles requests related to recipes, including creating, updating, deleting, and retrieving recipes by type or all recipes.
- `StepController`: Handles requests related to steps in recipes, including creating, updating, deleting, and retrieving steps by recipe and step ID.
- `UserController`: Handles requests related to users, including user sign-up, sign-in, sign-out, changing user details, and retrieving all users.

## Application Properties

The project's `application.properties` file includes key application properties, such as database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/RecipeDB?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
