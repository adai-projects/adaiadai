API
==============================
> API

### root
### UserController

| Method | Endpoint          | Note                        | True/False |
|:-------|:------------------|:----------------------------|:-----------|
| GET    | /users            | list all users              | T          |
| GET    | /users/{username} | find user by username       | T          |
| POST   | /users            | create user                 | T          |
| PUT    | /users/{id}       | update the full of user     | F          |
| PATCH  | /users/{id}       | update the part of user     | F          |
| DELETE | /users/{id}       | delete user by id           | T          |
| GET    | /users/create     | return the user create page | T          |
| GET    | /users/update     | return the user update page | T          |

### BlogController

| Method | Endpoint          | Note                        | True/False |
|:-------|:------------------|:----------------------------|:-----------|
| GET    | /blogs            | list all blogs              | T          |
| GET    | /blogs/{id}       | find blog by id             | T          |
| POST   | /blogs            | create blog                 | T          |
| PUT    | /blogs/{id}       | update the full of blog     | F          |
| PATCH  | /blogs/{id}       | update the part of blog     | F          |
| DELETE | /blogs/{id}       | delete blog by id           | T          |
| GET    | /blogs/create     | return the blog create page | T          |
| GET    | /blogs/update     | return the blog update page | T          |

### TopicController

| Method | Endpoint          | Note                          | True/False |
|:-------|:------------------|:------------------------------|:-----------|
| GET    | /topics           | list all topics              | T           |
| GET    | /topics/{id}      | find topic by id             | T           |
| POST   | /topics           | create topic                 | T           |
| PUT    | /topics/{id}      | update the full of topic     | F           |
| PATCH  | /topics/{id}      | update the part of topic     | F           |
| DELETE | /topics/{id}      | delete topic by id           | T           |
| GET    | /topics/create    | return the topic create page | T           |
| GET    | /topics/update    | return the topic update page | T           |

### TypeController

| Method | Endpoint          | Note                        | True/False |
|:-------|:------------------|:----------------------------|:-----------|
| GET    | /types            | list all types              | T          |
| GET    | /types/{id}       | find type by id             | F          |
| POST   | /types            | create type                 | T          |
| PUT    | /types/{id}       | update the full of type     | F          |
| PATCH  | /types/{id}       | update the part of type     | F          |
| DELETE | /types/{id}       | delete type by id           | T          |
| GET    | /types/create     | return the type create page | T          |
| GET    | /types/update     | return the type update page | T          |
