# Typora使用技巧

## 一、标题

1. 一级标题 # 
2. 二级标题 ##

## 二、字体

*顾清寒*

**顾清寒**

***顾清寒***

 

## 三、引用

> 摘抄引用



## 四、分割线

---

***

## 五、图片

![FB5AC3148CFA9833C52503F5C553B28A](C:\Users\27449\Pictures\Camera Roll\FB5AC3148CFA9833C52503F5C553B28A.jpg)



## 六、超链接

[aeveny](https://github.com/TheCherrySea/StudingNotes.git)

## 七、表格

- aeveny

## 八、代码

```java
```

`test`

## 九、修改字体颜色

[AutoHotkey](https://www.autohotkey.com/)到官网下载，**桌面新建文件 MyHotkeyScript.ahk 将以下代码复制进去保存** 注意文件后缀`.ahk`

```java
; Typora
; 快捷增加字体颜色
; SendInput {Text} 解决中文输入法问题

#IfWinActive ahk_exe Typora.exe
{
    ; Ctrl+Alt+o 橙色
    ^!o::addFontColor("orange")

    ; Ctrl+Alt+r 红色
    ^!r::addFontColor("red")

    ; Ctrl+Alt+b 浅蓝色
    ^!b::addFontColor("cornflowerblue")
}

; 快捷增加字体颜色
addFontColor(color){
    clipboard := "" ; 清空剪切板
    Send {ctrl down}c{ctrl up} ; 复制
    SendInput {TEXT}<font color='%color%'>
    SendInput {ctrl down}v{ctrl up} ; 粘贴
    If(clipboard = ""){
        SendInput {TEXT}</font> ; Typora 在这不会自动补充
    }else{
        SendInput {TEXT}</ ; Typora中自动补全标签
    }
}
{
; alt+0 红色
    !0::addFontColor("black")
  
    ; alt+1 红色
    !1::addFontColor("red")

    ; alt+1 橙色
    !2::addFontColor("orange") 

     ; alt+3 黄色
    !3::addFontColor("yellow")

     ; alt+4 绿色
    !4::addFontColor("green")

    ; alt+5 浅蓝色
    !5::addFontColor("cornflowerblue")

     ; alt+6 青色
    !6::addFontColor("cyan") 

   ; alt+7 紫色
    !7::addFontColor("purple")

}
```

这里对代码的特殊符号进行解释以下：

- !感叹号代表Alt键
- 井号代表 Windows 键
- ^ 上三角号代表 Ctrl键
- 加号代表 Shift 键

双击运行（使用`AutoHotkey`运行）

### 运行脚本

​	1.双击ahk脚本运行

​	2.Typora检测

* Ctrl+Alt+O——橙色Orange

* Ctrl+Alt+R——红色Red

* Ctrl+Alt+B——蓝色Blue
