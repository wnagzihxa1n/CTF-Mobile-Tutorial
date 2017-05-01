#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

signed char sub_1078(signed int a1)
{
    signed int v1; // r3@3

    if ( a1 > 9 || a1 < 0 )
    {
        if ( a1 <= 9 || a1 > 15 )
            v1 = 255;
        else
            v1 = (unsigned char)(a1 + 87);
    }
    else
    {
        v1 = (unsigned char)(a1 + 48);
    }
    return v1;
}

int main()
{
    char Key[] = "9838e8884918a8a8b8fc6908a9d9fcd838a8c9c968188829";
    for(int i = 0; i < strlen(Key); i += 2)
    {
        for(unsigned char j = 0; j < 0xFF; j++)
        {
            if(sub_1078(~j & 0xF) == Key[i] && sub_1078((j >> 4) ^ 0xE) == Key[i + 1])
                printf("%c", j);
        }
    }
    printf("\n");
    return 0;
}
