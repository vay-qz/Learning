# ThreadGroup

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

| 方法名      | 参数                            | 作用                                   | 备注                                                         |
| ----------- | ------------------------------- | -------------------------------------- | ------------------------------------------------------------ |
| ThreadGroup | String name                     | 创建一个线程组                         | 父线程组是当前线程的线程组<br />最大优先级、守护线程状态、虚拟机允许丢弃状态同父线程组 |
| ThreadGroup | ThreadGroup parent, String name | 创建一个线程组                         | 最大优先级、守护线程状态、虚拟机允许丢弃状态同父线程组       |
| parentOf    | ThreadGroup g                   | 测试当前线程组是否是g或g的父辈线程组   |                                                              |
| checkAccess |                                 | 测试当前线程是否有权限修改这个线程组   |                                                              |
| activeCount |                                 | 查询当前线程组及其子线程组的存活线程数 |                                                              |
| enumerate   | Thread list[]                   |                                        |                                                              |
|             |                                 |                                        |                                                              |
|             |                                 |                                        |                                                              |
|             |                                 |                                        |                                                              |
|             |                                 |                                        |                                                              |

