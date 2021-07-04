# GC日志总结

 ## 使用不同GC，打印的GC日志

### JDK8 默认GC - Parallel GC

命令：`java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g GCLogAnalysis`

```
2021-07-04T09:01:26.290+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43517K(305664K)] 262144K->87335K(1005056K), 0.0227293 secs] [Times: user=0.06 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:26.368+0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43498K(305664K)] 349479K->159410K(1005056K), 0.0285152 secs] [Times: user=0.05 sys=0.08, real=0.03 secs] 
2021-07-04T09:01:26.446+0800: [GC (Allocation Failure) [PSYoungGen: 304857K->43503K(305664K)] 420768K->226980K(1005056K), 0.0279884 secs] [Times: user=0.02 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:26.509+0800: [GC (Allocation Failure) [PSYoungGen: 305647K->43509K(305664K)] 489124K->300038K(1005056K), 0.0227299 secs] [Times: user=0.06 sys=0.06, real=0.03 secs] 
2021-07-04T09:01:26.571+0800: [GC (Allocation Failure) [PSYoungGen: 305529K->43517K(305664K)] 562058K->369783K(1005056K), 0.0292553 secs] [Times: user=0.06 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:26.665+0800: [GC (Allocation Failure) [PSYoungGen: 305283K->43507K(160256K)] 631548K->438840K(859648K), 0.0293358 secs] [Times: user=0.05 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:26.712+0800: [GC (Allocation Failure) [PSYoungGen: 160243K->66505K(232960K)] 555576K->471680K(932352K), 0.0209067 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
2021-07-04T09:01:26.759+0800: [GC (Allocation Failure) [PSYoungGen: 182982K->88785K(232960K)] 588157K->503652K(932352K), 0.0212062 secs] [Times: user=0.05 sys=0.00, real=0.03 secs] 
2021-07-04T09:01:26.806+0800: [GC (Allocation Failure) [PSYoungGen: 205521K->104496K(232960K)] 620388K->533169K(932352K), 0.0267196 secs] [Times: user=0.06 sys=0.02, real=0.03 secs] 
2021-07-04T09:01:26.853+0800: [GC (Allocation Failure) [PSYoungGen: 221232K->72291K(232960K)] 649905K->557376K(932352K), 0.0241458 secs] [Times: user=0.05 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:26.899+0800: [GC (Allocation Failure) [PSYoungGen: 189018K->31015K(232960K)] 674103K->580568K(932352K), 0.0194180 secs] [Times: user=0.05 sys=0.02, real=0.02 secs] 
2021-07-04T09:01:26.946+0800: [GC (Allocation Failure) [PSYoungGen: 147457K->39378K(232960K)] 697010K->615216K(932352K), 0.0121178 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 
2021-07-04T09:01:26.978+0800: [GC (Allocation Failure) [PSYoungGen: 155847K->37305K(232960K)] 731686K->648102K(932352K), 0.0290763 secs] [Times: user=0.02 sys=0.05, real=0.03 secs] 
2021-07-04T09:01:27.009+0800: [Full GC (Ergonomics) [PSYoungGen: 37305K->0K(232960K)] [ParOldGen: 610796K->324468K(699392K)] 648102K->324468K(932352K), [Metaspace: 3883K->3883K(1056768K)], 0.0616364 secs] [Times: user=0.09 sys=0.02, real=0.06 secs] 
2021-07-04T09:01:27.087+0800: [GC (Allocation Failure) [PSYoungGen: 116736K->38360K(232960K)] 441204K->362828K(932352K), 0.0056819 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
执行结束!共生成对象次数:9720
Heap
 PSYoungGen      total 232960K, used 131800K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 116736K, 80% used [0x00000000eab00000,0x00000000f0640370,0x00000000f1d00000)
  from space 116224K, 33% used [0x00000000f8e80000,0x00000000fb3f6000,0x0000000100000000)
  to   space 116224K, 0% used [0x00000000f1d00000,0x00000000f1d00000,0x00000000f8e80000)
 ParOldGen       total 699392K, used 324468K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 46% used [0x00000000c0000000,0x00000000d3cdd328,0x00000000eab00000)
 Metaspace       used 3890K, capacity 4572K, committed 4864K, reserved 1056768K
  class space    used 429K, capacity 460K, committed 512K, reserved 1048576K

Process finished with exit code 0

```

不分配堆内存大小，使用默认参数。

命令：`java -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis`

