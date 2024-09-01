一、查看Linux系统版本的命令（3种方法）

1、cat /etc/issue，此命令也适用于所有的Linux发行版。

　　[root@S-CentOS home]# cat /etc/issue
　　CentOS release 6.5 (Final)
　　Kernel \r on an \m

2、cat /etc/redhat-release，这种方法只适合Redhat系的Linux：

　　[root@S-CentOS home]# cat /etc/redhat-release
　　CentOS release 6.5 (Final)



3、lsb_release -a，即可列出所有版本信息：

　　[root@S-CentOS ~]# lsb_release -a
　　LSB Version: :base-4.0-amd64:base-4.0-noarch:core-4.0-amd64:core-4.0-noarch:graphics-4.0-amd64:graphics-4.0-noarch:printing-4.0-amd64:printing-4.0-noarch
　　Distributor ID: CentOS
　　Description: CentOS release 6.5 (Final)
　　Release: 6.5
　　Codename: Final



二、查看Linux内核版本命令（两种方法）：

1、cat /proc/version

　　[root@S-CentOS home]# cat /proc/version
　　Linux version 2.6.32-431.el6.x86_64 (mockbuild@c6b8.bsys.dev.centos.org) (gcc version 4.4.7 20120313 (Red Hat 4.4.7-4) (GCC) ) #1 SMP Fri Nov 22 03:15:09 UTC 2013

2、uname -a

　　[root@S-CentOS home]# uname -a

　　Linux S-CentOS 2.6.32-431.el6.x86_64 #1 SMP Fri Nov 22 03:15:09 UTC 2013 x86_64 x86_64 x86_64 GNU/Linux


## 安装MySQL


安装用来配置mysql的yum源的rpm包
rpm -Uvh https://repo.mysql.com//mysql80-community-release-el7-4.noarch.rpm
安装Mysql
yum install mysql-community-server
图片描述
开启mysql服务
service mysqld start
图片描述
mysql安装成功后创建的超级用户’root’@‘localhost’的密码会被存储在/var/log/mysqld.log，可以使用如下命令查看密码
grep 'temporary password' /var/log/mysqld.log
图片描述
使用mysql生成的’root’@‘localhost’用户和密码登录数据库，并修改 其密码，具体命令
mysql -uroot -p
ALTER USER 'root'@'localhost' IDENTIFIED BY 'Kangda2019!';
图片描述
开启远程连接
通过阿里云控制台开放3306端口
在阿里云控制台咱们的实例页面下面选择安全组->配置规则
图片描述
进入到规则配置页面之后，咱们可以看到目前只有22端口和3389端口支持远程访问，咱们还需要额外开通80端口（微信公众号用），3306端口(mysql)以及6379端口(redis)
图片描述
配置一个支持远程登录的帐号，这里配置一个rottokaka帐号，创建work帐号并授权，同时设置密码
mysql -u root -p
use mysql;
GRANT SELECT,UPDATE,INSERT,DELETE on *.* to 'rotto'@'%' IDENTIFIED BY 'Rotto0916!';
flush privileges;//生效配置
之后便能在我们本地通过调用mysql指令远程登录阿里云服务器上的mysql server中，
mysql -urotto -P3306 -h47.104.1.235 –p //本机远程登录mysql指令

## 字符集设置




mysql-5.7.21

ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

# 创建数据库

CREATE DATABASE internet_user;
CREATE DATABASE internet_book;

# 删除数据库


# 1. 创建用户
# CREATE USER 'username'@'host' IDENTIFIED BY 'password';

CREATE USER 'internet_user'@'localhost' IDENTIFIED BY 'user';
CREATE USER 'internet_book'@'localhost' IDENTIFIED BY 'book';

# 2. 权限授权
# GRANT PRIVILEGES ON databasename.tablename TO 'username'@'host'

GRANT ALL ON internet_user.* TO 'internet_user'@'localhost';
GRANT ALL ON internet_book.* TO 'internet_book'@'localhost';
# 3. 权限撤销
# REVOKE privilege ON databasename.tablename FROM 'username'@'host';
# 4. 密码更新
# SET PASSWORD FOR 'username'@'host' = PASSWORD('newpassword');
# 5. 删除用户
# DROP USER 'username'@'host';

# 刷新权限
# FLUSH PRIVILEGES;