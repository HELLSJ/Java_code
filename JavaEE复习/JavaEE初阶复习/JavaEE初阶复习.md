

1.CPU要执行的指令是在内存中的

冯诺依曼体系结构的基本设定，把执行和存储分开，解耦合，降低硬件设计的成本

2.CPU要想执行指令，就要先取指令，再解析指令，然后才能执行指令

3.取指令需要从内存中读取指令到CPU的寄存器中。取指令的操作很耗时，开销较大，从内存读取数据这件事跟不上越来越快的CPU了，于是设计出缓存

![](JavaEE复习/JavaEE初阶复习/image/img-20251217.png)

# 进程

进程：每个任务/进程在执行过程中都需要消耗一定的硬件资源，**进程是系统分配资源的基本单位**
## 进程在系统中是如何管理的？

1.**先描述**，使用类/结构体这样的方式，把实体属性给列出来
表示进程信息的结构体，叫做PCB（进程控制块，Process Control Block）
2.**再组织**，使用一定的数据结构，把这些结构体/对象串到一起

**一个单核CPU怎么支持一个多任务操作系统运行？**

分时复用（并发）：先执行进程1的代码，执行一会后让进程1下来，让进程2上；进程2执行一段时间后上进程3
### PCB
#### 核心属性

（1）PID：进程的身份标识，通过一个简单不重复的整数来进行区分
（2）内存指针：内存指针是用于描述和定位进程所申请并被操作系统分配的内存空间的一个标识。它记录了进程可访问内存区域的地址信息，用于指示程序在内存中的具体位置。
（3）文件描述符表
我们的进程经常要访问硬盘，而操作系统把硬盘这样的硬件设备封装成了文件
一个进程要想操作文件，需要先打开文件，就是让进程再文件描述符表中分配一个表项（构造一个结构体）来表示这个文件的相关信息
#### 支持进程调度方法

（1）状态：描述某个进程是否能够去CPU上执行
**就绪状态**：随时准备好去CPU上执行
**阻塞状态**：这个进程当前不方便去CPU上执行，不应该调度它（比如进程在等待IO）
（2）优先级：字面理解就是先调度谁，后调度谁的问题
（3）记账信息：针对每个进程占据了多少CPU的时间进行一个统计，并根据这个统计结果进行进一步的调整调度的策略
（4）上下文：这个是支撑进程调度的重要属性，相当于游戏中的存档和读档

所以就需要在进程调度出CPU之前把当前寄存器中的信息保存到内存中，这个就是**存档**
该进程下次再去CPU上执行的时候再把这些寄存器的信息恢复过来（加载到CPU对应寄存器中），这个过程就是**读档**
## 进程的问题

本质上来说，进程可以解决并发编程的问题
但是有些情况下进程表现不尽如人意
1. 如果请求很多，需要频繁的创建和销毁进程的时候，此时使用多进程编程，系统开销就会很大
2. 一个进程刚刚启动的时候，需要把依赖的代码和数据从磁盘加载到内存中

但是从系统分配一个内存不是件容易事情，因为申请内存的时候需要指定大小，系统内部把各种大小的空闲内存，通过一定的数据结构组织起来。实际申请的时候要去这样的空间中查找，找到大小合适的空间，再进行分配

# 线程

![](image/img-20251222-4.png)

线程称为轻量级进程，保持进程的独立调度执行，同时省去了**分配资源**和**释放资源**带来的额外开销

## 进程和线程的关系

1. 进程包含线程
2. 每个线程是一个独立的执行流，可以执行代码并参与CPU调度中（每个线程都有状态，优先级，记账信息和上下文）
3. 每个线程都有自己的资源，进程中的线程共享一份资源
4. 进程和线程之间，不会相互影响。但是如果同一个进程中某个线程抛出异常，可能导致进程中其他线程异常终止
5. 同一个进程中的线程之间会互相干扰，引起线程安全问题
6. 线程太多会导致调度开销过多的问题
7. 线程是系统**调度执行**的基本单位；进程是系统**分配资源**的基本单位