```
2021-07-04T08:56:24.386+0800: [GC (Allocation Failure) [PSYoungGen: 49152K->8185K(57344K)] 49152K->16465K(188416K), 0.0078239 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-07-04T08:56:24.414+0800: [GC (Allocation Failure) [PSYoungGen: 57055K->8188K(106496K)] 65335K->38529K(237568K), 0.0084989 secs] [Times: user=0.00 sys=0.06, real=0.01 secs] 
2021-07-04T08:56:24.466+0800: [GC (Allocation Failure) [PSYoungGen: 106492K->8191K(106496K)] 136833K->70675K(237568K), 0.0166045 secs] [Times: user=0.02 sys=0.02, real=0.02 secs] 
2021-07-04T08:56:24.502+0800: [GC (Allocation Failure) [PSYoungGen: 106213K->8179K(204800K)] 168697K->99835K(335872K), 0.0101087 secs] [Times: user=0.03 sys=0.03, real=0.01 secs] 
2021-07-04T08:56:24.512+0800: [Full GC (Ergonomics) [PSYoungGen: 8179K->0K(204800K)] [ParOldGen: 91656K->90763K(189952K)] 99835K->90763K(394752K), [Metaspace: 3363K->3363K(1056768K)], 0.0195202 secs] [Times: user=0.03 sys=0.00, real=0.02 secs] 
2021-07-04T08:56:24.622+0800: [GC (Allocation Failure) [PSYoungGen: 196608K->8182K(204800K)] 287371K->147629K(394752K), 0.0224525 secs] [Times: user=0.00 sys=0.05, real=0.02 secs] 
2021-07-04T08:56:24.645+0800: [Full GC (Ergonomics) [PSYoungGen: 8182K->0K(204800K)] [ParOldGen: 139446K->131508K(267776K)] 147629K->131508K(472576K), [Metaspace: 3363K->3363K(1056768K)], 0.0345090 secs] [Times: user=0.02 sys=0.00, real=0.04 secs] 
2021-07-04T08:56:24.711+0800: [GC (Allocation Failure) [PSYoungGen: 196608K->63358K(377344K)] 328116K->196285K(645120K), 0.0158514 secs] [Times: user=0.01 sys=0.05, real=0.02 secs] 
2021-07-04T08:56:24.866+0800: [GC (Allocation Failure) [PSYoungGen: 377214K->74751K(408576K)] 510141K->282255K(676352K), 0.0356658 secs] [Times: user=0.05 sys=0.08, real=0.04 secs] 
2021-07-04T08:56:24.902+0800: [Full GC (Ergonomics) [PSYoungGen: 74751K->0K(408576K)] [ParOldGen: 207504K->234046K(412672K)] 282255K->234046K(821248K), [Metaspace: 3363K->3363K(1056768K)], 0.0333511 secs] [Times: user=0.13 sys=0.00, real=0.03 secs] 
2021-07-04T08:56:24.998+0800: [GC (Allocation Failure) [PSYoungGen: 333824K->100181K(613888K)] 567870K->334228K(1026560K), 0.0304910 secs] [Times: user=0.02 sys=0.08, real=0.03 secs] 
2021-07-04T08:56:25.136+0800: [GC (Allocation Failure) [PSYoungGen: 589653K->135664K(625152K)] 823700K->443156K(1037824K), 0.0679234 secs] [Times: user=0.06 sys=0.14, real=0.07 secs] 
2021-07-04T08:56:25.281+0800: [GC (Allocation Failure) [PSYoungGen: 625136K->186869K(757248K)] 932628K->541119K(1169920K), 0.1115871 secs] [Times: user=0.09 sys=0.08, real=0.11 secs] 
2021-07-04T08:56:25.393+0800: [Full GC (Ergonomics) [PSYoungGen: 186869K->0K(757248K)] [ParOldGen: 354250K->337953K(544256K)] 541119K->337953K(1301504K), [Metaspace: 3886K->3886K(1056768K)], 0.0869404 secs] [Times: user=0.13 sys=0.02, real=0.09 secs] 
执行结束!共生成对象次数:8771
```

堆分配：

```
Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 3189768192 (3042.0MB)
   NewSize                  = 67108864 (64.0MB)
   MaxNewSize               = 1063256064 (1014.0MB)
   OldSize                  = 134217728 (128.0MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)

Heap Usage:
PS Young Generation
Eden Space:
   capacity = 584056832 (557.0MB)
   used     = 11864840 (11.315193176269531MB)
   free     = 572191992 (545.6848068237305MB)
   2.0314529939442605% used
From Space:
   capacity = 191365120 (182.5MB)
   used     = 0 (0.0MB)
   free     = 191365120 (182.5MB)
   0.0% used
To Space:
   capacity = 239599616 (228.5MB)
   used     = 0 (0.0MB)
   free     = 239599616 (228.5MB)
   0.0% used
PS Old Generation
   capacity = 557318144 (531.5MB)
   used     = 346064104 (330.0324478149414MB)
   free     = 211254040 (201.4675521850586MB)
   62.09453392567101% used

```

