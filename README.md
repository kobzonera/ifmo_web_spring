# Spring Project

### Установка зависимостей

Используйте [Spring Initializr](https://start.spring.io/) для создания проекта. 
В проекте применяются **Dependencies**:

```
* web
* thymeleaf
* oauth2
* data-jpa
* mysql-connector-java
```

### Настройка приложения

Сконфигурируйте приложение с помощью **application.properties**

```
server.port=8099
spring.mandatory-file-encoding=UTF-8
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/spring_project_db?autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=kobzon
```

## Использование

Веб-форма при GET запросе /authorize служит для регистрации и авторизации пользователей. 

UserController:
```
POST запрос /register - регистрация нового пользователя
Body:
username
password

GET запрос /logout - выход из аккаунта (remove token)
```

BlogController:
```
POST запрос /create - создание новой записи
Body:
title
body

GET запрос /posts - просмотр всех записей
GET запрос /post/{id} - просмотр записи по ID 
GET запрос /posts/{username} - просмотр всех записей, созданных USERNAME
DELETE запрос /post/{id} - удаление записи (доступ только для ADMIN или CREATOR)
```

## Stack 

* Spring Boot
* Spring Security (mongodb/mysql)
* Spring Data (OAUTH2 Server)
* VueJS + Axios
* SkeletonCSS (AuthForm)

## Authors

* **Алексей Кобзев** - [kobzonera](https://github.com/kobzonera)
