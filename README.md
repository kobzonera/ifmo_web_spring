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

### Использование

Веб-форма при GET запросе /authorize служит для регистрации и авторизации пользователей. 

## OAUTH2
Для запроса access_token:

```
GET /oauth/token?grant_type=password&username=admin&password=kobzon
```

При любых других запросах требуется проверка аутентфиикации, например:

```
/create?access_token=501f82d3-dfe5-49e1-8ceb-b6cd6cc97cc8
```

## UserController:
Регистрация нового пользователя

```
POST /register
Body:
username
password
```

Выход из аккаунта (remove token)

```
GET /logout
```

## BlogController:
Создание новой записи

```
POST /create 
Body:
title
body
```
Просмотр всех записей

```
GET /posts 
```

Просмотр записи по ID 

```
GET /post/{id} 
```

Просмотр всех записей, созданных USERNAME

```
GET /posts/{username} 
```

Удаление записи (доступ только для ADMIN или CREATOR)
 
 ```
DELETE /post/{id}
```


### Stack 

* Spring Boot
* Spring Security (mongodb/mysql)
* Spring Data (OAUTH2 Server)
* VueJS + Axios
* SkeletonCSS (AuthForm)

### Aвтор

* **Алексей Кобзев** - [kobzonera](https://github.com/kobzonera)