**发现的一些问题**：

1.在指定堆内存大小和不指定堆内存大小的情况小，两种情况都执行了14次GC。但是在我们使用计算机默认分配的堆内存时(3042.0MB ~ ~ 3G)，竟然发生了4次 Full GC，而指定的1G堆内存只发生了1次 Full GC。

然后：查看未指定堆内存大小的堆信息(上图)和指定堆内存大小的堆信息(下图)。

PS Old Generation 的大小

```
PS Old Generation
   capacity = 716177408 (683.0MB)
   used     = 340392608 (324.6236877441406MB)
   free     = 375784800 (358.3763122558594MB)
   47.52909044570141% used
```

capacity比上图的OLD区多了150M。

**分析原因**：虽然在我们没有指定堆内存大小的情况下，系统默认会给我们分配大约3G的堆内存，但是，并不是在JVM一启动就达到最大值。可以理解为这是一个扩容的机制，当我们的Eden区或者old区在承受不下这么多的对象时就会发生扩容，每次扩容一小部分，对象到来内存不够就继续扩容，一直扩容到相应的最大值。

指定参数情况下的第一次GC日输出：

堆的大小为：1005056K

```
2021-07-04T09:01:26.290+0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43517K(305664K)] 262144K->87335K(1005056K), 0.0227293 secs] [Times: user=0.06 sys=0.05, real=0.03 secs] 
```

未指定参数情况下的第一次GC日志输出：

堆的大小为：188416K

```
2021-07-04T08:56:24.386+0800: [GC (Allocation Failure) [PSYoungGen: 49152K->8185K(57344K)] 49152K->16465K(188416K), 0.0078239 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
```



接下来，我们来看一下继续将堆内存大小设置为更小，设置为512M。

**猜想：会进行更多的Full GC 或者 GC次数增加。**

