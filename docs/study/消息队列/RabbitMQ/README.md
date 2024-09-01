# RabbitMQ

>

## 1. 简介

## 2. 概念

### 2.1. 生产者与消费者

- 生产者（Producer）：生产消息的一方；
- 消费者（Consumer）：消费消息的一方。

消息一般由两部分组成，`消息头`（或者说是标签 Label）和 `消息体`。
消息体也可以称为 payload ，消息体是不透明的，而消息头则由一系列的可选属性组成，这些属性包括 `路由键（routing-key）`、相对于其他消息的 `优先权（priority）`、指出该消息可能需要`持久性存储（delivery-mode）`等。生产者把消息交由 `RabbitMQ` 后，`RabbitMQ` 会根据消息头把消息发送给感兴趣的 `消费者（Consumer）`。

### 2.2. 交换器（Exchange）

在 `RabbitMQ` 中，消息并不是直接被投递到消息 `队列（Queue）` 中的，中间还必须经过 `交换器（Exchange）` 这一层，`交换器` 会把我们的消息分配到对应的 `队列（Queue）` 中。

Exchange(交换器) 用来接收生产者发送的消息并将这些消息路由给服务器中的队列中，如果路由不到，或许会返回给 Producer(生产者) ，或许会被直接丢弃掉 。这里可以将RabbitMQ中的交换器看作一个简单的实体。

RabbitMQ 的 Exchange(交换器) 有4种类型，不同的类型对应着不同的路由策略：direct(默认)，fanout, topic, 和 headers，不同类型的Exchange转发消息的策略有所区别。这个会在介绍 Exchange Types(交换器类型) 的时候介绍到。

### 2.3. 队列（Queue）

消息`队列`用来保存消息直到发送给消费者。它是消息的容器，也是消息的终点。
一个消息可投入一个或多个队列。消息一直在队列里面，等待消费者连接到这个队列将其取走。

RabbitMQ 中消息只能存储在 `队列` 中，这一点和 `Kafka` 这种消息中间件相反。
`Kafka` 将消息存储在主题（topic）这个逻辑层面，而相对应的队列逻辑只是主题实际存储文件中的位移标识。
RabbitMQ 的生产者生产消息并最终投递到队列中，消费者可以从队列中获取消息并消费。

多个消费者可以订阅同一个队列，这时队列中的消息会被平均分摊（Round-Robin，即轮询）给多个消费者进行处理，而不是每个消费者都收到所有的消息并处理，这样避免的消息被重复消费。

### 2.4. 中间件（Broker）

对于 RabbitMQ 来说，一个 RabbitMQ Broker 可以简单地看作一个 RabbitMQ 服务节点，或者RabbitMQ服务实例。大多数情况下也可以将一个 RabbitMQ Broker 看作一台 RabbitMQ 服务器。

### 2.5. 交换器类型（ Exchange Types）

RabbitMQ 常用的 Exchange Type 有 fanout、direct、topic、headers 这四种（AMQP规范里还提到两种 Exchange Type，分别为 system 与 自定义，这里不予以描述）。

1. fanout: fanout 类型的Exchange路由规则非常简单，它会把所有发送到该Exchange的消息路由到所有与它绑定的Queue中，不需要做任何判断操作，所以 fanout 类型是所有的交换机类型里面速度最快的。fanout 类型常用来广播消息。

2. direct: direct 类型的Exchange路由规则也很简单，它会把消息路由到那些 Bindingkey 与 RoutingKey 完全匹配的 Queue 中。

3. topic: 前面讲到direct类型的交换器路由规则是完全匹配 BindingKey 和 RoutingKey ，但是这种严格的匹配方式在很多情况下不能满足实际业务的需求。topic类型的交换器在匹配规则上进行了扩展，它与 direct 类型的交换器相似，也是将消息路由到 BindingKey 和 RoutingKey 相匹配的队列中，但这里的匹配规则有些不同，它约定：
- RoutingKey 为一个点号“．”分隔的字符串（被点号“．”分隔开的每一段独立的字符串称为一个单词），如 “com.rabbitmq.client”、“java.util.concurrent”、“com.hidden.client”;
- BindingKey 和 RoutingKey 一样也是点号“．”分隔的字符串；
- BindingKey 中可以存在两种特殊字符串“”和“#”，用于做模糊匹配，其中“”用于匹配一个单词，“#”用于匹配多个单词(可以是零个)。
