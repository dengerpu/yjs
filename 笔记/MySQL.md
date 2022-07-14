# MySql

## 第1章_MySQ环境搭建

### 1. MySQL的卸载

#### 步骤1：停止MySQL服务

在卸载之前，先停止MySQL的服务。按键盘上的“Ctrl + Alt + Delete”组合键，打开“任务管理器”对话框，可以在“服务”列表找到“MySQL”的服务，如果现在“正在运行”状态，可以右键单击服务，选择“停 止”选项停止MySQL的服务，如图所示。

![image-20220712140522300](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712140522300.png)

#### 步骤2：软件的卸载

##### 方式1：通过控制面板方式

卸载MySQL的程序可以和其他桌面应用程序一样直接在“控制面板”选择“卸载程序”，并在程序列表中找到MySQL服务器程序，直接双击卸载即可，如图所示。这种方式删除，数据目录下的数据不会跟着删除。

![image-20220712140808778](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712140808778.png)

##### 方式2：通过360或电脑管家等软件卸载

略

##### 方式3：通过安装包提供的卸载功能卸载

你也可以通过安装向导程序进行MySQL服务器程序的卸载。

① 再次双击下载的mysql-installer-community-8.0.26.0.msi文件，打开安装向导。安装向导会自动检测已

安装的MySQL服务器程序。

② 选择要卸载的MySQL服务器程序，单击“Remove”（移除），即可进行卸载。

![image-20220712140940490](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712140940490.png)

③ 单击“Next”（下一步）按钮，确认卸载。

![image-20220712141008332](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712141008332.png)

④ 弹出是否同时移除数据目录选择窗口。如果想要同时删除MySQL服务器中的数据，则勾选“Remove the data directory”，如图所示。

![image-20220712141125222](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712141125222.png)

⑤ 执行卸载。单击“Execute”（执行）按钮进行卸载。

![image-20220712141158850](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712141158850.png)

⑥ 完成卸载。单击“Finish”（完成）按钮即可。如果想要同时卸载MySQL8.0的安装向导程序，勾选“Yes， Uninstall MySQL Installer”即可，如图所示。

![image-20220712141229000](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712141229000.png)

#### 步骤3：残余文件的清理

如果再次安装不成功，可以卸载后对残余文件进行清理后再安装。

（1）服务目录：mysql服务的安装目录

（2）数据目录：默认在C:\ProgramData\MySQL

如果自己单独指定过数据目录，就找到自己的数据目录进行删除即可。

> 注意：请在卸载前做好数据备份
>
> 在操作完以后，需要重启计算机，然后进行安装即可。如果仍然安装失败，需要继续操作如下步骤4。 

#### 步骤4：清理注册表（选做）

如果前几步做了，再次安装还是失败，那么可以清理注册表。

如何打开注册表编辑器：在系统的搜索框中输入 regedit

```shell
HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\MySQL服务 目录删除 

HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\Eventlog\Application\MySQL服务 目录删除 

HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\MySQL服务 目录删除 

HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Eventlog\Application\MySQL服务目录 

删除

HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\MySQL服务删除
```

>注册表中的ControlSet001,ControlSet002,不一定是001和002,可能是ControlSet005、006之类

步骤5：删除环境变量配置

找到path环境变量，将其中关于mysql的环境变量删除，切记不要全部删除。

例如：删除 D:\Program Files\MySQL\MySQL Server 5.5\bin; 这个部分

![image-20220712142051849](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142051849.png)

### 2. MySQL8.0的下载、安装、配置

> MySQL Community Server 社区版本，开源免费，自由下载，但不提供官方技术支持，适用于大多数普通用户。
>
> MySQL Enterprise Edition 企业版本，需付费，不能在线下载，可以试用30天。提供了更多的功能和更完备的技术支持，更适合于对数据库的功能和可靠性要求较高的企业客户。
>
> MySQL Cluster 集群版，开源免费。用于架设集群服务器，可将几个MySQL Server封装成一个Server。需要在社区版或企业版的基础上使用。
>
> MySQL Cluster CGE 高级集群版，需付费。

此外，官方还提供了 MySQL Workbench （GUITOOL）一款专为MySQL设计的 图形界面管理工具 。 

MySQLWorkbench又分为两个版本，分别是 社区版 （MySQL Workbench OSS）、 商用版 （MySQL WorkbenchSE）。

#### 2.1 软件的下载 

1.下载地址

官网：https://www.mysql.com 

2. 打开官网，点击DOWNLOADS

然后，点击 MySQL Community(GPL) Downloads 

![image-20220712142350312](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142350312.png)

3. 点击 MySQL Community Server

![image-20220712142457712](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142457712.png)

4. 在General Availability(GA) Releases中选择适合的版本

Windows平台下提供两种安装文件：MySQL二进制分发版（.msi安装文件）和免安装版（.zip压缩文件）。一般来讲，应当使用二进制分发版，因为该版本提供了图形化的安装向导过程，比其他的分发版使用起来要简单，不再需要其他工具启动就可以运行MySQL。

这里在Windows 系统下推荐下载 MSI安装程序 ；点击 Go to Download Page 进行下载即可

![image-20220712142703177](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142703177.png)



![image-20220712142752665](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142752665.png)

Windows下的MySQL8.0安装有两种安装程序

mysql-installer-web-community-8.0.29.0.msi 下载程序大小：2.4M；安装时需要联网安装组件。

mysql-installer-community-8.0.29.0.msi 下载程序大小：450.7M；安装时离线安装即可。推荐。

如果安装MySQL5.7版本的话，选择 Archives ，接着选择MySQL5.7的相应版本即可。这里下载最近期的MySQL5.7.37版本。

![image-20220712142927701](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712142927701.png)

![image-20220712143027324](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712143027324.png)

#### 2.2 MySQL8.0 版本的安装 

MySQL下载完成后，找到下载文件，双击进行安装，具体操作步骤如下。

步骤1：双击下载的mysql-installer-community-8.0.26.0.msi文件，打开安装向导。

步骤2：打开“Choosing a Setup Type”（选择安装类型）窗口，在其中列出了5种安装类型，分别是Developer Default（默认安装类型）、Server only（仅作为服务器）、Client only（仅作为客户端）、Full（完全安装）、Custom（自定义安装）。这里选择“Custom（自定义安装）”类型按钮，单击“Next(下一步)”按钮。

![image-20220712143134006](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712143134006.png)

步骤3：打开“Select Products” （选择产品）窗口，可以定制需要安装的产品清单。例如，选择“MySQL Server 8.0.26-X64”后，单击“→”添加按钮，即可选择安装MySQL服务器，如图所示。采用通用的方法，可以添加其他你需要安装的产品。

![image-20220712143259759](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712143259759.png)

此时如果直接“Next”（下一步），则产品的安装路径是默认的。如果想要自定义安装目录，则可以选中对应的产品，然后在下面会出现“Advanced Options”（高级选项）的超链接。

![image-20220712143350335](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712143350335.png)

ProgramData目录（这是一个隐藏目录）。如果自定义安装目录，请避免“中文”目录。另外，建议服务目录和数据目录分开存放。

![image-20220712143846791](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712143846791.png)

步骤4：在上一步选择好要安装的产品之后，单击“Next”（下一步）进入确认窗口，如图所示。单击“Execute”（执行）按钮开始安装。

![image-20220712144015735](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144015735.png)

步骤5：安装完成后在“Status”（状态）列表下将显示“Complete”（安装完成），如图所示。

![image-20220712144043236](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144043236.png)

#### 2.3 配置MySQL8.0 

MySQL安装之后，需要对服务器进行配置。具体的配置步骤如下。

步骤1：在上一个小节的最后一步，单击“Next”（下一步）按钮，就可以进入产品配置窗口。

![image-20220712144122924](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144122924.png)

![image-20220712144145607](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144145607.png)

其中，“Config Type”选项用于设置服务器的类型。单击该选项右侧的下三角按钮，即可查看3个选项，如图所示。

![image-20220712144226292](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144226292.png)

Server Machine（服务器） ：该选项代表服务器，MySQL服务器可以同其他服务器应用程序一起运行，例如Web服务器等。MySQL服务器配置成适当比例的系统资源。

Dedicated Machine（专用服务器） ：该选项代表只运行MySQL服务的服务器。MySQL服务器配置成使用所有可用系统资源。

步骤3：单击“Next”（下一步）按钮，打开设置授权方式窗口。其中，上面的选项是MySQL8.0提供的新的授权方式，采用SHA256基础的密码加密方法；下面的选项是传统授权方法（保留5.x版本兼容性）。

![image-20220712144422758](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144422758.png)

步骤4：单击“Next”（下一步）按钮，打开设置服务器root超级管理员的密码窗口，如图所示，需要输入两次同样的登录密码。也可以通过“Add User”添加其他用户，添加其他用户时，需要指定用户名、允许该用户名在哪台/哪些主机上登录，还可以指定用户角色等。

![image-20220712144515812](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144515812.png)

步骤5：单击“Next”（下一步）按钮，打开设置服务器名称窗口，如图所示。该服务名会出现在Windows服务列表中，也可以在命令行窗口中使用该服务名进行启动和停止服务。本书将服务名设置为“MySQL80”。如果希望开机自启动服务，也可以勾选“Start the MySQL Server at System Startup”选项（推荐）。

下面是选择以什么方式运行服务？可以选择“Standard System Account”(标准系统用户)或者“Custom User” (自定义用户)中的一个。这里推荐前者。

![image-20220712144620545](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144620545.png)

![image-20220712144641733](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144641733.png)

步骤7：完成配置，如图所示。单击“Finish”（完成）按钮，即可完成服务器的配置。

![image-20220712144705302](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144705302.png)

步骤8：如果还有其他产品需要配置，可以选择其他产品，然后继续配置。如果没有，直接选择“Next”（下一步），直接完成整个安装和配置过程

![image-20220712144732113](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144732113.png)

步骤9：结束安装和配置。

![image-20220712144754654](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712144754654.png)

#### 2.4环境变量配置

如果不配置MySQL环境变量，就不能在命令行直接输入MySQL登录命令。下面说如何配置MySQL的环境变量：

步骤1：在桌面上右击【此电脑】图标，在弹出的快捷菜单中选择【属性】菜单命令。 

步骤2：打开【系统】窗口，单击【高级系统设置】链接。 

步骤3：打开【系统属性】对话框，选择【高级】选项卡，然后单击【环境变量】按钮。

 步骤4：打开【环境变量】对话框，在系统变量列表中选择path变量。 

步骤5：单击【编辑】按钮，在【编辑环境变量】对话框中，将MySQL应用程序的bin目录（

C:\Program Files\MySQL\MySQL Server 8.0\bin）添加到变量值中，用分号将其与其他路径分隔开。 

步骤6：添加完成

之后，单击【确定】按钮，这样就完成了配置path变量的操作，然后就可以直接输入MySQL命令来登录数据库了。

#### 2.5MySQL5.7 版本的安装、配置

安装

此版本的安装过程与上述过程除了版本号不同之外，其它环节都是相同的。所以这里省略了MySQL5.7.34版本的安装截图。

配置

配置环节与MySQL8.0版本确有细微不同。大部分情况下直接选择“Next”即可，不影响整理使用。

这里配置MySQL5.7时，重点强调：与前面安装好的MySQL8.0不能使用相同的端口号。

#### 2.6安装失败问题 

MySQL的安装和配置是一件非常简单的事，但是在操作过程中也可能出现问题，特别是初学者。

问题1：无法打开MySQL8.0软件安装包或者安装过程中失败，如何解决？

在运行MySQL8.0软件安装包之前，用户需要确保系统中已经安装了.Net Framework相关软件，如果缺少此软件，将不能正常地安装MySQL8.0软件。

![image-20220712145123062](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712145123062.png)

另外，还要确保Windows Installer正常安装。windows上安装mysql8.0需要操作系统提前已安装好Microsoft Visual C++ 2015-2019。

![image-20220712145204984](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712145204984.png)

![image-20220712145215927](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712145215927.png)

问题2：卸载重装MySQL失败？

该问题通常是因为MySQL卸载时，没有完全清除相关信息导致的。

解决办法是，把以前的安装目录删除。如果之前安装并未单独指定过服务安装目录，则默认安装目录是“C:\Program Files\MySQL”，彻底删除该目录。同时删除MySQL的Data目录，如果之前安装并未单独指定过数据目录，则默认安装目录是“C:\ProgramData\MySQL”，该目录一般为隐藏目录。删除后，重新安装即可。

问题3：如何在Windows系统删除之前的未卸载干净的MySQL服务列表？

操作方法如下，在系统“搜索框”中输入“cmd”，按“Enter”（回车）键确认，弹出命令提示符界面。然后输入“sc delete MySQL服务名”,按“Enter”（回车）键，就能彻底删除残余的MySQL服务了。

### 3. MySQL的登录

#### 3.1 服务的启动与停止 

MySQL安装完毕之后，需要启动服务器进程，不然客户端无法连接数据库。

在前面的配置过程中，已经将MySQL安装为Windows服务，并且勾选当Windows启动、停止时，MySQL也自动启动、停止。

方式1：使用图形界面工具

步骤1：打开windows服务

* 方式1：计算机（点击鼠标右键）→ 管理（点击）→ 服务和应用程序（点击）→ 服务（点击）

* 方式2：控制面板（点击）→ 系统和安全（点击）→ 管理工具（点击）→ 服务（点击）

* 方式3：任务栏（点击鼠标右键）→ 启动任务管理器（点击）→ 服务（点击）

* 方式4：单击【开始】菜单，在搜索框中输入“services.msc”，按Enter键确认

步骤2：找到MySQL80（点击鼠标右键）→ 启动或停止（点击）

![image-20220712145808177](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712145808177.png)

##### 1.启动mySql服务命令

```shell
net start mysql   (后面填的是mysql服务名)
```

##### 2.停止mySql服务命令

```shell
net stop mysql
```

![image-20220712150031722](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712150031722.png)

说明：

1. start和stop后面的服务名应与之前配置时指定的服务名一致。

2. 如果当你输入命令后，提示“拒绝服务”，请以 系统管理员身份 打开命令提示符界面重新尝试。

#### 3.2 自带客户端的登录与退出 

当MySQL服务启动完成后，便可以通过客户端来登录MySQL数据库。注意：确认服务是开启的。

登录方式1：MySQL自带客户端

开始菜单 → 所有程序 → MySQL → MySQL 8.0 Command Line Client

![image-20220712150116416](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712150116416.png)

> 说明：仅限于root用户

格式：

```shell
mysql -h 主机名 -P 端口号 -u 用户名 -p密码
```

举例：(端口-P   P是大写)

```shell
mysql -h localhost -P 3306 -u root -proot # 这里我设置的root用户的密码是root
```

![image-20220712150709419](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712150709419.png)

注意：

（1）-p与密码之间不能有空格，其他参数名与参数值之间可以有空格也可以没有空格。如：

```shell
mysql -hlocalhost -P3306 -uroot -proot
```

（2）密码建议在下一行输入，保证安全

```shell
mysql -h localhost -P 3306 -u root -p
Enter password:
```

（3）客户端和服务器在同一台机器上，所以输入localhost或者IP地址127.0.0.1。同时，因为是连接本机： -hlocalhost就可以省略，如果端口号没有修改：-P3306也可以省略简写成：

##### 1.命令行登陆

```shell
mysql -uroot -p
Enter password: 
```

连接成功后，有关于MySQL Server服务版本的信息，还有第几次连接的id标识。

也可以在命令行通过以下方式获取MySQL Server服务版本的信息：

##### 2.查看版本信息

```shell
mysql -V  (v大写)
```

```shell
mysql --version
```

或登录后，通过以下方式查看当前版本信息：

```mysql
 select version();
```

![image-20220712152347588](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712152347588.png)

##### 3退出

```mysql
exit
或
quit
```

### 4. MySQL演示使用

#### 4.1 MySQL的使用演示 

> 注：所有的命令后面都要加分号

##### 1、查看所有的数据库

```mysql
show databases;
```

> “information_schema”是 MySQL 系统自带的数据库，主要保存 MySQL 数据库服务器的系统信息，比如数据库的名称、数据表的名称、字段名称、存取权限、数据文件 所在的文件夹和系统使用的文件夹，等等
>
> “performance_schema”是 MySQL 系统自带的数据库，可以用来监控 MySQL 的各类性能指标。
>
> “sys”数据库是 MySQL 系统自带的数据库，主要作用是以一种更容易被理解的方式展示 MySQL 数据库服务器的各类性能指标，帮助系统管理员和开发人员监控 MySQL 的技术性能。
>
> “mysql”数据库保存了 MySQL 数据库服务器运行时需要的系统信息，比如数据文件夹、当前使用的字符集、约束检查信息，等等

