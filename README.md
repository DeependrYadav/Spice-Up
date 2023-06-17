# Recipe Management System

The Recipe Management System is a software solution designed to assist users in managing and organizing their recipes. This system provides a user-friendly interface to store, search, and retrieve recipes easily. Users can view recipes, filter them based on ingredients, and like their favorite recipes. The system also includes an admin user with additional functionalities to manage recipes, view likes, and perform CRUD operations on recipes. The project is developed using Java programming language, MySQL as the database management system, and Hibernate as the Object-Relational Mapping (ORM) framework.

## Table of Contents
- [Domain Description](#domain-description)
- [Types of Users](#types-of-users)
- [Role of Customer](#role-of-customer)
- [Role of Admin](#role-of-admin)
- [Note](#note)

## Domain Description
The Recipe Management System is a software solution designed to assist users in managing and organizing their recipes. The system aims to provide users with a user-friendly interface to store, search, and retrieve recipes easily. It allows customers to view recipes, filter recipes based on ingredients, and give likes to their favorite recipes. The admin user has additional functionalities to manage recipes, view likes, and perform CRUD operations on recipes. The system will be developed using a Java programming language, MySQL as the database management system, and Hibernate as the Object-Relational Mapping (ORM) framework.

## Types of Users
The Recipe Management System consists of the following types of users:

1. Admin: The admin user has elevated privileges and is responsible for managing the system. They can add, update, and delete recipes, view likes, and generate reports.

2. Customer: Customers are regular users of the system. They can view recipes, filter them based on ingredients, like/favorite recipes, and manage their own account.

## Role of Customer
The role of the customer in the Recipe Management System includes the following:

1. Register for an account by providing necessary personal information.
2. Log in to the Recipe Management System using registered credentials.
3. View a collection of recipes available in the system.
4. Filter recipes based on ingredients to find recipes that match their preferences.
5. Like or favorite recipes to save them for future reference.
6. Log out from the Recipe Management System.

## Role of Admin
The role of the admin in the Recipe Management System includes the following:

1. Register for an admin account by providing necessary information.
2. Log in to the admin account using registered credentials.
3. Add new recipes to the system, including recipe name, ingredients, and preparation steps.
4. Update existing recipes with new information.
5. Delete recipes from the system.
6. View the number of likes received by each recipe.
7. Generate reports on recipe likes and popularity.
8. Log out from the admin account.

## Note
Here are some additional guidelines and considerations for the project:

- Design the database schema using MySQL to capture information related to users, recipes, and likes. Maintain appropriate relationships and constraints between tables, such as foreign keys and unique constraints.
- Use Hibernate as the ORM framework to map Java objects to database tables, providing a seamless integration between the application and the database.
- Create an ER-Diagram to visualize the database structure and relationships.
- Develop the project in a modular manner, following best practices to ensure reusability and scalability.

Feel free to explore the code and adapt it to your specific requirements. Enjoy managing and organizing your recipes with the Recipe Management System!
