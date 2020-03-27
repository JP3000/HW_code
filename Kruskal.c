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
//定义辅助数组
typedef struct{
    VertexType value;//顶点数据
    int sign;//每个顶点所属的集合
}assist[MAX_VERTEX_NUM];
assist assists;
//qsort排序函数中使用,使edges结构体中的边按照权值大小升序排序
int cmp(const void *a, const void *b){
    return ((struct edge*)a)->weight-((struct edge*)b)->weight;
}
//初始化连通网
void CreateUDN(edge *edges, int *vexnum, int *arcnum){
    printf("输入连通网的边数: \n");
    scanf("%d %d", &(*vexnum), &(*arcnum));
    printf("输入连通网的顶点: \n");
    for(int i = 0; i < (*vexnum); i++){
        scanf("%d", &(assists[i].value));
        assists[i].sign = i;
    }
    printf("输入各边的起始点和终点及权重: \n");
    for(int i = 0; i < (*arcnum); i++){
        scanf("%d, %d, %d", &(*edges)[i].initial, &(*edges)[i].end, &(*edges)[i].weight);
    }
}
//在assists数组中找到顶点point对应的位置下标
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
    //对连通网中所有边进行升序排序, 结果仍保存在edges数组中
    qsort(edges, arcnum, sizeof(edges[0]), cmp);
    //创建一个空的结构体数组, 用于存放最小生成树
    edge minTree;
    //设置一个用于记录最小生成树中边的数量的常量
    int num = 0;
    //遍历所有的边
    for(int i = 0; i < arcnum; i++){
        //找到边的起始顶点和结束顶点在数组assists中的位置
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
        printf("%d, %d\n", minTree[i].initial, minTree[i].end);
    }
    return 0;
}