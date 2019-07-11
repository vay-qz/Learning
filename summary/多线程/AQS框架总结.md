# 总结

在这里补充一下AbstractQueueSynchronizer的类图

![](./pic/AQS.png)

其中Node节点的waitStatus只会有5个值，nextWaiter只会有SHARE和EXCLUSIVE两个值