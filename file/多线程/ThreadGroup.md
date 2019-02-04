# ThreadGroup
[TOC]
#### ThreadGroup的域

| 名称              | 备注         | 发布情况 |
| ----------------- | ------------ | -------- |
| parent            | 父线程组     | get      |
| name              | 名字         | get      |
| maxPriority       | 最大优先级   | √        |
| destroyed         | 是否销毁     | get      |
| daemon            | 是否守护     | √        |
| vmAllowSuspension |              |          |
| nUnstartedThreads | 未开始线程数 |          |
| nthreads          | 存活线程数   |          |
| threads[]         | 线程         |          |
| ngroups           | 子线程组数   |          |
| groups[]          | 子线程组     |          |

#### 常用方法

| 方法名            | 参数                                | 作用                                                         | 备注                                                         |
| ----------------- | ----------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ThreadGroup       | String name                         | 创建一个线程组                                               | 父线程组是当前线程的线程组<br />最大优先级、守护线程状态、虚拟机允许丢弃状态同父线程组 |
| ThreadGroup       | ThreadGroup parent, String name     | 创建一个线程组                                               | 最大优先级、守护线程状态、虚拟机允许丢弃状态同父线程组       |
| parentOf          | ThreadGroup g                       | 测试当前线程组是否是g或g的父辈线程组                         |                                                              |
| checkAccess       |                                     | 测试当前线程是否有权限修改这个线程组                         |                                                              |
| activeCount       |                                     | 查询当前线程组及其子线程组的存活线程数                       |                                                              |
| enumerate         | Thread list[], boolean recurse      | 将此线程组中每个存活的线程复制到该数组中，如果recurse=true，该线程组的子线程组中的存活线程也会被移到这个数组中， | 如果数组不够大，那溢出的线程会被忽略                         |
| activeGroupCount  |                                     | 返回存活的线程组及其子线程组的数量                           |                                                              |
| enumerate         | ThreadGroup list[], boolean recurse | 将此线程组中每个存活的子线程组复制到该线程组中，如果recurse=true，该子线程组的子线程组中的存活线程组也会被复制到这个线程组中， | 如果数组不够大，那溢出的线程组会被忽略                       |
| interrupt         |                                     | 停止线程组中的所有线程                                       | 同样作用于子线程组中的线程                                   |
| ~~stop            |                                     | 停止线程组中的所有线程                                       | 弃用，原因同Thread.stop                                      |
| destroy           |                                     | 销毁这个线程组及其子线程组，这个线程组必须为空，说明这个线程组中的所有的线程都已经停止了 |                                                              |
| uncaughtException |                                     |                                                              | 使用Thread.UncaughtExceptionHandler                          |

#### 与thread的关联

- 线程初始化时，nUnstartedThreads++
- 线程start时，nUnstartedThreads--，threads++，线程加入threads[]
- 线程的未捕获异常为空时返回线程组未捕获异常

