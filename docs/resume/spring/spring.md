# Spring

**Spring framework 6.0 特点**
- AOT编译：Ahead-Of-Time，即预先编译，与我们熟知的Just-In-Time（JIT，即时编译）来说 AOT 带来的好处是 JVM 可以直接加载这些已经预编译成二进制码的类信息，可以直接调用，而无需再将其运行时编译成二进制码。因为 AOT 不占用运行时间，可以做一些较耗时的优化，从而显著的加快程序的启动。避免在程序运行时的编译性能消耗和内存消耗，可以在程序运行初期就达到最高性能。
- Spring native: 在新版本中引入了Spring Native，有了Spring Native ，Spring可以不再依赖Java虚拟机，而是基于 GraalVM 将 Spring 应用程序编译成原生镜像（native image），提供了一种新的方式来部署 Spring 应用，这种部署 Spring 的方式是云原生友好的。
- 虚拟线程

## 核心模块
- spring-core：Spring 框架基本的核心工具类。
- spring-beans：提供对 bean 的创建、配置和管理等功能的支持。
- spring-context：提供对国际化、事件传播、资源加载等功能的支持。
- spring-expression：提供对表达式语言（Spring Expression Language） SpEL 的支持，只依赖于 core 模块，不依赖于其他模块，可以单独使用。


**AOP**
- spring-aspects：该模块为与 AspectJ 的集成提供支持。
- spring-aop：提供了面向切面的编程实现。
- spring-instrument：提供了为 JVM 添加代理（agent）的功能。 具体来讲，它为 Tomcat 提供了一个织入代理，能够为 Tomcat 传递类文 件，就像这些文件是被类加载器加载的一样。没有理解也没关系，这个模块的使用场景非常有限。

**Data Access/Integration**
- spring-jdbc：提供了对数据库访问的抽象 JDBC。不同的数据库都有自己独立的 API 用于操作数据库，而 Java 程序只需要和 JDBC API 交互，这样就屏蔽了数据库的影响。
- spring-tx：提供对事务的支持。
- spring-orm：提供对 Hibernate、JPA、iBatis 等 ORM 框架的支持。
- spring-oxm：提供一个抽象层支撑 OXM(Object-to-XML-Mapping)，例如：JAXB、Castor、XMLBeans、JiBX 和 XStream 等。
- spring-jms : 消息服务。自 Spring Framework 4.1 以后，它还提供了对 spring-messaging 模块的继承。

**Spring Web**
- spring-web：对 Web 功能的实现提供一些最基础的支持。
- spring-webmvc：提供对 Spring MVC 的实现。
- spring-websocket：提供了对 WebSocket 的支持，WebSocket 可以让客户端和服务端进行双向通信。
- spring-webflux：提供对 WebFlux 的支持。WebFlux 是 Spring Framework 5.0 中引入的新的响应式框架。与 Spring MVC 不同，它不需要 Servlet API，是完全异步。

## IoC
IoC（Inversion of Control:控制反转）是一种设计思想，而不是一个具体的技术实现。IoC 的思想就是将原本在程序中手动创建对象的控制权，交由 Spring 框架来管理。不过， IoC 并非 Spring 特有，在其他语言中也有应用。
为什么叫控制反转？
- 控制：指的是对象创建（实例化、管理）的权力
- 反转：控制权交给外部环境（Spring 框架、IoC 容器）
在 Spring 中， IoC 容器是 Spring 用来实现 IoC 的载体， IoC 容器实际上就是个 Map（key，value），Map 中存放的是各种对象。

依赖注入（Dependency Injection，简称 DI）
## AOP
AOP(Aspect-Oriented Programming:面向切面编程)能够将那些与业务无关，却为业务模块所共同调用的逻辑或责任（例如事务处理、日志管理、权限控制等）封装起来，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可拓展性和可维护性。
Spring AOP 就是基于动态代理的，如果要代理的对象，实现了某个接口，那么 Spring AOP 会使用 JDK Proxy，去创建代理对象，而对于没有实现接口的对象，就无法使用 JDK Proxy 去进行代理了，这时候 Spring AOP 会使用 Cglib 生成一个被代理对象的子类来作为代理，如下图所示：

Spring AOP 和 AspectJ AOP 有什么区别？Spring AOP 属于运行时增强，而 AspectJ 是编译时增强。 Spring AOP 基于代理(Proxying)，而 AspectJ 基于字节码操作(Bytecode Manipulation)。

**Spring Bean**

简单来说，Bean 代指的就是那些被 IoC 容器所管理的对象。

**@Component 和 @Bean 的区别是什么？**
- @Component 注解作用于类，而@Bean注解作用于方法。
- @Component通常是通过类路径扫描来自动侦测以及自动装配到 Spring 容器中（我们可以使用 @ComponentScan 注解定义要扫描的路径从中找出标识了需要装配的类自动装配到 Spring 的 bean 容器中）。 @Bean 注解通常是我们在标有该注解的方法中定义产生这个 bean,@Bean告诉了 Spring 这是某个类的实例，当我需要用它的时候还给我。
- @Bean 注解比 @Component 注解的自定义性更强，而且很多地方我们只能通过 @Bean 注解来注册 bean。比如当我们引用第三方库中的类需要装配到 Spring容器时，则只能通过 @Bean来实现。

**@Autowired 和 @Resource 的区别是什么？**
- Autowired 属于 Spring 内置的注解,byType->byName
- @Resource 属于 JDK 提供的注解 byName->byType

## 设计模式

- https://javaguide.cn/system-design/framework/spring/spring-design-patterns-summary.html

## 循环依赖

Spring 框架通过使用三级缓存来解决循环依赖的问题，确保即使在循环依赖的情况下也能正确创建 Bean。

简单来说，Spring 的三级缓存包括：
- 一级缓存（singletonObjects）：存放最终形态的 Bean（已经实例化、属性填充、初始化），单例池，为“Spring 的单例属性”⽽⽣。一般情况我们获取 Bean 都是从这里获取的，但是并不是所有的 Bean 都在单例池里面，例如原型 Bean 就不在里面。
- 二级缓存（earlySingletonObjects）：存放过渡 Bean（半成品，尚未属性填充），也就是三级缓存中ObjectFactory产生的对象，与三级缓存配合使用的，可以防止 AOP 的情况下，每次调用ObjectFactory#getObject()都是会产生新的代理对象的。
- 三级缓存（singletonFactories）：存放ObjectFactory，ObjectFactory的getObject()方法（最终调用的是getEarlyBeanReference()方法）可以生成原始 Bean 对象或者代理对象（如果 Bean 被 AOP 切面代理）。三级缓存只会对单例 Bean 生效。

**Spring 创建 Bean 的流程：**
- 先去 一级缓存 singletonObjects 中获取，存在就返回；
- 如果不存在或者对象正在创建中，于是去 二级缓存 earlySingletonObjects 中获取；
- 如果还没有获取到，就去 三级缓存 singletonFactories 中获取，通过执行 ObjectFacotry 的 getObject() 就可以获取该对象，获取成功之后，从三级缓存移除，并将该对象加入到二级缓存中。

## 事务
