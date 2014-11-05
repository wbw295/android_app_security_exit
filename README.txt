android_security_exit;

template:
【Method_:】
思路->
做法->
Test Result->
结论->
分析->

======================================================
【Method_1:】

思路->首先获取当前进程的ID，然后杀死该进程
做法->android.os.Process.killProcess(android.os.Process.myPid());


Test Result->
1.当只有一个activity时，在其中调用Process.killProcess(Process.myPid());
会杀掉当前activity，同时Process也被干掉

2.当Task任务栈有多个activity，在最顶层的activity调用Process.killProcess(Process.myPid());只能除去最顶层的activity，Task任务栈及Process均存活。

结论->通过这种方式并不能将应用程序完全杀死，并且它不会把当前应用的Activity的Task任务栈清空。只能杀死当前的activiy，而无法关闭程序。
分析->谷歌设计的时候规定程序不能自杀。
======================================================
【Method_2:】
思路->终止当前正在运行的java虚拟机，导致程序终止。
做法->System.exit(0);

Test Result->
1.当只有一个activity时，在其中调用System.exit(0);
会杀掉当前activity，同时Process也被干掉

2.当Task任务栈有多个activity，在最顶层的activity调用System.exit(0);只能除去最顶层的activity，Task任务栈及Process均存活。

结论->通过这种方式并不能将应用程序完全杀死，并且它不会把当前应用的Activity的Task任务栈清空。只能杀死当前的activiy，而无法关闭程序。
分析->Android使用的是dalvik虚拟机，而并非java虚拟机。
======================================================
【Method_3:】
思路->强制关闭与该包有关联的一切执行。
做法->
ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
manager.restartPackage(getPackageName());

AndroidManifest.xml:
<uses-permission android:name="android.permission.RESTART_PACKAGES"/>
或者<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>

Test Result->
1.当只有一个activity时，在其中调用如上代码，结果无反应。
2.当Task任务栈有多个activity，在最顶层的activity调用如上代码，结果无反应。
3.在应用A的一个activity去调用如上代码，改写为restartPackage("B应用的包名")，即Kill掉B应用，结果成功Kill掉;

结论->这种方式不能Kill掉自己。
分析->ActivityManager机制，不能Kill掉自己。
======================================================
综上可以看出谷歌的设计即是程序不能自我的从Process或者System层面去Kill掉自己
但是每个应用都有个Application，即全局的Context，可以利用这个 context去管理我们的activity
======================================================


思路：
括展Application->MyApplication
括展Activity->TActivity(作为模板)
