为什么 Workbench 里面我们只能看到“demo”和“sys”这 2 个数据库呢？

这是因为，Workbench 是图形化的管理工具，主要面向开发人 员，“demo”和“sys”这 2 个数据库已经够用了。如果有特殊需求，比如，需要监控 MySQL 数据库各项性能指标、直接操作 MySQL 数据库系统文件等，可以由 DBA 通过 SQL 语句，查看其它的系统数据库。

##### 2、创建自己的数据库

```mysql
create database 数据库名; 
#创建learnmysql数据库，该名称不能与已经存在的数据库重名。
create database learnmysql;
```

##### 3、使用自己的数据库

```mysql
use 数据库名; 
#使用learnmysql数据库 
use learnmysql;
```

>  说明：如果没有使用use语句，后面针对数据库的操作也没有加“数据名”的限定，那么会报“ERROR 1046 (3D000): No database selected”（没有选择数据库）

使用完use语句之后，如果接下来的SQL都是针对一个数据库操作的，那就不用重复use了，如果要针对另一个数据库操作，那么要重新use。

![image-20220712160503180](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712160503180.png)

##### 4、查看某个库的所有表格

```mysql
show tables from 数据库名;
```

##### 5、创建新的表格

```mysql
create table 表名称( 
    字段名 数据类型, 
    字段名 数据类型 
);
```

> 说明：如果是最后一个字段，后面就不用加逗号，因为逗号的作用是分割每个字段。

例如：

```mysql
#创建学生表 
create table student( 
	id int, 
	name varchar(20) #说名字最长不超过20个字符 
);
```

##### 6、查看一个表的数据

```mysql
select  from 数据库名称;
```

```mysql
#查看学生表的数据 
select  from student;
```

##### 7、添加一条记录

```mysql
insert into 表名称 values(值列表); 
#添加两条记录到student表中 
insert into student values(1,'张三'); 
insert into student values(2,'李四');
```

报错：

```mysql
mysql> insert into student values(1,'张三'); 
ERROR 1366 (HY000): Incorrect string value: '\xD5\xC5\xC8\xFD' for column 'name' at row 1 
mysql> insert into student values(2,'李四'); 
ERROR 1366 (HY000): Incorrect string value: '\xC0\xEE\xCB\xC4' for column 'name' at row 1 
mysql> show create table student;
```

![image-20220712161638214](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712161638214.png)

字符集的问题。

##### 8、查看表的创建信息

```mysql
show create table 表名称\G 

#查看student表的详细创建信息 
show create table student\G
       Table: student
Create Table: CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
1 row in set (0.00 sec)
```

##### 9、查看数据库的创建信息

```mysql
show create database 数据库名\G

#查看learnmysql数据库的详细创建信息
mysql> show create database learnmysql\G
#结果
 1. row 
       Database: learnmysql
Create Database: CREATE DATABASE `learnmysql` /!40100 DEFAULT CHARACTER SET utf8 /
1 row in set (0.00 sec)
```

##### 10、删除表格

```mysql
drop table 表名称;

#删除学生表 
drop table student;
```

##### 11、删除数据库

```mysql
drop database 数据库名;
#删除atguigudb数据库 
drop database learnmysql;
```

#### 4.2 MySQL的编码设置 

##### MySQL5.7中

问题再现：命令行操作sql乱码问题

```mysql
mysql> INSERT INTO t_stu VALUES(1,'张三','男');
ERROR 1366 (HY000): Incorrect string value: '\xD5\xC5\xC8\xFD' for column 'sname' at row 1
```

问题解决

步骤1：查看编码命令

```mysql
show variables like 'character_%'; 
show variables like 'collation_%';
```

步骤2：修改mysql的数据目录下的my.ini配置文件

```ini
default-character-set=utf8 
#默认字符集 [mysqld]
# 大概在76行左右，在其下添加 
... 
character-set-server=utf8
collation-server=utf8_general_ci
```

> 注意：建议修改配置文件使用notepad++等高级文本编辑器，使用记事本等软件打开修改后可能会导致文件编码修改为“含BOM头”的编码，从而服务重启失败。

步骤3：重启服务

步骤4：查看编码命令

```mysql
show variables like 'character_%'; 
show variables like 'collation_%';
```

![image-20220712163514386](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712163514386.png)

如果是以上配置就说明对了。接着我们就可以新创建数据库、新创建数据表，接着添加包含中文的数据了。

上述方法不行，还是添加不了，请看下面

```mysql
set names gbk;
```

![image-20220712164120432](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164120432.png)

插入成功

![image-20220712164137755](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164137755.png)

##### MySQL8.0中 

在MySQL 8.0版本之前，默认字符集为latin1，utf8字符集指向的是utf8mb3。网站开发人员在数据库设计的时候往往会将编码修改为utf8字符集。如果遗忘修改默认的编码，就会出现乱码的问题。从MySQL 8.0开始，数据库的默认编码改为 utf8mb4 ，从而避免了上述的乱码问题。

### 5. MySQL图形化管理工具

MySQL图形化管理工具极大地方便了数据库的操作与管理，常用的图形化管理工具有：MySQL Workbench、phpMyAdmin、Navicat Preminum、MySQLDumper、SQLyog、dbeaver、MySQL ODBC Connector。 

#### 工具1. MySQL Workbench 

MySQL官方提供的图形化管理工具MySQL Workbench完全支持MySQL 5.0以上的版本。MySQL Workbench分为社区版和商业版，社区版完全免费，而商业版则是按年收费。

MySQL Workbench 为数据库管理员、程序开发者和系统规划师提供可视化设计、模型建立、以及数据库管理功能。它包含了用于创建复杂的数据建模ER模型，正向和逆向数据库工程，也可以用于执行通常需要花费大量时间的、难以变更和管理的文档任务。

下载地址：http://dev.mysql.com/downloads/workbench/。

使用：首先，我们点击 Windows 左下角的“开始”按钮，如果你是 Win10 系统，可以直接看到所有程序。接着，找到“MySQL”，点开，找到“MySQL Workbench 8.0 CE”。点击打开 Workbench，如下图所示：

![image-20220712164518305](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164518305.png)

左下角有个本地连接，点击，录入 Root 的密码，登录本地 MySQL 数据库服务器，如下图所示：

![image-20220712164543085](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164543085.png)

![image-20220712164627645](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164627645.png)

![image-20220712164640805](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712164640805.png)

这是一个图形化的界面，我来给你介绍下这个界面。

* 上方是菜单。左上方是导航栏，这里我们可以看到 MySQL 数据库服务器里面的数据 库，包括数据表、视图、存储过程和函数；左下方是信息栏，可以显示上方选中的数据 库、数据表等对象的信息。

* 中间上方是工作区，你可以在这里写 SQL 语句，点击上方菜单栏左边的第三个运行按 钮，就可以执行工作区的 SQL 语句了。

* 中间下方是输出区，用来显示 SQL 语句的运行情况，包括什么时间开始运行的、运行的 内容、运行的输出，以及所花费的时长等信息。

#### 工具2. Navicat 

Navicat MySQL是一个强大的MySQL数据库服务器管理和开发工具。它可以与任何3.21或以上版本的MySQL一起工作，支持触发器、存储过程、函数、事件、视图、管理用户等，对于新手来说易学易用。其精心设计的图形用户界面（GUI）可以让用户用一种安全简便的方式来快速方便地创建、组织、访问和共享信息。Navicat支持中文，有免费版本提供。 下载地址：http://www.navicat.com/。 

![image-20220712165418016](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712165418016.png)

#### 工具3. SQLyog 

SQLyog 是业界著名的 Webyog 公司出品的一款简洁高效、功能强大的图形化 MySQL 数据库管理工具。

这款工具是使用C++语言开发的。该工具可以方便地创建数据库、表、视图和索引等，还可以方便地进行插入、更新和删除等操作，同时可以方便地进行数据库、数据表的备份和还原。该工具不仅可以通过SQL文件进行大量文件的导入和导出，还可以导入和导出XML、HTML和CSV等多种格式的数据。 下载地址：http://www.webyog.com/，读者也可以搜索中文版的下载地址。

![image-20220712165642162](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712165642162.png)

![image-20220712165703903](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712165703903.png)

#### 可能出现连接问题：

有些图形界面工具，特别是旧版本的图形界面工具，在连接MySQL8时出现“Authentication plugin 'caching_sha2_password' cannot be loaded”错误。

![image-20220712165736462](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712165736462.png)

出现这个原因是MySQL8之前的版本中加密规则是mysql_native_password，而在MySQL8之后，加密规则是caching_sha2_password。解决问题方法有两种，

* 第一种是升级图形界面工具版本，

* 第二种是把MySQL8用户登录密码加密规则还原成mysql_native_password。

第二种解决方案如下，用命令行登录MySQL数据库之后，执行如下命令修改用户密码加密规则并更新用户密码，这里修改用户名为“root@localhost”的用户密码规则为“mysql_native_password”，密码值为“123456”，如图所示。

```mysql
#使用mysql数据库 
USE mysql; 
#修改'root'@'localhost'用户的密码规则和密码 
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'abc123'; 
#刷新权限 FLUSH PRIVILEGES;
```

### 6. MySQL目录结构与源码

#### 6.1 主要目录结构 

| MySQL的目录结构                               | 说明                                 |
| --------------------------------------------- | ------------------------------------ |
| bin目录                                       | 所有MySQL的可执行文件。如：mysql.exe |
| MySQLInstanceConfig.exe                       | 数据库的配置向导，在安装时出现的内容 |
| data目录                                      | 系统数据库所在的目录                 |
| my.ini文件                                    | MySQL的主要配置文件                  |
| C:\Program Files\MySQL\MySQL Server 5.5\data\ | 用户创建的数据库所在的目录           |

#### 6.2 MySQL 源代码获取

首先，你要进入 MySQL下载界面。 这里你不要选择用默认的“Microsoft Windows”，而是要通过下拉栏，找到“Source Code”，在下面的操作系统版本里面， 选择 Windows（Architecture Independent），然后点击下载。

接下来，把下载下来的压缩文件解压，我们就得到了 MySQL 的源代码。

MySQL 是用 C++ 开发而成的，我简单介绍一下源代码的组成。

mysql-8.0.22 目录下的各个子目录，包含了 MySQL 各部分组件的源代码：

![image-20220712170833749](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712170833749.png)

* sql 子目录是 MySQL 核心代码；

* libmysql 子目录是客户端程序 API； 

* mysql-test 子目录是测试工具；

* mysys 子目录是操作系统相关函数和辅助函数；

问题1：root用户密码忘记，重置的操作 

1: 通过任务管理器或者服务管理，关掉mysqld(服务进程)

 2: 通过命令行+特殊参数开启mysqld mysqld -- defaults-file="D:\ProgramFiles\mysql\MySQLServer5.7Data\my.ini" --skip-grant-tables 

3: 此时，mysqld服务进程已经打开。并且不需要权限检查 

4: mysql -uroot 无密码登陆服务器。另启动一个客户端进行 

5: 修改权限表

 （1） use mysql; 

（2）update user set authentication_string=password('新密码') where user='root' and Host='localhost'; 

（3）flush privileges; 

6: 通过任务管理器，关掉mysqld服务进程。 

7: 再次通过服务管理，打开mysql服务。 

8: 即可用修改后的新密码登陆。

问题2：mysql命令报“不是内部或外部命令”

如果输入mysql命令报“不是内部或外部命令”，把mysql安装目录的bin目录配置到环境变量path中。如

![image-20220712171119022](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712171119022.png)

ERROR 1046 (3D000): No database selected

解决方案一：就是使用“USE 数据库名;”语句，这样接下来的语句就默认针对这个数据库进行操作

解决方案二：就是所有的表对象前面都加上“数据库.”

问题4：命令行客户端的字符集问题

```mysql
mysql> INSERT INTO t_stu VALUES(1,'张三','男'); 
ERROR 1366 (HY000): Incorrect string value: '\xD5\xC5\xC8\xFD' for column 'sname' at row 1
```

原因：服务器端认为你的客户端的字符集是utf-8，而实际上你的客户端的字符集是GBK。

![image-20220712171309610](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712171309610.png)

查看所有字符集：SHOW VARIABLES LIKE 'character_set_%'; 

解决方案，设置当前连接的客户端字符集 “SET NAMES GBK;” 

问题5：修改数据库和表的字符编码

修改编码：

（1)先停止服务，（2）修改my.ini文件（3）重新启动服务

说明：

如果是在修改my.ini之前建的库和表，那么库和表的编码还是原来的Latin1，要么删了重建，要么使用alter语句修改编码。

## 第2章_基本的SELECT语句

### 2.1SQL 分类 

SQL语言在功能上主要分为如下3大类：

* DDL（Data Definition Languages、数据定义语言），这些语句定义了不同的数据库、表、视图、索引等数据库对象，还可以用来创建、删除、修改数据库和数据表的结构。主要的语句关键字包括 CREATE 、 DROP 、 ALTER 等。

* DML（Data Manipulation Language、数据操作语言），用于添加、删除、更新和查询数据库记录，并检查数据完整性。主要的语句关键字包括 INSERT 、 DELETE 、 UPDATE 、 SELECT 等。SELECT是SQL语言的基础，最为重要。

* DCL（Data Control Language、数据控制语言），用于定义数据库、表、字段、用户的访问权限和安全级别。主要的语句关键字包括 GRANT 、 REVOKE 、 COMMIT 、 ROLLBACK 、 SAVEPOINT 等。

> 因为查询语句使用的非常的频繁，所以很多人把查询语句单拎出来一类：DQL（数据查询语言）。还有单独将 COMMIT 、 ROLLBACK 取出来称为TCL （Transaction Control Language，事务控制语言）。

### 2.2SQL语言的规则与规范

1.SQL 可以写在一行或者多行。为了提高可读性，各子句分行写，必要时使用缩进

* 每条命令以 ; 或 \g 或 \G 结束

* 关键字不能被缩写也不能分行

* 关于标点符号
  * 必须保证所有的()、单引号、双引号是成对结束的
  * 必须使用英文状态下的半角输入方式
  * 字符串型和日期时间类型的数据可以使用单引号（' '）表示列的别名，尽量使用双引号（" "），而且不建议省略as 

2SQL大小写规范 （建议遵守） 

* MySQL 在 Windows 环境下是大小写不敏感的

* MySQL 在 Linux 环境下是大小写敏感的
  * 数据库名、表名、表的别名、变量名是严格区分大小写的
  * 关键字、函数名、列名(或字段名)、列的别名(字段的别名) 是忽略大小写的。

* 推荐采用统一的书写规范：

  * 数据库名、表名、表别名、字段名、字段别名等都小写

  * SQL 关键字、函数名、绑定变量等都大写

3 注 释

可以使用如下格式的注释结构

```mysql
单行注释：#注释文字(MySQL特有的方式) 
单行注释：-- 注释文字(--后面必须包含一个空格。) 
多行注释：/ 注释文字 /
```

4 命名规则（暂时了解）

