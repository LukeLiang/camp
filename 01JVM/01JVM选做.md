# 业务系统的JVM信息详情

是在本地RUN的一个小demo。

![image-20210626210641643](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210626210641643.png)

![image-20210626212102845](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210626212102845.png)

使用4个线程运行GC，GC使用的是并行GC



堆配置情况：

空闲堆空间的最小百分比：0  (如果HeapFreeRatio < MinHeapFreeRtio,就需要扩容)

空闲堆空间的最大百分比：100 (如果HeapFreeRatio > MaxHeapFreeRatio, 就需要缩容)

最大堆内存：4074.0M

新生代堆空间的大小：85M

新生代堆空间的最大值：1358M

老年代堆空间的最大值：171M

新生代和老年代的占比比值：新生代：老年代 = 1:2

新生代中Eden区：From区：To区 = 8:1:1

元空间大小：20M

JVM元空间的默认值：1024M

最大元空间大小

G1region区大小：0 (因为没有使用G1 GC)



堆使用情况：

​	年轻代：

​	Eden区

​		容量：

​		已使用：

​		剩余：

​		已经使用Eden区的百分比

From区：

​		容量：

​		已使用：

​		剩余：

​		已经使用From区的百分比

To区：

​		容量：

​		已使用：

​		剩余：

​		已经使用To区的百分比



思考：需要改进的地方：

1.本机是12G内存的，如果该服务器只部署这一个项目的话，考虑到预留一些内存给其他进程使用。

可以考虑将整个堆内从可以设置为本机内存的60%；

2.改用CSM或G1收集器，已减少停顿时间。

3.提高MinHeapFreeSize的值和降低MaxHeapFreeSize的值。可控制在20% ~ 80%之间。





# G1 GC JVM情况分析

## 参数启动命令

java -Xmx1g -Xms -XX:-UseAdaptiveSizePolicy -XX:UseG1GC -XX:MaxGCPauseMillis=200 -jar demo-0.0.1-SNAPSHOT.jar

## 参数

![image-20210626214051496](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210626214051496.png

![image-20210626214657913](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210626214657913.png)

![image-20210626214725589](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210626214725589.png)

参数和业务系统JVM类似，只是部分参数使用情况不同。

不同：

在YGC的Eden，From, To和OGC的区域中，会使用region块大小来标注空间使用情况。