#include<iostream>
using namespace std;
#define MAXCHAR 0x80
int tsp(int arc[5][5], int w){
    int edgeCount = 0, TSPLength = 0;
    int min, u, v;
    int n = 5;
    int flag[n] = {0};
    u = w;
    flag[w] = 1;
    while (edgeCount < n - 1){
        min = 100;
        for(int j = 0; j < n; j++){
            if((flag[j] == 0) && (arc[u][j] != 0) && (arc[u][j] < min)){
                v = j;
                min = arc[u][j];
            }
        }
        TSPLength += arc[u][v];
        flag[v] = 1;
        edgeCount++;
        cout << u << "-->" << v << endl;
        u = v;
    }
    cout << v << "-->" << w << endl;
    return (TSPLength + arc[u][v]);
}
int main(){
    int m = MAXCHAR;
    int g[5][5] = {{m, 3, 3, 2, 6},
                   {3, m, 7, 3, 2},
                   {3, 7, m, 2, 5},
                   {2, 3, 2, m, 3},
                   {6, 2, 5, 3, m}};
    int p = 0;
    tsp(g, p);
    return 0;
}