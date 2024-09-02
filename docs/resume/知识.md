# Knowledge

- 框架：Spring、Spring Cloud、SpringMVC、Spring Boot、Mybatis
- 中间件：RabbitMQ、Kafka
- 数据库：MySQL/PGSQL、SQL 优化、索引优化、分库分表技术
  - NoSQL：Redis\MongoDB\
- 搜索：ES
- 缓存：Redis\Memcached
- 消息队列：RocketMQ
- Java: IO、多线程、集合、JVM、GC、反射、NIO
- 缓存、分布式、网络编程、缓存、消息
- 高并发、高可用、高负载
- 设计原则、设计模式、数据结构、算法分析
- DDD
- tomcat\nginx
- HTTP、RESTful
- docker\k8s
- linux
- maven\gradle\git\idea
- 前端：vue\
- 云原生?
- 语言：Python、Shell、golang

- 复杂度？

## 业务

- 搜索/推荐/广告
- 地图
- 效能
- 财务
- 风控

## 数据结构（Data Structure）

### 数组（Array）

- 索引
- 数据随机访问

### 链表（LinkedList）

- 线性表
- 指针

**分类**

> 单链还是双链表，是否循环

- 单链表
- 双向链表
- 循环链表
- 双向循环链表

### 栈 (Stack)

> 只允许在有序的线性数据集合的一端（称为栈顶 top）进行加入数据（push）和移除数据（pop）。因而按照 **后进先出（LIFO, Last In First Out）** 的原理运作。**在栈中，push 和 pop 的操作都发生在栈顶。**

### 队列（Queue）

> **先进先出 (FIFO，First In, First Out)** 的线性表。

### 图

- 顶点、边、度



## 资料

### 消息队列

- 优点：、异步、削峰
- 系统可用性降低、系统复杂度提高、一致性问题
- 

1. ### 为什么使用消息队列？

#### RabbitMQ

RabbitMQ 有三种模式：单机模式、普通集群模式、镜像集群模式。

#### Kafka

Kafka 一个最基本的架构认识：由多个 broker 组成，每个 broker 是一个节点；你创建一个 topic，这个 topic 可以划分为多个 partition，每个 partition 可以存在于不同的 broker 上，每个 partition 就放一部分数据。

这就是**天然的分布式消息队列**，就是说一个 topic 的数据，是**分散放在多个机器上的，每个机器就放一部分数据**。

### 搜索引擎

### 缓存

主要作用：

- 高性能：对于一些需要复杂操作耗时查出来的结果，且确定后面不怎么变化，但是有很多读请求，那么直接将查询出来的结果放在缓存中，后面直接读缓存就好
- 高并发：缓存是走内存的，内存天然就支撑高并发

副作用：

#### 如何保证缓存与数据库的双写一致性

**Cache Aside Pattern**

最经典的缓存+数据库读写的模式，就是 Cache Aside Pattern。

- 读的时候，先读缓存，缓存没有的话，就读数据库，然后取出数据后放入缓存，同时返回响应。
- 更新的时候，**先更新数据库，然后再删除缓存**。



## 问题

1. 主从架构（非分布式）和分布式架构
   1. 



## 名词

HA(High Availability, 高可用性) 