* 数据库、表名不得超过30个字符，变量名限制为29个
* 必须只能包含 A–Z, a–z, 0–9, _共63个字符
* 数据库名、表名、字段名等对象名中间不要包含空格
* 同一个MySQL软件中，数据库不能同名；同一个库中，表不能重名；同一个表中，字段不能重名
* 必须保证你的字段没有和保留字、数据库系统或常用方法冲突。如果坚持使用，请在SQL语句中使用`（着重号）引起来
* 保持字段名和类型的一致性，在命名字段并为其指定数据类型的时候一定要保证一致性。假如数据类型在一个表里是整数，那在另一个表里可就别变成字符型了

例如：

```mysql
#以下两句是一样的，不区分大小写
show databases; 
SHOW DATABASES; 
#创建表格 
#create table student info(...); 
#表名错误，因为表名有空格 
create table student_info(...); 
#其中order使用``飘号，因为order和系统关键字或系统函数名等预定义标识符重名了 
CREATE TABLE `order`();
select id as "编号", `name` as "姓名" from t_stu; 
#起别名时，as都可以省略 
select id as 编号, `name` as 姓名 from t_stu; 
#如果字段别名中没有空格，那么可以省略"" 
select id as 编 号, `name` as 姓 名 from t_stu; 
#错误，如果字段别名中有空格，那么不能省略""
```

### 数据导入指令

在命令行客户端登录mysql，使用source指令导入

```mysql
mysql> source d:\mysqldb.sql
```

### 2.3基本的SELECT语句

#### 2.3.0 SELECT... 

```mysql
SELECT 1; #没有任何子句 
SELECT 9/2; #没有任何子句 
```

#### 2.3.1 SELECT ... FROM

* 语法：

```mysql
SELECT 标识选择哪些列 FROM 标识从哪个表中选择
```

* 选择全部列：

```mysql
select  from student
```

> 一般情况下，除非需要使用表中所有的字段数据，最好不要使用通配符‘’。使用通配符虽然可以节省输入查询语句的时间，但是获取不需要的列数据通常会降低查询和所使用的应用程序的效率。通配符的优势是，当不知道所需要的列的名称时，可以通过它获取它们。
>
> 在生产环境下，不推荐你直接使用 SELECT  进行查询。

* 选择特定的列：

```mysql
SELECT id, name FROM student;
```

> ySQL中的SQL语句是不区分大小写的，因此SELECT和select的作用是相同的，但是，许多开发人员习惯将关键字大写、数据列和表名小写，读者也应该养成一个良好的编程习惯，这样写出来的代码更容易阅读和维护。

#### 2.3.2 列的别名

* 重命名一个列

* 便于计算

* 紧跟列名，也可以在列名和别名之间加入关键字AS，别名使用双引号，以便在别名中包含空格或特殊的字符并区分大小写。

* AS 可以省略

* 建议别名简短，见名知意

举例:

```mysql
SELECT id AS 编号, name AS 姓名 FROM student;
```

```mysql
SELECT last_name 名字, salary12 年薪 FROM employees;
```

#### 2.3.3 去除重复行

* 默认情况下，查询会返回全部行，包括重复行。

```mysql
SELECT department_id FROM employees;
```

![image-20220712190703781](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712190703781.png)

在SELECT语句中使用关键字DISTINCT去除重复行

```mysql
SELECT DISTINCT department_id id FROM employees;
```

针对于：

这里有两点需要注意：

```mysql
SELECT DISTINCT department_id,salary FROM employees;
```

1. DISTINCT 需要放到所有列名的前面，如果写成 SELECT salary, DISTINCT department_id FROM employees 会报错。

2. DISTINCT 其实是对后面所有列名的组合进行去重，你能看到最后的结果是 74 条，因为这 74 个部门id不同，都有 salary 这个属性值。如果你想要看都有哪些不同的部门（department_id），只需要写 DISTINCT department_id 即可，后面不需要再加其他的列名了。

#### 2.3.4 空值参与运算

所有运算符或列值遇到null值，运算的结果都为null

```mysql
SELECT employee_id,salary,commission_pct, 12  salary  (1 + commission_pct) "annual_sal" FROM employees;
```

![image-20220712191226833](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712191226833.png)

这里你一定要注意，在 MySQL 里面， 空值不等于空字符串。一个空字符串的长度是 0，而一个空值的长度是空。而且，在 MySQL 里面，空值是占用空间的。

#### 2.3.5 着重号

错误的order是关键字

```mysql
mysql> SELECT  FROM ORDER; 
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'ORDER' at line 1
```

正确写法：

```mysql
mysql> SELECT  FROM `ORDER`;
```

结论:我们需要保证表中的字段、表名等没有和保留字、数据库系统或常用方法冲突。如果真的相同，请在SQL语句中使用一对``（着重号）引起来。

#### 2.3.6 查询常数

SELECT 查询还可以对常数进行查询。对的，就是在 SELECT 查询结果中增加一列固定的常数列。这列的取值是我们指定的，而不是从数据表中动态取出的。

你可能会问为什么我们还要对常数进行查询呢？

SQL 中的 SELECT 语法的确提供了这个功能，一般来说我们只从一个表中查询数据，通常不需要增加一个固定的常数列，但如果我们想整合不同的数据源，用常数列作为这个表的标记，就需要查询常数。比如说，我们想对 employees 数据表中的员工姓名进行查询，同时增加一列字段 corporation ，这个字段固定值为“程序员”，可以这样写：

```mysql
SELECT '程序员' AS corporation, last_name FROM employees;
```

![image-20220712191726639](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712191726639.png)

### 2.4显示表结构

* 使用DESCRIBE 或 DESC 命令，表示表结构。

```mysql
DESCRIBE employees; 
或
DESC employees;
```

```mysql
mysql> desc employees;
+----------------+-------------+------+-----+---------+-------+
| Field          | Type        | Null | Key | Default | Extra |
+----------------+-------------+------+-----+---------+-------+
| employee_id    | int(6)      | NO   | PRI | 0       |       |
| first_name     | varchar(20) | YES  |     | NULL    |       |
| last_name      | varchar(25) | NO   |     | NULL    |       |
| email          | varchar(25) | NO   | UNI | NULL    |       |
| phone_number   | varchar(20) | YES  |     | NULL    |       |
| hire_date      | date        | NO   |     | NULL    |       |
| job_id         | varchar(10) | NO   | MUL | NULL    |       |
| salary         | double(8,2) | YES  |     | NULL    |       |
| commission_pct | double(2,2) | YES  |     | NULL    |       |
| manager_id     | int(6)      | YES  | MUL | NULL    |       |
| department_id  | int(4)      | YES  | MUL | NULL    |       |
+----------------+-------------+------+-----+---------+-------+
11 rows in set (0.00 sec)
```

其中，各个字段的含义分别解释如下：

* Field：表示字段名称。

* Type：表示字段类型，这里 barcode、goodsname 是文本型的，price 是整数类型的。

* Null：表示该列是否可以存储NULL值。

* Key：表示该列是否已编制索引。PRI表示该列是表主键的一部分；UNI表示该列是UNIQUE索引的一部分；MUL表示在列中某个给定值允许出现多次。

* Default：表示该列是否有默认值，如果有，那么值是多少。

* Extra：表示可以获取的与给定列有关的附加信息，例如AUTO_INCREMENT等


### 2.5过滤数据where

语法：

```mysql
SELECT 字段1,字段2 FROM 表名 WHERE 过滤条件
```

使用WHERE 子句，将不满足条件的行过滤掉WHERE子句紧随 FROM子句

举例：

```mysql
SELECT employee_id, last_name, job_id, department_id FROM employees WHERE department_id = 90 ;
```

## 第3章_运算符

### 3.1算术运算符

算术运算符主要用于数学运算，其可以连接运算符前后的两个数值或表达式，对数值或表达式进行加（+）、减（-）、乘（）、除（/）和取模（%）运算

![image-20220712192657443](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712192657443.png)

#### 3.1.1加法与减法运算符

```mysql
mysql> SELECT 100, 100 + 0, 100 - 0, 100 + 50, 100 + 50 -30, 100 + 35.5, 100 - 35.5 FROM dual;
+-----+---------+---------+----------+--------------+------------+------------+
| 100 | 100 + 0 | 100 - 0 | 100 + 50 | 100 + 50 -30 | 100 + 35.5 | 100 - 35.5 |
+-----+---------+---------+----------+--------------+------------+------------+
| 100 |     100 |     100 |      150 |          120 |      135.5 |       64.5 |
+-----+---------+---------+----------+--------------+------------+------------+
1 row in set (0.00 sec)
```

由运算结果可以得出如下结论：

> * 一个整数类型的值对整数进行加法和减法操作，结果还是一个整数；
>
> * 一个整数类型的值对浮点数进行加法和减法操作，结果是一个浮点数；
>
> * 加法和减法的优先级相同，进行先加后减操作与进行先减后加操作的结果是一样的；
>
> * 在Java中，+的左右两边如果有字符串，那么表示字符串的拼接。但是在MySQL中+只表示数值相加。如果遇到非数值类型，先尝试转成数值，如果转失败，就按0计算。（补充：MySQL中字符串拼接要使用字符串函数CONCAT()实现）

```mysql
mysql> select 1 + "100", 1 + "100.1", 1 + "字符", 1 + null;
+-----------+-------------+------------+----------+
| 1 + "100" | 1 + "100.1" | 1 + "字符"    | 1 + null |
+-----------+-------------+------------+----------+
|       101 |       101.1 |          1 |     NULL |
+-----------+-------------+------------+----------+
1 row in set, 2 warnings (0.00 sec)
```

#### 3.1.2乘法与除法运算符

```mysql
mysql> SELECT 100, 100  1, 100  1.0, 100 / 1.0, 100 / 2,100 + 2  5 / 2,100 /3, 100 DIV 0 FROM dual;
+-----+---------+-----------+-----------+---------+-----------------+---------+-----------+
| 100 | 100  1 | 100  1.0 | 100 / 1.0 | 100 / 2 | 100 + 2  5 / 2 | 100 /3  | 100 DIV 0 |
+-----+---------+-----------+-----------+---------+-----------------+---------+-----------+
| 100 |     100 |     100.0 |  100.0000 | 50.0000 |        105.0000 | 33.3333 |      NULL |
+-----+---------+-----------+-----------+---------+-----------------+---------+-----------+
1 row in set (0.00 sec)
```

由运算结果可以得出如下结论:

> * 一个数乘以整数1和除以整数1后仍得原数；
>
> * 一个数乘以浮点数1和除以浮点数1后变成浮点数，数值与原数相等；
>
> * 一个数除以整数后，不管是否能除尽，结果都为一个浮点数；
>
> * 一个数除以另一个数，除不尽时，结果为一个浮点数，并保留到小数点后4位；
>
> * 乘法和除法的优先级相同，进行先乘后除操作与先除后乘操作，得出的结果相同。
>
> * 在数学运算中，0不能用作除数，在MySQL中，一个数除以0为NULL。 

#### 3.1.3求模（求余）运算符 

将t22表中的字段i对3和5进行求模（求余）运算

```mysql
mysql>  SELECT 12 % 3, 12 MOD 5 FROM dual;
+--------+----------+
| 12 % 3 | 12 MOD 5 |
+--------+----------+
|      0 |        2 |
+--------+----------+
1 row in set (0.00 sec)
```

### 3.2比较运算符

比较运算符用来对表达式左边的操作数和右边的操作数进行比较，比较的结果为真则返回1，比较的结果为假则返回0，其他情况则返回NULL。

比较运算符经常被用来作为SELECT查询语句的条件来使用，返回符合条件的结果记录。

![image-20220712193734246](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712193734246.png)

#### 3.2.1等号运算符

* 等号运算符（=）判断等号两边的值、字符串或表达式是否相等，如果相等则返回1，不相等则返回0。

* 在使用等号运算符时，遵循如下规则：

  * 如果等号两边的值、字符串或表达式都为字符串，则MySQL会按照字符串进行比较，其比较的是每个字符串中字符的ANSI编码是否相等。

  * 如果等号两边的值都是整数，则MySQL会按照整数来比较两个值的大小。

  * 如果等号两边的值一个是整数，另一个是字符串，则MySQL会将字符串转化为数字进行比较。

  * 如果等号两边的值、字符串或表达式中有一个为NULL，则比较结果为NULL。

* 对比：SQL中赋值符号使用 := 

```mysql
mysql> SELECT 1 = 1, 1 = '1', 1 = 0, 'a' = 'a', (5 + 3) = (2 + 6), '' = NULL , NULL = NULL;
+-------+---------+-------+-----------+-------------------+-----------+-------------+
| 1 = 1 | 1 = '1' | 1 = 0 | 'a' = 'a' | (5 + 3) = (2 + 6) | '' = NULL | NULL = NULL |
+-------+---------+-------+-----------+-------------------+-----------+-------------+
|     1 |       1 |     0 |         1 |                 1 |      NULL |        NULL |
+-------+---------+-------+-----------+-------------------+-----------+-------------+
```

```mysql
mysql>  SELECT 1 = 2, 0 = 'abc', 1 = 'abc' FROM dual;
+-------+-----------+-----------+
| 1 = 2 | 0 = 'abc' | 1 = 'abc' |
+-------+-----------+-----------+
|     0 |         1 |         0 |
+-------+-----------+-----------+
1 row in set, 2 warnings (0.00 sec)
```

非数值类型，先尝试转成数值，如果转失败，就按0计算。

```mysql
#查询salary=10000，注意在Java中比较是== 
SELECT employee_id,salary FROM employees WHERE salary = 10000;
```

#### 3.2.2安全等于运算符 

安全等于运算符（<=>）与等于运算符（=）的作用是相似的， 唯一的区别 是‘<=>’可以用来对NULL进行判断。在两个操作数均为NULL时，其返回值为1，而不为NULL；当一个操作数为NULL时，其返回值为0，而不为NULL。

```mysql
mysql> SELECT 1 <=> '1', 1 <=> 0, 'a' <=> 'a', (5 + 3) <=> (2 + 6), '' <=> NULL,NULL <=> NULL FROM dual;
+-----------+---------+-------------+---------------------+-------------+---------------+
| 1 <=> '1' | 1 <=> 0 | 'a' <=> 'a' | (5 + 3) <=> (2 + 6) | '' <=> NULL | NULL <=> NULL |
+-----------+---------+-------------+---------------------+-------------+---------------+
|         1 |       0 |           1 |                   1 |           0 |             1 |
+-----------+---------+-------------+---------------------+-------------+---------------+
1 row in set (0.00 sec)
```

```mysql
#查询commission_pct等于0.40 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct = 0.40; 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct <=> 0.40;
```

可以看到，使用安全等于运算符时，两边的操作数的值都为NULL时，返回的结果为1而不是NULL，其他返回结果与等于运算符相同。

#### 3.2.3不等于运算符 

不等于运算符（<>和!=）用于判断两边的数字、字符串或者表达式的值是否不相等，如果不相等则返回1，相等则返回0。不等于运算符不能判断NULL值。如果两边的值有任意一个为NULL，或两边都为NULL，则结果为NULL。

 SQL语句示例如下：

```mysql
mysql> SELECT 1 <> 1, 1 != 2, 'a' != 'b', (3+4) <> (2+6), 'a' != NULL, NULL <> NULL;
+--------+--------+------------+----------------+-------------+--------------+
| 1 <> 1 | 1 != 2 | 'a' != 'b' | (3+4) <> (2+6) | 'a' != NULL | NULL <> NULL |
+--------+--------+------------+----------------+-------------+--------------+
|      0 |      1 |          1 |              1 |        NULL |         NULL |
+--------+--------+------------+----------------+-------------+--------------+
1 row in set (0.00 sec)
```

此外，还有非符号类型的运算符：

![image-20220712201909262](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712201909262.png)

#### 3.2.4空运算符 

空运算符（IS NULL或者ISNULL）判断一个值是否为NULL，如果为NULL则返回1，否则返回0。 

SQL语句示例如下：

```mysql
mysql> SELECT NULL IS NULL, ISNULL(NULL), ISNULL('a'), 1 IS NULL;
+--------------+--------------+-------------+-----------+
| NULL IS NULL | ISNULL(NULL) | ISNULL('a') | 1 IS NULL |
+--------------+--------------+-------------+-----------+
|            1 |            1 |           0 |         0 |
+--------------+--------------+-------------+-----------+
1 row in set (0.00 sec)
```

```mysql
#查询commission_pct等于NULL。比较如下的四种写法 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct IS NULL; 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct <=> NULL; 
SELECT employee_id,commission_pct FROM employees WHERE ISNULL(commission_pct); 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct = NULL;
```

```mysql
SELECT last_name, manager_id FROM employees WHERE manager_id IS NULL;
```

#### 3.2.5非空运算符 

非空运算符（IS NOT NULL）判断一个值是否不为NULL，如果不为NULL则返回1，否则返回0。 

SQL语句示例如下：

```mysql
mysql> SELECT NULL IS NOT NULL, 'a' IS NOT NULL, 1 IS NOT NULL;
+------------------+-----------------+---------------+
| NULL IS NOT NULL | 'a' IS NOT NULL | 1 IS NOT NULL |
+------------------+-----------------+---------------+
|                0 |               1 |             1 |
+------------------+-----------------+---------------+
1 row in set (0.00 sec)
```

```mysql
#查询commission_pct不等于NULL 
SELECT employee_id,commission_pct FROM employees WHERE commission_pct IS NOT NULL; 
SELECT employee_id,commission_pct FROM employees WHERE NOT commission_pct <=> NULL; 
SELECT employee_id,commission_pct FROM employees WHERE NOT ISNULL(commission_pct);
```

#### 3.2.6最小值运算符 

语法格式为：LEAST(值1，值2，...，值n)。其中，“值n”表示参数列表中有n个值。在有两个或多个参数的情况下，返回最小值。

```mysql
mysql> SELECT LEAST (1,0,2), LEAST('a','b','c'), LEAST(1,NULL,2);
+---------------+--------------------+-----------------+
| LEAST (1,0,2) | LEAST('a','b','c') | LEAST(1,NULL,2) |
+---------------+--------------------+-----------------+
|             0 | a                  |            NULL |
+---------------+--------------------+-----------------+
1 row in set (0.00 sec)
```

由结果可以看到，当参数是整数或者浮点数时，LEAST将返回其中最小的值；当参数为字符串时，返回字母表中顺序最靠前的字符；当比较值列表中有NULL时，不能判断大小，返回值为NULL。 

#### 3.2.7最大值运算符 

语法格式为：GREATEST(值1，值2，...，值n)。其中，n表示参数列表中有n个值。当有两个或多个参数时，返回值为最大值。假如任意一个自变量为NULL，则GREATEST()的返回值为NULL。

```mysql
mysql> SELECT GREATEST(1,0,2),GREATEST('b','a','c'),GREATEST(1,NULL,2);
+-----------------+-----------------------+--------------------+
| GREATEST(1,0,2) | GREATEST('b','a','c') | GREATEST(1,NULL,2) |
+-----------------+-----------------------+--------------------+
|               2 | c                     |               NULL |
+-----------------+-----------------------+--------------------+
1 row in set (0.00 sec)
```

由结果可以看到，当参数中是整数或者浮点数时，GREATEST将返回其中最大的值；当参数为字符串时，返回字母表中顺序最靠后的字符；当比较值列表中有NULL时，不能判断大小，返回值为NULL。 

#### 3.2.8 BETWEEN AND运算符 

BETWEEN运算符使用的格式通常为SELECT D FROM TABLE WHERE C BETWEEN A AND B，此时，当C大于或等于A，并且C小于或等于B时，结果为1，否则结果为0。 

```mysql
mysql> SELECT 1 BETWEEN 0 AND 1, 10 BETWEEN 11 AND 12,'b' BETWEEN 'a' AND 'c';
+-------------------+----------------------+-------------------------+
| 1 BETWEEN 0 AND 1 | 10 BETWEEN 11 AND 12 | 'b' BETWEEN 'a' AND 'c' |
+-------------------+----------------------+-------------------------+
|                 1 |                    0 |                       1 |
+-------------------+----------------------+-------------------------+
1 row in set (0.00 sec)
```

```mysql
SELECT last_name, salary 
FROM employees 
WHERE salary BETWEEN 2500 AND 3500;
```

#### 3.2.9 IN运算符 

IN运算符用于判断给定的值是否是IN列表中的一个值，如果是则返回1，否则返回0。如果给定的值为NULL，或者IN列表中存在NULL，则结果为NULL。 

```mysql
mysql>  SELECT 'a' IN ('a','b','c'), 1 IN (2,3), NULL IN ('a','b'), 'a' IN ('a', NULL);
+----------------------+------------+-------------------+--------------------+
| 'a' IN ('a','b','c') | 1 IN (2,3) | NULL IN ('a','b') | 'a' IN ('a', NULL) |
+----------------------+------------+-------------------+--------------------+
|                    1 |          0 |              NULL |                  1 |
+----------------------+------------+-------------------+--------------------+
1 row in set (0.00 sec)
```

```mysql
SELECT employee_id, last_name, salary, manager_id 
FROM employees 
WHERE manager_id IN (100, 101, 201);
```

#### 3.2.10 NOT IN运算符 

NOT IN运算符用于判断给定的值是否不是IN列表中的一个值，如果不是IN列表中的一个值，则返回1，否则返回0。 

```mysql
mysql> SELECT 'a' NOT IN ('a','b','c'), 1 NOT IN (2,3);
+--------------------------+----------------+
| 'a' NOT IN ('a','b','c') | 1 NOT IN (2,3) |
+--------------------------+----------------+
|                        0 |              1 |
+--------------------------+----------------+
1 row in set (0.00 sec)
```

#### 3.2.11 LIKE运算符 

LIKE运算符主要用来匹配字符串，通常用于模糊匹配，如果满足条件则返回1，否则返回0。如果给定的值或者匹配条件为NULL，则返回结果为NULL。 

LIKE运算符通常使用如下通配符：

```mysql
“%”：匹配0个或多个字符。 
“_”：只能匹配一个字符。
```

```mysql
mysql> SELECT NULL LIKE 'abc', 'abc' LIKE NULL, NULL LIKE '%abc%';
+-----------------+-----------------+-------------------+
| NULL LIKE 'abc' | 'abc' LIKE NULL | NULL LIKE '%abc%' |
+-----------------+-----------------+-------------------+
|            NULL |            NULL |              NULL |
+-----------------+-----------------+-------------------+
1 row in set (0.00 sec)
```

```mysql
SELECT first_name
FROM employees
WHERE first_name LIKE 'S%';
```

```mysql
SELECT last_name
FROM employees
WHERE last_name LIKE '_o%'; # 查找第二个字符为o的
```

#### 3.2.12 ESCAPE

回避特殊符号的：使用转义符。例如：将[%]转为[$%]、[]转为[$]，然后再加上[ESCAPE‘$’]即可。

```mysql
SELECT job_id 
FROM jobs 
WHERE job_id LIKE 'IT\_%'; # 查找IT_开头的
```

如果使用\表示转义，要省略ESCAPE。如果不是\，则要加上ESCAPE。 

```mysql
SELECT job_id 
FROM jobs 
WHERE job_id LIKE 'IT$_%' ESCAPE '$';
```

#### 3.2.13 REGEXP运算符

REGEXP运算符用来匹配字符串，语法格式为： expr REGEXP 匹配条件 。如果expr满足匹配条件，返回1；如果不满足，则返回0。若expr或匹配条件任意一个为NULL，则结果为NULL。REGEXP运算符在进行匹配时，常用的有下面几种通配符：

```
（1）‘^’匹配以该字符后面的字符开头的字符串。
（2）‘$’匹配以该字符前面的字符结尾的字符串。 
（3）‘.’匹配任何一个单字符。 
（4）“[...]”匹配在方括号内的任何字符。例如，“[abc]”匹配“a”或“b”或“c”。为了命名字符的范围，使用一个‘-’。“[a-z]”匹配任何字母，而“[0-9]”匹配任何数字。 
（5）‘’匹配零个或多个在它前面的字符。例如，“x”匹配任何数量的‘x’字符，“[0-9]”匹配任何数量的数字， 而“”匹配任何数量的任何字符。
```

SQL语句示例如下：

```mysql
mysql> SELECT 'shkstart' REGEXP '^s', 'shht' REGEXP 't$', 'shkstart' REGEXP 'hk';
+------------------------+--------------------+------------------------+
| 'shkstart' REGEXP '^s' | 'shht' REGEXP 't$' | 'shkstart' REGEXP 'hk' |
+------------------------+--------------------+------------------------+
|                      1 |                  1 |                      1 |
+------------------------+--------------------+------------------------+
1 row in set (0.00 sec)
```

```mysql
mysql> SELECT 'abc' REGEXP 'acb.cd', 'abc' REGEXP '[cd]';
+-----------------------+---------------------+
| 'abc' REGEXP 'acb.cd' | 'abc' REGEXP '[cd]' |
+-----------------------+---------------------+
|                     0 |                   1 |
+-----------------------+---------------------+
1 row in set (0.00 sec)
```

### 3.3逻辑运算符

逻辑运算符主要用来判断表达式的真假，在MySQL中，逻辑运算符的返回结果为1、0或者NULL。 MySQL中支持4种逻辑运算符如下：

![image-20220712211124825](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712211124825.png)

#### 3.3.1逻辑非运算符 

逻辑非（NOT或!）运算符表示当给定的值为0时返回1；当给定的值为非0值时返回0；当给定的值为NULL时，返回NULL。

```mysql
mysql> SELECT NOT 1, NOT 0, NOT(1+1), NOT !1, NOT NULL;
+-------+-------+----------+--------+----------+
| NOT 1 | NOT 0 | NOT(1+1) | NOT !1 | NOT NULL |
+-------+-------+----------+--------+----------+
|     0 |     1 |        0 |      1 |     NULL |
+-------+-------+----------+--------+----------+
1 row in set (0.00 sec)
```

```mysql
SELECT last_name, job_id 
FROM employees 
WHERE job_id NOT IN ('IT_PROG', 'ST_CLERK', 'SA_REP');
```

#### 3.3.2逻辑与运算符 

逻辑与（AND或&&）运算符是当给定的所有值均为非0值，并且都不为NULL时，返回1；当给定的一个值或者多个值为0时则返回0；否则返回NULL。 

```mysql
mysql> SELECT 1 AND -1, 0 AND 1, 0 AND NULL, NULL AND 0, 1 AND NULL;
+----------+---------+------------+------------+------------+
| 1 AND -1 | 0 AND 1 | 0 AND NULL | NULL AND 0 | 1 AND NULL |
+----------+---------+------------+------------+------------+
|        1 |       0 |          0 |          0 |       NULL |
+----------+---------+------------+------------+------------+
1 row in set (0.00 sec)
```

```mysql
SELECT employee_id, last_name, job_id, salary 
FROM employees 
WHERE salary >=10000 
AND job_id LIKE '%MAN%';
```

#### 3.3.3逻辑或运算符 

逻辑或（OR或||）运算符是当给定的值都不为NULL，并且任何一个值为非0值时，则返回1，否则返回0；当一个值为NULL，并且另一个值为非0值时，返回1，否则返回NULL；当两个值都为NULL时，返回NULL。

```mysql
mysql> SELECT 1 OR -1, 1 OR 0, 1 OR NULL, 0 || NULL, NULL || NULL;
+---------+--------+-----------+-----------+--------------+
| 1 OR -1 | 1 OR 0 | 1 OR NULL | 0 || NULL | NULL || NULL |
+---------+--------+-----------+-----------+--------------+
|       1 |      1 |         1 |      NULL |         NULL |
+---------+--------+-----------+-----------+--------------+
1 row in set (0.00 sec)
```

```mysql
#查询基本薪资不在9000-12000之间的员工编号和基本薪资
SELECT job_id, salary
FROM employees
WHERE salary NOT BETWEEN 9000 AND 12000; 

