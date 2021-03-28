# 2017陕西省网络安全大赛Mobile第三题

**Author: wnagzihxa1n
E-Mail: wnagzihxa1n@gmail.com**

## 0x00 前言
这题可以秒掉

## 0x01 分析
一进来就看到这个，这代码写的很渣，不想看逻辑，跳过看后面的

![](Image/1.png)

在`onCreate()`函数里发现有一个结束主Activity的操作，直接去掉

![](Image/2.png)

使用AndroidKiller修改代码

![](Image/3.png)

把`run()`的逻辑全去掉
```
# virtual methods
.method public run()V
    .locals 0

    .prologue
    return-void
.end method
```

编译安装，可以正常运行

然后分析下面的点击事件，`GetString.encrypt()`函数是native函数
```
if(GetString.encrypt(MainActivity.this.editText.getText().toString().trim())) {
    Toast.makeText(MainActivity.this, "OK", 0).show();
}
else {
    Toast.makeText(MainActivity.this, "Error", 0).show();
}
```

不是很懂为什么作者要在这里定义三个函数。。。。。。仿佛是一个第一次用NDK的新手。。。。。。
```
public class GetString {
    static {
        System.loadLibrary("XTU");
    }

    public GetString() {
        super();
    }

    public static native boolean encrypt(GetString this, String arg1) {
    }

    public static native String getString(GetString this) {
    }

    public static native String sendData(GetString this, String arg1) {
    }
}
````

使用IDA分析so

![](Image/4.png)

在分析完逻辑后，有两个方法可以拿到RegCode
- 写代码跑，计算逻辑都已经给了
- 动态调试，下个断点跟踪

第一种方法，找到赋值的数组

![](Image/5.png)

简单写了个脚本跑
```
# coding:utf-8

RegCode_Cal = []
Key = list("yInS567!bcNOUV8vwCDefXYZadoPQRGx13ghTpqrsHklm2EFtuJKLzMijAB094W")
dest = [0x39, 0x20, 0x07, 0x0A, 0x20, 0x29, 0x13, 0x02, 0x3A, 0xC, 0x11, 0x31, 0x3B, 0x0B, 0x07]

for i in range(len(dest)):
	RegCode_Cal.append(Key[dest[i]])

print "".join(RegCode_Cal)
```

结果
```
A1!N1HenBUCu0O!
```

第二种方法，动态调试出结果
```
C:\Users\wangz\Desktop
$ adb forward tcp:23946 tcp:23946
C:\Users\wangz\Desktop
$ adb shell
root@jflte:/ # cd data/local
root@jflte:/data/local # ./as
IDA Android 32-bit remote debug server(ST) v1.19. Hex-Rays (c) 2004-2015
Listening on port #23946...

```

再次使用IDA打开一个新的so文件，无任何修改，下面两个地方下断点都可以

![](Image/6.png)

挂上应用，断下来后，在数据窗口跟随R4就可以看到RegCode

![](Image/7.png)

## 0x02 小结
喵喵喵~




