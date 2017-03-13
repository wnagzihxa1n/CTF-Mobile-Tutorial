#include <stdio.h>
#include <cstring>
#include <iostream>

using namespace std;

int main()
{
	char temp[17] = "QflMn`fH,ZHVW^7c";
	for(int i = 0; i < 16; i++)
	{
		if(i < 8)
			temp[i] -= 3;
		printf("%c", temp[i] + i);
	}
	return 0;
}





//char temp1[17] = "NciJk]cE,ZHVW^7c";
//NdkMobiL4cRackEr
