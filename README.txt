android_security_exit;

template:
��Method_:��
˼·->
����->
Test Result->
����->
����->

======================================================
��Method_1:��

˼·->���Ȼ�ȡ��ǰ���̵�ID��Ȼ��ɱ���ý���
����->android.os.Process.killProcess(android.os.Process.myPid());


Test Result->
1.��ֻ��һ��activityʱ�������е���Process.killProcess(Process.myPid());
��ɱ����ǰactivity��ͬʱProcessҲ���ɵ�

2.��Task����ջ�ж��activity��������activity����Process.killProcess(Process.myPid());ֻ�ܳ�ȥ����activity��Task����ջ��Process����

����->ͨ�����ַ�ʽ�����ܽ�Ӧ�ó�����ȫɱ��������������ѵ�ǰӦ�õ�Activity��Task����ջ��ա�ֻ��ɱ����ǰ��activiy�����޷��رճ���
����->�ȸ���Ƶ�ʱ��涨��������ɱ��
======================================================
��Method_2:��
˼·->��ֹ��ǰ�������е�java����������³�����ֹ��
����->System.exit(0);

Test Result->
1.��ֻ��һ��activityʱ�������е���System.exit(0);
��ɱ����ǰactivity��ͬʱProcessҲ���ɵ�

2.��Task����ջ�ж��activity��������activity����System.exit(0);ֻ�ܳ�ȥ����activity��Task����ջ��Process����

����->ͨ�����ַ�ʽ�����ܽ�Ӧ�ó�����ȫɱ��������������ѵ�ǰӦ�õ�Activity��Task����ջ��ա�ֻ��ɱ����ǰ��activiy�����޷��رճ���
����->Androidʹ�õ���dalvik�������������java�������
======================================================
��Method_3:��
˼·->ǿ�ƹر���ð��й�����һ��ִ�С�
����->
ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
manager.restartPackage(getPackageName());

AndroidManifest.xml:
<uses-permission android:name="android.permission.RESTART_PACKAGES"/>
����<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES"/>

Test Result->
1.��ֻ��һ��activityʱ�������е������ϴ��룬����޷�Ӧ��
2.��Task����ջ�ж��activity��������activity�������ϴ��룬����޷�Ӧ��
3.��Ӧ��A��һ��activityȥ�������ϴ��룬��дΪrestartPackage("BӦ�õİ���")����Kill��BӦ�ã�����ɹ�Kill��;

����->���ַ�ʽ����Kill���Լ���
����->ActivityManager���ƣ�����Kill���Լ���
======================================================
���Ͽ��Կ����ȸ����Ƽ��ǳ��������ҵĴ�Process����System����ȥKill���Լ�
����ÿ��Ӧ�ö��и�Application����ȫ�ֵ�Context������������� contextȥ�������ǵ�activity
======================================================


˼·��
��չApplication->MyApplication
��չActivity->TActivity(��Ϊģ��)
























