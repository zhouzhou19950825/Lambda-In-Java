 # Lambda-in-Java
    通过Demo演示出Lambda语法在Java中的魅力（使用需要JDK1.8以上）
    
- **用Lambda语法写线程**
- **Lambda表达式 为button添加ActionListener**
- **使用Comparator接口排序**
- **自定义接口实现**
-  **forEach**
- - filter过滤删选
- -  Predicate(准备条件)
- - 并行处理和顺序处理
-  **探讨Lambda是否为语法糖**




-------------------
>语法
（1）	形参列表。如果没有参数()表示
（2）	->
（3）	代码块

## 用Lambda语法写线程
### 快速启动（输出其实并不重要）

```
mvn compile exec:java -Dexec.mainClass=com.upic.LambdaTest.ThreadLambda
```
原来线程实现:

```
new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread");
			}
		}).start();
```
通过Lambda实现

```
new Thread(() -> {
			System.out.println("Lambda Thread");
		}, "ThreadName-1").start();
		
		Runnable r=()->{
			System.out.println("Runnable");
		};
		r.run();

```
     代码量简洁了不少

## Lambda表达式 为button添加ActionListener
原来的添加：

```
button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("你好！" );

            }
        });

```
Lambda:

```
button.addActionListener(e -> System.out.println("你好！"));
```

## 使用Comparator接口排序
原来的写法:

```
Collections.sort(list, new Comparator<String>() {
			// 使用新的排序规则 根据第二个字符进行逆序排
			@Override
			public int compare(String a, String b) {
				if (a.charAt(1) <= b.charAt(1)) {
					return 1;
				} else {
					return -1;
				}
			}
		});

```
Lambda写法:

```
// lambda会自动推断出 a,b 的类型
		Collections.sort(list, (a, b) -> a.charAt(1) < b.charAt(1) ? 1 : -1);
		list.forEach(str -> {
			System.out.println(str);
		});

```

## 自定义接口实现
### 快速启动

```
mvn compile exec:java -Dexec.mainClass=com.upic.LambdaTest.LambdaImp
```
代码

```
@FunctionalInterface
public interface ILambda {

	public int add(int i,int j);
}

```
实现:

```
ILambda l=(i,j)->i+j;
System.out.println(l.add(1, 2));

```
## Lambda forEach写法
### 快速启动

```
mvn compile exec:java -Dexec.mainClass=com.upic.LambdaTest.CompareSort
```

```
//部分代码
list.forEach(it->System.out.println(it));
```
## Lambda好朋友Steam
>stream就是JAVA8提供给我们的对于元素集合统一、快速、并行操作的一种方式。 
它能充分运用多核的优势，以及配合lambda表达式、链式结构对集合等进行许多有用的操作。

### filter过滤筛选
#### 快速运行

```
mvn compile exec:java -Dexec.mainClass=com.upic.lanbdaSteam.LambdaSteam
```

#### 说明：
筛选一个list里相应条件的对象

### Predicate(准备条件)
#### 快速运行

```
mvn compile exec:java -Dexec.mainClass=com.upic.lanbdaSteam.PredicateFilter
```
部分代码

```
Predicate<User> ageFilter = (p) -> (p.getAge() > 50);
Predicate<User> positionFilter = (p) ->(p.getPosition().equals(Position.SOLDIER.toString()));

```
#### 说明：
“多条件筛选” “多条件筛选再限制个数”
筛选出年龄大于五十岁且是战士的人

### 并行处理和顺序处理：
#### 快速运行:

```
mvn compile exec:java -Dexec.mainClass=com.upic.lanbdaSteam.DoTestPerformance
```
#### 说明
计算1~200W数字能余2的结果集，serial：单行处理 parallel：并行处理

## 探讨Lambda是否为语法糖
>现在java语法糖有很多，包括泛型、自动装/拆箱、forEach等，都是java的语法糖，让开发人员更好的去理解，便与开发；

那么我们的lambda语法是不是也是语法糖,我拿一个类com.upic.LambdaTest.SortList做测试，
源代码:

```
public static void newSort() {
		// lambda会自动推断出 a,b 的类型
		Collections.sort(list, (a, b) -> a.charAt(1) < b.charAt(1) ? 1 : -1);
		list.forEach(str -> {
			System.out.println(str);
		});
	}

	public static void main(String[] args) {
		// oldSort();
		newSort();
		for(String s:list){
			System.out.println(s);
		}

```
    加了个For，为了待会反编译查看结果做对比
反编译之后:

```
public static void newSort() {
		Collections.sort(list, (a, b) -> {
			return a.charAt(1) < b.charAt(1) ? 1 : -1;
		});
		list.forEach((str) -> {
			System.out.println(str);
		});
	}	

	public static void main(String[] args) {
		newSort();
		Iterator arg1 = list.iterator();

		while (arg1.hasNext()) {
			String s = (String) arg1.next();
			System.out.println(s);
		}

	}

```

Lambda语法没有发生任何改变。而for循环经过编译后就改写成这样了。

查看类字节码结构的时候发现一个指令

```
 14: invokedynamic #59,  0             // InvokeDynamic #1:accept:()Ljava/util/function/Consumer;

```

> Invokedynamic是jdk1.7引入的指令，Invokedynamic先在运行时动态解析出调用点限定符所引用的方法，然后再执行该方法，指令的分派逻辑是由用户所设定的引导方法决定的。
> 会引出MethodHandler、MethodType的概念，这个我明天或者后天写几个demo放上来。

下面的事class字节码结构中的:

```
0: #121 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lan
g/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Lja
va/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/Metho
dType;)Ljava/lang/invoke/CallSite;

```

通过MethodHandles动态调用的。

> 所以Lambda不是语法糖

完工，请大家多多指教！star下