SELECT employee_id, salary
FROM employees
WHERE NOT (salary >= 9000 AND salary <= 12000);

SELECT employee_id,salary 
FROM employees 
WHERE salary <9000 OR salary > 12000;
```

```mysql
SELECT employee_id, last_name, job_id, salary 
FROM employees 
WHERE salary >= 10000
OR job_id LIKE '%MAN%';
```

> 注意：
>
> OR可以和AND一起使用，但是在使用时要注意两者的优先级，由于AND的优先级高于OR，因此先对AND两边的操作数进行操作，再与OR中的操作数结合。

#### 3.3.4逻辑异或运算符 

逻辑异或（XOR）运算符是当给定的值中任意一个值为NULL时，则返回NULL；如果两个非NULL的值都是0或者都不等于0时，则返回0；如果一个值为0，另一个值不为0时，则返回1。 （相同为0，相异为1）

```mysql
mysql> SELECT 1 XOR -1, 1 XOR 0, 0 XOR 0, 1 XOR NULL, 1 XOR 1 XOR 1, 0 XOR 0 XOR 0, NULL XOR NULL;
+----------+---------+---------+------------+---------------+---------------+---------------+
| 1 XOR -1 | 1 XOR 0 | 0 XOR 0 | 1 XOR NULL | 1 XOR 1 XOR 1 | 0 XOR 0 XOR 0 | NULL XOR NULL |
+----------+---------+---------+------------+---------------+---------------+---------------+
|        0 |       1 |       0 |       NULL |             1 |             0 |          NULL |
+----------+---------+---------+------------+---------------+---------------+---------------+
1 row in set (0.00 sec)
```

```mysql
select last_name,department_id,salary
from employees 
where department_id in (10,20) XOR salary > 8000;
```

### 3.4位运算符

位运算符是在二进制数上进行计算的运算符。位运算符会先将操作数变成二进制数，然后进行位运算，最后将计算结果从二进制变回十进制数。

MySQL支持的位运算符如下：

![image-20220712213618560](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712213618560.png)

#### 3.4.1按位与运算符

 按位与（&）运算符将给定值对应的二进制数逐位进行逻辑与运算。当给定值对应的二进制位的数值都为1时，则该位返回1，否则返回0。

```mysql
mysql> select 1 & 10, 20 & 30;
+--------+---------+
| 1 & 10 | 20 & 30 |
+--------+---------+
|      0 |      20 |
+--------+---------+
1 row in set (0.00 sec)
```

1的二进制数为0001，10的二进制数为1010，所以1 & 10的结果为0000，对应的十进制数为0。20的二进制数为10100，30的二进制数为11110，所以20 & 30的结果为10100，对应的十进制数为20。 

0001		10100		

1010		11110

0000		10100

#### 3.4.2按位或运算符 

按位或（|）运算符将给定的值对应的二进制数逐位进行逻辑或运算。当给定值对应的二进制位的数值有一个或两个为1时，则该位返回1，否则返回0。 

```mysql
mysql> SELECT 1 | 10, 20 | 30;
+--------+---------+
| 1 | 10 | 20 | 30 | 
+--------+---------+
| 	  11 | 		30 | 
+--------+---------+
1 row in set (0.00 sec)
```

1的二进制数为0001，10的二进制数为1010，所以1 | 10的结果为1011，对应的十进制数为11。20的二进制数为10100，30的二进制数为11110，所以20 | 30的结果为11110，对应的十进制数为30。

0001		10100

1010		11110

1011		11110

#### 3.4.3按位异或运算符 

按位异或（^）运算符将给定的值对应的二进制数逐位进行逻辑异或运算。当给定值对应的二进制位的数值不同时，则该位返回1，否则返回0。 

```mysql
mysql> SELECT 1 ^ 10, 20 ^ 30;
+--------+---------+
| 1 ^ 10 | 20 ^ 30 | 
+--------+---------+
|  	  11 | 		10 | 
+--------+---------+
1 row in set (0.00 sec)
```

1的二进制数为0001，10的二进制数为1010，所以1 ^ 10的结果为1011，对应的十进制数为11。20的二进制数为10100，30的二进制数为11110，所以20 ^ 30的结果为01010，对应的十进制数为10

0001		10100

1010		11110

1011		01010

![image-20220712214627106](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712214627106.png)

#### 3.4.4按位取反运算符 

按位取反（~）运算符将给定的值的二进制数逐位进行取反操作，即将1变为0，将0变 为1。

```mysql
mysql> SELECT 10 & ~1; 
+---------+
| 10 & ~1 | 
+---------+
| 	   10 | 
+---------+
1 row in set (0.00 sec)
```

于按位取反（~）运算符的优先级高于按位与（&）运算符的优先级，所以10 & ~1，首先，对数字1进行按位取反操作，结果除了最低位为0，其他位都为1，然后与10进行按位与操作，结果为10。 （与本身还是本身）

1 按位取反  0001 为 1000

#### 3.4.5按位右移运算符 

按位右移（>>）运算符将给定的值的二进制数的所有位右移指定的位数。右移指定的位数后，右边低位的数值被移出并丢弃，左边高位空出的位置用0补齐。

```mysql
mysql> SELECT 1 >> 2, 4 >> 2; 
+--------+--------+
| 1 >> 2 | 4 >> 2 | 
+--------+--------+
|	   0 | 		1 | 
+--------+--------+
1 row in set (0.00 sec)
```

1的二进制数为0000 0001，右移2位为0000 0000，对应的十进制数为0。4的二进制数为0000 0100，右移2位为0000 0001，对应的十进制数为1。

#### 3.4.6按位左移运算符 

按位左移（<<）运算符将给定的值的二进制数的所有位左移指定的位数。左移指定的位数后，左边高位的数值被移出并丢弃，右边低位空出的位置用0补齐。

```mysql
mysql> SELECT 1 << 2, 4 << 2; 
+--------+--------+
| 1 << 2 | 4 << 2 | 
+--------+--------+
| 	   4 | 	   16 | 
+--------+--------+
1 row in set (0.00 sec)
```

1的二进制数为0000 0001，左移两位为0000 0100，对应的十进制数为4。4的二进制数为0000 0100，左移两位为0001 0000，对应的十进制数为16

### 3.5运算符的优先级

![image-20220712215528764](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712215528764.png)

数字编号越大，优先级越高，优先级高的运算符先进行计算。可以看到，赋值运算符的优先级最低，使用“()”括起来的表达式的优先级最高。

### 3.6拓展：使用正则表达式查询

正则表达式通常被用来检索或替换那些符合某个模式的文本内容，根据指定的匹配模式匹配文本中符合要求的特殊字符串。例如，从一个文本文件中提取电话号码，查找一篇文章中重复的单词或者替换用户输入的某些敏感词语等，这些地方都可以使用正则表达式。正则表达式强大而且灵活，可以应用于非常复杂的查询。

MySQL中使用REGEXP关键字指定正则表达式的字符匹配模式。下表列出了REGEXP操作符中常用字符匹配列表。

![image-20220712215901523](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220712215901523.png)

#### 3.6.1查询以特定字符或字符串开头的记录 

字符‘^’匹配以特定字符或者字符串开头的文本。

在fruits表中，查询f_name字段以字母‘b’开头的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP '^b';
```

