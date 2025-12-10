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

