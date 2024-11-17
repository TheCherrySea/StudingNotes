# TS（typeScript）

TypeScript 是一种给 JavaScript 添加特性的语言扩展。

## JavaScript 与 TypeScript 的区别

TypeScript 是 JavaScript 的超集，扩展了 JavaScript 的语法，因此现有的 JavaScript 代码可与 TypeScript 一起工作无需任何修改，TypeScript 通过类型注解提供编译时的静态类型检查。

TypeScript 可处理已有的 JavaScript 代码，并只对其中的 TypeScript 代码进行编译。

![image-20241106233035567](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241106233035567.png)



## 一、安装

安装 typescript：

```java
npm install -g typescript
```



查看版本号：

```java
tsc -v
```

通常我们使用 .ts 作为 TypeScript 代码文件.

文件扩展名：

* xxx**.ts**

然后执行以下命令将 TypeScript 转换为 JavaScript 代码：

```java
tsc app.ts
```

![image-20241106233418477](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241106233418477.png)

这时候在当前目录下（与 app.ts 同一目录）就会生成一个 app.js 文件,使用 node 命令来执行 app.js 文件：

```java
node app.js 
```

TypeScript 转换为 JavaScript 过程如下图：

![image-20241106233609834](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241106233609834.png)

# 

##  二、TypeScript  基础语法

tsc指令同时编译多个 ts 文件：

```java
tsc file1.ts file2.ts file3.ts
```

tsc 常用编译参数如下表所示：

| 序号 | 编译参数说明                                                 |
| :--: | :----------------------------------------------------------- |
|  1.  | **--help** 显示帮助信息                                      |
|  2.  | **--module** 载入扩展模块                                    |
|  3.  | **--target** 设置 ECMA 版本                                  |
|  4.  | **--declaration** 额外生成一个 .d.ts 扩展名的文件。 `tsc ts-hw.ts --declaration` 以上命令会生成 ts-hw.d.ts、ts-hw.js 两个文件。 |
|  5.  | **--removeComments** 删除文件的注释                          |
|  6.  | **--out** 编译多个文件并合并到一个输出的文件                 |
|  7.  | **--sourcemap** 生成一个 sourcemap (.map) 文件。 sourcemap 是一个存储源代码与编译代码对应位置映射的信息文件。 |
|  8.  | **--module noImplicitAny** 在表达式和声明上有隐含的 any 类型时报错 |
|  9.  | **--watch** 在监视模式下运行编译器。会监视输出文件，在它们改变时重新编译。 |

### 空白和换行

TypeScript 会忽略程序中出现的空格、制表符和换行符。 

空格、制表符通常用来缩进代码，使代码易于阅读和理解。

### TypeScript 区分大小写

TypeScript 区分大写和小写字符

### TypeScript 支持两种类型的注释