#### 3.6.2查询以特定字符或字符串结尾的记录 

字符‘$’匹配以特定字符或者字符串结尾的文本。

在fruits表中，查询f_name字段以字母‘y’结尾的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP 'y$';
```

#### 3.6.3用符号"."来替代字符串中的任意一个字符

 字符‘.’匹配任意一个字符。 在fruits表中，查询f_name字段值

包含字母‘a’与‘g’且两个字母之间只有一个字母的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP 'a.g';
```

#### 3.6.4使用"\"和"+"来匹配多个字符 

星号‘’匹配前面的字符任意多次，包括0次。加号‘+’匹配前面的字符至少一次。

在fruits表中，查询f_name字段值以字母‘b’开头且‘b’后面出现字母‘a’的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP '^ba';
```

在fruits表中，查询f_name字段值以字母‘b’开头且‘b’后面出现字母‘a’至少一次的记录，SQL语句如下：

```mysql
SELECT  
FROM fruits
WHERE f_name REGEXP '^ba+';
```

#### 3.6.5匹配指定字符串 

正则表达式可以匹配指定字符串，只要这个字符串在查询文本中即可，如要匹配多个字符串，多个字符串之间使用分隔符‘|’隔开。

在fruits表中，查询f_name字段值包含字符串“on”的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP 'on';
```

在fruits表中，查询f_name字段值包含字符串“on”或者“ap”的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP 'on|ap';
```

之前介绍过，LIKE运算符也可以匹配指定的字符串，但与REGEXP不同，LIKE匹配的字符串如果在文本中间出现，则找不到它，相应的行也不会返回。REGEXP在文本内进行匹配，如果被匹配的字符串在文本中出现，REGEXP将会找到它，相应的行也会被返回。对比结果如下所示。

在fruits表中，使用LIKE运算符查询f_name字段值为“on”的记录，SQL语句如下：

```mysql
SELECT  FROM fruits WHERE f_name like 'on';
```

#### 3.6.6匹配指定字符中的任意一个 

方括号“[]”指定一个字符集合，只匹配其中任何一个字符，即为所查找的文本。

在fruits表中，查找f_name字段中包含字母‘o’或者‘t’的记录，SQL语句如下：

```mysql
SELECT f_name 
FROM fruits
WHERE f_name REGEXP '[ot]';
```

在fruits表中，查询s_id字段中包含4、5或者6的记录，SQL语句如下：

```mysql
SELECT s_id 
FROM fruits
WHERE s_id REGEXP '[456]';
```

#### 3.6.7匹配指定字符以外的字符 [ ^ 字符集合]

匹配不在指定集合中的任何字符。

在fruits表中，查询f_id字段中包含字母a~e和数字1~2以外字符的记录，SQL语句如下：

```mysql
SELECT  FROM fruits WHERE f_id REGEXP '[^a-e1-2]';
```

#### 3.6.8使用{n,}或者{n,m}来指定字符串连续出现的次数 

“字符串{n,}”表示至少匹配n次前面的字符；“字符串{n,m}”表示匹配前面的字符串不少于n次，不多于m次。例如，a{2,}表示字母a连续出现至少2次，也可以大于2次；a{2,4}表示字母a连续出现最少2次，最多不能超过4次。

在fruits表中，查询f_name字段值出现字母‘x’至少2次的记录，SQL语句如下：

```mysql
 SELECT  FROM fruits WHERE f_name REGEXP 'x{2,}';
```

在fruits表中，查询f_name字段值出现字符串“ba”最少1次、最多3次的记录，SQL语句如下：

```mysql
 SELECT  FROM fruits WHERE f_name REGEXP 'ba{1,3}';
```

## 第4章_排序与分页

### 4.1排序数据

#### 4.1.1 排序规则

使用 ORDER BY 子句排序

ASC（ascend）: 升序

DESC（descend）:降序

ORDER BY 子句在SELECT语句的结尾。

#### 4.1.2 单列排序 

```mysql
SELECT last_name, job_id, department_id, hire_date
FROM employees
ORDER BY hire_date;
```

```mysql
SELECT last_name, job_id, department_id, hire_date
FROM employees
ORDER BY hire_date DESC;
```

#### 4.1.3 多列排序

salary升序，当salary相同时，对department_id进行降序排列

```mysql
SELECT last_name, department_id, salary
FROM employees
ORDER BY salary, department_id DESC;
```

* 可以使用不在SELECT列表中的列排序。

* 在对多列进行排序的时候，首先排序的第一列必须有相同的列值，才会对第二列进行排序。如果第一列数据中所有值都是唯一的，将不再对第二列进行排序。

### 4.2分页

#### 4.2.1 背景

背景1：查询返回的记录太多了，查看起来很不方便，怎么样能够实现分页查询呢？

背景2：表里有 4 条数据，我们只想要显示第 2、3 条数据怎么办呢？

#### 4.2.2 实现规则

分页原理:

​	所谓分页显示，就是将数据库中的结果集，一段一段显示出来需要的条件。

​	MySQL中使用 LIMIT 实现分页

* 格式：

```mysql
LIMIT [偏移量,] 行数
```

第一个“位置偏移量”参数指示MySQL从哪一行开始显示，是一个可选参数，如果不指定“位置偏移量”，将会从表中的第一条记录开始（第一条记录的位置偏移量是0，第二条记录的位置偏移量是1，以此类推）；第二个参数“行数”指示返回的记录条数。

* 举例

```mysql
--前10条记录： SELECT  FROM 表名 LIMIT 0,10;
或者
SELECT  FROM 表名 LIMIT 10;
--第11至20条记录： SELECT  FROM 表名 LIMIT 10,10;
--第21至30条记录： SELECT  FROM 表名 LIMIT 20,10;
```

> MySQL 8.0中可以使用“LIMIT 3 OFFSET 4”，意思是获取从第5条记录开始后面的3条记录，和“LIMIT 4,3;”返回的结果相同。

* 分页显式公式：（当前页数-1）每页条数，每页条数

```mysql
SELECT  FROM table LIMIT(PageNo - 1)PageSize,PageSize;
```

* 注意：LIMIT 子句必须放在整个SELECT语句的最后！

* 使用 LIMIT 的好处

约束返回结果的数量可以 减少数据表的网络传输量 ，也可以 提升查询效率 。如果我们知道返回结果只有1 条，就可以使用 LIMIT 1 ，告诉 SELECT 语句只需要返回一条记录即可。这样的好处就是 SELECT 不需要扫描完整的表，只需要检索到一条符合条件的记录即可返回。

#### 4.2.3 拓展

在不同的 DBMS 中使用的关键字可能不同。在 MySQL、PostgreSQL、MariaDB 和 SQLite 中使用 LIMIT 关键字，而且需要放到 SELECT 语句的最后面。

* 如果是 SQL Server 和 Access，需要使用 TOP 关键字，比如：

```mysql
SELECT TOP 5 name, hp_max FROM heros ORDER BY hp_max DESC
```

* 如果是 DB2，使用 FETCH FIRST 5 ROWS ONLY 这样的关键字：

```mysql
SELECT name, hp_max FROM heros ORDER BY hp_max DESC FETCH FIRST 5 ROWS ONLY
```

* 如果是 Oracle，你需要基于 ROWNUM 来统计行数：

```mysql
SELECT rownum,last_name,salary FROM employees WHERE rownum < 5 ORDER BY salary DESC;
```

需要说明的是，这条语句是先取出来前 5 条数据行，然后再按照 hp_max 从高到低的顺序进行排序。但这样产生的结果和上述方法的并不一样。我会在后面讲到子查询，你可以使用

```mysql
SELECT rownum, last_name,salary 
FROM (
    SELECT last_name,salary 
    FROM employees
    ORDER BY salary DESC)
WHERE rownum < 10;
```

## 第5章_多表查询

多表查询，也称为关联查询，指两个或更多个表一起完成查询操作。

前提条件：这些一起查询的表之间是有关系的（一对一、一对多），它们之间一定是有关联字段，这个关联字段可能建立了外键，也可能没有建立外键。比如：员工表和部门表，这两个表依靠“部门编号”进行关联。

笛卡尔积（或交叉连接）的理解

笛卡尔乘积是一个数学运算。假设我有两个集合 X 和 Y，那么 X 和 Y 的笛卡尔积就是 X 和 Y 的所有可能组合，也就是第一个对象来自于 X，第二个对象来自于 Y 的所有可能。组合的个数即为两个集合中元素个数的乘积数。

![image-20220713102138987](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713102138987.png)

### 5.1多表查询分类讲解

#### 5.1.1 等值连接 vs 非等值连接 

##### 等值连接

![image-20220713102851249](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713102851249.png)

```mysql
SELECT employees.employee_id, employees.last_name, employees.department_id, departments.department_id, departments.location_id 
FROM employees, departments 
WHERE employees.department_id = departments.department_id;
```

拓展1：多个连接条件与 AND 操作符

拓展2：区分重复的列名

* 多个表中有相同列时，必须在列名之前加上表名前缀。

* 在不同表中具有相同列名的列可以用 表名 加以区分

```mysql
SELECT employees.last_name, departments.department_name,employees.department_id 
FROM employees, departments 
WHERE employees.department_id = departments.department_id;
```

拓展3：表的别名

* 使用别名可以简化查询。

* 列名前使用表名前缀可以提高查询效率。

```mysql
SELECT e.last_name, d.department_name,e.department_id 
FROM employees e, departments d 
WHERE e.department_id = d.department_id;
```

> 需要注意的是，如果我们使用了表的别名，在查询字段中、过滤条件中就只能使用别名进行代替，
>
> 不能使用原有的表名，否则就会报错。

> 阿里开发规范 ： 
>
> 【 强制 】对于数据库中表记录的查询和变更，只要涉及多个表，都需要在列名前加表的别名（或表名）进行限定。
>
> 说明 ：对多表进行查询记录、更新记录、删除记录时，如果对操作列没有限定表的别名（或表名），并且操作列在多个表中存在时，就会抛异常。
>
> 正例 ：select t1.name from table_first as t1 , table_second as t2 where t1.id=t2.id; 
>
> 反例 ：在某业务中，由于多表关联查询语句没有加表的别名（或表名）的限制，正常运行两年后，最近在 某个表中增加一个同名字段，在预发布环境做数据库变更后，线上查询语句出现出1052 异常：Column 'name' in field list is ambiguous。

拓展4：连接多个表

![image-20220713103535589](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713103535589.png)

总结：连接 n个表,至少需要n-1个连接条件。比如，连接三个表，至少需要两个连接条件。

练习：查询出公司员工的 last_name,department_name, city 

```mysql
SELECT e.last_name, d.department_name,l.city
FROM employees e, departments d, locations l
WHERE e.`department_id` = d.`department_id` AND d.`location_id` = l.`location_id`;
```

##### 非等值连接

![image-20220713104022195](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713104022195.png)

```mysql
SELECT e.last_name, e.salary, j.grade_level 
FROM employees e, job_grades j 
WHERE e.salary BETWEEN j.lowest_sal AND j.highest_sal;
```

#### 5.1.2 自连接 vs 非自连接 

![image-20220713134644595](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713134644595.png)

当table1和table2本质上是同一张表，只是用取别名的方式虚拟成两张表以代表不同的意义。然后两个表再进行内连接，外连接等查询。

题目：查询employees表，返回“Xxx works for Xxx”

#练习：查询员工id,员工姓名及其管理者的id和姓名

```mysql
SELECT emp.employee_id, emp.last_name, mgr.employee_id managerId, mgr.last_name managerName
FROM employees emp, employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;
```

练习：查询出last_name为 ‘Chen’ 的员工的 manager 的信息。

```mysql
SELECT emp.employee_id, emp.last_name, mgr.employee_id managerId, mgr.last_name managerName
FROM employees emp, employees mgr
WHERE emp.`last_name` = "Chen";
```

#### 5.1.3 内连接 vs 外连接

除了查询满足条件的记录以外，外连接还可以查询某一方不满足条件的记录。

![image-20220713142023235](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713142023235.png)

* 内连接: 合并具有同一列的两个以上的表的行, 结果集中不包含一个表与另一个表不匹配的行

* 外连接: 两个表在连接过程中除了返回满足连接条件的行以外还返回左（或右）表中不满足条件的行 ，这种连接称为左（或右） 外连接。没有匹配的行时, 结果表中相应的列为空(NULL)。

* 如果是左外连接，则连接条件中左边的表也称为 主表 ，右边的表称为 从表 。

* 如果是右外连接，则连接条件中右边的表也称为 主表 ，左边的表称为 从表 。

SQL92：使用(+)创建连接 在 SQL92 中采用（+）代表从表所在的位置。即左或右外连接中，(+) 表示哪个是从表。

Oracle 对 SQL92 支持较好，而 MySQL 则不支持 SQL92 的外连接。

```mysql
#左外连接 
SELECT last_name,department_name 
FROM employees ,departments 
WHERE employees.department_id = departments.department_id(+); 
#右外连接 
SELECT last_name,department_name 
FROM employees ,departments 
WHERE employees.department_id(+) = departments.department_id;
```

而且在 SQL92 中，只有左外连接和右外连接，没有满（或全）外连接。

### 5.2 SQL99语法实现多表查询

#### 5.2.1 基本语法

使用JOIN...ON子句创建连接的语法结构：

```mysql
SELECT table1.column, table2.column,table3.column
FROM table1 
JOIN table2 ON table1 和 table2 的连接条件 
JOIN table3 ON table2 和 table3 的连接条件
```

语法说明：

*  可以使用 ON 子句指定额外的连接条件。

* 这个连接条件是与其它条件分开的。

* ON 子句使语句具有更高的易读性。

* 关键字 JOIN、INNER JOIN、CROSS JOIN 的含义是一样的，都表示内连接

#### 5.2.2 内连接(INNER JOIN)的实现

语法:

```mysql
SELECT 字段列表
FROM A表 
INNER JOIN B表 ON 关联条件 
WHERE 等其他子句;
```

```mysql
SELECT e.employee_id, e.last_name, e.department_id, d.department_id, d.location_id 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id);
```

```mysql
SELECT employee_id, city, department_name 
FROM employees e 
JOIN departments d ON d.department_id = e.department_id 
JOIN locations l ON d.location_id = l.location_id;
```

#### 5.2.3 外连接(OUTER JOIN)的实现 

##### 1 左外连接(LEFT OUTER JOIN)

语法：

```mysql
#实现查询结果是A 
SELECT 字段列表 
FROM A表 LEFT JOIN B表 
ON 关联条件
WHERE 等其他子句;
```



```mysql
SELECT e.last_name, e.department_id,d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON (e.`department_id` = d.`department_id`);
```

![image-20220713145201611](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713145201611.png)

##### 2 右外连接(RIGHT OUTER JOIN)

语法：

```mysql
#实现查询结果是B 
SELECT 字段列表 
FROM A表 RIGHT JOIN B表 
ON 关联条件 
WHERE 等其他子句;
```

```mysql
SELECT e.last_name, e.department_id,d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON (e.`department_id` = d.`department_id`);
```

![image-20220713145552235](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713145552235.png)

> 需要注意的是，LEFT JOIN 和 RIGHT JOIN 只存在于 SQL99 及以后的标准中，在 SQL92 中不存在，只能用 (+) 表示。

##### 3 满外连接(FULL OUTER JOIN)

* 满外连接的结果 = 左右表匹配的数据 + 左表没有匹配到的数据 + 右表没有匹配到的数据。

* SQL99是支持满外连接的。使用FULL JOIN 或 FULL OUTER JOIN来实现。

* 需要注意的是，MySQL不支持FULL JOIN，但是可以用 LEFT JOIN UNION RIGHT join代替。

### 5.3 UNION的使用

合并查询结果 利用UNION关键字，可以给出多条SELECT语句，并将它们的结果组合成单个结果集。合并时，两个表对应的列数和数据类型必须相同，并且相互对应。各个SELECT语句之间使用UNION或UNION ALL关键字分隔。

语法格式:

```mysql
SELECT column,... FROM table1 
UNION [ALL] 
SELECT column,... FROM table2
```

UNION操作符

![image-20220713150128818](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713150128818.png)

UNION ALL操作符

![image-20220713150219452](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713150219452.png)

> 注意：执行UNION ALL语句时所需要的资源比UNION语句少。如果明确知道合并数据后的结果数据不存在重复数据，或者不需要去除重复的数据，则尽量使用UNION ALL语句，以提高数据查询的效率。

举例：查询部门编号>90或邮箱包含a的员工信息

```mysql
# 方式一
SELECT  
FROM employees e
WHERE e.`department_id` > 90 OR e.`email` LIKE '%a%';
```

````mysql
# 方式二
SELECT  FROM employees e WHERE e.`department_id` > 90
UNION
SELECT  FROM employees e WHERE e.`email` LIKE '%a%';
````

举例：查询中国用户中男性的信息以及美国用户中年男性的用户信息

```mysql
SELECT id,cname FROM t_chinamale WHERE csex='男' 
UNION ALL 
SELECT id,tname FROM t_usmale WHERE tGender='male';
```

### 5.4 7种SQL JOINS的实现

![image-20220713151204416](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713151204416.png)

代码实现 :

```mysql
#中图：内连接 A∩B
SELECT e.`last_name`,e.`employee_id`,d.`department_name`
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`;
```

