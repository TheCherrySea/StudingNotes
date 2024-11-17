# Ymal语法

对空格要求较高，yaml可以给实体类赋值

1.普通的key-value

```java
name: sakura
```

2.对象

```java
#键值对
name: sakura
#对象：
student:
  name: sakura
  age: 3

#对象的行内写法
test: {name: sakura,age: 3}

#数组
pets:
  - cat
  - dog
  - pig
    
    pet:[cat,dog,pig]
```



3.绑定

![image-20241104145953428](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104145953428.png)

## properties配置文件取值

![image-20241104145834245](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104145834245.png)