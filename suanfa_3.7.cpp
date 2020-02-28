#include<iostream>
using namespace std;
void delete_re(int a[], int n)
{
    int b[100] = {0};
    int i, k;
    k = 0; 
    static int j = 0;
    for (i = 0; i < n; i++)
        b[a[i]]++;
        for(i = 0; i < 100; i++)
        {
            if(b[i] != 0)
            {
                if(b[i] == 2)
                {k++;}
                a[j] = i;
                j++;
            }
        }
        for(i = 0; i < n-k; i++)
        {
            cout << a[i] << endl;
        }
}
int main()
{
    int a[] = {0, 0, 3, 4, 4, 5, 6, 6, 7,};
    delete_re(a, 9);
    return 0;
}
