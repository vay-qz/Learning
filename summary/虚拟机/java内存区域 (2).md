# Java内存区域

在我们的日常编程中，常常会有这样的疑问

- new的对象究竟储存在哪里呢？

- 对象究竟是根据哪里的模板生成的呢？

- 为什么我进入一个方法并执行完毕之后还能返回我进入的位置呢？

  ......

那么本文就来从Java内存区域的角度来说一说这些问题

[TOC]

## 内存区域介绍

![1557325334502](./pic/内存区域.png)

如上图所示，Java的运行时区域分为如上5个部分

1. Heap：Java堆。用于存放对象实例和数组，分为年轻代和老年代，年轻代又可分为survior区和Eden区

2. 虚拟机栈：最小单元为栈帧，每个方法的开始和完成就对应着一个栈帧的入栈与出栈操作，每个虚拟机栈都是线程独立的。在栈顶的栈帧被称为当前栈帧，当前线程只处理当前栈帧。在虚拟机栈中保存了动态链接、操作数栈、局部变量表、返回地址等信息。

   > - 动态链接：符号引用在编辑阶段就转为直接引用的称为静态连接，在程序运行时解析为直接引用的程为动态链接
   >
   > - 操作数栈：存放操作数
   >
   >   > 一条add指令需要两个操作数，这两个操作数就会放在操作数栈中，当执行add时进行出栈相加操作
   >
   > - 局部变量表：存储方法参数信息以及方法中定义的局部变量
   >
   > - 返回地址：正常返回时取PC计数器中的地址，异常返回则由异常处理器处理

3. 本地方法栈：native方法所使用的栈

4. 程序计数器：记录当前线程执行到了哪里，线程独立

5. 方法区：存储每个类的结构如运行时常量池，属性和方法数据

除此之外还有两部分区域是我们需要关注的

1. 运行时常量池：运行时常量池属于方法区的一部分，在《Java虚拟机规范》中对这部分的定义是这样的

   > A *run-time constant pool* is a per-class or per-interface run-time representation of the `constant_pool` table in a `class` file

   也就是说运行时常量池是每个类或接口的class文件中的常量池的运行时体现

2. 直接内存：直接内存并不属于运行时区域，但是在开发过程中我们确实可以用到，而且在某些情况下效率会比使用堆内存效率更高//FIXME

## 溢出测试

在我们日常工作中，可能会因为这样那样的原因而导致一些溢出。而同样的代码在不同的jdk版本执行下却可能出现不同的错误。

- 字符串常量池溢出

  ```java
      /**
       * 测试字符串常量池溢出，简介验证字符串常量池的位置
       * <p>
       *     -Xms20m
       *     -Xmx20m
       *     -XX:PermSize=10m
       *     -XX:MaxPermSize=10m
       *     -XX:-UseGCOverheadLimit  //一定要加，否则报的就是GC ovenhead limit exceeded
       * </p>
       * <p>
       *     预期
       *      1.6永久代溢出
       *      1.7/1.8堆溢出
       * </p>
       * <p>
       *     结论：
       *      1.6中字符串常量池在永久代中
       *      1.7、1.8在堆中
       * </p>
       */
      public void stringPoolOOM() {
          List<String> list = new ArrayList<String>();
          int i = 10000;
          while(true){
              System.out.println(i);
              list.add(String.valueOf("String" + i++).intern());
          }
      }
  ```

  1.6溢出错误信息

  ![1557411180971](./pic/1.6string.png)

  1.7/1.8溢出错误信息

  ![1557411258305](./pic/1.7and1.8string.png)

  > 由此可见，字符串常量池在1.6中存放在永久代中，1.7和1.8存放在堆中

- 类信息溢出

  ```java
      /**
       * 测试class信息溢出，间接测试方法区的实现方式是永久代还是元空间
       * <p>
       *     jdk1.6/1.7
       *      -XX:PermSize=10m
       *      -XX:MaxPermSize=10m
       *     jdk1.8
       *      -XX:MetaspaceSize=10m
       *      -XX:MaxMetaspaceSize=10m
       * </p>
       * <p>
       *     预期
       *      1.6/1.7实现方式为永久代
       *      1.8为元空间
       * </p>
       */
      public void classInfosOOM() {
          while (true) {
              Enhancer enhancer = new Enhancer();
              enhancer.setSuperclass(OOMTest.class);
              enhancer.setUseCache(false);
              enhancer.setCallback(new MethodInterceptor() {
                  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                      return proxy.invokeSuper(obj, args);
                  }
              });
              enhancer.create();
          }
      }
  ```

  1.6/1.7类信息溢出图

  ![1557412056590](./pic/1.6and1.7class.png)

  1.8类信息溢出图

  ![1557412383285](./pic/1.8class.png)

以上，我们讨论的主要是1.6/1.7/1.8三个版本的jdk，在1.6与1.7中，永久代是方法区的主要实现，但是方法区并不等同于永久代，在1.6中，永久代还包括了字符串常量池，如果字符串常量池过大同样会引起永久代的溢出，而在jdk1.7中，字符串常量池被移到了堆中。从jdk1.8开始，永久代被移除，类信息转移到元空间中进行存储。

## Q&A

运行时常量池中存放的时字面量和符号引用，字符串常量池中存放的是字符串，这二者有什么关系？

元空间和直接内存都使用的是本地内存，二者有什么关系吗？

jdk6中的方法区所存储的东西在jdk7和jdk8分别做了哪些转移？

## 结论

常量池在方法区中

字符串常量池和常量池是两个东西，没有关系