```
2021-07-04T09:53:27.343+0800: [GC (Allocation Failure) [PSYoungGen: 131547K->21493K(153088K)] 131547K->44681K(502784K), 0.0113233 secs] [Times: user=0.00 sys=0.06, real=0.01 secs] 
2021-07-04T09:53:27.383+0800: [GC (Allocation Failure) [PSYoungGen: 153077K->21499K(153088K)] 176265K->87692K(502784K), 0.0172367 secs] [Times: user=0.00 sys=0.05, real=0.02 secs] 
2021-07-04T09:53:27.424+0800: [GC (Allocation Failure) [PSYoungGen: 153083K->21495K(153088K)] 219276K->127724K(502784K), 0.0188509 secs] [Times: user=0.02 sys=0.03, real=0.02 secs] 
2021-07-04T09:53:27.464+0800: [GC (Allocation Failure) [PSYoungGen: 153079K->21498K(153088K)] 259308K->162795K(502784K), 0.0247422 secs] [Times: user=0.00 sys=0.02, real=0.02 secs] 
2021-07-04T09:53:27.521+0800: [GC (Allocation Failure) [PSYoungGen: 152987K->21488K(153088K)] 294284K->197711K(502784K), 0.0135218 secs] [Times: user=0.00 sys=0.03, real=0.01 secs] 
2021-07-04T09:53:27.556+0800: [GC (Allocation Failure) [PSYoungGen: 153072K->21493K(80384K)] 329295K->237334K(430080K), 0.0126406 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.579+0800: [GC (Allocation Failure) [PSYoungGen: 79892K->34337K(116736K)] 295733K->255245K(466432K), 0.0061449 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.594+0800: [GC (Allocation Failure) [PSYoungGen: 93075K->44866K(116736K)] 313983K->273814K(466432K), 0.0084103 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.612+0800: [GC (Allocation Failure) [PSYoungGen: 103641K->55436K(116736K)] 332590K->289613K(466432K), 0.0084338 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.632+0800: [GC (Allocation Failure) [PSYoungGen: 113990K->41401K(116736K)] 348168K->308661K(466432K), 0.0146905 secs] [Times: user=0.01 sys=0.02, real=0.01 secs] 
2021-07-04T09:53:27.655+0800: [GC (Allocation Failure) [PSYoungGen: 99724K->19688K(116736K)] 366984K->323934K(466432K), 0.0121242 secs] [Times: user=0.03 sys=0.02, real=0.01 secs] 
2021-07-04T09:53:27.667+0800: [Full GC (Ergonomics) [PSYoungGen: 19688K->0K(116736K)] [ParOldGen: 304245K->236564K(349696K)] 323934K->236564K(466432K), [Metaspace: 3363K->3363K(1056768K)], 0.0380629 secs] [Times: user=0.11 sys=0.00, real=0.04 secs] 
2021-07-04T09:53:27.714+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->17593K(116736K)] 295444K->254157K(466432K), 0.0028004 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T09:53:27.726+0800: [GC (Allocation Failure) [PSYoungGen: 76473K->18452K(116736K)] 313037K->270818K(466432K), 0.0053517 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.742+0800: [GC (Allocation Failure) [PSYoungGen: 77332K->20056K(116736K)] 329698K->289903K(466432K), 0.0054262 secs] [Times: user=0.06 sys=0.00, real=0.00 secs] 
2021-07-04T09:53:27.757+0800: [GC (Allocation Failure) [PSYoungGen: 78936K->17676K(116736K)] 348783K->306444K(466432K), 0.0055493 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.771+0800: [GC (Allocation Failure) [PSYoungGen: 76556K->23806K(116736K)] 365324K->329417K(466432K), 0.0063759 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.778+0800: [Full GC (Ergonomics) [PSYoungGen: 23806K->0K(116736K)] [ParOldGen: 305611K->267678K(349696K)] 329417K->267678K(466432K), [Metaspace: 3363K->3363K(1056768K)], 0.0380726 secs] [Times: user=0.09 sys=0.00, real=0.04 secs] 
2021-07-04T09:53:27.826+0800: [GC (Allocation Failure) [PSYoungGen: 58689K->19513K(116736K)] 326367K->287192K(466432K), 0.0044295 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T09:53:27.841+0800: [GC (Allocation Failure) [PSYoungGen: 78081K->23034K(116736K)] 345760K->309437K(466432K), 0.0091931 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.861+0800: [GC (Allocation Failure) [PSYoungGen: 81171K->19842K(116736K)] 367574K->328397K(466432K), 0.0090294 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.882+0800: [GC (Allocation Failure) [PSYoungGen: 78693K->20424K(116736K)] 387248K->347012K(466432K), 0.0091795 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.892+0800: [Full GC (Ergonomics) [PSYoungGen: 20424K->0K(116736K)] [ParOldGen: 326588K->299212K(349696K)] 347012K->299212K(466432K), [Metaspace: 3363K->3363K(1056768K)], 0.0488438 secs] [Times: user=0.09 sys=0.00, real=0.05 secs] 
2021-07-04T09:53:27.951+0800: [GC (Allocation Failure) [PSYoungGen: 58326K->20835K(116736K)] 357539K->320056K(466432K), 0.0032111 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T09:53:27.967+0800: [GC (Allocation Failure) [PSYoungGen: 79715K->21792K(116736K)] 378936K->339965K(466432K), 0.0062199 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:27.973+0800: [Full GC (Ergonomics) [PSYoungGen: 21792K->0K(116736K)] [ParOldGen: 318172K->309011K(349696K)] 339965K->309011K(466432K), [Metaspace: 3783K->3783K(1056768K)], 0.0433450 secs] [Times: user=0.16 sys=0.00, real=0.04 secs] 
2021-07-04T09:53:28.027+0800: [GC (Allocation Failure) [PSYoungGen: 58839K->23961K(116736K)] 367850K->332973K(466432K), 0.0036893 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T09:53:28.039+0800: [GC (Allocation Failure) [PSYoungGen: 82776K->21299K(116736K)] 391788K->351786K(466432K), 0.0075192 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-07-04T09:53:28.047+0800: [Full GC (Ergonomics) [PSYoungGen: 21299K->0K(116736K)] [ParOldGen: 330487K->319091K(349696K)] 351786K->319091K(466432K), [Metaspace: 3884K->3884K(1056768K)], 0.0515444 secs] [Times: user=0.13 sys=0.00, real=0.05 secs] 
2021-07-04T09:53:28.107+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 319091K->323640K(349696K)] 377971K->323640K(466432K), [Metaspace: 3884K->3884K(1056768K)], 0.0532151 secs] [Times: user=0.16 sys=0.00, real=0.05 secs] 
2021-07-04T09:53:28.170+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 323640K->328242K(349696K)] 382520K->328242K(466432K), [Metaspace: 3884K->3884K(1056768K)], 0.0478509 secs] [Times: user=0.16 sys=0.00, real=0.05 secs] 
执行结束!共生成对象次数:7455
```

如上图，验证猜想。

其他GC 情况相似，就不在一一列举。



### 相同堆内存大小下，不同GC策略对比

1.串行化GC

