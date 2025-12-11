# 时间复杂度 和 集合框架
![](image/img-20251210-6.png)

![](image/img-20251210-7.png)

**二分查找**
```java
while (begin <= end) {
    mid = begin + (end - begin) / 2;

    if (array[mid] < value)
        begin = mid + 1;
    else if (array[mid] > value)
        end = mid - 1;
    else
        return mid;
}
return -1;
```
假设查找次数为 y，则：

`n / 2^y = 1 → n = 2^y → y = log₂n`

所以时间复杂度为：`O(log n)`

**斐波那契数列**
```
           F(n)
      /           \
   F(n-1)        F(n-2)
   /    \          /    \
F(n-2) F(n-3)   F(n-3) F(n-4)
...
```
1. 形成一棵高度为 N 的二叉树。二叉树节点数：`≈ 2^N`
2. 递归次数类似：`2^0 + 2^1 + 2^2 + ... + 2^(n-1)`
3. 几何级数求和：`Sn = 2^n - 1`
4. 所以时间复杂度：`O(2^N)`

**空间复杂度**关键点不是看有多少次递归，而是看**递归深度**
对于斐波那契数列而言，最深的路径就是 `fib(n) → fib(n-1) → fib(n-2) → … → fib(1)`
长度为 **n**。

# 包装类
![](image/img-20251210-8.png)
装箱（auto-boxing）：基本类型 → 包装类型
`Integer a = 10;   // 自动转为 Integer.valueOf(10)`

拆箱（auto-unboxing）：包装类型 → 基本类型
`int b = a;  // 自动转为 a.intValue()`

装箱和拆箱都是**编译器帮我们做的**，所以是**自动**的
## 泛型

1. 泛型就是把类型当成参数传递给类、接口、方法，让容器记住它应该存的类型，从**编译**阶段就**发现类型错误**，避免运行时报错。
2. 泛型是在编译阶段存在的，到JVM运行阶段这个概念就不成立了
3. 
```
ArrayList<int> ❌ 不允许
ArrayList<Integer> ✔ 正确
```
### **擦除机制**：

编译器在编译时会把泛型信息擦除 → 变成原始类型（一般为 Object 或边界类型）
例如：
```java
class Box<T> {
    T data;
}
```
编译后的字节码中实际变成：
```java
class Box {
    Object data;
}
```
泛型只是**编译期检查规则**，运行时不会保留类型参数。

### 泛型的上界：

可以给泛型加约束，让其必须是某个类的子类或实现某个接口

例如：
`<T extends Number>`
表示 T 必须是 Number 或其子类（Integer、Double 等）。

### 通配符（Wildcard）?

让方法或类可以接收“多种类型的泛型参数”，从而提高泛型的灵活性，同时又保证类型安全
**泛型 = 限制类型**  
**通配符 = 放宽这种限制（但仍保持安全）**

（1）? extends T —— 上界通配符（可以读，不能写）
	`? extends Fruit`
表示：该泛型容器里存的是 Fruit 或其子类（Apple、Banana）。
用途：
- 常用于 **读取**（get）
- 不允许 add（除了 null）
- 因为你不知道到底是 Fruit 还是 Apple 还是 Banana
	`? extends T —— 读可以，写不行`

（2）? super T —— 下界通配符（可以写，读只能是 Object）
	`? super Fruit`
表示：这是 Fruit 的父类类型（如 Food、Object）的泛型容器
用途：
- 常用于 **写入**（add Fruit 或其子类）
- 读取只能得到 Object，因为你不确定具体类型
	`? super T —— 写可以，读不行`

`? extends T` —— 生产者（Producer）安全，适合读
`? super T` —— 消费者（Consumer）安全，适合写

# ArrayList

![](image/img-20251211.png)

- List 是 **Collection 的子接口**
- 特点：**有序、可重复、线性表结构**
- 常见实现类：**ArrayList、LinkedList**

顺序表 = 物理地址连续的存储空间 + 按顺序存储数据
## ArrayList

ArrayList 是：

- 一个 **实现了 List 接口的类**
- 底层使用 **动态数组**（可自动扩容）
- 支持 **随机访问（实现了 RandomAccess 接口）**
- 实现了 **Cloneable、Serializable**
- **非线程安全**（多线程情况下使用 Vector / CopyOnWriteArrayList）

扩容步骤：

1. 判断是否需要扩容（minCapacity > 当前容量）
2. 预计扩大为原来的 **1.5 倍**
    `newCapacity = oldCapacity + oldCapacity >> 1`
3. 如果用户需求比 1.5 倍还大 → 使用用户需求容量
4. 检查是否超过最大数组限制（MAX_ARRAY_SIZE）
5. 使用 `Arrays.copyOf()` 执行扩容

扩容过程 =  **申请新空间 → 拷贝旧数据 → 释放旧空间**
### 方法

|方法|解释|
|---|---|
|`boolean add(E e)`|尾插 e|
|`void add(int index, E element)`|将 e 插入到 index 位置|
|`boolean addAll(Collection<? extends E> c)`|尾插 c 中的元素|
|`E remove(int index)`|删除 index 位置元素|
|`boolean remove(Object o)`|删除遇到的第一个 o|
|`E get(int index)`|获取下标 index 位置元素|
|`E set(int index, E element)`|将下标 index 位置元素设置为 element|
|`void clear()`|清空|
|`boolean contains(Object o)`|判断 o 是否在线性表中|
|`int indexOf(Object o)`|返回第一个 o 所在下标|
|`int lastIndexOf(Object o)`|返回最后一个 o 所在下标|
|`List<E> subList(int fromIndex, int toIndex)`|截取部分 list（左闭右开）|

