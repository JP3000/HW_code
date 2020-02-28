#include<iostream>
using namespace std;
void delete_n(int *a, int *b, int len);
int x = 4;
int main()
{
    int a[] = {1, 2, 3, 4, 5, 4, 6, 7}, len, *new_arr;
    len = sizeof(a) / sizeof(a[0]);
    new_arr = (int *)malloc(len *sizeof(int));
    delete_n(a, new_arr, len);
    return 0;
}
void delete_n(int *a, int *b, int len)
{
    int new_len = 0;
    for(int i = 0, j = 0; i < len; i++)
    {
        if(a[i] == x)
            continue;
        else
        {
            b[j] = a[i];
            j++;
        }
        new_len = j;
    }
    for(int i = 0; i < new_len; i++)
        printf("%d\n", b[i]);
}
