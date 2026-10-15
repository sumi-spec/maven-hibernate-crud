# Maven + Hibernate CRUD Project

A simple Java 25 + Maven + Hibernate ORM + MySQL project.

## Project structure

- `Student` entity
- `Course` entity
- DAO classes for database operations
- Hibernate configuration
- CRUD examples
- MySQL database created automatically if it does not exist

## Requirements

1. JDK 25
2. Maven
3. MySQL Server / XAMPP MySQL

## MySQL setup

Start MySQL. The default configuration in `hibernate.cfg.xml` uses:

- Host: localhost
- Port: 3306
- User: root
- Password: root
- Database: hibernate_demo

If your MySQL password is different, set `DB_PASSWORD` before running the application.
The configuration file's `pass123` value is used when the environment variable is not set.

The database `hibernate_demo` will be created automatically because of:
`createDatabaseIfNotExist=true`

## Run

Open terminal in the project folder:

```text
$env:JAVA_HOME = 'D:\Tools\openjdk-25\jdk-25.0.2'
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
$env:DB_USER = 'root'
$env:DB_PASSWORD = '<your-mysql-password>'
mvn clean install
mvn exec:java
```

You should see Hibernate SQL and Student/Course records in the console.

## If Maven is not recognized

Install Maven and make sure `mvn -version` works.

## Important

If port 3306 is already used by another MySQL installation, use the port of your running MySQL server in `hibernate.cfg.xml`.