```
2021-07-04T10:14:43.216+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.216+0800: [DefNew: 279616K->34943K(314560K), 0.0578419 secs] 279616K->90719K(1013632K), 0.0579203 secs] [Times: user=0.02 sys=0.03, real=0.06 secs] 
2021-07-04T10:14:43.324+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.324+0800: [DefNew: 314559K->34944K(314560K), 0.0719105 secs] 370335K->172472K(1013632K), 0.0719539 secs] [Times: user=0.01 sys=0.05, real=0.07 secs] 
2021-07-04T10:14:43.440+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.440+0800: [DefNew: 314560K->34943K(314560K), 0.0512306 secs] 452088K->253903K(1013632K), 0.0512745 secs] [Times: user=0.00 sys=0.05, real=0.05 secs] 
2021-07-04T10:14:43.537+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.537+0800: [DefNew: 314559K->34944K(314560K), 0.0434840 secs] 533519K->327672K(1013632K), 0.0435260 secs] [Times: user=0.02 sys=0.03, real=0.04 secs] 
2021-07-04T10:14:43.628+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.628+0800: [DefNew: 314560K->34943K(314560K), 0.0510743 secs] 607288K->407834K(1013632K), 0.0511232 secs] [Times: user=0.02 sys=0.03, real=0.05 secs] 
2021-07-04T10:14:43.725+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.725+0800: [DefNew: 314559K->34944K(314560K), 0.0479410 secs] 687450K->480436K(1013632K), 0.0479915 secs] [Times: user=0.02 sys=0.03, real=0.05 secs] 
2021-07-04T10:14:43.811+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.811+0800: [DefNew: 314560K->34943K(314560K), 0.0486409 secs] 760052K->561298K(1013632K), 0.0486874 secs] [Times: user=0.02 sys=0.03, real=0.05 secs] 
2021-07-04T10:14:43.900+0800: [GC (Allocation Failure) 2021-07-04T10:14:43.900+0800: [DefNew: 314559K->34944K(314560K), 0.0465624 secs] 840914K->634673K(1013632K), 0.0466116 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
执行结束!共生成对象次数:9559
Heap
 def new generation   total 314560K, used 314285K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  99% used [0x00000000c0000000, 0x00000000d10cb788, 0x00000000d1110000)
  from space 34944K, 100% used [0x00000000d1110000, 0x00000000d3330000, 0x00000000d3330000)
  to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
 tenured generation   total 699072K, used 599729K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  85% used [0x00000000d5550000, 0x00000000f9efc688, 0x00000000f9efc800, 0x0000000100000000)
 Metaspace       used 3892K, capacity 4572K, committed 4864K, reserved 1056768K
  class space    used 429K, capacity 460K, committed 512K, reserved 1048576K

Process finished with exit code 0

```



2.并行化GC

```
2021-07-04T10:15:41.528+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.528+0800: [ParNew: 279616K->34944K(314560K), 0.0228862 secs] 279616K->84020K(1013632K), 0.0229498 secs] [Times: user=0.03 sys=0.03, real=0.02 secs] 
2021-07-04T10:15:41.620+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.620+0800: [ParNew: 314560K->34944K(314560K), 0.0276502 secs] 363636K->161706K(1013632K), 0.0277314 secs] [Times: user=0.02 sys=0.05, real=0.03 secs] 
2021-07-04T10:15:41.695+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.695+0800: [ParNew: 314560K->34944K(314560K), 0.0518044 secs] 441322K->246910K(1013632K), 0.0518510 secs] [Times: user=0.14 sys=0.06, real=0.05 secs] 
2021-07-04T10:15:41.798+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.798+0800: [ParNew: 314560K->34944K(314560K), 0.0504430 secs] 526526K->329679K(1013632K), 0.0504877 secs] [Times: user=0.09 sys=0.03, real=0.05 secs] 
2021-07-04T10:15:41.895+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.895+0800: [ParNew: 314560K->34944K(314560K), 0.0456687 secs] 609295K->407111K(1013632K), 0.0457141 secs] [Times: user=0.09 sys=0.05, real=0.05 secs] 
2021-07-04T10:15:41.998+0800: [GC (Allocation Failure) 2021-07-04T10:15:41.998+0800: [ParNew: 314560K->34944K(314560K), 0.0429411 secs] 686727K->478557K(1013632K), 0.0429871 secs] [Times: user=0.05 sys=0.05, real=0.04 secs] 
2021-07-04T10:15:42.089+0800: [GC (Allocation Failure) 2021-07-04T10:15:42.089+0800: [ParNew: 314560K->34944K(314560K), 0.0484411 secs] 758173K->557769K(1013632K), 0.0484902 secs] [Times: user=0.09 sys=0.05, real=0.05 secs] 
2021-07-04T10:15:42.167+0800: [GC (Allocation Failure) 2021-07-04T10:15:42.167+0800: [ParNew: 314560K->34944K(314560K), 0.0495610 secs] 837385K->646936K(1013632K), 0.0496081 secs] [Times: user=0.11 sys=0.03, real=0.05 secs] 
2021-07-04T10:15:42.261+0800: [GC (Allocation Failure) 2021-07-04T10:15:42.261+0800: [ParNew: 314560K->314560K(314560K), 0.0000266 secs]2021-07-04T10:15:42.261+0800: [Tenured: 611992K->369696K(699072K), 0.0541153 secs] 926552K->369696K(1013632K), [Metaspace: 3886K->3886K(1056768K)], 0.0542249 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 
执行结束!共生成对象次数:9585
Heap
 par new generation   total 314560K, used 77477K [0x00000000c0000000, 0x00000000d5550000, 0x00000000d5550000)
  eden space 279616K,  27% used [0x00000000c0000000, 0x00000000c4ba9410, 0x00000000d1110000)
  from space 34944K,   0% used [0x00000000d1110000, 0x00000000d1110000, 0x00000000d3330000)
  to   space 34944K,   0% used [0x00000000d3330000, 0x00000000d3330000, 0x00000000d5550000)
 tenured generation   total 699072K, used 369696K [0x00000000d5550000, 0x0000000100000000, 0x0000000100000000)
   the space 699072K,  52% used [0x00000000d5550000, 0x00000000ebe580b8, 0x00000000ebe58200, 0x0000000100000000)
 Metaspace       used 3893K, capacity 4572K, committed 4864K, reserved 1056768K
  class space    used 429K, capacity 460K, committed 512K, reserved 1048576K

Process finished with exit code 0

```



