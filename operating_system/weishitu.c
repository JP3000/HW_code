#include<stdio.h>
#include<math.h>
#include<malloc.h>
#include<stdlib.h>

int m = 5, n = 5;
int map[5][5];
int input(){
    printf("初始化数组:\n");
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            map[i][j] = 0;
            printf("%d", map[i][j])
        }
        printf("\n");
    }
}
int fenpei(int *q){
    int b[25], t;
    int x = 0, i, j, k;
    t = *q;
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            if(map[i][j] == 0){
                b[x] = n * i + j;
                x++;
            }
        }
    }
    if(t > x){
        printf("空间不足，请输入一个数:");
        scanf("%d", &t);
        fenpei(&t);
    }
    else{
        for(int z = 0; z < x; z++){
            if(b[z] == t){
                i = t / n;
                j = t % n;
                map[i][j] = 1;
                for(i = 0; i < m; i++){
                    for(j = 0; j < n; j++){
                        printf("%d ", map[i][j]);
                    }
                    printf("\n");
                }
                break;
            }
        }
    }
}
int huishou(int *w){
    int p, i, j;
    p = *w;
    if(p > 25){
        printf("超出范围，再次输入一个数: \n");
        printf("       \n");
        scanf("%d", &p);
        huishou(&p);
    }
    else{
        i = p / n;
        j = p % n;
        if(map[i][j] == 1){
            map[i][j] = 0;
            for(i = 0; i < m; i++){
                for(j = 0; j < n; j++){
                    printf("%d", map[i][j]);
                }
                printf("\n");
            }
        }
        else
        printf("此号空闲! \n");
        printf("         \n");
    }
    return 0;
}
int main(){
    int  w, f;
    printf("        \n");
    input();
    printf("请选择当前操作 \n");
    printf("             \n");
    while(1){
        printf("按下１表示盘块分配　　按下２表示盘块回收 \n");
        scanf("%d", &w);
        switch(w){
            case 1:
                printf("进行盘块分配回收: \n");
                printf("输入盘块号 \n");
                scanf("%d", &f);
                fenpei(&f);
            break;
            case 2:
                printf("进行盘块回收: \n");
                scanf("%d", &f);
                huishou(&f);
            break;
        }
    }
}