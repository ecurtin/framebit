---
layout: post
title: Debugging Adventures: Spark Failed To Start
---

Today after browsing the latest William Carlos Williams memes on Twitter, I figured it was time to actually do work.

```
cd ~/git/spark-bench
sbt test
```
only to be met with a mountain of red. 
```
java.lang.NoClassDefFoundError: Could not initialize class com.ibm.sparktc.sparkbench.testfixtures.SparkSessionProvider$
	at com.ibm.sparktc.sparkbench.testfixtures.BuildAndTeardownData.<init>(BuildAndTeardownData.scala:35)
	at com.ibm.sparktc.sparkbench.NotebookSimTest.<init>(NotebookSimTest.scala:27)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at java.lang.Class.newInstance(Class.java:442)
	at org.scalatest.tools.Framework$ScalaTestTask.execute(Framework.scala:435)
	at sbt.TestRunner.runTest$1(TestFramework.scala:76)
	at sbt.TestRunner.run(TestFramework.scala:85)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1$$anonfun$apply$8.apply(TestFramework.scala:202)
	at sbt.TestFramework$.sbt$TestFramework$$withContextLoader(TestFramework.scala:185)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFramework$$anon$2$$anonfun$$init$$1.apply(TestFramework.scala:202)
	at sbt.TestFunction.apply(TestFramework.scala:207)
	at sbt.Tests$.sbt$Tests$$processRunnable$1(Tests.scala:239)
	at sbt.Tests$$anonfun$makeSerial$1.apply(Tests.scala:245)
	at sbt.Tests$$anonfun$makeSerial$1.apply(Tests.scala:245)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$3$$anonfun$apply$2.apply(System.scala:44)
	at sbt.std.Transform$$anon$4.work(System.scala:63)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
	at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
	at sbt.Execute.work(Execute.scala:237)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
	at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
	at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
[error] Could not run test com.ibm.sparktc.sparkbench.NotebookSimTest: java.lang.NoClassDefFoundError: Could not initialize class com.ibm.sparktc.sparkbench.testfixtures.SparkSessionProvider$
```
Cool. That's fun. Everything was totes fine yesterday, now I can't make a SparkSession. 

First let's make sure sbt hasn't done anything weird. And let's also try checking out master and seeing if it's just my changes.

```
sbt clean test
```
Mountain of red.
```
git checkout master
sbt clean
sbt test
```
Mountain of red.

Ok, that didn't work. Seems like it's not my code. This is good/bad news.

What if I try a spark-shell?
```
/opt/spark-2.1.1-bin-hadoop2.7/bin/spark-shell
```
Wait for it, wait for it, wait for it, JVM startup times are really sad, 
```
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
17/12/01 10:34:48 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 WARN Utils: Service 'sparkDriver' could not bind on port 0. Attempting port 1.
17/12/01 10:34:48 ERROR SparkContext: Error initializing SparkContext.
java.net.BindException: Can't assign requested address: Service 'sparkDriver' failed after 16 retries (starting from 0)! Consider explicitly setting the appropriate port for the service 'sparkDriver' (for example spark.ui.port for SparkUI) to an available port or increasing spark.port.maxRetries.
	at sun.nio.ch.Net.bind0(Native Method)
	at sun.nio.ch.Net.bind(Net.java:433)
	at sun.nio.ch.Net.bind(Net.java:425)
	at sun.nio.ch.ServerSocketChannelImpl.bind(ServerSocketChannelImpl.java:223)
	at io.netty.channel.socket.nio.NioServerSocketChannel.doBind(NioServerSocketChannel.java:127)
	at io.netty.channel.AbstractChannel$AbstractUnsafe.bind(AbstractChannel.java:501)
	at io.netty.channel.DefaultChannelPipeline$HeadContext.bind(DefaultChannelPipeline.java:1218)
	at io.netty.channel.AbstractChannelHandlerContext.invokeBind(AbstractChannelHandlerContext.java:506)
	at io.netty.channel.AbstractChannelHandlerContext.bind(AbstractChannelHandlerContext.java:491)
	at io.netty.channel.DefaultChannelPipeline.bind(DefaultChannelPipeline.java:965)
	at io.netty.channel.AbstractChannel.bind(AbstractChannel.java:210)
	at io.netty.bootstrap.AbstractBootstrap$2.run(AbstractBootstrap.java:353)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:408)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:455)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:140)
	at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	at java.lang.Thread.run(Thread.java:748)
java.net.BindException: Can't assign requested address: Service 'sparkDriver' failed after 16 retries (starting from 0)! Consider explicitly setting the appropriate port for the service 'sparkDriver' (for example spark.ui.port for SparkUI) to an available port or increasing spark.port.maxRetries.
  at sun.nio.ch.Net.bind0(Native Method)
  at sun.nio.ch.Net.bind(Net.java:433)
  at sun.nio.ch.Net.bind(Net.java:425)
  at sun.nio.ch.ServerSocketChannelImpl.bind(ServerSocketChannelImpl.java:223)
  at io.netty.channel.socket.nio.NioServerSocketChannel.doBind(NioServerSocketChannel.java:127)
  at io.netty.channel.AbstractChannel$AbstractUnsafe.bind(AbstractChannel.java:501)
  at io.netty.channel.DefaultChannelPipeline$HeadContext.bind(DefaultChannelPipeline.java:1218)
  at io.netty.channel.AbstractChannelHandlerContext.invokeBind(AbstractChannelHandlerContext.java:506)
  at io.netty.channel.AbstractChannelHandlerContext.bind(AbstractChannelHandlerContext.java:491)
  at io.netty.channel.DefaultChannelPipeline.bind(DefaultChannelPipeline.java:965)
  at io.netty.channel.AbstractChannel.bind(AbstractChannel.java:210)
  at io.netty.bootstrap.AbstractBootstrap$2.run(AbstractBootstrap.java:353)
  at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:408)
  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:455)
  at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:140)
  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
  at java.lang.Thread.run(Thread.java:748)
<console>:14: error: not found: value spark
       import spark.implicits._
              ^
<console>:14: error: not found: value spark
       import spark.sql
              ^
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.1.1
      /_/
```