3. CMS GC

```
2021-07-04T10:16:38.099+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.099+0800: [ParNew: 272640K->34048K(306688K), 0.0258434 secs] 272640K->76101K(1014528K), 0.0259208 secs] [Times: user=0.00 sys=0.08, real=0.03 secs] 
2021-07-04T10:16:38.202+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.202+0800: [ParNew: 306688K->34048K(306688K), 0.0391288 secs] 348741K->155299K(1014528K), 0.0391884 secs] [Times: user=0.01 sys=0.08, real=0.04 secs] 
2021-07-04T10:16:38.332+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.332+0800: [ParNew: 306688K->34048K(306688K), 0.0511744 secs] 427939K->234354K(1014528K), 0.0512275 secs] [Times: user=0.09 sys=0.03, real=0.05 secs] 
2021-07-04T10:16:38.444+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.444+0800: [ParNew: 306688K->34048K(306688K), 0.0488126 secs] 506994K->312067K(1014528K), 0.0488649 secs] [Times: user=0.09 sys=0.03, real=0.05 secs] 
2021-07-04T10:16:38.567+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.567+0800: [ParNew: 306688K->34048K(306688K), 0.0453527 secs] 584707K->382195K(1014528K), 0.0454317 secs] [Times: user=0.08 sys=0.02, real=0.04 secs] 
2021-07-04T10:16:38.693+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.693+0800: [ParNew: 306688K->34048K(306688K), 0.0562610 secs] 654835K->464713K(1014528K), 0.0563146 secs] [Times: user=0.11 sys=0.06, real=0.06 secs] 
2021-07-04T10:16:38.749+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 430665K(707840K)] 464970K(1014528K), 0.0003829 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T10:16:38.750+0800: [CMS-concurrent-mark-start]
2021-07-04T10:16:38.761+0800: [CMS-concurrent-mark: 0.011/0.011 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2021-07-04T10:16:38.761+0800: [CMS-concurrent-preclean-start]
2021-07-04T10:16:38.762+0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T10:16:38.762+0800: [CMS-concurrent-abortable-preclean-start]
2021-07-04T10:16:38.814+0800: [GC (Allocation Failure) 2021-07-04T10:16:38.814+0800: [ParNew2021-07-04T10:16:38.867+0800: [CMS-concurrent-abortable-preclean: 0.004/0.105 secs] [Times: user=0.16 sys=0.01, real=0.11 secs] 
: 306688K->34048K(306688K), 0.0554868 secs] 737353K->550350K(1014528K), 0.0555403 secs] [Times: user=0.17 sys=0.01, real=0.06 secs] 
2021-07-04T10:16:38.870+0800: [GC (CMS Final Remark) [YG occupancy: 34222 K (306688 K)]2021-07-04T10:16:38.870+0800: [Rescan (parallel) , 0.0011999 secs]2021-07-04T10:16:38.871+0800: [weak refs processing, 0.0000284 secs]2021-07-04T10:16:38.871+0800: [class unloading, 0.0004318 secs]2021-07-04T10:16:38.872+0800: [scrub symbol table, 0.0007178 secs]2021-07-04T10:16:38.873+0800: [scrub string table, 0.0002101 secs][1 CMS-remark: 516302K(707840K)] 550524K(1014528K), 0.0027297 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
执行结束!共生成对象次数:71122021-07-04T10:16:38.873+0800: [CMS-concurrent-sweep-start]
2021-07-04T10:16:38.874+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-07-04T10:16:38.875+0800: [CMS-concurrent-reset-start]
2021-07-04T10:16:38.875+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

Heap
 par new generation   total 306688K, used 47750K [0x00000000c0000000, 0x00000000d4cc0000, 0x00000000d4cc0000)
  eden space 272640K,   5% used [0x00000000c0000000, 0x00000000c0d618b8, 0x00000000d0a40000)
  from space 34048K, 100% used [0x00000000d2b80000, 0x00000000d4cc0000, 0x00000000d4cc0000)
  to   space 34048K,   0% used [0x00000000d0a40000, 0x00000000d0a40000, 0x00000000d2b80000)
 concurrent mark-sweep generation total 707840K, used 351874K [0x00000000d4cc0000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 3890K, capacity 4572K, committed 4864K, reserved 1056768K
  class space    used 429K, capacity 460K, committed 512K, reserved 1048576K

Process finished with exit code 0

```



