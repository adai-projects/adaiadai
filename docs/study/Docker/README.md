Docker
================================================================================
> Docker

## Feature

- 与运行环境无关：真正做到一次构建，到处运行

## Install


```
  $ curl -fsSL https://get.docker.com -o get-docker.sh
  $ sudo sh get-docker.sh --Mirror Aliyun
```

### 加速器

```
 $ vim /etc/docker/daemon.json

```
2. Aliyun 加速器
```
{
  "registry-mirrors": ["https://51qe9zsq.mirror.aliyuncs.com"]
}

```


### Compose

```
  $ curl -L https://github.com/docker/compose/releases/download/1.25.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
  $ chmod +x /usr/local/bin/docker-compose
```

```
https://github.com/docker/compose
```

2. Useage

### CentOS

  https://docs.docker.com/install/linux/docker-ce/centos/

## 加速器

  https://www.cnblogs.com/stulzq/p/8628019.html

### 镜像

#### 列出镜像

```
  docker image ls
```


## Compose



## 命令

1. 交互的方式启动容器
```
  $ docker run -it tomcat bash
```
2. 交互的方式进入容器
```
  $ docker exec -it dockerId bash
```

## DockerFile

1. FROM

2. RUN

### 构建镜像

```
  $ docker build -t myTomcat .
```


## 补充

1. echo > >>

2. 虚玄镜像

## 数据卷
