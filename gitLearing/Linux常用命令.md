Linux常用命令

![image-20241029211704911](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029211704911.png)

# Git的使用方法

1.![image-20241029212000605](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029212000605.png)

2.![image-20241029212529269](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029212529269.png)

3.![image-20241029212802710](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029212802710.png)

4.idea中会自动生成该文件

![image-20241029213023118](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029213023118.png)

idea重生成文件位置![image-20241029213101113](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241029213101113.png)



## 本机绑定github免密登录

1.现在本地.ssh目录下生成公钥文件

![image-20241030134251932](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030134251932.png)

![image-20241030134259666](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030134259666.png)

2.进行与github账户绑定

![image-20241030134350533](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030134350533.png)



![image-20241030134408301](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030134408301.png)

3.将生成的公钥粘贴

![image-20241030134633366](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030134633366.png)

4.验证本地绑定是否成功（ssh -T git@github.com）

![image-20241030140756783](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030140756783.png)

5.与远程仓库连接

git remote add origin https://github.com/TheCherrySea/StudingNotes.git(远程仓库地址)

6.查看远程仓库

git remote





## git分支管理

1.若创建分支时出现该错误

![image-20241030143503402](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030143503402.png)

原因：创建本地仓库时没有提交文件但本地仓库没有找到分支

解决：

![image-20241030143651345](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030143651345.png)

2.提交后指针即可找到分支

![image-20241030143722112](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030143722112.png)

### git中常用的分支命令

1.`列出所有分支`  git branch

2.`列出所有远程分支`  git branch -a(remote)

3.`新建一个分支但依然停留在当前分支`  git branch name(分支名)

4.`合并分支到当前分支`  git merge [branch(分支名)]

5.`删除分支`  git branch -d name(分支名)

6.`删除远程分支`  git branch -dr [remote/branch]

7.查看远程分支命令 git branch -r

8.推送本地分支到远程仓库 git push --set-upstream origin 分支名

9.将远程git仓库里的指定分支拉取到本地（本地不存在的分支）git checkout -b 本地分支名 origin/远程分支名

```
如果出现提示
fatal: Cannot update paths and switch to branch 'dev2' at the same time.
Did you intend to checkout 'origin/dev2' which can not be resolved as commit?

先执行：
git fetch

在执行
git checkout -b 本地分支名 origin/远程分支名
```

10.切换到父分支

```java
切换到父分支
git checkout
```









![image-20241030151311329](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030151311329.png)







![image-20241030151403485](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030151403485.png)

![image-20241030151508909](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030151508909.png)

## 项目提交到远程仓库

![image-20241030152401503](C:\Users\27449\AppData\Roaming\Typora\typora-user-images\image-20241030152401503.png)

如果仓库没有设置分支，需要先设置分支，再上传文件