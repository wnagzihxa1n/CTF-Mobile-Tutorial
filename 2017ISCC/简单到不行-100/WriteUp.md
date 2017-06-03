# 2017ISCC全国大学生信息安全与对抗技术竞赛Mobile第一题

**Author：wnagzihxain
Mail：tudouboom@163.com**

## 0x00 前言
后天物理考试，打场CTF放松一下

## 0x01 分析
题目说了是送分题，应该是送分的，非常传统的套路，Java层获取一个RegCode，然后传入native层进行校验

![](Image/1.png)

native层的校验，遍历前一半的数据，每一个加5，然后跟对称的数据进行交换

![](Image/2.png)

那么我们还原的代码就是从后面开始遍历，遍历后一半，然后跟对称的数据进行交换
```
#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{
	char Key[] = "=0HWYl1SE5UQWFfN?I+PEo.UcshU";
	int len = strlen(Key);
	for(int i = len - 1; i >= len / 2; i--)
	{
		Key[i] += 5;
		int temp = Key[len - i - 1];
		Key[len - i - 1] = Key[i];
		Key[i] = temp;
	}
	printf("%s\n", Key);
	return 0;
}
```

结果
```
ZmxhZ3tJU0NDSkFWQU5ES1lYWH0=
```

这很明显的是Base64处理过的，拿去还原
```
flag{ISCCJAVANDKYXX}
```

需要注意一下，这题使用了动态注册，使用F5的时候，有些怪怪的，直接找关键的代码就行

![](Image/3.png)

跟进去，可以看到动态注册的函数调用，双击过去就是待注册函数表

![](Image/4.png)

## 0x02 小结
就一题Mobile吗？