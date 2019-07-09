# AQS框架——CLH Queue

AbstractQueueSynchronizer抽象类就是AQS框架，这个类为使用Java类实现锁提供了规范与思路。要理解AQS框架，最重要的是理解“CLH Queue”，这是队列的数据结构为双向链表，链表上每个节点的值只有固定的5个，分别代表不同的涵义，接下来我们就从CLH队列为切入点了解AQS

既然CLH Queue是一个双向链表，那么AbstractQueueSynchronizer类就一定符合双向链表的两个特征

- 在AbstractQueueSynchronizer类中一定保存了其首节点和尾节点
- 每个节点一定保存了其前序节点、后序节点以及自己的值

于是乎，我们在AbstractQueueSynchronizer类中找到了如下私有域

| 域名                 | 类型         | 备注     |
| -------------------- | ------------ | -------- |
| first                | Node         | 首节点   |
| last                 | Node         | 尾节点   |

而Node节点的域也果然如我们所料

| 域名       | 类型         | 备注     |
| ---------- | ------------ | -------- |
| prev       | Node         | 前序节点 |
| next       | Node         | 后续节点 |
| waitStatus | voletite int | 状态     |

上文中提到，Node节点的值有且只有5个，每个值都有特殊的含义，那么接下来我们就来看看这些值具体有什么意义呢？

```java
/** waitStatus值表明当前线程已取消 */
static final int CANCELLED =  1;
/** waitStatus值表明后继线程应该被释放 */
static final int SIGNAL    = -1;
/** waitStatus值表明当前线程在condition中等待 */
static final int CONDITION = -2;
/** waitStatus值表明下一个请求共享的线程应该被无条件传播 */
static final int PROPAGATE = -3;
```

上边那四个再加上一个无意义的0值，就是waitStatus所可以取到的值

开头我们说到，AQS框架为使用Java实现锁提供了规范和思路，那么它到底是如何规范的呢？首先我们抛出三个问题

1. 如何实现上锁？
2. 如何实现A获取到锁之后其余线程获取失败并等待？
3. 在A释放锁后如何通知等待线程可以获取锁了？

在AQS框架中