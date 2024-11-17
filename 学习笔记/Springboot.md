# Springboot

官网：https://spring.io/

## 一、手动创建springboot项目

1.创建项目

![image-20241104012511265](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104012511265.png)

2.引入依赖

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sakura</groupId>
    <artifactId>springboot01</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <!-- 引入 Spring Boot 统一版本父项目管理依赖 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.18</version>
    </parent>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.7.18</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>2.7.18</version>

        </dependency>
        <!--springboot热部署依赖自动刷新更改内容-->
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <version>2.7.18</version>
        </dependency>

    </dependencies>
    <!-- SpringBoot应用打包插件 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

3.创建程序启动类/主入口

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```

4.创建测试类

```
package com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
@SpringBootTest
public class HellowWord {
    @Test
    public void test(){
        System.out.println("hello");
    }
}
```

5.测试结果

![image-20241104013017052](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104013017052.png)

![image-20241104013036225](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104013036225.png)

###### 出现该界面创建成功

** **

#### 建包需要在application同级目录下否则扫描不到

![image-20241104013437191](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104013437191.png)

## 二、项目打包

1.引入打包插件

```java
   <!-- SpringBoot应用打包插件 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

2.第一步clean

![image-20241104015251348](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104015655506.png)

![image-20241104015716137](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104015716137.png)

3.package

![image-20241104015740143](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104015740143.png)

4.执行结果

```java
java -jar springboot01-1.0-SNAPSHOT.jar
```



![image-20241104020014020](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104020014020.png)

出现则为成功

![image-20241104020129470](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104020129470.png)

## 三、springboot修改端口和banner

1.在src目录下新建路径

![image-20241104022005739](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104022005739.png)

2.修改端口application文件中修改

![image-20241104022115791](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104022115791.png)

3.修改banner

在resources目录下创建banner文件（https://www.bootschool.net/ascii-art/search）

![image-20241104022413124](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104022413124.png)

## 四、springboot自动配置原理

1.SpringBoot启动会加载大量的自动配置类

2.看需要的功能有没有在SpringBoot默认写好的自动配置类当中;
3.看这个自动配置类中到底配置了哪些组件;(只要我们要用的组件存在在其中，我们就不需要再手动配置了)
4.给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可;
xxxxAutoConfigurartion:自动配置类;给容器中添加组件

xxxxProperties:封装配置文件中相关属性



1.pom.xml

* spring-boot-dependencies ：核心依赖在父工程中![image-20241104130942994](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104130942994.png)
* ![image-20241104131056598](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104131056598.png)

## 主程序

```java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication//标注这个类是一个springboot启动应用
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```

## 注解

```java
@SpringBootConfiguration//springboot的配置，启动类下的所有资源被导入
@Configuration//spring配置类
@Component//也是spring一个组件


@EnableAutoConfiguration//自动配置
@AutoConfigurationPackage//自动配置包
@Import({AutoConfigurationPackages.Registrar.class})//自动配置包注册
@Import({AutoConfigurationImportSelector.class})//自动配置导入选择
//获取所有的配置
 List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);


//获取候选的配置
  protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
        List<String> configurations = new ArrayList(SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader()));
        ImportCandidates.load(AutoConfiguration.class, this.getBeanClassLoader()).forEach(configurations::add);
        Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories nor in META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports. If you are using a custom packaging, make sure that file is correct.");
        return configurations;
    }
```

自动配置核心配置文件：

![image-20241104134820405](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241104134820405.png)

### 所有的springboot配置都是在启动的时候扫描并加载，但是不一定生效，需要对应的启动器，相应的自动装配才会生效



##  五、JSR303校验使用步骤：