```mysql
#左上图：左外连接
SELECT employee_id,last_name,department_name 
FROM employees e LEFT JOIN departments d 
ON e.`department_id` = d.`department_id`;
```

```mysql
#右上图：右外连接 
SELECT employee_id,last_name,department_name
FROM employees e RIGHT JOIN departments d 
ON e.`department_id` = d.`department_id`;
```

```mysql
#左中图：A - A∩B 
SELECT employee_id,last_name,department_name 
FROM employees e LEFT JOIN departments d 
ON e.`department_id` = d.`department_id` 
WHERE d.`department_id` IS NULL
```

```mysql
#右中图：B-A∩B 
SELECT employee_id,last_name,department_name 
FROM employees e RIGHT JOIN departments d 
ON e.`department_id` = d.`department_id` 
WHERE e.`department_id` IS NULL
```

```mysql
#左下图：满外连接 # 左中图 + 右上图 A∪B 
SELECT employee_id,last_name,department_name 
FROM employees e LEFT JOIN departments d 
ON e.`department_id` = d.`department_id` 
WHERE d.`department_id` IS NULL 
UNION ALL #没有去重操作，效率高
SELECT employee_id,last_name,department_name 
FROM employees e RIGHT JOIN departments d 
ON e.`department_id` = d.`department_id`;
```

```mysql
#右下图 #左中图 + 右中图 A ∪B- A∩B 或者 (A - A∩B) ∪ （B - A∩B）
SELECT employee_id,last_name,department_name 
FROM employees e LEFT JOIN departments d 
ON e.`department_id` = d.`department_id` 
WHERE d.`department_id` IS NULL 
UNION ALL 
SELECT employee_id,last_name,department_name 
FROM employees e RIGHT JOIN departments d 
ON e.`department_id` = d.`department_id` 
WHERE e.`department_id` IS NULL
```

语法格式小结

* 左中图

```mysql
#实现A - A∩B 
select 字段列表
from A表 left join B表
on 关联条件 
where 从表关联字段 is null and 等其他子句;
```

* 右中图

```mysql
#实现B - A∩B 
select 字段列表
from A表 right join B表 
on 关联条件 
where 从表关联字段 is null and 等其他子句;
```

* 左下图

```mysql
#实现查询结果是A∪B #用左外的A，union 右外的B 
select 字段列表
from A表 left join B表 
on 关联条件 
where 等其他子句

union 

select 字段列表
from A表 right join B表 
on 关联条件 
where 等其他子句;
```

* 右下图

```mysql
#实现A∪B - A∩B 或 (A - A∩B) ∪ （B - A∩B） #使用左外的 (A - A∩B) union 右外的（B - A∩B） 
select 字段列表
from A表 left join B表
on 关联条件 
where 从表关联字段 is null and 等其他子句 

union 

select 字段列表
from A表 right join B表 
on 关联条件 
where 从表关联字段 is null and 等其他子句
```

### 5.5 SQL99语法新特性

#### 5.5.1 自然连接 

SQL99 在 SQL92 的基础上提供了一些特殊语法，比如 NATURAL JOIN 用来表示自然连接。我们可以把自然连接理解为 SQL92 中的等值连接。它会帮你自动查询两张连接表中 所有相同的字段 ，然后进行 等值 连接 。 

在SQL92标准中：

```mysql
SELECT employee_id,last_name,department_name
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id` AND e.`manager_id` = d.`manager_id`;
```

在 SQL99 中你可以写成：

```mysql
SELECT employee_id,last_name,department_name 
FROM employees e 
NATURAL JOIN departments d;
```

#### 5.5.2 USING连接

当我们进行连接的时候，SQL99还支持使用 USING 指定数据表里的 同名字段 进行等值连接。但是只能配合JOIN一起使用。比如：

```mysql
SELECT e.`employee_id`, e.`last_name`, d.`department_id`
FROM employees e JOIN departments d
USING (department_id)
```

你能看出与自然连接 NATURAL JOIN 不同的是，USING 指定了具体的相同的字段名称，你需要在 USING的括号 () 中填入要指定的同名字段。同时使用 JOIN...USING 可以简化 JOIN ON 的等值连接。它与下面的 SQL 查询结果是相同的：

```mysql
SELECT employee_id,last_name,department_name 
FROM employees e ,departments d 
WHERE e.department_id = d.department_id;
```

### 5.6章节小结

表连接的约束条件可以有三种方式：WHERE, ON, USING 

* WHERE：适用于所有关联查询

* ON ：只能和JOIN一起使用，只能写关联条件。虽然关联条件可以并到WHERE中和其他条件一起写，但分开写可读性更好。

* USING：只能和JOIN一起使用，而且要求两个关联字段在关联表中名称一致，而且只能表示关联字段值相等

```mysql
#关联条件 #把关联条件写在where后面 
SELECT last_name,department_name 
FROM employees,departments 
WHERE employees.department_id = departments.department_id; 

#把关联条件写在on后面，只能和JOIN一起使用 
SELECT last_name,department_name 
FROM employees INNER JOIN departments 
ON employees.department_id = departments.department_id; 

SELECT last_name,department_name 
FROM employees CROSS JOIN departments 
ON employees.department_id = departments.department_id;

SELECT last_name,department_name 
FROM employees JOIN departments 
ON employees.department_id = departments.department_id; 

#把关联字段写在using()中，只能和JOIN一起使用 
#而且两个表中的关联字段必须名称相同，而且只能表示= 
#查询员工姓名与基本工资 
SELECT last_name,job_title 
FROM employees INNER JOIN jobs 
USING(job_id)

#n张表关联，需要n-1个关联条件 
#查询员工姓名，基本工资，部门名称 
SELECT last_name,job_title,department_name 
FROM employees,departments,jobs
WHERE employees.department_id = departments.department_id 
AND employees.job_id = jobs.job_id; 

SELECT last_name,job_title,department_name 
FROM employees INNER JOIN departments INNER JOIN jobs 
ON employees.department_id = departments.department_id
AND employees.job_id = jobs.job_id;
```

注意：

我们要 控制连接表的数量 。多表连接就相当于嵌套 for 循环一样，非常消耗资源，会让 SQL 查询性能下降得很严重，因此不要连接不必要的表。在许多 DBMS 中，也都会有最大连接表的限制。

> 【强制】超过三个表禁止 join。需要 join 的字段，数据类型保持绝对一致；多表关联查询时， 保证被关联的字段需要有索引。
>
> 说明：即使双表 join 也要注意表索引、SQL 性能。

## 第6章_单行函数

### 6.1函数的理解

#### 6.1.1 什么是函数

函数在计算机语言的使用中贯穿始终，函数的作用是什么呢？它可以把我们经常使用的代码封装起来，需要的时候直接调用即可。这样既 提高了代码效率 ，又提高了可维护性 。在 SQL 中我们也可以使用函数对检索出来的数据进行函数操作。使用这些函数，可以极大地 提高用户对数据库的管理效率 。

![image-20220713155819656](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713155819656.png)

从函数定义的角度出发，我们可以将函数分成 内置函数 和 自定义函数 。在 SQL 语言中，同样也包括了内置函数和自定义函数。内置函数是系统内置的通用函数，而自定义函数是我们根据自己的需要编写的，本章及下一章讲解的是 SQL 的内置函数。

#### 6.1.2 不同DBMS函数的差异

我们在使用 SQL 语言的时候，不是直接和这门语言打交道，而是通过它使用不同的数据库软件，即DBMS。DBMS 之间的差异性很大，远大于同一个语言不同版本之间的差异。实际上，只有很少的函数是被 DBMS 同时支持的。比如，大多数 DBMS 使用（||）或者（+）来做拼接符，而在 MySQL 中的字符串拼接函数为concat()。大部分 DBMS 会有自己特定的函数，这就意味着采用 SQL 函数的代码可移植性是很差的，因此在使用函数的时候需要特别注意。

#### 6.1.3 MySQL的内置函数及分类 

MySQL提供了丰富的内置函数，这些函数使得数据的维护与管理更加方便，能够更好地提供数据的分析与统计功能，在一定程度上提高了开发人员进行数据分析与统计的效率。MySQL提供的内置函数从 实现的功能角度 可以分为数值函数、字符串函数、日期和时间函数、流程控制函数、加密与解密函数、获取MySQL信息函数、聚合函数等。这里，我将这些丰富的内置函数再分为两类： 单行函数 、 聚合函数（或分组函数） 。

![image-20220713160701468](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713160701468.png)

单行函数

* 操作数据对象

* 接受参数返回一个结果

* 只对一行进行变换

* 每行返回一个结果

* 可以嵌套

* 参数可以是一列或一个值

### 6.2数值函数

#### 6.2.1 基本函数

| 函数                  | 用法                                                         |
| --------------------- | ------------------------------------------------------------ |
| ABS(x)                | 返回x的绝对值                                                |
| SIGN(x)               | 返回x的符号。正数返回1，负数返回-1，0返回0                   |
| PI()                  | 返回圆周率的值                                               |
| CEIL(x), CEILING(x)   | 返回大于或等于某个值的最小整数                               |
| FLOOR(x)              | 返回大于或等于某个值的最大整数                               |
| LEAST(e1,e2,e3...)    | 返回列表中的最小值                                           |
| GREATEST(e1,e2,e3...) | 返回列表中的最大值                                           |
| MOD(x,y)              | 返回x除以y后的余数                                           |
| RAND()                | 返回0~1的随机值                                              |
| RAND(x)               | 返回0~1的随机值，其中x的值用作种子值，相同的X值会产生相同的随机数 |
| ROUND(x)              | 返回一个对x的值进行四舍五入后，最接近于X的整数               |
| ROUND(x,y)            | 返回一个对x的值进行四舍五入后最接近X的值，并保留到小数点后面Y位 |
| TRUNCATE(x,y)         | 返回数字x截断为y位小数的结果                                 |
| SQRT(x)               | 返回x的平方根。当X的值为负数时，返回NULL                     |

举例：

```mysql
mysql> SELECT ABS(-123),ABS(32),SIGN(-23),SIGN(43),PI(),CEIL(32.32),CEILING(-43.23),FLOOR(32.32), FLOOR(-43.23),MOD(12,5) FROM DUAL;
+-----------+---------+-----------+----------+----------+-------------+-----------------+--------------+---------------+-----------+
| ABS(-123) | ABS(32) | SIGN(-23) | SIGN(43) | PI()     | CEIL(32.32) | CEILING(-43.23) | FLOOR(32.32) | FLOOR(-43.23) | MOD(12,5) |
+-----------+---------+-----------+----------+----------+-------------+-----------------+--------------+---------------+-----------+
|       123 |      32 |        -1 |        1 | 3.141593 |          33 |             -43 |           32 |           -44 |         2 |
+-----------+---------+-----------+----------+----------+-------------+-----------------+--------------+---------------+-----------+
1 row in set (0.00 sec)
```

![image-20220713162834310](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713162834310.png)

```mysql
SELECT RAND(),RAND(),RAND(10),RAND(10),RAND(-1),RAND(-1) FROM DUAL;
```

![image-20220713163135567](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713163135567.png)

```mysql
SELECT ROUND(12.33),ROUND(12.343,2),ROUND(12.324,-1),TRUNCATE(12.66,1),TRUNCATE(12.66,-1) FROM DUAL;
```

![image-20220713163301671](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713163301671.png)

#### 6.2.2 角度与弧度互换函数 

| 函数       | 用法                                  |
| ---------- | ------------------------------------- |
| RADIANS(x) | 将角度转化为弧度，其中，参数x为角度值 |
| DEGREES(x) | 将弧度转化为角度，其中，参数x为弧度值 |

```mysql
SELECT RADIANS(30),RADIANS(60),RADIANS(90),DEGREES(2*PI()),DEGREES(RADIANS(90))FROM DUAL;
```

![image-20220713185020188](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713185020188.png)

2.3 三角函数

| 函数       | 用法                                                         |
| ---------- | ------------------------------------------------------------ |
| SIN(x)     | 返回x的正弦值，其中，参数x为弧度值                           |
| ASIN(x)    | 返回x的反正弦值，即获取正弦为x的值。如果x的值不在-1到1之间，则返回NULL |
| COS(x)     | 返回x的余弦值，其中，参数x为弧度值                           |
| ACOS(x)    | 返回x的反余弦值，即获取余弦为x的值。如果x的值不在-1到1之间，则返回NULL |
| TAN(x)     | 返回x的正切值，其中，参数x为弧度值                           |
| ATAN(x)    | 返回x的反正切值，即返回正切值为x的值                         |
| ATAN2(m,n) | 返回两个参数的反正切值                                       |
| COT(x)     | 返回x的余切值，其中，X为弧度值                               |

 2.4 指数与对数

| 函数          | 用法                                                 |
| ------------- | ---------------------------------------------------- |
| POW(x,y)，    | POWER(X,Y) 返回x的y次方                              |
| EXP(X)        | 返回e的X次方，其中e是一个常数，2.718281828459045     |
| LN(X)，LOG(X) | 返回以e为底的X的对数，当X <= 0 时，返回的结果为NULL  |
| LOG10(X)      | 返回以10为底的X的对数，当X <= 0 时，返回的结果为NULL |
| LOG2(X)       | 返回以2为底的X的对数，当X <= 0 时，返回NULL          |

2.5 进制间的转换

![image-20220713190725780](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713190725780.png)

 ```mysql
