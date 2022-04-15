k8s
特点：
1、轻量级：消耗资源小
2、开源
3、弹性伸缩
4、负载均衡：IPVS

学习：
介绍说明：前世今生 k8s框架 k8s关键字含义
基础概念： 什么是Pod  控制器类型  K8s网络通讯模式
K8s：构建k8s集群
资源清单：什么是资源  掌握资源清单的语法  编写Pod  掌握Pod的生命周期（重要）
Pod控制器：掌握各种控制器的特点以及使用定义方式
Service服务发现：掌握  SVC  原理及其构建方式
存储：掌握多种存储类型的特点 并且能够在不同环境中选择合适的存储的方案（有自己的见解）
调度器：掌握调度器原理 能够根据要求把Pod定义到想要的节点运行
集群安全机制：集群的认证  鉴权  访问控制原理及其流程
HELM：Linux yum   掌握HELM原理   HELM模版自定义  HELM部署一些常用插件
运维：修改Kubeadm达到证书可用期限为10年 能够构建高可用的k8s集群


服务分类
    有状态服务：DBMS  
    无状态服务：LVS APACHE 

高可用集群副本数最好是>=3奇数个

API SERVICE：所有服务访问的统一入口
ControllerMananger控制器：维持副本期望数目
Scheduler：负责接受任务，选择合适的节点进行分配任务
etcd：键值对数据库，存储k8s集群所有重要信息（持久化）
Kubelet：直接跟容器引擎交互，实现容器的生命周期管理
Kube-proxy：负责写入规则至 IPTABLES、IPVS实现服务映射
COREDNS：可以为集群中的SVC创建一个域名IP的对应关系解析
DASHBOARD：给k8s集群提供一个B/S结构访问体系
INGRESS CONTROLLER：官方只能实现四层代理，INGRESS可以实现七层代理
FEDERATION：提供一个可以跨集群中心多k8s统一管理功能
PROMETHEUS：提供k8s集群的监控能力
ELK：提供K8s集群日志统一分析介入平台

