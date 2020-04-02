#include<stdio.h>
#include<stdlib.h>
#define MAX_VERTEX_NUM 20
#define VertexType int
typedef struct edge
{
    VertexType initial;
    VertexType end;
    VertexType weight;
}edge[MAX_VERTEX_NUM];
typedef struct{
    VertexType value;
    int sign;
}assist[MAX_VERTEX_NUM];
assist assists;
int cmp(const void *a, const void *b){
    return ((struct edge*)a)->weight-((struct edge*)b)->weight;
}
void CreateUDN(edge *edges, int *vexnum, int *arcnum){
    printf("输入连通网的边数: \n");
    scanf("%d %d", &(*vexnum), &(*arcnum));
    printf("输入连通网的顶点: ");
    for(int i = 0; i < (*vexnum); i++){
        scanf("%d", &(assists[i].value));
        assists[i].sign = i;
    }
    printf("输入各边的起始点和终点及权重: \n");
    for(int i = 0; i < (*arcnum); i++){
        scanf("%d,%d,%d", &(*edges)[i].initial, &(*edges)[i].end, &(*edges)[i].weight);
    }
}
int LocateVex(int vexnum, int point){
    for(int i = 0; i < vexnum; i++){
        if(assists[i].value == point){
            return i;
        }
    }
    return -1;
}
int main(){
    int arcnum, vexnum;
    edge edges;
    CreateUDN(&edges, &vexnum, &arcnum);
    qsort(edges, arcnum, sizeof(edges[0]), cmp);
    edge minTree;
    int num = 0;
    for(int i = 0; i < arcnum; i++){
        int initial = LocateVex(vexnum, edges[i].initial);
        int end = LocateVex(vexnum, edges[i].end);
        if(initial != -1 && end != -1 && assists[initial].sign != assists[end].sign){
            minTree[num] = edges[i];
            num++;
            for(int k = 0; k < vexnum; k++){
                if(assists[k].sign == assists[end].sign){
                    assists[k].sign = assists[initial].sign;
                }
            }
            if(num == vexnum - 1){
                break;
            }
        }
    }
    for(int i = 0; i < vexnum - 1; i++){
        printf("%d-->%d\n", minTree[i].initial, minTree[i].end);
    }
    return 0;
}