内置注解：
@Null 被注释的元素必须为 null
@NotNull 被注释的元素必须不为 null
@AssertTrue 被注释的元素必须为 true
@AssertFalse 被注释的元素必须为 false
@Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max, min) 被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction) 被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past 被注释的元素必须是一个过去的日期
@Future 被注释的元素必须是一个将来的日期
@Pattern(value) 被注释的元素必须符合指定的正则表达式
Hibernate扩展注解：
@Email 被注释的元素必须是电子邮箱地址
@Length 被注释的字符串的大小必须在指定的范围内
@NotEmpty 被注释的字符串的必须非空
@Range 被注释的元素必须在合适的范围内

1.依赖

```java
 <!--数据校验-->
 <dependency>
     <groupId>javax.validation</groupId>
     <artifactId>validation-api</artifactId>
     <version>2.0.1.Final</version>
 </dependency>
```

2.在entity类的属性上添加注解

3.开启校验功能：在controller类的方法的参数上加上@Valid属性

4.校验失败的处理

- 第一种：单独处理

```java
public R save(@Valid @RequestBody BrandEntity brand,BindingResult result){
        if(result.hasErrors()){
            Map<String,String> map = new HashMap<>();
            //1、获取校验的错误结果
            result.getFieldErrors().forEach((item)->{
                //FieldError 获取到错误提示
                String message = item.getDefaultMessage();
                //获取错误的属性的名字
                String field = item.getField();
                map.put(field,message);
            });
            return R.error(400,"提交的数据不合法").put("data",map);
        }else {
			brandService.save(brand);
        }
        return R.ok();
    }
```

- 第二种，抛出异常后统一处理

1. 定义`@RestControllerAdvice`处理请求异常类
2. 将`@ExceptionHandler(value= xxx.class)`注解根据异常类型标注在方法上，编写处理逻辑

```java
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((error)->{
            //存储校验字段名，以及校验字段失败提示
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){

        log.error("错误：",throwable);
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }
}
```

3.定义异常枚举类

```java
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VAILD_EXCEPTION(10001,"参数格式校验失败");
    private int code;
    private String msg;
    BizCodeEnume(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
```

## 分组校验

步骤:

1. 在校验注解上加上`groups = {xxx.class, ...}`属性，值可以是任意interface接口，例如

   `@URL(message = "logo必须是一个合法的url地址",groups={AddGroup.class,UpdateGroup.class})`；

2. 在开启校验处，将`@Valid`注解改为`@Validated({xxx.class})`，例如`@Validated({AddGroup.class})`就表示只校验该组的属性；

   注意：未添加任何分组的校验将会无效,开启娇艳的时候i如果添加了分组信息，那么只会校验同样页添加了该分组的属性。

### 自定义校验

1）、编写一个自定义的校验注解

```java
@Documented
@Constraint(validatedBy = { })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface ListValue {
    String message() default "{com.lx.common.valid.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] vals() default { };
}
```

2）、编写配置文件`ValidationMessages.properties`，给自定义的校验配置校验失败的信息

```properties
com.lx.common.valid.ListValue.message=显示状态只能为1或0
```

3）、编写一个自定义的校验器 ConstraintValidator

 实现ConstraintValidator接口，第一个参数为绑定的校验注解名，第二个参数为校验的属性类型，完成初始化与判断方法。

```java
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {

    private Set<Integer> set = new HashSet<>();
    /**
     * @Description: 根据注解中的属性初始化
     * @Param0: constraintAnnotation
     **/
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for (int val:vals) {
            set.add(val);
        }
    }

    /**
     * @Description: 判断校验是否成功
     * @Param0: value 被校验值
     * @Param1: context
     **/
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
```

4）、关联自定义的校验器和自定义的校验注解

```java
@Constraint(validatedBy = { ListValueConstraintValidator.class })
```

5）、使用

```java
@NotNull(groups = {AddGroup.class, UpdateGroup.class})
@ListValue(vals = {0,1},groups = {AddGroup.class,UpdateGroup.class})
private Integer showStatus;
```

完整代码

conteoller

```java
/**
 * 保存
 */
@RequestMapping("/save")
public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand){
    brandService.save(brand);

    return R.ok();
}

/**
 * 修改
 */
@RequestMapping("/update")
public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
    brandService.updateById(brand);

    return R.ok();
}
```