多线程执行

两个线程并发执行，但是这些线程执行的先后顺序是不确定的。
因为操作系统的内核中有一个调度器模块，这个模块的实现方式是一种类似于随机调度的效果
随机调度？（也是抢占式执行）

1. 一个线程什么时候被调度到CPU上执行，时机是不确定的
2. 一个线程什么时候从CPU上下来，给别的线程让位，时机也是不确定的
### 线程创建
#### 1. 继承Thread，重写run

```java
//1. 创建一个自己的类来继承Thread（在java.lang里面，自动导包）
class MyClass extends Thread{
    @Override
    public void run(){
        System.out.println("hello world");
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        //2. 根据刚才的类创建出实例（线程实例才是真正的线程）
        Thread t = new MyClass();
        //3.调用Thread的start方法，才会真正调用API，在系统内核中创建出线程
        //对于同一个Thread对象来说，start只能调用一次
        t.start();
    }
}
```
这里的run类似于main方法，是一个Java进程的入口方法；不需要程序员手动调用，会在合适的时机（线程创建好了之后），被JVM自动调用执行

这种风格的函数被称为**回调函数**
(回调函数是一种特殊的函数，它作为参数传递给另一个函数，并在被调用函数执行完毕后被调用)

#### 2. 实现Runnable接口，重写run

![](JavaEE复习/JavaEE初阶复习/image/img-20251217-1.png)
#### 3. 继承Thread，重写run，但是使用匿名内部类

```java
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("hello thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        while (true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

#### 4.  第四种方法：实现Runnable，重写run，实现匿名内部类
```java
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("hello runnable");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();
        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```
#### 5. 第五种方法：使用lambda表达式

![](image/img-20251222.png)

**前台线程的运行会阻止进程结束**
**后台线程的运行不会阻止进程结束**

### 线程中断

```java
public class ThreadDemo13 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //isInterrupted 判定标志位
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("我是一个线程, 正在工作中...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程执行完毕!");
        });
 
        t.start();
 
        Thread.sleep(3000);
        // 使用一个 interrupt 方法, 来修改刚才标志位的值，设置标志位
        System.out.println("让 t 线程结束");
        t.interrupt();
    }
}
```
`interupt()`不直接终止线程，而是通过设置中断标志位发送 “需要停止” 的信号，目标线程需主动检测该标志并做相应处理（如终止执行、清理资源或忽略信号）。

上面代码中，当主线程调用 `t.interrupt()` 时，目标线程 `t` 正处于 `Thread.sleep(1000)` 的阻塞状态中。根据线程中断的机制，阻塞状态（`sleep`/`wait`/`join`）下的线程被中断时，会**立即抛出 `InterruptedException` 异常**，同时**清除线程的中断标志位**（即 `isInterrupted()` 会返回 `false`）。

可以在catch代码后面加上`break`让线程正常退出

```
实际开发中，catch里面需要写什么代码？

