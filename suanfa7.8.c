#include<stdio.h>
int main(){
    void knapsack1(int a[10000], int n);
    void knapsack2(int b[10000], int n);
    int a[10000],b[10000];
    int w, i, n;
    int max = 0;
    int sum = 0;
    printf("number:");
    scanf("%d", &n);
    printf("weight:");
    for(i = 0; i < n; i++)
        scanf("%d", &a[i]);
    printf("value:");
    for (i = 0; i < n; i++)
        scanf("%d", &b[i]);
    printf("capacity:");
    scanf("%d", &w);
        knapsack1(a, n);
        knapsack2(b, n);
        for(i = 0; i < n; i++){
            max += a[i];
            if(max <= w)
                sum += b[i]; 
        }
        printf("result:%d\n", sum);
     return 0;
}
void knapsack1(int a[10000], int n){
    int i, j, k;
    int t;
    for(i = 0; i < n; i++){
        k = i;
        for(j = j+1; j < n; j++)
            if(a[k] > a[j]) k = j;
            t = a[i];
            a[i] = a[k];
            a[k] = t;
    }
}
void knapsack2(int b[10000], int n){
    int i, j, k;
    int t;
    for(i = 0; i < n; i++){
        k = i;
        for(j = i+1; j < n; j++)
            if(b[k] < b[j]) k = j;
            t = b[i];
            b[i] = b[k];
            b[k] = t;
    }
}