# ConcurrentHashMap
> JDK1.7之前的ConcurrentHashMap使用分段锁机制实现，JDK1.8则使用数组+链表+红黑树数据结构和CAS原子操作实现ConcurrentHashMap

- HashTable : 使用了synchronized关键字对put等操作进行加锁;
- ConcurrentHashMap JDK1.7: 使用分段锁机制实现;ConcurrentHashMap 
- JDK1.8: 则使用数组+链表+红黑树数据结构和CAS原子操作实现

**1.7**
在JDK1.5~1.7版本，Java使用了分段锁机制实现ConcurrentHashMap.
简而言之，ConcurrentHashMap在对象中保存了一个Segment数组，即将整个Hash表划分为多个分段；而每个Segment元素，即每个分段则类似于一个Hashtable；这样，在执行put操作时首先根据hash算法定位到元素属于哪个Segment，然后对该Segment加锁即可。因此，ConcurrentHashMap在多线程并发编程中可是实现多线程put操作。接下来分析JDK1.7版本中ConcurrentHashMap的实现原理。

**1.8**

在JDK1.7之前，ConcurrentHashMap是通过分段锁机制来实现的，所以其最大并发度受Segment的个数限制。
因此，在JDK1.8中，ConcurrentHashMap的实现原理摒弃了这种设计，而是选择了与HashMap类似的数组+链表+红黑树的方式实现，而加锁则采用CAS和synchronized实现