4. G1GC

```
2021-07-04T10:17:07.384+0800: [GC pause (G1 Evacuation Pause) (young) 58M->22M(1024M), 0.0067718 secs]
2021-07-04T10:17:07.413+0800: [GC pause (G1 Evacuation Pause) (young) 75M->40M(1024M), 0.0055351 secs]
2021-07-04T10:17:07.438+0800: [GC pause (G1 Evacuation Pause) (young) 95M->60M(1024M), 0.0051103 secs]
2021-07-04T10:17:07.455+0800: [GC pause (G1 Evacuation Pause) (young) 114M->80M(1024M), 0.0043597 secs]
2021-07-04T10:17:07.475+0800: [GC pause (G1 Evacuation Pause) (young) 145M->100M(1024M), 0.0077996 secs]
2021-07-04T10:17:07.515+0800: [GC pause (G1 Evacuation Pause) (young) 197M->136M(1024M), 0.0073691 secs]
2021-07-04T10:17:07.749+0800: [GC pause (G1 Evacuation Pause) (young) 492M->238M(1024M), 0.0204013 secs]
2021-07-04T10:17:07.784+0800: [GC pause (G1 Evacuation Pause) (young) 310M->259M(1024M), 0.0077881 secs]
2021-07-04T10:17:07.825+0800: [GC pause (G1 Evacuation Pause) (young) 412M->302M(1024M), 0.0090132 secs]
2021-07-04T10:17:07.879+0800: [GC pause (G1 Evacuation Pause) (young) 501M->363M(1024M), 0.0117296 secs]
2021-07-04T10:17:07.931+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 583M->419M(1024M), 0.0124746 secs]
2021-07-04T10:17:07.943+0800: [GC concurrent-root-region-scan-start]
2021-07-04T10:17:07.943+0800: [GC concurrent-root-region-scan-end, 0.0001924 secs]
2021-07-04T10:17:07.943+0800: [GC concurrent-mark-start]
2021-07-04T10:17:07.950+0800: [GC concurrent-mark-end, 0.0070935 secs]
2021-07-04T10:17:07.950+0800: [GC remark, 0.0016198 secs]
2021-07-04T10:17:07.952+0800: [GC cleanup 460M->448M(1024M), 0.0006171 secs]
2021-07-04T10:17:07.953+0800: [GC concurrent-cleanup-start]
2021-07-04T10:17:07.953+0800: [GC concurrent-cleanup-end, 0.0000244 secs]
2021-07-04T10:17:08.018+0800: [GC pause (G1 Evacuation Pause) (young) 732M->476M(1024M), 0.0166417 secs]
2021-07-04T10:17:08.035+0800: [GC pause (G1 Evacuation Pause) (mixed) 496M->410M(1024M), 0.0080062 secs]
2021-07-04T10:17:08.035+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 420M->412M(1024M), 0.0016259 secs]
2021-07-04T10:17:08.035+0800: [GC concurrent-root-region-scan-start]
2021-07-04T10:17:08.035+0800: [GC concurrent-root-region-scan-end, 0.0001524 secs]
2021-07-04T10:17:08.035+0800: [GC concurrent-mark-start]
2021-07-04T10:17:08.051+0800: [GC concurrent-mark-end, 0.0062490 secs]
2021-07-04T10:17:08.051+0800: [GC remark, 0.0017041 secs]
2021-07-04T10:17:08.051+0800: [GC cleanup 448M->444M(1024M), 0.0006004 secs]
2021-07-04T10:17:08.051+0800: [GC concurrent-cleanup-start]
2021-07-04T10:17:08.051+0800: [GC concurrent-cleanup-end, 0.0000202 secs]
2021-07-04T10:17:08.129+0800: [GC pause (G1 Evacuation Pause) (young)-- 838M->619M(1024M), 0.0179489 secs]
2021-07-04T10:17:08.145+0800: [GC pause (G1 Evacuation Pause) (mixed) 632M->566M(1024M), 0.0120478 secs]
2021-07-04T10:17:08.160+0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 568M->566M(1024M), 0.0020414 secs]
2021-07-04T10:17:08.160+0800: [GC concurrent-root-region-scan-start]
2021-07-04T10:17:08.160+0800: [GC concurrent-root-region-scan-end, 0.0001460 secs]
2021-07-04T10:17:08.160+0800: [GC concurrent-mark-start]
2021-07-04T10:17:08.176+0800: [GC concurrent-mark-end, 0.0074701 secs]
2021-07-04T10:17:08.176+0800: [GC remark, 0.0024340 secs]
2021-07-04T10:17:08.176+0800: [GC cleanup 603M->596M(1024M), 0.0008053 secs]
2021-07-04T10:17:08.176+0800: [GC concurrent-cleanup-start]
2021-07-04T10:17:08.176+0800: [GC concurrent-cleanup-end, 0.0000237 secs]
2021-07-04T10:17:08.254+0800: [GC pause (G1 Evacuation Pause) (young)-- 853M->662M(1024M), 0.0105703 secs]
2021-07-04T10:17:08.269+0800: [GC pause (G1 Evacuation Pause) (mixed) 688M->576M(1024M), 0.0074858 secs]
2021-07-04T10:17:08.285+0800: [GC pause (G1 Evacuation Pause) (mixed) 631M->521M(1024M), 0.0087844 secs]
执行结束!共生成对象次数:9344

Process finished with exit code 0

```



