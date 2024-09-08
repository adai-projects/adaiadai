# Java 线程

## 状态


- 新建(New)： 创建后尚未启动。 
- 可运行(Runnable)：可能正在运行，也可能正在等待 CPU 时间片。包含了操作系统线程状态中的 Running 和 Ready。
- 阻塞(Blocking)：等待获取一个排它锁，如果其线程释放了锁就会结束此状态。
- 无限期等待(Waiting)：等待其它线程显式地唤醒，否则不会被分配 CPU 时间片。
- 限期等待(Timed Waiting)：无需等待其它线程显式地唤醒，在一定时间之后会被系统自动唤醒。
- 死亡(Terminated)：可以是线程结束任务之后自己结束，或者产生了异常而结束。

|                         | 进入方法                                   | 退出方法                                        |
| ----------------------- | ------------------------------------------ | ----------------------------------------------- |
| 限期等待(Timed Waiting) | Thread.sleep()                             | 时间结束                                        |
| 限期等待(Timed Waiting) | 设置了 Timeout 参数的 Object.wait() 方法   | 时间结束 / Object.notify() / Object.notifyAll() |
| 无限期等待(Waiting)     | 没有设置 Timeout 参数的 Object.wait() 方法 | Object.notify() / Object.notifyAll()            |
| 限期等待(Timed Waiting) | 设置了 Timeout 参数的 Thread.join() 方法   | 时间结束 / 被调用的线程执行完毕                 |
| 无限期等待(Waiting)     | 没有设置 Timeout 参数的 Thread.join() 方法 | 被调用的线程执行完毕                            |
| 限期等待(Timed Waiting) | LockSupport.parkNanos() 方法               |                                                 |
| 限期等待(Timed Waiting) | LockSupport.parkUntil() 方法               |                                                 |
| 无限期等待(Waiting)     | LockSupport.park() 方法                    |                                                 |



## 使用

- 实现 Runnable 接口：需要实现 run() 方法。通过 Thread 调用 start() 方法来启动线程。
- 实现 Callable 接口：与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装
- 继承 Thread 类：同样也是需要实现 run() 方法，因为 Thread 类也实现了 Runable 接口。当调用 start() 方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的 run() 方法。

> 实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用。可以说任务是通过线程驱动从而执行的。

## 机制

### Thread.sleep(millisec)

Thread.sleep(millisec) 方法会休眠当前正在执行的线程，millisec 单位为毫秒。

sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理。线程中抛出的其它异常也同样需要在本地进行处理。

### yield()

对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。

## 中断

一个线程执行完毕之后会自动结束，如果在运行过程中发生异常也会提前结束。

### interrupt()

通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。

### interrupted()

如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt() 方法就无法使线程提前结束。

但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。

## 互斥同步

Java 提供了两种锁机制来控制多个线程对共享资源的互斥访问，第一个是 JVM 实现的 synchronized，而另一个是 JDK 实现的 ReentrantLock。

## 协作

当多个线程可以一起工作去解决某个问题时，如果某些部分必须在其它部分之前完成，那么就需要对线程进行协调。

### join()

在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。

### wait() notify() notifyAll()

调用 wait() 使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其它线程会调用 notify() 或者 notifyAll() 来唤醒挂起的线程。

它们都属于 Object 的一部分，而不属于 Thread。

只能用在同步方法或者同步控制块中使用，否则会在运行时抛出 IllegalMonitorStateExeception。

使用 wait() 挂起期间，线程会释放锁。这是因为，如果没有释放锁，那么其它线程就无法进入对象的同步方法或者同步控制块中，那么就无法执行 notify() 或者 notifyAll() 来唤醒挂起的线程，造成死锁。

**wait() 和 sleep() 的区别**

- wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
- wait() 会释放锁，sleep() 不会。
