  统一资源定位系统（Uniform Resource Locator;URL）
===============================================================================

> 关于URL的涉及规范


## 标签

| Method | Endpoint          | Note                        | True/False |
|:-------|:------------------|:----------------------------|:-----------|
| POST   | /tags             | create tag                  | T          |
| POST   | /tags/inString    | create tag in string        | T          |
| PUT    | /tags/{id}        | update the full of tag      | F          |
| PATCH  | /tags/{id}        | update the part of tag      | F          |
| DELETE | /tags/{id}        | delete tag by id            | T          |
| GET    | /tags             | list all tags               | T          |
| GET    | /tags/inBtn       | list all tags in button     | T          |
| GET    | /tags/{id}        | find tag by id              | T          |
| GET    | /tags/create      | return the tag create page  | T          |
| GET    | /tags/create/input| return the tag input page   | T          |
| GET    | /tags/update      | return the tag update page  | T          |

/tag
/tags/{tagName}
