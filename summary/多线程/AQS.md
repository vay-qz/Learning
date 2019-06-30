# AQS框架

说起Java并发编程就不得不提AQS，那么什么是AQS呢？AQS是java.util.concurrent包中的一个虚拟类——AbstractQueuedSynchronizer。这个类为concurrent包中的同步类提供了基础实现思路。

既然说到并发编程，那么就离不开线程的暂停与执行。在Java中，有且仅有四种方式使线程暂停

- Thread类中的sleep等方法
- Object类中的wait方法
- 竞争synchronized锁
- LockSupport类中的park方法

AQS框架中的线程暂停使用的就是第四种——LockSupport#park方法，且通过实现Condition接口间接实现了第二种

在AQS框架中，我们维护一个节点有状态区分的双向链表，这个双向链表称为CLH队列。

在AQS框架中，有两个内部类

- Node
- ConditionObject

前者用来实现CLH列表，后者则间接实现Object#wait和Object#notify、Object#notifyAll

在AQS框架中有这些方法可供使用

请求锁的方法

acquire

tryacquire

请求共享锁的方法

acquireShare

释放锁的方法

release

在AQS框架中使用到了模板方法模式