#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

int main()
{
	char temp;
	char Key[] = "S!@#@1FD23154A34";
	int len = strlen(Key);
	for (int i = len - 3; i - 2 >= -1; i -= 2)
	{
		for (int j = len - 4; j - 4 >= -3; j -= 4)
		{
			temp = Key[j];
			Key[j] = Key[j - 4];
			Key[j - 4] = temp;
		}
		temp = Key[i];
		Key[i] = Key[i - 1];
		Key[i - 1] = temp;
	}
	printf("%s\n", Key);
	return 0;
}