1. 尝试自动回复的程序
2. 记录日志（非严重的问题）
3. 发出报警（严重问题）
4. 少数正常业务逻辑（比如文件操作）
```

#### 等待线程

`join`关键字：影响线程结束的先后顺序

实现t2线程等待t1线程，就要让t1先结束，t2后结束；join可以使t2线程阻塞

在main线程中调用join，意思是让main线程等待t线程结束（t执行，main阻塞）

#### 获取线程引用

继承Thread -> 用`this`拿到线程实例
如果是Runnable 或者 lambda的方式，就只能使用`Thread.currentThread`

## 线程状态

就绪：线程随时可以去CPU上执行，也包含在CPU上执行的线程

阻塞：这个线程暂时不方便去CPU上执行

Java中，线程有下面几个状态

1. NEW：Thread对象创建好了，但还没有调用start在系统中创建线程
2. TERMINATED：Thread对象仍然存在，但是系统内部的线程已经执行完毕了
3. RUNNABLE：就绪状态，表示这个线程随时可以去CPU上执行，或者在CPU上执行的线程
4. TIMED_WAITING：指定时间的阻塞，到达一定时间后会自动解除阻塞（sleep或者带有超时时间的join）
5. WAITING：不带时间的阻塞（死等），一定要满足某个条件才能解除阻塞（join或者wait）
6. BLOCKED：由于锁竞争引起的阻塞

![[img-20251222-1.png]]
## 线程安全

线程安全：某个代码无论是在单个线程下执行还是在多个线程下执行都不会产生bug

线程不安全的原因

1. 操作系统上的线程“抢占式执行”“随机调度”，线程之间的执行顺序不确定（根本原因）
2. 代码结构。代码中多个线程同时修改同一个变量（单线程修改，多线程读取同一个变量没问题；多线程修改不同变量没问题）
	（所以String对象**不可变**的特性就是线程安全的）
3. 多线程操作本身不是原子的。（直接原因）
	比如count++需要多个CPU指令，可能一个线程的指令还没执行完就给调度走，给其他线程可乘之机
	单个CPU指令就是原子的，要么执行完，要么不执行
	（可以通过加锁把这多个CPU指令打包成一个整体，实现线程间的锁竞争）
4. 内存可见性问题
5. 指令重排序问题

### 针对原因1，2，3的解决方案：加锁
#### 特性1：互斥性

加锁具有互斥，排他的特性，一般采用synchronized关键字（调用系统api进行加锁）

加锁前需要准备好一个锁对象，依托于这个锁对象进行加锁和解锁操作

如果一个线程针对一个对象加锁之后，其他线程尝试对这个对象进行加锁操作就会被阻塞（锁冲突/锁竞争），阻塞到前一个线程释放锁为止（互斥性） -- **锁竞争**
- 一次只允许一个线程持有锁
- 多个线程操作**同一个实例** → 有竞争 → 安全；
- 多个线程操作**不同实例** → 各自锁自己的对象 → **无竞争 → 不安全**

#### 特性2：可重入性

**可重入性：同一个线程可以多次获取同一把锁而不会导致死锁**。

在**Java**里面用synchronized加锁，利用了它的**可重入**特性
真正的加锁，把计数器+1，说明当前这个对象被加锁一次，同时记录线程是谁

![[img-20251222-2.png]]

### 死锁

场景：
1. 一个线程，一把锁，如果锁是不可重入锁，并且一个线程对这把锁加锁两次，就会出现死锁
2. 两个线程，两把锁。线程1获取到锁A，线程2获取到锁B，1尝试获取锁B，2尝试获取锁A，就出现死锁了
```java
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(()->{
            synchronized (A){
                //sleep一下，给t2时间能拿到B
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //尝试获取B，但没有释放A
                synchronized (B){
                    System.out.println("t1拿到两把锁");
                }
            }
        });
 
        Thread t2 = new Thread(()->{
            synchronized (B){
                //sleep一下，给t1时间能拿到A
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //尝试获取A，但是没有释放B
                synchronized (A){
                    System.out.println("t2拿到两把锁");
                }
            }
        });
        t1.start();
        t2.start();
    }
