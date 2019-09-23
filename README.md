### ik分词器连接mysql进行词库热更新

对6.7版本的ik分词器进行的修改

Dictionary类中增加定时任务 从mysql中加载词

```java
if (Boolean.valueOf(singleton.jdbcProps.getProperty(ENABLE_DICT))) {
    // 加载MySQL自定义词库
    if (Boolean.valueOf(singleton.jdbcProps.getProperty(ENABLE_EXT_DICT))){
        pool.scheduleAtFixedRate(() -> singleton.loadMysqlExtDict(), 10, 60, TimeUnit.SECONDS);
    }
    // 加载MySQL停用词
    if (Boolean.valueOf(singleton.jdbcProps.getProperty(ENABLE_STOPWORDS_DICT))){
        pool.scheduleAtFixedRate(() -> singleton.loadMysqlStopWordDict(), 10, 60, TimeUnit.SECONDS);
    }
}
```
相关配置在jdbc.properties中

打包后确认一下是否有 mysql-connector-java 和 druid jar

### 可能遇到的问题
因为jdk安全策略 启动elasticsearch时可能会报一些无权限的错误 需要修改一下java.policy中的配置 
jdk/jre/lib/security/java.policy
添加
```
    permission java.util.PropertyPermission "*", "read,write";
    permission java.lang.RuntimePermission "getClassLoader";
    permission javax.management.MBeanServerPermission "createMBeanServer";
    permission java.lang.RuntimePermission "setContextClassLoader";
    permission javax.management.MBeanTrustPermission "register";
    permission java.net.SocketPermission "*", "connect,resolve";
    permission javax.management.MBeanPermission "*", "registerMBean";
```