mysql> SELECT BIN(10),HEX(10),OCT(10),CONV(10,2,8);
+---------+---------+---------+--------------+
| BIN(10) | HEX(10) | OCT(10) | CONV(10,2,8) |
+---------+---------+---------+--------------+
| 1010    | A       | 12      | 2            |
+---------+---------+---------+--------------+
1 row in set (0.01 sec)
 ```

3. 字符串函数

![image-20220713190747434](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713190747434.png)

![image-20220713190824141](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713190824141.png)

![image-20220713190950219](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713190950219.png)

## 第7章_聚合函数

### 7.1. 聚合函数介绍

* 什么是聚合函数
  聚合函数作用于一组数据，并对一组数据返回一个值。

* 聚合函数类型
  * AVG()
  * SUM()
  * MAX()
  * MIN()
  * COUNT()

* 聚合函数不能嵌套调用。比如不能出现类似“AVG(SUM(字段名称))”形式的调用。

#### 7.1.1 AVG和SUM函数

可以对数值型数据使用AVG 和 SUM 函数。

```mysql
SELECT AVG(salary), MAX(salary), MIN(salary),SUM(salary)
FROM employees
WHERE job_id LIKE '%REP%';
```

#### 7.1.2 MIN和MAX函数

可以对==任意数据==类型的数据使用 MIN 和 MAX 函数。

```mysql
SELECT MIN(hire_date), MAX(hire_date)
FROM employees;
```

#### 7.1.3 COUNT函数

* COUNT(*)返回表中记录总数，适用于==任意数据类型==。

```mysql
SELECT COUNT(*)
FROM employees
WHERE department_id = 50;
```

* COUNT(expr) 返回==expr不为空==的记录总数。

```mysql
SELECT COUNT(commission_pct)
FROM employees
WHERE department_id = 50;
```

### ![image-20220713210849833](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713210849833.png)7.2 GROUP BY

#### 7.2.1 基本使用

可以使用GROUP BY子句将表中的数据分成若干组

```mysql
SELECT column, group_function(column)
FROM table
[WHERE condition]
[GROUP BY group_by_expression]
[ORDER BY column];
```

> 明确：WHERE一定放在FROM后面

在SELECT列表中所有未包含在组函数中的列都应该包含在 GROUP BY子句中包含

```mysql
SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id ;
```

![image-20220713212443846](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713212443846.png)

包含在 GROUP BY 子句中的列不必包含在SELECT 列表中

```mysql
SELECT AVG(salary)
FROM employees
GROUP BY department_id ;
```

#### 7.2.2 使用多个列分组

![image-20220713212936352](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713212936352.png)

```mysql
SELECT department_id dept_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id ;
```

#### 7.2.3 GROUP BY中使用WITH ROLLUP

使用==WITH ROLLUP== 关键字之后，在所有查询出的分组记录之后增加一条记录，该记录计算查询出的所
有记录的总和，即统计记录数量。

```mysql
SELECT department_id, AVG(salary)
FROM employees
WHERE department_id > 80
GROUP BY department_id WITH ROLLUP;
```

![image-20220713213701454](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713213701454.png)

> 注意：
> 当使用ROLLUP时，不能同时使用ORDER BY子句进行结果排序，即<span style="color:red;">ROLLUP和ORDER BY</span>是互相排斥的。

### 7.3 HAVING

#### 7.3.1基本使用

过滤分组：HAVING子句
1. 行已经被分组。
2. 使用了聚合函数。
3. 满足HAVING 子句中条件的分组将被显示。
4. **HAVING 不能单独使用，必须要跟 GROUP BY 一起使用。**

```mysql
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary)>10000 ;
```

* **<span style="color:#880000;">非法使用聚合函数 ： 不能在 WHERE 子句中使用聚合函数。</span>**如下：

```mysql
SELECT department_id, AVG(salary)
FROM employees
WHERE AVG(salary) > 8000
GROUP BY department_id;
```

> 查询：SELECT department_id, AVG(salary) FROM employees WHERE AVG(salary) > 8000 GROUP BYdepartment_id LIMIT 0, 1000错误代码： 1111
> Invalid use of group function

3.2 WHERE和HAVING的对比

<span style="color: #880000;font-weight: bold;">区别1：WHERE 可以直接使用表中的字段作为筛选条件，但不能使用分组中的计算函数作为筛选条件；
HAVING 必须要与 GROUP BY 配合使用，可以把分组计算的函数和分组字段作为筛选条件。</span>

这决定了，在需要对数据进行分组统计的时候，HAVING 可以完成 WHERE 不能完成的任务。这是因为，在查询语法结构中，WHERE 在 GROUP BY 之前，所以无法对分组结果进行筛选。HAVING 在 GROUP BY 之后，可以使用分组字段和分组中的计算函数，对分组的结果集进行筛选，这个功能是 WHERE 无法完成的。另外，WHERE排除的记录不再包括在分组中。

<span style="color: #880000;font-weight: bold;">区别2：如果需要通过连接从关联表中获取需要的数据，WHERE 是先筛选后连接，而 HAVING 是先连接后筛选。</span>这一点，就决定了在关联查询中，WHERE 比 HAVING 更高效。因为 WHERE 可以先筛选，用一个筛选后的较小数据集和关联表进行连接，这样占用的资源比较少，执行效率也比较高。HAVING 则需要先把结果集准备好，也就是用未被筛选的数据集进行关联，然后对这个大的数据集进行筛选，这样占用的资源就比较多，执行效率也较低。

|        | 优点                         | 缺点                                   |
| ------ | ---------------------------- | -------------------------------------- |
| WHERE  | 先筛选数据再关联，执行效率高 | 不能使用分组中的计算函数进行筛选       |
| HAVING | 可以使用分组中的计算函数     | 在最后的结果集中进行筛选，执行效率较低 |

<span style="color: #880000;font-weight: bold;">开发中的选择：</span>
WHERE 和 HAVING 也不是互相排斥的，我们可以在一个查询里面同时使用 WHERE 和 HAVING。包含分组统计函数的条件用 HAVING，普通条件用 WHERE。这样，我们就既利用了 WHERE 条件的高效快速，又发挥了 HAVING 可以使用包含分组统计函数的查询条件的优点。当数据量特别大的时候，运行效率会有很大的差别。

### 7.4 SELECT的执行过程

#### 7.4.1 查询的结构

```mysql
#方式1：
SELECT ...,....,...
FROM ...,...,....
WHERE 多表的连接条件
AND 不包含组函数的过滤条件
GROUP BY ...,...
HAVING 包含组函数的过滤条件
ORDER BY ... ASC/DESC
LIMIT ...,...

#方式2：
SELECT ...,....,...
FROM ... JOIN ...
ON 多表的连接条件
JOIN ...
ON ...
WHERE 不包含组函数的过滤条件
AND/OR 不包含组函数的过滤条件
GROUP BY ...,...
HAVING 包含组函数的过滤条件
ORDER BY ... ASC/DESC
LIMIT ...,...

#其中：
#（1）from：从哪些表中筛选
#（2）on：关联多表查询时，去除笛卡尔积
#（3）where：从表中筛选的条件
#（4）group by：分组依据
#（5）having：在统计结果中再次筛选
#（6）order by：排序
#（7）limit：分页
```

#### 7.4.2 SELECT执行顺序

**1.你需要记住 SELECT 查询时的两个顺序：**

```mysql
SELECT ... FROM ... WHERE ... GROUP BY ... HAVING ... ORDER BY ... LIMIT...
```

**2.SELECT 语句的执行顺序**（在 MySQL 和 Oracle 中，SELECT 执行顺序基本相同）：

```mysql
FROM -> WHERE -> GROUP BY -> HAVING -> SELECT 的字段 -> DISTINCT -> ORDER BY -> LIMIT
```

比如你写了一个 SQL 语句，那么它的关键字顺序和执行顺序是下面这样的：

```mysql
SELECT DISTINCT player_id, player_name, count(*) as num # 顺序 5
FROM player JOIN team ON player.team_id = team.team_id # 顺序 1
WHERE height > 1.80 # 顺序 2
GROUP BY player.team_id # 顺序 3
HAVING num > 2 # 顺序 4
ORDER BY num DESC # 顺序 6
LIMIT 2 # 顺序 7
```

在 SELECT 语句执行这些步骤的时候，每个步骤都会产生一个虚拟表，然后将这个虚拟表传入下一个步骤中作为输入。需要注意的是，这些步骤隐含在 SQL 的执行过程中，对于我们来说是不可见的。

#### 7.4.3 SQL 的执行原理

SELECT 是先执行 FROM 这一步的。在这个阶段，如果是多张表联查，还会经历下面的几个步骤：
1. 首先先通过 CROSS JOIN 求笛卡尔积，相当于得到虚拟表==vt（virtual table）1-1==；
2. 通过 ON 进行筛选，在虚拟表 ==vt1-1== 的基础上进行筛选，得到虚拟表 ==vt1-2==；
3. 添加外部行。如果我们使用的是左连接、右链接或者全连接，就会涉及到外部行，也就是在虚拟表 ==vt1-2== 的基础上增加外部行，得到虚拟表 ==vt1-3==。
当然如果我们操作的是两张以上的表，还会重复上面的步骤，直到所有表都被处理完为止。这个过程得到是我们的原始数据。

当我们拿到了查询数据表的原始数据，也就是最终的虚拟表 ==vt1== ，就可以在此基础上再进行 WHERE 阶段。在这个阶段中，会根据 ==vt1== 表的结果进行筛选过滤，得到虚拟表 ==vt2== 。
然后进入第三步和第四步，也就是 ==GROUP== 和 ==HAVING==阶段。在这个阶段中，实际上是在虚拟表 ==vt2== 的基础上进行分组和分组过滤，得到中间的虚拟表 ==vt3== 和 ==vt4== 。
当我们完成了条件筛选部分之后，就可以筛选表中提取的字段，也就是进入到 SELECT 和 DISTINCT阶段。
首先在 SELECT 阶段会提取想要的字段，然后在 DISTINCT 阶段过滤掉重复的行，分别得到中间的虚拟表==vt5-1== 和 ==vt5-2== 。
当我们提取了想要的字段数据之后，就可以按照指定的字段进行排序，也就是 ORDER BY 阶段，得到虚拟表==vt6==。
最后在 ==vt6== 的基础上，取出指定行的记录，也就是 LIMIT 阶段，得到最终的结果，对应的是虚拟表==vt7== 。
当然我们在写 SELECT 语句的时候，不一定存在所有的关键字，相应的阶段就会省略。

同时因为 SQL 是一门类似英语的结构化查询语言，所以我们在写 SELECT 语句的时候，还要注意相应的关键字顺序，**所谓底层运行的原理，就是我们刚才讲到的执行顺序。**

## 第8章_子查询

子查询指一个查询语句嵌套在另一个查询语句内部的查询，这个特性从MySQL 4.1开始引入。
SQL 中子查询的使用大大增强了 SELECT 查询的能力，因为很多时候查询需要从结果集中获取数据，或者需要从同一个表中先计算得出一个数据结果，然后与这个数据结果（可能是某个标量，也可能是某个集合）进行比较。

```mysql
SELECT last_name,salary
FROM employees
WHERE salary > (
	SELECT salary
	FROM employees
	WHERE last_name = 'Abel'
);
```

### 8.1子查询的基本使用

子查询（内查询）在主查询之前一次执行完成。
子查询的结果被主查询（外查询）使用 。

* 注意事项
  子查询要包含在括号内
  将子查询放在比较条件的右侧
  单行操作符对应单行子查询，多行操作符对应多行子查询

#### 8.1.1子查询的分类

分类方式1：
我们按内查询的结果返回一条还是多条记录，将子查询分为==单行子查询==、==多行子查询==。

![image-20220713221723278](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713221723278.png)

分类方式2：

我们按内查询是否被执行多次，将子查询划分为==相关(或关联)子查询==和==不相关(或非关联)子查询==。
子查询从数据表中查询了数据结果，如果这个数据结果只执行一次，然后这个数据结果作为主查询的条件进行执行，那么这样的子查询叫做不相关子查询。
同样，如果子查询需要执行多次，即采用循环的方式，先从外部查询开始，每次都传入子查询进行查询，然后再将结果反馈给外部，这种嵌套的执行方式就称为相关子查询。

### 8.2单行子查询

#### 8.2.1 单行比较操作符

![image-20220713221932092](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220713221932092.png)

#### 8.2.2 代码示例

题目：查询工资大于149号员工工资的员工的信息

```mysql
SELECT * 
FROM employees
WHERE salary > (
	SELECT salary FROM employees
	WHERE employee_id = 149
);
```

题目：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资

```mysql
SELECT last_name, job_id, salary
FROM employees
WHERE job_id = (
	SELECT job_id 
	FROM employees 
	WHERE employee_id = 141
)
AND salary > (
	SELECT salary 
	FROM employees 
	WHERE employee_id = 143
);
```

题目：返回公司工资最少的员工的last_name,job_id和salary

```mysql
SELECT last_name, job_id, salary
FROM employees
WHERE salary =
(	SELECT MIN(salary)
	FROM employees
);
```

题目：查询与141号或174号员工的manager_id和department_id相同的其他员工的employee_id，manager_id，department_id

实现方式1：不成对比较

```mysql
SELECT employee_id, manager_id, department_id
FROM employees
WHERE manager_id IN
(	SELECT manager_id
	FROM employees
	WHERE employee_id IN (174,141)
)
AND department_id IN
(	SELECT department_id
	FROM employees
	WHERE employee_id IN (174,141)
)
AND employee_id NOT IN(174,141);
```

实现方式2：成对比较

```mysql
ELECT employee_id, manager_id, department_id
FROM employees
WHERE (manager_id, department_id) IN
	(
    	SELECT manager_id, department_id
		FROM employees
		WHERE employee_id IN (141,174)
	)
AND employee_id NOT IN (141,174);
```

#### 8.2.3 HAVING 中的子查询

首先执行子查询。
向主查询中的HAVING 子句返回结果。

题目：查询最低工资大于50号部门最低工资的部门id和其最低工资

```mysql
SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
	SELECT MIN(salary)
	FROM employees
	WHERE department_id = 50
);
```

#### 8.2.4 CASE中的子查询

在CASE表达式中使用单列子查询：

题目：显示员工的employee_id,last_name和location。其中，若员工department_id与location_id为1800的department_id相同，则location为’Canada’，其余则为’USA’。

```mysql
SELECT employee_id, last_name,
	(
	CASE department_id
	WHEN
		(SELECT department_id FROM departments
			WHERE location_id = 1800)
	THEN 'Canada' ELSE 'USA' END
	) AS location	
