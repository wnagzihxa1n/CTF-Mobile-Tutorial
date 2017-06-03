#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

void cal()
{
	char RegCode[] = "0123456789";
    int len = strlen(RegCode);
    int j = 0;
    for (int i = 0; ; i++)
    {
        --j;
        if (i >= len / 2)
            break;
        int temp = RegCode[i] - 5;
        RegCode[i] = RegCode[len + j];
        RegCode[len + j] = temp;
    }
    RegCode[len] = 0;
    printf("%s\n", RegCode);
}

int main()
{
	printf("%c", "U"+5);
	cal();
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