```

3. N个线程M把锁

**哲学家就餐问题**：**多个线程（哲学家）竞争多把资源（筷子/锁）时，因环路等待而引发死锁**

**场景**：

- 5 个哲学家围坐在圆桌旁，每人面前有一碗面。
- 每两人之间放一根筷子，共 **5 根筷子**（每人左右各一根）。
- 要吃面，必须 **同时拿到左右两根筷子**（即两把锁）。
- 吃完后，**同时放下两根筷子**。

**规则**：

- 哲学家在“思考”和“吃饭”之间交替。
- 筷子是**独占资源**：一次只能一个人用，不能抢（不可抢占）。

如果所有哲学家**同时饿了**，并都先拿**左边的筷子**：  
→ 每个人都拿着一根筷子，等着右边那根……  
→ 但右边的筷子都被别人拿着！  
→ **谁也吃不上，谁也不放手 → 死锁！**

#### 死锁产生条件

1. **互斥使用**，获取锁的过程是互斥的。一个线程拿到锁，另一个线程只能阻塞等待（最基本特性）
2. **不可抢占**。一个线程拿到锁之后，只能主动解锁，不能让别的线程强行把锁抢走（最基本特性）
3. **请求保持**。一个线程拿到锁A之后，持有A的前提下尝试获取B（代码结构）
4. 循环等待/环路等待（代码结构，最容易破坏）
#### 解决方法

1. 引入额外的筷子（锁）
2. 去掉一个哲学家（线程）
3. 引入计数器，限制最多多少人吃面
4. **引入加锁顺序规则（常用）**
5. 银行家算法

### 原因4：内存可见性问题

**一个线程对共享数据的写入，对其他线程不可见**。

关键要素

1. **存在多个线程**；
2. **访问同一个共享变量**（通常位于堆内存）；
3. **至少有一个线程在写，另一个线程在读**；
4. 由于JVM优化、CPU缓存等原因，一个线程的修改，其他线程**看不到**
### 原因5：指令重排序问题

由于编译器/JVM/CPU 为优化性能**主动调整顺序**，导致指令执行顺序和**代码书写顺序不一致**
#### 解决方法：用volatile关键字

volatile 关键字可以保证并发编程三大特征（原子性、可见性、有序性）中的可见性和有序性，不能保证原子性。

**可见性（Visibility）**：volatile 保证了当一个线程修改了共享变量的值后，其他线程能够立即看到这个修改，即保证了对于所有线程的可见性。普通的变量在多线程环境下，线程之间可能会存在缓存不一致的问题，而使用 volatile 关键字修饰的变量会将其值立即刷新到主内存中，保证可见性。

**禁止指令重排序**：volatile 修饰的变量会禁止编译器和处理器对其进行指令重排序优化，保证了程序的执行顺序与代码顺序一致。可以避免某些情况下的线程安全问题

![](image/img-20251222-3.png)

## 等待和通知机制

join：等待另一个线程执行完，才继续执行
wait：等待，当另一个线程收到notify通知之后就结束等待，不要求另一个线程必须执行完

#### 线程饿死

线程饿死是指：某个线程由于某种原因，长期无法获得所需的资源（如锁、CPU 时间片等），导致它**一直处于等待状态**，无法执行任务的现象。

| 概念     | 发生原因          | 是否有环路等待  |
| ------ | ------------- | -------- |
| **死锁** | 多线程相互等待对方释放资源 | 有（循环等待）  |
| **饿死** | 某线程长期得不到资源    | 无（只是被忽略） |

可以用wait和notify来解决

wait做了三件事：

1.释放锁；
2.进入阻塞等待；
3.当其他线程调用notify的时候，wait解除阻塞，并重写获取到锁

⚠wait进来要先释放锁，释放锁的前提就是能拿到锁，而sychronized也叫做监视器锁，wait没有放到sychronized里面的话就会出现监视器异常

```java
        Object object = new Object();
        synchronized (object){
            // 调用wait的对象一定要和synchronized中的锁对象是一致的
            object.wait();
        }