FROM employees;
```

#### 8.2.5 子查询中的空值问题

```mysql
SELECT last_name, job_id
FROM employees
WHERE job_id =
(	SELECT job_id
	FROM employees
	WHERE last_name = 'Haas'
);
```

![image-20220714112432814](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714112432814.png)

> 子查询不返回任何行

```mysql
SELECT employee_id, last_name
FROM employees
WHERE salary =
(	SELECT MIN(salary)
	FROM employees
	GROUP BY department_id
); # 这个子查询返回结果有多行
```

<span style="color:red">查询：SELECT employee_id, last_name FROM employees WHERE salary = (SELECT MIN(salary) FROM employees GROUP BY department_id)错误代码： 1242</span>
Subquery returns more than 1 row

> 多行子查询使用单行比较符

### 8.3多行子查询

* 也称为集合比较子查询
* 内查询返回多行
* 使用多行比较操作符

#### 8.3.1 多行比较操作符

![image-20220714112908897](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714112908897.png)

#### 8.3.2 代码示例

题目：返回其它job_id中比job_id为‘IT_PROG’部门任一工资低的员工的员工号、姓名、job_id 以及salary

```mysql
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ANY(
	SELECT salary 
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND job_id <> 'IT_PROG';
```

题目：返回其它job_id中比job_id为‘IT_PROG’部门所有工资都低的员工的员工号、姓名、job_id以及salary

```mysql
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL(
	SELECT salary 
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND job_id <> 'IT_PROG';
```

题目：查询平均工资最低的部门id

```mysql
#方式1：
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (
	SELECT MIN(avg_sal)
	FROM (
		SELECT AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
	) dept_avg_sal
)
```

```mysql
#方式2：
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL (
		SELECT AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
)
```

### 8.4EXISTS 与 NOT EXISTS关键字

关联子查询通常也会和 EXISTS操作符一起来使用，用来检查在子查询中是否存在满足条件的行。

* 如果在子查询中不存在满足条件的行：

  * 条件返回 FALSE

  * 继续在子查询中查找

* 如果在子查询中存在满足条件的行：
    * 不在子查询中继续查找
      
    * 条件返回 TRUE
      
      
      
      NOT EXISTS关键字表示如果不存在某种条件，则返回TRUE，否则返回FASE。

```mysql
SELECT employee_id, last_name, job_id, department_id
FROM employees e1
WHERE EXISTS ( 
    SELECT *
	FROM employees e2
	WHERE e2.manager_id =e1.employee_id
);
```

```mysql
SELECT department_id, department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT 'X'
	FROM employees
	WHERE department_id = d.department_id
);
```

#### 8.4.1相关更新

```mysql
UPDATE table1 alias1
SET column = (
    SELECT expression
	FROM table2 alias2
	WHERE alias1.column = alias2.column
);
```

```mysql
# 1）
ALTER TABLE employees
ADD(department_name VARCHAR2(14));
# 2）
UPDATE employees e
SET department_name = (
    SELECT department_name
	FROM departments d
	WHERE e.department_id = d.department_id
);
```

#### 8.4.2相关删除

```mysql
DELETE FROM table1 alias1
WHERE column operator (
    SELECT expression
	FROM table2 alias2
	WHERE alias1.column = alias2.column
);
```

```mysql
DELETE FROM employees e
WHERE employee_id in
(	
    SELECT employee_id
	FROM emp_history
	WHERE employee_id = e.employee_id
);
```

## 第9章_创建和管理表

### 9.1基础知识

#### 9.1.1标识符命名规则

* 数据库名、表名不得超过30个字符，变量名限制为29个
* 必须只能包含 A–Z, a–z, 0–9, _共63个字符
* 数据库名、表名、字段名等对象名中间不要包含空格
* 同一个MySQL软件中，数据库不能同名；同一个库中，表不能重名；同一个表中，字段不能重名
* 必须保证你的字段没有和保留字、数据库系统或常用方法冲突。如果坚持使用，请在SQL语句中使用`（着重号）引起来
* 保持字段名和类型的一致性：在命名字段并为其指定数据类型的时候一定要保证一致性，假如数据
* 类型在一个表里是整数，那在另一个表里可就别变成字符型了

#### 9.1.2 MySQL中的数据类型

![image-20220714155850542](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714155850542.png)

![image-20220714160428363](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714160428363.png)

### 9.2创建和管理数据库

#### 9.2.1 创建数据库

* 方式1：创建数据库

```mysql
CREATE DATABASE 数据库名;
```

* 方式2：创建数据库并指定字符集

```mysql
CREATE DATABASE 数据库名 CHARACTER SET 字符集;
```

* 方式3：判断数据库是否已经存在，不存在则创建数据库（ ==推荐==）

```mysql
CREATE DATABASE IF NOT EXISTS 数据库名;
```

如果MySQL中已经存在相关的数据库，则忽略创建语句，不再创建数据库。

> 注意：DATABASE 不能改名。一些可视化工具可以改名，它是建新库，把所有表复制到新库，再删旧库完成的。

#### 9.2.2 使用数据库

* 查看当前所有的数据库

```mysql
SHOW DATABASES; #有一个S，代表多个数据库
```

* 查看当前正在使用的数据库

```mysql
SELECT DATABASE(); #使用的一个 mysql 中的全局函数
```

* 查看指定库下所有的表

```mysql
SHOW TABLES FROM 数据库名;
```

* 查看数据库的创建信息

```mysql
SHOW CREATE DATABASE 数据库名;
或者：
SHOW CREATE DATABASE 数据库名\G
```

* 使用/切换数据库

```mysql
USE 数据库名;
```

> 注意：要操作表格和数据之前必须先说明是对哪个数据库进行操作，否则就要对所有对象加上“数据库名.”。

#### 9.2.3 修改数据库

* 更改数据库字符集

```mysql
ALTER DATABASE 数据库名 CHARACTER SET 字符集; #比如：gbk、utf8等
```

#### 9.2.4 删除数据库

* 方式1：删除指定的数据库

```mysql
DROP DATABASE 数据库名;
```

* 方式2：删除指定的数据库（==推荐==）

```mysql
DROP DATABASE IF EXISTS 数据库名;
```

### 9.3创建表

#### 9.3.1 创建方式1

* **必须具备：**
* CREATE TABLE权限
  
* 存储空间

语法格式：

```mysql
CREATE TABLE [IF NOT EXISTS] 表名(
字段1, 数据类型 [约束条件] [默认值],
字段2, 数据类型 [约束条件] [默认值],
字段3, 数据类型 [约束条件] [默认值],
……
[表约束条件]
);
```

> 加上了IF NOT EXISTS关键字，则表示：如果当前数据库中不存在要创建的数据表，则创建数据表；
> 如果当前数据库中已经存在要创建的数据表，则忽略建表语句，不再创建数据表。

* **必须指定：**
  * 表名
  * 列名(或字段名)，数据类型，长度
* 可选指定：
  * 约束条件
  * 默认值
* 创建表举例1：

```mysql
-- 创建表
CREATE TABLE emp (
-- int类型
emp_id INT,
-- 最多保存20个中英文字符
emp_name VARCHAR(20),
-- 总位数不超过15位
salary DOUBLE,
-- 日期类型
birthday DATE
);
```

![image-20220714162659422](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714162659422.png)

MySQL在执行建表语句时，将id字段的类型设置为int(11)，这里的11实际上是int类型指定的显示宽度，默认的显示宽度为11。也可以在创建数据表的时候指定数据的显示宽度。

```mysql
CREATE TABLE dept(
-- int类型，自增
deptno INT(2) AUTO_INCREMENT,
dname VARCHAR(14),
loc VARCHAR(13),
-- 主键
PRIMARY KEY (deptno)
);
```

> 在MySQL 8.x版本中，不再推荐为INT类型指定显示长度，并在未来的版本中可能去掉这样的语法。

#### 9.3.2 创建方式2

* 使用 AS subquery 选项，将**创建表和插入数据结合起来**

* 指定的列和子查询中的列要一一对应
* 通过列名和默认值定义列

```mysql
CREATE TABLE emp1 AS SELECT * FROM employees;
CREATE TABLE emp2 AS SELECT * FROM employees WHERE 1=2; -- 创建的emp2是空表
```

```mysql
CREATE TABLE dept80
AS
SELECT employee_id, last_name, salary*12 ANNSAL, hire_date
FROM employees
WHERE department_id = 80;
```

```mysql
DESCRIBE dept80;
```

#### 9.3.3 查看数据表结构

在MySQL中创建好数据表之后，可以查看数据表的结构。MySQL支持使用==DESCRIBE/DESC== 语句查看数据表结构，也支持使用==SHOW CREATE TABLE== 语句查看数据表结构。语法格式如下：

```mysql
SHOW CREATE TABLE 表名\G
```

使用SHOW CREATE TABLE语句不仅可以查看表创建时的详细语句，还可以查看存储引擎和字符编码。

### 9.4修改表

修改表指的是修改数据库中已经存在的数据表的结构。
使用 ALTER TABLE 语句可以实现：

* 向已有的表中添加列
* 修改现有表中的列
* 删除现有表中的列
* 重命名现有表中的列

#### 9.4.1 追加一个列

语法格式如下：
举例：

```mysql
ALTER TABLE 表名 ADD 【COLUMN】 字段名 字段类型 【FIRST|AFTER 字段名】;
```

```mysql
ALTER TABLE dept
ADD job_id varchar(15);
```

#### 9.4.2 修改一个列

可以修改列的数据类型，长度、默认值和位置
修改字段数据类型、长度、默认值、位置的语法格式如下：

```mysql
ALTER TABLE 表名 MODIFY 【COLUMN】 字段名1 字段类型 【DEFAULT 默认值】【FIRST|AFTER 字段名2】;
```

举例：

```mysql
ALTER TABLE dept
MODIFY last_name VARCHAR(30);
```

```mysql
ALTER TABLE dept
MODIFY salary double(9,2) default 1000;
```

对默认值的修改只影响今后对表的修改

#### 9.4.3 重命名一个列

使用 CHANGE old_column new_column dataType子句重命名列。语法格式如下

```mysql
ALTER TABLE 表名 CHANGE 【column】 列名 新列名 新数据类型;
```

举例：

```mysql
ALTER TABLE dept
CHANGE department_name dept_name varchar(15);
```

#### 9.4.4 删除一个列

删除表中某个字段的语法格式如下：

```mysql
ALTER TABLE 表名 DROP 【COLUMN】字段名
```

举例：

```mysql
ALTER TABLE dept
DROP COLUMN job_id;
```

### 9.5重命名表

方式一：使用RENAME

```mysql
RENAME TABLE emp TO myemp;
```

 方式二：

```mysql
ALTER table dept
RENAME [TO] detail_dept; -- [TO]可以省略
```

### 9.6删除表

* 在MySQL中，当一张数据表没有与其他任何数据表形成关联关系时，可以将当前数据表直接删除。
* 数据和结构都被删除
* 所有正在运行的相关事务被提交
* 所有相关索引被删除
  语法格式：

```mysql
DROP TABLE [IF EXISTS] 数据表1 [, 数据表2, …, 数据表n];
```

IF EXISTS 的含义为：如果当前数据库中存在相应的数据表，则删除数据表；如果当前数据库中不存在相应的数据表，则忽略删除语句，不再执行删除数据表的操作。

举例：

```mysql
DROP TABLE users1;
```

**DROP TABLE 语句不能回滚**

### 9.7清空表

* TRUNCATE TABLE语句：
  * 删除表中所有的数据
  * 释放表的存储空间
* 举例：

```mysql
TRUNCATE TABLE student;
```

**TRUNCATE语句不能回滚，而使用 DELETE 语句删除数据，可以回滚**
对比：

```mysql
SET autocommit = FALSE;
DELETE FROM student;
#TRUNCATE TABLE student;
SELECT * FROM student;
ROLLBACK;
SELECT * FROM student;
```

> 阿里开发规范：
> 【参考】TRUNCATE TABLE 比 DELETE 速度快，且使用的系统和事务日志资源少，但 TRUNCATE 无事务且不触发 TRIGGER，有可能造成事故，故不建议在开发代码中使用此语句。
> 说明：TRUNCATE TABLE 在功能上与不带 WHERE 子句的 DELETE 语句相同。

### 9.8内容拓展

拓展1：阿里巴巴《Java开发手册》之MySQL字段命名

【==强制==】表名、字段名必须使用小写字母或数字，禁止出现数字开头，禁止两个下划线中间只出现数字。数据库字段名的修改代价很大，因为无法进行预发布，所以字段名称需要慎重考虑。
正例：aliyun_admin，rdc_config，level3_name
反例：AliyunAdmin，rdcConfig，level_3_name
【==强制==】禁用保留字，如 desc、range、match、delayed 等，请参考 MySQL 官方保留字。
【==强制==】表必备三字段：id, gmt_create, gmt_modified。
说明：其中 id 必为主键，类型为BIGINT UNSIGNED、单表时自增、步长为 1。gmt_create,gmt_modified 的类型均为 DATETIME 类型，前者现在时表示主动式创建，后者过去分词表示被动式更新
【==推荐==】表的命名最好是遵循 “业务名称_表的作用”。
正例：alipay_task 、 force_project、 trade_config
【==推荐==】库名与应用名称尽量一致。
【==参考==】合适的字符存储长度，不但节约数据库表空间、节约索引存储，更重要的是提升检索速

![image-20220714184224115](https://trpora-1300527744.cos.ap-chongqing.myqcloud.com/img/image-20220714184224115.png)

拓展2：如何理解清空表、删除表等操作需谨慎？！

表删除操作将把表的定义和表中的数据一起删除，并且MySQL在执行删除操作时，不会有任何的确认信息提示，因此执行删除操时应当慎重。在删除表前，最好对表中的数据进行备份，这样当操作失误时可以对数据进行恢复，以免造成无法挽回的后果。
同样的，在使用 ALTER TABLE 进行表的基本修改操作时，在执行操作过程之前，也应该确保对数据进行完整的备份，因为数据库的改变是无法撤销的，如果添加了一个不需要的字段，可以将其删除；相同的，如果删除了一个需要的列，该列下面的所有数据都将会丢失。

拓展3：MySQL8新特性—DDL的原子化

在MySQL 8.0版本中，InnoDB表的DDL支持事务完整性，即DDL操作要么成功要么回滚。DDL操作回滚日志写入到data dictionary数据字典表mysql.innodb_ddl_log（该表是隐藏的表，通过show tables无法看到）中，用于回滚操作。通过设置参数，可将DDL操作日志打印输出到MySQL错误日志中。
分别在MySQL 5.7版本和MySQL 8.0版本中创建数据库和数据表，结果如下：

```mysql
CREATE DATABASE mytest;
USE mytest;
CREATE TABLE book1(
	book_id INT ,
	book_name VARCHAR(255)
);
SHOW TABLES;
```

（1）在MySQL 5.7版本中，测试步骤如下： 删除数据表book1和数据表book2，结果如下：(book2表是不存在的)

```mysql
mysql> DROP TABLE book1,book2;
ERROR 1051 (42S02): Unknown table 'mytest.book2'
```

再次查询数据库中的数据表名称，结果如下：

```mysql
mysql> SHOW TABLES;
Empty set (0.00 sec)
```

从结果可以看出，虽然删除操作时报错了，但是仍然删除了数据表book1。
（2）在MySQL 8.0版本中，测试步骤如下： 删除数据表book1和数据表book2，结果如下：

```mysql
mysql> DROP TABLE book1,book2;
ERROR 1051 (42S02): Unknown table 'mytest.book2'
```

再次查询数据库中的数据表名称，结果如下：

```mysql
mysql> show tables;
+------------------+
| Tables_in_mytest |
+------------------+
| book1 |
+------------------+
1 row in set (0.00 sec)
```

从结果可以看出，数据表book1并没有被删除。

## 第10章_数据处理之增删改

### 10.1插入数据

#### 10.1.1 方式1：VALUES的方式添加

使用这种语法一次只能向表中插入一条数据。

**情况1：为表的所有字段按默认顺序插入数据**

```mysql
INSERT INTO 表名
VALUES (value1,value2,....);
```

值列表中需要为表的每一个字段指定值，并且值的顺序必须和数据表中字段定义时的顺序相同。

举例：

```mysql
INSERT INTO student VALUES (1, '张三');
INSERT INTO student VALUES (2, NULL);
```

**情况2：为表的指定字段插入数据**

```mysql
INSERT INTO 表名(column1 [, column2, …, columnn])
VALUES (value1 [,value2, …, valuen]);
```

为表的指定字段插入数据，就是在INSERT语句中只向部分字段中插入值，而其他字段的值为表定义时的默认值。
在 INSERT 子句中随意列出列名，但是一旦列出，VALUES中要插入的value1,....valuen需要与column1,...columnn列一一对应。如果类型不同，将无法插入，并且MySQL会产生错误。
举例：

```mysql
INSERT INTO student(id, NAME) VALUES (3, '李四');
```

**情况3：同时插入多条记录**

INSERT语句可以同时向数据表中插入多条记录，插入时指定多个值列表，每个值列表之间用逗号分隔开，基本语法格式如下：

```mysql
INSERT INTO table_name
VALUES
(value1 [,value2, …, valuen]),
(value1 [,value2, …, valuen]),
……
(value1 [,value2, …, valuen]);
```

或

```mysql
INSERT INTO table_name(column1 [, column2, …, columnn])
VALUES
(value1 [,value2, …, valuen]),
(value1 [,value2, …, valuen]),
……
(value1 [,value2, …, valuen]);
```

举例：

```mysql
INSERT INTO student(id, NAME) VALUE (4,'王五'),(5, '赵六');
```

```mysql
mysql> INSERT INTO emp(emp_id,emp_name)
-> VALUES (1001,'shkstart'),
-> (1002,'atguigu'),
-> (1003,'Tom');
Query OK, 3 rows affected (0.00 sec)
Records: 3 Duplicates: 0 Warnings: 0
```

使用INSERT同时插入多条记录时，MySQL会返回一些在执行单行插入时没有的额外信息，这些信息的含义如下： ●　Records：表明插入的记录条数。 ●　Duplicates：表明插入时被忽略的记录，原因可能是这些记录包含了重复的主键值。 ●　Warnings：表明有问题的数据值，例如发生数据类型转换。

> 一个同时插入多行记录的INSERT语句等同于多个单行插入的INSERT语句，但是多行的INSERT语句在处理过程中效率更高。因为MySQL执行单条INSERT语句插入多行数据比使用多条INSERT语句快，所以在插入多条记录时最好选择使用单条INSERT语句的方式插入。

小结：

* VALUES 也可以写成VALUE ，但是VALUES是标准写法。
* 字符和日期型数据应包含在单引号中。

#### 10.1.2 方式2：将查询结果插入到表中

INSERT还可以将SELECT语句查询的结果插入到表中，此时不需要把每一条记录的值一个一个输入，只需要使用一条INSERT语句和一条SELECT语句组成的组合语句即可快速地从一个或多个表中向一个表中插入多行。

基本语法格式如下：

```mysql
INSERT INTO 目标表名
(tar_column1 [, tar_column2, …, tar_columnn])
SELECT
(src_column1 [, src_column2, …, src_columnn])
FROM 源表名
[WHERE condition]
```

* 在 INSERT 语句中加入子查询。
* 不必书写 VALUES 子句。
* 子查询中的值列表应与 INSERT 子句中的列名对应。

举例：

```mysql
INSERT INTO emp2
SELECT *
FROM employees
WHERE department_id = 90;
```

```mysql
INSERT INTO sales_reps(id, name, salary, commission_pct)
SELECT employee_id, last_name, salary, commission_pct
FROM employees
WHERE job_id LIKE '%REP%';
```

### 10.2更新数据

使用 UPDATE 语句更新数据。语法如下：

```mysql
UPDATE table_name
SET column1=value1, column2=value2, … , column=valuen
[WHERE condition]
```

* 可以一次更新多条数据。
* 如果需要回滚数据，需要保证在DML前，进行设置：**SET AUTOCOMMIT = FALSE;**
* 使用 WHERE 子句指定需要更新的数据。

```mysql
UPDATE employees
SET department_id = 70
WHERE employee_id = 113;
```

如果省略 WHERE 子句，则表中的所有数据都将被更新。

```mysql
UPDATE copy_emp
SET department_id = 110;
```

### 10.3删除数据

使用 DELETE 语句从表中删除数据

```mysql
DELETE FROM table_name [WHERE <condition>];
```

table_name指定要执行删除操作的表；“[WHERE ]”为可选参数，指定删除条件，如果没有WHERE子句，DELETE语句将删除表中的所有记录。

使用 WHERE 子句删除指定的记录。

```mysql
DELETE FROM departments
WHERE department_name = 'Finance';
```

如果省略 WHERE 子句，则表中的全部数据将被删除

```mysql
DELETE FROM departments
WHERE department_id = 60;
```