I love how it'll still get all the way to the ASCII art and the shell even if everything has blown up. Welcome to your busted Spark-Shell! It's like a Scala shell but with a little ASCII art and more error messages! But at least I know it's not Spark-Bench that's the issue.

Now let's stumble around with permissions issues because maybe magic elves changed permissions on stuff without me noticing and I can't be bothered to `ls -l /opt`. 

Sudo make me a sandwich:
```
sudo /opt/spark-2.1.1-bin-hadoop2.7/bin/spark-shell
```
And same thing happens because dastardly permissions goblins are just a children's story told to bad kids by their parents who are burnt-out programmers.

Since the stacktraces are whining about assigning addresses, maybe there's a networking thing? Let's disconnect from the network and try again.

```
ERROR SparkContext: Error initializing SparkContext.
org.apache.spark.SparkException: Invalid Spark URL: spark://HeartbeatReceiver@:52009
	at org.apache.spark.rpc.RpcEndpointAddress$.apply(RpcEndpointAddress.scala:65)
	at org.apache.spark.rpc.netty.NettyRpcEnv.asyncSetupEndpointRefByURI(NettyRpcEnv.scala:133)
	at org.apache.spark.rpc.RpcEnv.setupEndpointRefByURI(RpcEnv.scala:100)
	at org.apache.spark.rpc.RpcEnv.setupEndpointRef(RpcEnv.scala:108)
	at org.apache.spark.util.RpcUtils$.makeDriverRef(RpcUtils.scala:32)
	at org.apache.spark.executor.Executor.<init>(Executor.scala:134)
	at org.apache.spark.scheduler.local.LocalEndpoint.<init>(LocalSchedulerBackend.scala:59)
	at org.apache.spark.scheduler.local.LocalSchedulerBackend.start(LocalSchedulerBackend.scala:126)
	at org.apache.spark.scheduler.TaskSchedulerImpl.start(TaskSchedulerImpl.scala:156)
	at org.apache.spark.SparkContext.<init>(SparkContext.scala:509)
	at org.apache.spark.SparkContext$.getOrCreate(SparkContext.scala:2320)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$6.apply(SparkSession.scala:868)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$6.apply(SparkSession.scala:860)
	at scala.Option.getOrElse(Option.scala:121)
	at org.apache.spark.sql.SparkSession$Builder.getOrCreate(SparkSession.scala:860)
	at org.apache.spark.repl.Main$.createSparkSession(Main.scala:96)
	at $line3.$read$$iw$$iw.<init>(<console>:15)
	at $line3.$read$$iw.<init>(<console>:42)
	at $line3.$read.<init>(<console>:44)
	at $line3.$read$.<init>(<console>:48)
	at $line3.$read$.<clinit>(<console>)
	at $line3.$eval$.$print$lzycompute(<console>:7)
	at $line3.$eval$.$print(<console>:6)
	at $line3.$eval.$print(<console>)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:786)
	at scala.tools.nsc.interpreter.IMain$Request.loadAndRun(IMain.scala:1047)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:638)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:637)
	at scala.reflect.internal.util.ScalaClassLoader$class.asContext(ScalaClassLoader.scala:31)
	at scala.reflect.internal.util.AbstractFileClassLoader.asContext(AbstractFileClassLoader.scala:19)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest.loadAndRunReq(IMain.scala:637)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:569)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:565)
	at scala.tools.nsc.interpreter.ILoop.interpretStartingWith(ILoop.scala:807)
	at scala.tools.nsc.interpreter.ILoop.command(ILoop.scala:681)
	at scala.tools.nsc.interpreter.ILoop.processLine(ILoop.scala:395)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply$mcV$sp(SparkILoop.scala:38)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:37)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:37)
	at scala.tools.nsc.interpreter.IMain.beQuietDuring(IMain.scala:214)
	at org.apache.spark.repl.SparkILoop.initializeSpark(SparkILoop.scala:37)
	at org.apache.spark.repl.SparkILoop.loadFiles(SparkILoop.scala:105)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply$mcZ$sp(ILoop.scala:920)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply(ILoop.scala:909)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply(ILoop.scala:909)
	at scala.reflect.internal.util.ScalaClassLoader$.savingContextLoader(ScalaClassLoader.scala:97)
	at scala.tools.nsc.interpreter.ILoop.process(ILoop.scala:909)
	at org.apache.spark.repl.Main$.doMain(Main.scala:69)
	at org.apache.spark.repl.Main$.main(Main.scala:52)
	at org.apache.spark.repl.Main.main(Main.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:743)
	at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:187)
	at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:212)
	at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:126)
	at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
```

Aha! This has to do with hostnames!

[Insert some Googling]

```
export SPARK_LOCAL_HOSTNAME=localhost
```

Voila! It works! Now on to make my unit tests work like a boss.