```


notify 方法是唤醒等待的线程.
- 方法notify()也要在同步⽅法或同步块中调⽤，该⽅法是⽤来通知那些可能等待该对象的对象锁的其它线程，对其发出通知notify，并使它们重新获取该对象的对象锁。
- 如果有多个线程等待，则有线程调度器随机挑选出⼀个呈 wait 状态的线程。(并没有 "先来后到")
- 在notify()⽅法后，当前线程不会⻢上释放该对象锁，要等到执⾏notify()⽅法的线程将程序执⾏完，也就是退出同步代码块之后才会释放对象锁

⚠wait和notify要通过同一个对象来联系

object1.wait();

object2.notify();

此时是无法唤醒的

## 多线程案例

### 一、阻塞队列

特点：1.线程安全；2.阻塞

如果一个已经满了的队列进行入队列，此时入队列操作就会阻塞，一直阻塞到队列不满之后

如果一个已经空的队列进行出队列，出队列操作就会阻塞，一直阻塞到队列有元素为止
#### 一、生产者-消费者模型（Producer-Consumer Pattern）

核心思想：**生产者负责生成数据，消费者负责处理数据，中间用一个“队列”缓冲，实现解耦和异步。**
##### 1. 解耦合

原来服务器问题（耦合低，B或者C服务器挂了A就寄了）
![](image/img-20251222-6.png)
加个阻塞队列，这个阻塞队列不是简单的数据结构，而是基于这个数据结构实现的服务器程序，又被部署到单独的主机上
![](image/img-20251222-5.png)

##### 2. 削峰填谷（Smooth Traffic Peaks）

问题：请求突增时服务器容易“挂”

- 用户突然大量访问（如秒杀、大促）；
- 服务器 B、C 处理能力有限 → CPU、内存、数据库被打爆 → **宕机**；
- A 作为入口也扛不住 → 整个系统崩溃！

解决方案：引入“队列”作为缓冲区

![](image/img-20251222-7.png)

- **队列像蓄水池**：请求高峰期，A 把请求存进去；
- **B/C 按稳定速度处理**：即使请求量是原来的10倍，B/C 仍按原速处理；
- **队列承担峰值压力** → B、C 不会瞬间过载 → **系统稳定运行**！

这就是“削峰填谷”：**把尖峰流量平滑成匀速处理流**。

### 二、单例模式

单例 = 单个实例（对象）

某个类在一个进程中只应该创建出一个实例（原则上不应该有多个）

#### 饿汉模式（Eager Initialization）

- **类加载时就创建实例**，不管是否使用。
- “饿汉” = 非常“迫切”，一启动就创建。
```java
public class Singleton {
    // 1. 私有构造函数，防止外部 new
    private Singleton() {}

    // 2. 静态成员变量，在类加载时初始化
    private static final Singleton instance = new Singleton();

    // 3. 公共静态方法获取实例
    public static Singleton getInstance() {
        return instance;
    }
}
```

#### 懒汉模式（Lazy Initialization）

- **首次调用 `getInstance()` 时才创建实例**。
- “懒汉” = 懒得早创建，等到真正需要时再创建。

```java
public class SingletonLazy {
    // 1. 使用 volatile 保证可见性和禁止指令重排序
    private static volatile SingletonLazy instance = null;

    // 2. 私有构造函数，防止外部 new
    private SingletonLazy() {}

