# 2016AliCTF-Timer

**Author：wnagzihxain
Mail：wnagzihxa1n@gmail.com**

## 0x00 前言
2016年阿里CTF的第一道Mobile题，分值50

## 0x01 分析
使用Jadx反编译样本，刚开始看着代码感觉有点怪怪的，看了一会，整理了逻辑，使用`postDelayed()`循环执行，间隔为1s

![](Image/1.png)

`is2()`函数用于判断素数

![](Image/2.png)

那么在去掉其余代码，总结就是：循环200000次，然后循环的时候进行素数判断，根据判断的结果进行不同的操作

Java还原
```
package test;

public class Main {
	
	public static void main(String[] args) throws Exception{
		int beg = 200000;
		int k = 0;
		int i;
		for(i = beg; i > 0; i--){
	        if(is2(beg - i)) {
	            k += 100;
	        } else {
	            k--;
	        }
		}
		System.out.println(Integer.toString(k));
		System.out.println("Finish!");
	}
		
	public static boolean is2(long l) {
        if (l <= 3) {
            if (l > 1) {
                return true;
            }
            return false;
        } else if (l % 2 == 0 || l % 3 == 0) {
            return false;
        } else {
            int i = 5;
            while (i * i <= l) {
                if (l % i == 0 || l % (i + 2) == 0) {
                    return false;
                }
                i += 6;
            }
            return true;
        }
    }
}
```

跑出结果
```
1616384
Finish!
```

那么这个数字传入
```
public native String stringFromJNI2(int i);
```

这是一个native方法，小书包里掏出IDA

![](Image/3.png)

我去，一堆除和余，分析太费劲，反正没有其它的干扰了，写个APP自己调用这个so
```
package net.bluelotus.tomorrow.easyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wnagzihxain.demo.R;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("lhm");
    }

    public native String stringFromJNI2(int number);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(this, stringFromJNI2(1616384), Toast.LENGTH_LONG).show();
        Log.i("toT0C", stringFromJNI2(1616384));
    }
}
```

有几点要注意
- so直接放`src/main/`目录下的`jniLibs`，没有就自己创建，记得把`armeabi`带上
- 调用类的路径需要和so里描述的一样，不然会找不到方法
- `int __fastcall Java_net_bluelotus_tomorrow_easyandroid_MainActivity_stringFromJNI2(int a1, int a2, signed int a3)`

最后看一下完整的路径结构，这种调用so的方法不需要修改`build.gradle`，虽然不建议

![](Image/4.png)

跑起来，输出Flag
```
03-28 09:02:21.066 25084-25084/com.wnagzihxain.demo I/toT0C: Y0vAr3TimerMa3te7
```

## 0x02 小结
毕竟才50分，还要分析so那简直太折腾，还是走捷径比较好，要是想锻炼so分析能力的同学可以去折腾一下











