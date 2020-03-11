#include<iostream>
using namespace std;
int BinSearch(int a[], int key, int low, int high){
    int i = low;
    int j = high;
    int mid = (low + high) / 2;
    if(i > j){
        return -1;
    }
    if(key == a[mid]){
        return mid;
    }
    else if(key > a[mid]){
        return BinSearch(a, key, mid + 1, j);
    }
    else{
        return BinSearch(a, key, i, mid - 1);
    }
    return -1;
}
int main()
{
    int a[] = {1, 2, 3, 4, 5, 6, 7 ,8, 9};
    int i; 
    cout << "input the num what you want to find: "<< endl;
    cin >> i ;
    int result = BinSearch(a, i, 0, 8);
    cout << "result is: "<< result << endl;
    return 0;    
}