    // 3. 公共静态方法获取实例（双重检查）
    public static SingletonLazy getInstance() {
        if (instance == null) { //外层的 if 就是判定下看当前是否已经把 instance 实例创建出来了
            synchronized (SingletonLazy.class) {
                if (instance == null) { // 当多线程⾸次调⽤ getInstance, ⼤家可能都发现 instance 为 null, 于是⼜继续往下执⾏来竞争锁, 其中竞争成功的线程, 再完成创建实例的操作.当这个实例创建完了之后, 其他竞争到锁的线程就被⾥层 if 挡住了. 也就不会继续创建其他实例.
                    instance = new SingletonLazy(); // volatile 保证这里无重排序问题
                }
            }
        }
        return instance;
    }
}
```

### 三、定时器

**定时器的作用**

- 在**指定时间点**自动执行某段逻辑
- 典型场景：博客定时发布、延迟任务执行等

**基本用法思想**

- 定义一个 `Timer`
- 向 Timer 中添加多个任务
- 每个任务都携带一个**执行时间**

定时器的构成

- ⼀个带优先级队列(不要使⽤ PriorityBlockingQueue, 容易死锁!)
- 队列中的每个元素是⼀个 Task 对象.
- Task 中带有⼀个时间属性, 队⾸元素就是即将要执⾏的任务
- 同时有⼀个 worker 线程⼀直扫描队⾸元素, 看队⾸元素是否需要执⾏

### 四、线程池

池是什么？

池就相当于一个共享资源，是对资源的整合和调配，节省存储空间，当需要的时候可以直接在池中取，用完之后再还回去。比如，如果你喝水，你可以拿杯子去水龙头接。如果很多人喝水，那就只能排队去接。

线程池：把要使用的线程提前创建好，用完了也不要直接释放而是放到池子里备下次使用，能够节省创建/销毁线程的开销
#### 线程复用

每一个 Thread 的类都有一个 start 方法。 当调用 start 启动线程时 Java 虚拟机会调用该类的 run方法。 那么该类的 run() 方法中就是调用了 Runnable 对象的 run() 方法。 我们可以继承重写Thread 类，在其 start 方法中添加不断循环调用传递过来的 Runnable 对象。 这就是线程池的实现原理。循环方法中不断获取 Runnable 是用 Queue 实现的，在获取下一个 Runnable 之前可以是阻塞的。
#### 线程池的组成

一般的线程池主要分为以下 4 个组成部分

1. 线程池管理器：用于创建并管理线程池
2. 工作线程：线程池中的线程
3. 任务接口：每个任务必须实现的接口，用于工作线程调度其运行
4. 任务队列：用于存放待处理的任务，提供一种缓冲机制

Java 中的线程池是通过 Executor 框架实现的，该框架中用到了 Executor，Executors，
ExecutorService，ThreadPoolExecutor ，Callable 和 Future、FutureTask 这几个类。
#### 构造方法
ThreadPoolExecutor 的构造方法如下：

```java
public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize, long keepAliveTime,
TimeUnit unit, BlockingQueue<Runnable> workQueue) {
	this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
Executors.defaultThreadFactory(), defaultHandler);
}
```
1. corePoolSize：指定了线程池中的线程数量。
2. maximumPoolSize：指定了线程池中的最大线程数量。
3. kepAliveTime：当前线程池数量超过 corePoolSize 时，多余的空闲线程的存活时间，即多 次时间内会被销毁。
4. unit：keepAliveTime 的单位。
5. workQueue：任务队列，被提交但尚未被执行的任务。
6. threadFactory：线程工厂，用于创建线程，一般用默认的即可。
7. handler：拒绝策略，当任务太多来不及处理，如何拒绝任务。
#### 拒绝策略

线程池中的线程已经用完了，无法继续为新任务服务，同时，等待队列也已经排满了，再也
塞不下新任务了。这时候我们就需要拒绝策略机制合理的处理这个问题。

JDK 内置的拒绝策略如下：

1. AbortPolicy ： 直接抛出异常，阻止系统正常运行。
2. CallerRunsPolicy ： 只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。显然这样做不会真的丢弃任务，但是，任务提交线程的性能极有可能会急剧下降。
3. DiscardOldestPolicy ： 丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。
4. DiscardPolicy ： 该策略默默地丢弃无法处理的任务，不予任何处理。如果允许任务丢失，这是最好的一种方案。以上内置拒绝策略均实现了 RejectedExecutionHandler 接口，若以上策略仍无法满足实际需要，完全可以自己扩展 RejectedExecutionHandler 接口。

#### Java 线程池工作过程

1. 线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。
2. 当调用 execute() 方法添加一个任务时，线程池会做如下判断：
	a) 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
	b) 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列；
	c) 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建非核心线程立刻运行这个任务；
	d) 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常 RejectExecutionException。
3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。
4. 当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。