entity

```java
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改必须指定品牌id",groups = {UpdateGroup.class})
	@Null(message = "新增不能指定id",groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo必须是一个合法的url地址",groups={AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups = {AddGroup.class, UpdateGroup.class})
	@ListValue(vals = {0,1},groups = {AddGroup.class,UpdateGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups={AddGroup.class})
	@Pattern(regexp="^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups={AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(groups={AddGroup.class})
	@Min(value = 0,message = "排序必须大于等于0",groups={AddGroup.class,UpdateGroup.class})
	private Integer sort;

```

## 六、springboo的多环境配置

可以选择激活配置文件:

1.properties文件

```java
spring.profiles.active=dev（修改dev）
```

2.yaml文件

```java
server:
 port: 8081
spring:
 profiles:
 active:dev//激活dev环境
---     
server:
 port: 8082
spring:
 profiles:dev
---     
server:
 port: 8083
spring:
 profiles:test
```



## 七、springboot Web开发

1.问题：

![image-20241105094502910](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241105094502910.png)

解决：

* 只有将application启动类与controller放在同一目录下，无论是用@Controller @ReponseBody，或者@RequstController，都可以扫描到。

* 不在同一路径下，@[SpringBootApplication注解](https://so.csdn.net/so/search?q=SpringBootApplication注解&spm=1001.2101.3001.7020)并不知道我的controller的存在，需要给@SpringBootApplication指条路。

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackageClasses =com.controller.HelloWord.class)//标注这个类是一个springboot启动应用，scanBasePackageClasses给springboot指明扫描类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 使用java8创建springboot项目

在server url处配置阿里云镜像，就可以选择java8版本

![image-20241105095349239](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241105095349239.png)



## 八、静态资源导入

```
public void addResourceHandlers(ResourceHandlerRegistry registry)  {

    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
    } else {
        this.addResourceHandler(registry, "/webjars/**", "classpath:/META-INF/resources/webjars/");
        this.addResourceHandler(registry, this.mvcProperties.getStaticPathPattern(), (registration) -> {
            registration.addResourceLocations(this.resourceProperties.getStaticLocations());
            if (this.servletContext != null) {
                ServletContextResource resource = new ServletContextResource(this.servletContext, "/");
                registration.addResourceLocations(new Resource[]{resource});
            }

        });
    }
}
```



1.在springBoot可以使用以下方式处理静态资源：

* webjars            localhost://8080/webjars/资源存储路径

* public, static,/**,resources            已经被映射过可以直接使用 localhost://8080/  直接访问

2.优先级： resources>static(默认使用static)>public

## 九、首页定制

1.默认static目录下的index.html文件为首页

2.使用templates文件夹下需要使用controller来跳转，同时也需要引入thymeleaf包才可以使用

![image-20241105205740914](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241105205740914.png)

修改图标需要把默认图标关闭,新版本无

```java
spring.mvc.favicon.enabled=false
```



![image-20241105210609772](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241105210609772.png)

## 十、Thymeleaf

官网：https://www.thymeleaf.org/

![thymeleaf](C:\Users\27449\Desktop\thymeleaf.png)

Thymeleaf是适用于Web和独立环境的现代服务器端`Java模板引擎`

* Thymeleaf导入时需要注意默认包版本在3.0以上才可以使用（springboot默认版本可能是2.x）

  ```java
    <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf -->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>
          <!-- https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf-spring5 -->
          <dependency>
              <groupId>org.thymeleaf</groupId>
              <artifactId>thymeleaf-spring5</artifactId>
              <version>3.0.15.RELEASE</version>
          </dependency>
  ```

1.所有的thymelraf模版引擎都需要写在templates目录下

2.templates目录下文件都需要controller来控制跳转，thymeleaf已自动为文件添加前后缀

![image-20241105220611978](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241105220611978.png)

3.thymeleaf的使用必须要注意springboot版本