从4次不同GC策略可以看出，从上到下，GC的**平均耗时**依次减小，其中CMSGC和G1GC的两种策略都采用了并发标记的手段

。G1GC的由于采用了Region的设计结构，使得垃圾回收时间大幅度减少。



## 结论

**Serial收集器**
单线程收集器，并且会暂停其他所有的工作线程（Stop The World）



**ParNew收集器**(并行收集器)
Serial收集器的多线程版本，其他行为和参数设置与Serial收集器完全一致。是server模式下首选新生代收集器，他能与老年代收集器CMS配合工作。默认开启的收集线程与CPU数量相同



**CMS收集器**
关注最短停顿时间为目标的收集器，注重服务响应速度，更好的用户体验。使用“标记-清除”算法。分为4个步骤
初始标记、并发标记、重新标记、并发清除
其中 初始标记、重新标记仍需要“Stop The World”，耗时长的并发标记和并发清除是可以与用户线程一起工作。
并发低停顿收集器
缺点：
1、对CPU资源非常敏感。默认启动线程数是（CPU数+3）/ 4。当CPU在4个以上时，并发回收最多占用不超过25%的CPU资源，但是当CPU不足4个时，差不多占用一半的CPU资源，如果此时负载较大时，对用户线程来说很有压力。
2、存在失败风险，从而导致另外一次fullGC，并且会临时使用Serial Old收集器。因为CMS工作时，需要预留足够的内存空间给用户线程使用，默认在68%时激活GC。
-XX:CMSInitiatingOccupancyFraction 触发GC的百分比，适当提高，可以降低回收次数，设的太高很容易导致“Concurrent Mode Failure”，性能反而下降
3、清除算法容易导致空间碎片。碎片过多会导致在老年代还有很多剩余空间时大对象无法分配，不得不提前触发FullGC。
-XX:+UseCMSCompactAtFullCollection 开启后，在FullGC后进行碎片整理，会增大停顿时间
-XX:CMSFullGCsBeforeCompaction 设置多少次FullGC后进行一次压缩处理。



**G1收集器**
“标记-整理”算法，可以非常精确的控制停顿，实现在基本不牺牲吞吐量的前提下完成低停顿的内存回收。G1将整个java堆（包括新生代、老年代）划分为多个固定大小的独立区域（Region）,并跟踪这些区域的垃圾，维护一个优先列表，优先回收垃圾最多的区域。