- **单行注释 ( // )** − 在 // 后面的文字都是注释内容。
- **多行注释 (/\*   \*/)** − 这种注释可以跨越多行

##  三、TypeScript 基础类型

| 数据类型   | 关键字    | 描述                                                         |
| ---------- | --------- | ------------------------------------------------------------ |
| 任意类型   | any       | 声明为 any 的变量可以赋予任意类型的值。                      |
| 数字类型   | number    | 双精度 64 位浮点值。它可以用来表示整数和分数。 `let binaryLiteral: number = 0b1010; // 二进制 let octalLiteral: number = 0o744;    // 八进制 let decLiteral: number = 6;    // 十进制 let hexLiteral: number = 0xf00d;    // 十六进制` |
| 字符串类型 | string    | 一个字符系列，使用单引号（'）或双引号（"）来表示字符串类型。反引号（`）来定义多行文本和内嵌表达式。 `let name: string = "Runoob"; let years: number = 5; let words: string = `您好，今年是 ${ name } 发布 ${ years + 1} 周年`;` |
| 布尔类型   | boolean   | 表示逻辑值：true 和 false。  `let flag: boolean = true;`     |
| 数组类型   | 无        | 声明变量为数组。 `// 在元素类型后面加上[] let arr: number[] = [1, 2]; // 或者使用数组泛型 let arr: Array<number> = [1, 2];` |
| 元组       | 无        | 元组类型用来表示已知元素数量和类型的数组，各元素的类型不必相同，对应位置的类型需要相同。 `let x: [string, number]; x = ['Runoob', 1];    // 运行正常 x = [1, 'Runoob'];    // 报错 console.log(x[0]);    // 输出 Runoob` |
| 枚举       | enum      | 枚举类型用于定义数值集合。 `enum Color {Red, Green, Blue}; let c: Color = Color.Blue; console.log(c);    // 输出 2` |
| void       | void      | 用于标识方法返回值的类型，表示该方法没有返回值。 `function hello(): void {    alert("Hello Runoob"); }` |
| null       | null      | 表示对象值缺失。                                             |
| undefined  | undefined | 用于初始化变量为一个未定义的值                               |
| never      | never     | never 是其它类型（包括 null 和 undefined）的子类型，代表从不会出现的值。 |

**注意：****TypeScript 和 JavaScript 没有整数类型。**

## Any 类型

任意值是 TypeScript 针对编程时类型不明确的变量使用的一种数据类型，它常用于以下三种情况。

1、变量的值会动态改变时，比如来自用户的输入，任意值类型可以让这些变量跳过编译阶段的类型检查，

```java
let arrayList: any[] = [1, false, 'fine'];
arrayList[1] = 100;
```

## Null 和 Undefined

### null

在 JavaScript 中 null 表示 "什么都没有"。

null是一个只有一个值的特殊类型。表示一个空对象引用。

用 typeof 检测 null 返回是 object。

### undefined

在 JavaScript 中, undefined 是一个没有设置值的变量。

typeof 一个没有值的变量会返回 undefined。

Null 和 Undefined 是其他任何类型（包括 void）的子类型，可以赋值给其它类型，如数字类型，此时，赋值后的类型会变成  null 或 undefined。而在TypeScript中启用严格的空校验（--strictNullChecks）特性，就可以使得null 和 undefined 只能被赋值给 void 或本身对应的类型，示例代码如下：

```java
// 启用 --strictNullChecks
let x: number;
x = 1; // 编译正确
x = undefined;    // 编译错误
x = null;    // 编译错误
```

上面的例子中变量 x 只能是数字类型。如果一个类型可能出现 null 或 undefined， 可以用 | 来支持多种类型，示例代码如下：

```
// 启用 --strictNullChecks
let x: number | null | undefined;
x = 1; // 编译正确
x = undefined;    // 编译正确
x = null;    // 编译正确
```

## never 类型

never 是其它类型（包括 null 和 undefined）的子类型，代表从不会出现的值。这意味着声明为 never 类型的变量只能被 never 类型所赋值，在函数中它通常表现为抛出异常或无法执行到终止点（例如无限循环），示例代码如下：

```
let x: never;
let y: number;

// 编译错误，数字类型不能转为 never 类型
x = 123;

// 运行正确，never 类型可以赋值给 never类型
x = (()=>{ throw new Error('exception')})();

// 运行正确，never 类型可以赋值给 数字类型
y = (()=>{ throw new Error('exception')})();

// 返回值为 never 的函数可以是抛出异常的情况
function error(message: string): never {
    throw new Error(message);
}

// 返回值为 never 的函数可以是无法被执行到的终止点的情况
function loop(): never {
    while (true) {}
}
```

## 四、TypeScript 变量声明

变量是一种使用方便的占位符，用于引用计算机内存地址。

TypeScript 变量的命名规则：

- 变量名称可以包含数字和字母。
- 除了下划线 _ 和美元 $ 符号外，不能包含其他特殊字符，包括空格。
- 变量名不能以数字开头。

声明变量的类型及初始值：

```
var [变量名] : [类型] = 值;

例如：
var uname:string = "Runoob";

声明变量的类型，但没有初始值，变量值会设置为 undefined：

var [变量名] : [类型];

例如：
var uname:string;

声明变量并初始值，但不设置类型，该变量可以是任意类型：

var [变量名] = 值;

例如：
var uname = "Runoob";

声明变量没有设置类型和初始值，类型可以是任意类型，默认初始值为 undefined：

var [变量名];

例如：
var uname;
```

<font color='red'>**注意：变量不要使用 name 否则会与 DOM 中的全局 window 对象下的 name 属性出现了重名。**</font>

## 类型断言（Type Assertion）

类型断言可以用来手动指定一个值的类型，即允许变量从一种类型更改为另一种类型。

语法格式：

```
<类型>值

例：
var str = '1' 
```

或:

```
值 as 类型

例：
var str2:number = <number> <any> str   //str、str2 是 string 类型
```

## 变量作用域

变量作用域指定了变量定义的位置。

程序中变量的可用性由变量作用域决定。

TypeScript 有以下几种作用域：

- **全局作用域** − 全局变量定义在程序结构的外部，它可以在你代码的任何位置使用。
- **类作用域** − 这个变量也可以称为 **字段**。类变量声明在一个类里头，但在类的方法外面。 该变量可以通过类的对象来访问。类变量也可以是静态的，静态的变量可以通过类名直接访问。
- **局部作用域** − 局部变量，局部变量只能在声明它的一个代码块（如：方法）中使用。

```java
var global_num = 12          // 全局变量
class Numbers { 
   num_val = 13;             // 实例变量
   static sval = 10;         // 静态变量
   
   storeNum():void { 
      var local_num = 14;    // 局部变量
   } 
} 
console.log("全局变量为: "+global_num)  
console.log(Numbers.sval)   // 静态变量
var obj = new Numbers(); 
console.log("实例变量: "+obj.num_val)
```



## 循环

语法格式如下所示：

```java
for ( init; condition; increment ){
    statement(s);
}
```

下面是 for 循环的控制流程解析：

1. **init** 会首先被执行，且只会执行一次。这一步允许您声明并初始化任何循环控制变量。您也可以不在这里写任何语句，只要有一个分号出现即可。
2. 接下来，会判断 **condition**。如果为 true，则执行循环主体。如果为 false，则不执行循环主体，且控制流会跳转到紧接着 for 循环的下一条语句。
3. 在执行完 for 循环主体后，控制流会跳回上面的 **increment** 语句。该语句允许您更新循环控制变量。该语句可以留空，只要在条件后有一个分号出现即可。
4. 条件再次被判断。如果为 true，则执行循环，这个过程会不断重复（循环主体，然后增加步值，再然后重新判断条件）。在条件变为 false 时，for 循环终止。

在这里，statement(s) 可以是一个单独的语句，也可以是几个语句组成的代码块。

condition 可以是任意的表达式，当条件为 true 时执行循环，当条件为 false 时，退出循环。



## for…of 、forEach、every 和 some 循环

此外，TypeScript 还支持 for…of 、forEach、every 和 some 循环。

for...of 语句创建一个循环来迭代可迭代的对象。在 ES6 中引入的 for...of 循环，以替代 for...in 和  forEach() ，并支持新的迭代协议。for...of 允许你遍历 Arrays（数组）, Strings（字符串）, Maps（映射）,  Sets（集合）等可迭代的数据结构等。

```java
let someArray = [1, "string", false];
 
for (let entry of someArray) {
    console.log(entry); // 1, "string", false
}
```

## 函数

#### 函数返回值

有时，我们会希望函数将执行的结果返回到调用它的地方。

通过使用 return 语句就可以实现。

在使用 return 语句时，函数会停止执行，并返回指定的值。

语法格式如下所示：

```java
function function_name():return_type { 
    // 语句
    return value; 
}

实例
// 函数定义
function greet():string { // 返回一个字符串
    return "Hello World" 
} 
 
function caller() { 
    var msg = greet() // 调用 greet() 函数 
    console.log(msg) 
} 
 
// 调用函数
caller()
```

- return_type 是返回值的类型。
- return 关键词后跟着要返回的结果。
- 一般情况下，一个函数只有一个 return 语句。
- 返回值的类型需要与函数定义的返回类型(return_type)一致。

#### 参数

在 TypeScript 函数里，如果我们定义了参数，则我们必须传入这些参数，除非将这些参数设置为可选，可选参数使用问号标识 ？。

```java
function buildName(firstName: string, lastName: string) {
    return firstName + " " + lastName;
}
 
let result1 = buildName("Bob");                  // 错误，缺少参数
let result2 = buildName("Bob", "Adams", "Sr.");  // 错误，参数太多了
let result3 = buildName("Bob", "Adams");         // 正确


以下实例，我们将 lastName 设置为可选参数：
    function buildName(firstName: string, lastName?: string) {
    if (lastName)
        return firstName + " " + lastName;
    else
        return firstName;
}
 
let result1 = buildName("Bob");  // 正确
let result2 = buildName("Bob", "Adams", "Sr.");  // 错误，参数太多了
let result3 = buildName("Bob", "Adams");  // 正确
```

## 余参数

有一种情况，我们不知道要向函数传入多少个参数，这时候我们就可以使用剩余参数来定义。

剩余参数语法允许我们将一个不确定数量的参数作为一个数组传入。

```java
function buildName(firstName: string, ...restOfName: string[]) {
    return firstName + " " + restOfName.join(" ");
}
  
let employeeName = buildName("Joseph", "Samuel", "Lucas", "MacKinzie");


函数的最后一个命名参数 restOfName 以 ... 为前缀，它将成为一个由剩余参数组成的数组，索引值从0（包括）到 restOfName.length（不包括）。
    
    function addNumbers(...nums:number[]) {  
    var i;   
    var sum:number = 0; 
    
    for(i = 0;i<nums.length;i++) { 
       sum = sum + nums[i]; 
    } 
    console.log("和为：",sum) 
 } 
 addNumbers(1,2,3) 
 addNumbers(10,10,10,10,10)
    
```



## 多维数组

<font color='red'>**‌[迭代器]（Iterator）**‌是一种设计模式，用于按顺序访问一个容器中的元素，而不需要暴露容器的内部结构。迭代器提供了一种统一的方法来遍历数据结构，使得设计人员无需关心容器对象的内存分配的实现细节</font>

一个数组的元素可以是另外一个数组，这样就构成了多维数组（Multi-dimensional Array）。

最简单的多维数组是二维数组，定义方式如下：![image-20241107003611854](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241107003611854.png)



#### Map

```
for (const value of map.values()) {
  console.log(value);
}
```

#### TypeScript 元组

我们知道数组中元素的数据类型都一般是相同的（any[] 类型的数组可以不同），如果存储的元素数据类型不同，则需要使用元组。

TypeScript 中的元组（Tuple）是一种特殊类型的数组，它允许在数组中存储不同类型的元素，与普通数组不同，元组中的每个元素都有明确的类型和位置。元组可以在很多场景下用于表示固定长度、且各元素类型已知的数据结构。

创建元组的语法格式如下：

```java
let tuple: [类型1, 类型2, 类型3, ...];
```

我们可以使用以下两个函数向元组添加新元素或者删除元素：

- push() 向元组添加元素，添加在最后面。
- pop() 从元组中移除元素（最后一个），并返回移除的元素。

## TypeScript 模块

模块导出使用关键字 export 关键字，语法格式如下：

```java
// 文件名 : SomeInterface.ts 
export interface SomeInterface { 
   // 代码部分
}

要在另外一个文件使用该模块就需要使用 import 关键字来导入:
import someInterfaceRef = require("./SomeInterface");
```

## 声明文件

TypeScript 作为 JavaScript 的超集，在开发过程中不可避免要引用其他第三方的 JavaScript  的库。虽然通过直接引用可以调用库的类和方法，但是却无法使用TypeScript  诸如类型检查等特性功能。为了解决这个问题，需要将这些库里的函数和方法体去掉后只保留导出类型声明，而产生了一个描述 JavaScript  库和模块信息的声明文件。通过引用这个声明文件，就可以借用 TypeScript 的各种特性来使用库文件了。

假如我们想使用第三方库，比如 jQuery，我们通常这样获取一个 id 是 foo 的元素：

```java
$('#foo');
// 或
jQuery('#foo');
```

但是在 TypeScript 中，我们并不知道 $ 或 jQuery 是什么东西，需要使用 declare 关键字来定义它的类型，帮助 TypeScript 判断我们传入的参数类型对不对：

```java
declare var jQuery: (selector: string) => any;

jQuery('#foo');
```

<font color='orange'>declare 定义的类型只会用于编译时的检查，编译结果中会被删除。</font>

![image-20241107005150073](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241107005150073.png)

```java
很多流行的第三方库的声明文件不需要我们定义了，比如 jQuery 已经有人帮我们定义好了

/// <reference types="sizzle" />
/// <reference path="JQueryStatic.d.ts" />
/// <reference path="JQuery.d.ts" />
/// <reference path="misc.d.ts" />
/// <reference path="legacy.d.ts" />

export = jQuery;
```

