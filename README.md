# spring-boot-mq

#### 介绍
springboot整合消息中间件

#### 软件架构
springboot , activemq，后期待加入和 rabbitmq,rocketmq等等消息中间件例子


#### 安装教程

##### ActiveMQ 安装
1. 从百度网盘上下载 activemq 链接：https://pan.baidu.com/s/1NtfG37-rx7CpbxhdW43xFw 提取码：1j6p 
2. 解压后包含 windows 和 linux 两个版本，windows 进入 磁盘路径\apache-activemq-5.15.0\bin 目录下，根据操作系统不同
   进入 win32 或 win64 目录下，双击 activemq.bat 启动
3. linux 进入 磁盘路径\apache-activemq-5.15.0\bin 目录下根据操作系统不同 进入 linux-x86-32或 linux-x86-64 目录下，运行
    ./activemq 命令
4. 浏览器输入 http://localhost:8161出现管理界面即安装成功 用户名 admin 密码 admin 

##### RabbitMQ 安装
1. 从百度网盘上下载 rabbitmq 链接 ：https://pan.baidu.com/s/1iJ1oNTZp9h9HRyoFQUxISw  提取码：exx0              
2. windows 点击 otp_win64_17.3.exe(64位操作系统) 或 otp_win32_17.4.exe(32位操作系统) 安装 Erlang环境
   然后点击 rabbitmq-server-3.4.1.exe 安装服务器环境，打开开始菜单找到rabbitmq安装选项，打开命令行工具输入rabbitmq-plugins enable rabbitmq_management 命令启动web管理台
3. 输入 http://localhost:15672  进入管理界面 ，用户名 guest 密码 guest
4.  [参考教程](https://blog.csdn.net/lu1005287365/article/details/52315786)

#### 使用说明

1. 运行 ActivemqProducerTest 类中编写好的测试方法


#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
