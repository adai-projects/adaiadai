
  About Entity
================================================================================

实体分类，主要用于建表，根据属性的进行复用。

- 前提，ID是所有实体用户有的属性
- 属性的添加，分两个方面，必须有添加，非必须的不添加；
  + 如果是可有可无，那就不添加;
  + 对于时间属性，如果是频繁的创建和删除，或者很容易创建和删除，那就不添加时间属性；
  + 考虑从大的方向，不必为了可能存在的一个问题，添加属性，可以通过具体实例实体单独添加；

## Entity Overview

| entity      | classfy   | Note                      |
|:------------|:----------|:--------------------------|
| User        | domain    |                           |
| Blog        | domain    |                           |
| Tag         | aspect    |                           |
| Topic       | aspect    |                           |
| Axis        | aspect    |                           |
| TopicAxis   | aspect    |                           |



## *Domain

主体实体，比如，用户，博客等，

- 其实用户的存在是比较模糊的，不容易去定位

用户可以存在，也可以不存在，理解的角度；
强用户作用，用户创建博客，所有的其他实体都是和用户息息相关；
弱用户作用，一些关系实体对象，可以没有用户的存在，或者没有那么多必要性；
再比如在系统配置中，用户的作用并没有那么重要；

### Field Summary

| attribute   | description   | Note                      |
|:------------|:--------------|:--------------------------|
| id          | ID            | unique constraint         |
| gmtCreate   | create time   |                           |
| gmtModified | update time   |                           |




## *Aspect

方面实体，

| attribute   | description         | Note                      |
|:------------|:--------------------|:--------------------------|
| id          | ID                  | unique constraint         |
| name        | Name as a symbol    | e.g. tag.name, topic.name |
| description | description of name |                           |

## *Relate

关系实体，

| attribute   | description         | Note                      |
|:------------|:--------------------|:--------------------------|
| id          | ID                  | unique constraint         |


create_time: 2019-04-15 03:00
update_time: 2019-04-15 09:56
