#include <stdio.h>
#define getjcb(type)(type*)malloc(sizeof(type))
#define NULL 0

int n = 0, time = 0;
float eti, ewi;

struct jcb{
    char name[10];
    char state;
    int ts;
    float super;
    int tb;
    int tc;
    float ti;
    float wi;
    int ntime;
    char resource[10];
    struct jcb *link;
}*p, *q, *head = NULL;
typedef struct jcb JCB;

inital(){
    int i;
    printf("\n input jcb num \n");
    scanf("%d", &n);
    printf("Input \n name \t ts \t ntime \t resource \n");
    for(i = 0; i < n; i++){
        p = getjcb(JCB);
        scanf("％s \t %d \t %d \t %s", &p->name, &p->ts, &p->ntime, &p->resource);
        p->state = 'W';
        p->link = NULL;
        if(head == NULL)
            head = q = p;
        else{
            q->link = p;
            q = p;
        }
    }
}
fileinput(){
    FILE *fp;
    int i;
    if((fp = fopen("os2.txt", "r")) == NULL) 
        printf(" open error!");
        fscanf(fp, "%d\n", &n);
    for(i = 0; i < n; i++){
        p = getjcb(JCB);
        fscanf(fp, "%s%d%d%s", &p->name, &p->ts, &p->ntime, &p->resource);
        p->state = 'W';
        p->link = NULL;
        if(head == NULL)
            head = q = p;
        else{
            q->link = p;
            q = p;
        }
    }
    fclose(fp);
}

void print(JCB *pr, int m){
    JCB *p;
    printf("\n time = %d", time);
    if(m == 3){
        printf("\n name \t state \t ts \t ntime \t super \t source \t tc \t ti \t wi \n");
        printf("%s \t %c \t %d \t %d \t %4.2f \t %s \t %d \t %d \t %4,2f \t 4.2f \n"
        pr->name, pr->state, pr->ts, pr->ntime, pr->super, pr->resource, pr->tb, pr->tc, pr->ti, pr->wi);        
    }
    else{
        printf("\n name \t state \t ts \t ntime \t source \t tb \t tc \t ti \t wi \n");
        printf("%s \t %c \t %d \t %d \t %s \t %d \t %d \t %4.2f \t %4.2f \n",
        pr->name, pr->state, pr->ts, pr->ntime, pr->resource, pr->tb, pr->tc, pr->ti, pr->wi);
    }
    p = head;
    do{
        if(p->state == 'W')
            if(m == 3){
                printf("%s \t %c \t %d \t %d \t %4.2f \t %s \n",
                p->name, p->state, p->ts, p->ntime, p->super, p->resource);
            }
            else{
                printf("%s \t %c \t %d \t %d \t %s\n",
                p->name, p->state, p->ts, p->ntime, p->resource);
            }
            p = p->link;
    }
    while(p != NULL);
    p = head;
    do{
        if(p->state = 'F')
        if(m == 3){
            printf("%s \t %c \t %d \t %d \t %4.2f \t %s \t %d \t %d \t %4,2f \t 4.2f \n"
            pr->name, pr->state, pr->ts, pr->ntime, pr->super, pr->resource, pr->tb, pr->tc, pr->ti, pr->wi);
        }
        else{
            printf("%s \t %c \t %d \t %d \t %s \t %d \t %d \t %4.2f \t %4.2f \n",
            pr->name, pr->state, pr->ts, pr->ntime, pr->resource, pr->tb, pr->tc, pr->ti, pr->wi);
        }
        p = p->link;
    }
    while(p != NULL);
}

void last(){
    eti/ = n;
    ewi/ = n;
    printf("\n eti = %7.3f \t ewi = %7.3f\n", eti, ewi);
}
super(){
    JCB *padv;
    padv = head;

    do{
        if(padv->state == 'W' && padv->ts <= time)
        padv->super = (float)(time-padv->ts+padv->ntime)/padv->ntime;
        padv = padv->link;
    }
    while (padv != NULL);
}

void hrn(m){
    JCB *min;
    int i, iden;
    for(i = 0; i < n; i++){
        p = min = head;
        iden = 1;
        super();
        do{
            if(p->state == 'W' && p->ts <= time)
            if(iden){
                min = p;
                iden = 0;
            }
            else if(p->super > min->super)
            min = p;
            p = p->link;
        }
        while(p != NULL);
        if(iden){
            i--; time++; printf("\n time = %d: \tno JCB submib...wait...", time);
            if(time > 1000){printf("\n runtime is too long...error..."); getch();}
        }
        else{
            running(min, m);
        }
    }
}

fcfs(int m){
    int i, iden;
    printf("\n\nthe jcb is running...");
    for(i = 0; i < n; i++){
        p = head; 
        iden = 1;
        do{
            if(p->state == 'W' && p->ts <= time)
                iden = 0;
            if(iden)
                p = p->link;
        }
        while(p != NULL && iden);
        if(iden){
            i--;
            printf("\n time = %d: \t no JCB submib...wait...", time);
            time++;
            if(time > 100){printf("\n runtime is too long...error"); getch();}
        }
        else{
            running(p, m);
        }
    }
}

running(JCB *p, int m){
    p->tb = time; p->state = 'R';
    p->tc = p->tb + p->ntime;
    p->ti = (float)(p->tc-p->ts);
    p->wi = (float)(p->ti / p->ntime);
    eti += p->ti;
    ewi += p->wi;
    print(p, m);
    time += p->ntime;
    p->state = 'F';
    printf("\n %s has been finished!\n press any key to contine...\n", p->name);
    getch();
}

void runjcb(int m){
    printf("\n\nstart running jcb...");
    switch(m){
        case 1: fcfs(m); break;
        case 2: sjf(m); break;
        case 3: hrn(m); break;
        default: printf("\n runjcb error...\n"); exit();
    }
}

fileway(){
    printf("\n adopts the file way to input the datas...y/n:");
    if(getch() == 'y')
        fileinput();
    else inital();
}

start(){
    int m;
    char str[100] = "\nselect algorithm\n1.FCFS\n2.SJF\n3.HRN\n";
    print("%s", str);
    m = getch() - 48;

    fileway();
    if(1 <＝ m && m <= 3) runjcb(m);
    else{
        printf("\nselect error! try again...\n");
        start();
    }
    last();
}

main()
{
    start();
    printf("\n finished!");
    getch();
}




























