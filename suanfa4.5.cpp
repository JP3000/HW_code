#include<iostream>
using namespace std;
extern const int n = 10;
int main()
{
    int a[n] = {1, 2, 11, 4 ,5, 7, 0, 3, 12, 6};
    int mid = n/2;
    int max1 = 0, max2 = 0;
    for(int i = 0; i <= n/2; ++i){
        if(a[i] > max1)
            max1 = a[i];
    } 
    for(int j = n/2 + 1; j < n; ++j){
        if(a[j] > max2)
        max2 = a[j];
    }
    if(max1 >= max2)
    cout << " max is " << max1 << endl;
    else
    cout << " max is " << max2 << endl;
    return 0;
}