```java
List<String> a = new ArrayList<>();
List<Double> b = new ArrayList<>();
List<List<Integer>> c = new ArrayList<>();
```
<> 代表：请编译器使用我左边的类型参数。

# 链表

![](image/img-20251211-1.png)

## 为什么需要 LinkedList？

ArrayList 底层是 **连续数组**，存在缺陷：

- 在任意位置插入、删除元素需要整体搬移 → **O(n)**，效率低
- 适合读操作（随机访问快），不适合频繁增删
因此引入 **LinkedList（链表结构）** 来解决这一问题。

## 链表介绍

链表是一种 **物理空间不连续，但逻辑顺序连续** 的数据结构。

节点结构如下：

`data + next (单链表) data + next + prev (双链表)`

1. 无头单向非循环链表（单链表）

- 结构简单
- 常用于面试、OJ题
- 也常用作其他数据结构的基础（如哈希桶、邻接表）

2. 无头双向链表（LinkedList 的底层）

- 双向指针 prev / next
- 插入删除更高效
- Java LinkedList 采用 **双向循环链表**

![](image/img-20251211-2.png)


| 项目        | ArrayList  | LinkedList |
| --------- | ---------- | ---------- |
| 底层结构      | 动态数组（连续空间） | 双向链表（不连续）  |
| 随机访问      | O(1) 非常快   | O(n) 很慢    |
| 插入/删除（中间） | O(n) 需要搬移  | O(1) 修改指针  |
| 扩容        | 需要，代价高     | 无需扩容       |
| 内存占用      | 紧凑         | 节点额外开销大    |
| 适用场景      | 读多写少       | 写多读少、频繁插删  |
## 方法

1. 增加元素（Add）

|方法|功能说明|
|---|---|
|`add(e)`|在链表尾部插入元素|
|`addFirst(e)`|在链表头部插入元素|
|`addLast(e)`|在链表尾部插入（与 add 等价）|
2. 删除元素（Remove）

|方法|功能说明|
|---|---|
|`remove()`|删除第一个元素（空时抛异常）|
|`removeFirst()`|删除头部元素（空时抛异常）|
|`removeLast()`|删除尾部元素（空时抛异常）|
|`poll()`|删除并返回头部元素（空返回 null）|
|`pollFirst()`|删除并返回头部元素（空返回 null）|
|`pollLast()`|删除并返回尾部元素（空返回 null）|
3. 获取元素（Get / Peek）

|方法|功能说明|
|---|---|
|`get(index)`|获取指定下标元素（O(n)）|
|`getFirst()`|获取头部元素（空时抛异常）|
|`getLast()`|获取尾部元素（空时抛异常）|
|`peek()`|查看头部元素（空返回 null）|
|`peekFirst()`|查看头部元素（空返回 null）|
|`peekLast()`|查看尾部元素（空返回 null）|
4. 遍历（Iterator）

|方法|功能说明|
|---|---|
|`iterator()`|返回正向迭代器|
|`listIterator()`|返回可以双向遍历的迭代器|

# 栈和队列

![](image/img-20251211-3.png)
## 栈

**栈**：一种特殊的线性表，其只允许在固定的一端进行插入和删除元素操作。进行数据插入和删除操作的一端称为栈顶，另一端称为栈底。栈中的数据元素遵守后进先出LIFO（Last In First Out）的原则。

**压栈**：栈的插入操作叫做进栈/压栈/入栈，入数据在栈顶。

**出栈**：栈的删除操作叫做出栈。出数据在栈顶。

![](image/img-20251211-4.png)

| 方法                | 功能           |
| ----------------- | ------------ |
| `Stack()`         | 构造一个空的栈      |
| `E push(E e)`     | 将 e 入栈，并返回 e |
| `E pop()`         | 将栈顶元素出栈并返回   |
| `E peek()`        | 获取栈顶元素（不出栈）  |
| `int size()`      | 获取栈中有效元素个数   |
| `boolean empty()` | 检测栈是否为空      |
Stack继承了**Vector**，Vector和ArrayList类似，都是动态的顺序表，不同的是Vector是线程安全的。

| 名称                  | 概念                         | 归属       |
| ------------------- | -------------------------- | -------- |
| **栈**               | 一种数据结构（LIFO）               | 算法结构     |
| **虚拟机栈**            | JVM 运行时区域之一，维护线程的方法调用      | JVM 内存模型 |
| **栈帧（Stack Frame）** | 每次方法调用产生一个栈帧，包含局部变量表、操作数栈等 | JVM 栈的元素 |
```
线程 Thread
 └── 虚拟机栈 JVM Stack
       ├── 栈帧 Frame（方法A）
       ├── 栈帧 Frame（方法B）
       └── 栈帧 Frame（方法C）
```
## 队列

**队列**：只允许在一端进行插入数据操作，在另一端进行删除数据操作的特殊线性表，队列具有先进先出FIFO(First In First Out) 
**入队列**：进行插入操作的一端称为队尾（Tail/Rear） 
**出队列**：进行删除操作的一端称为队头

在Java中，**Queue**是个接口，底层是通过链表实现的。

| 方法          | 说明        |
| ----------- | --------- |
| `offer(e)`  | 入队        |
| `poll()`    | 出队并返回队头元素 |
| `peek()`    | 查看队头元素    |
| `size()`    | 元素个数      |
| `isEmpty()` | 是否为空      |
### 常见面试题

1. **用两个队列实现栈**
2. **用两个栈实现队列**
3. 判断一个序列是否可能是栈的出栈序列
4. 最小栈设计
5. 括号匹配
6. 逆波兰表达式求值

# 二叉树

![](image/img-20251211-5.png)