#include "stdio.h"
#include<stdlib.h>
#define getjcb(type) (type*)malloc(sizeof(type))
#include<conio.h>
#define NULL 0
int n=0,time=0;float eti,ewi; 
struct jcb{ 
char name[10];           /* 作业名 */             
char state;              /* 作业状态 */             
int ts;                  /* 提交时间 */             
float super;               /* 优先权 */             
int tb;                  /* 开始运行时间 */             
int tc;                  /* 完成时间 */             
float ti;                /* 周转时间 */             
float wi;                /* 带权周转时间 */             
int ntime;               /* 作业所需运行时间 */             
char resource[10];       /* 所需资源 */             
struct jcb *link;        /* 结构体指针 */ 
} *p,*q,*head=NULL; typedef struct jcb JCB; 
void running(JCB *p,int m);        
inital(){
    int i;
    printf("\nInput jcb num\n");
    scanf("%d",&n);
    printf("Input\nname\tts\tntime\tresource\n");
    for(i=0;i<n;i++){
        p=getjcb(JCB);
        scanf("%s\t%d\t%d\t%s",&p->name,&p->ts,&p->ntime,&p->resource);
        p->state='W';
        p->link=NULL;
        if(head==NULL)	head=q=p;
        else{
            q->link=p;
            q=p;
        }
    }
}


fileinput(){
    FILE *fp;
    int i;
    if((fp=fopen("os2.txt","r"))==NULL) printf(" open error!") ;
    fscanf(fp,"%d\n",&n);
    for(i=0;i<n;i++){
        p=getjcb(JCB);
        fscanf(fp,"%s%d%d%s",&p->name,&p->ts,&p->ntime,&p->resource);
        p->state='W';
        p->link=NULL;
        if(head==NULL)	head=q=p;
        else{
            q->link=p;
            q=p;
        }
    }
    fclose(fp);
}
void print(JCB *pr,int m){
    JCB *p;
    printf("\ntime=%d",time);
    if(m==3){
        printf("\nname\tstate\tts\tntime\tsuper\tsource\ttb\ttc\tti\twi\n");
        printf("%s\t%c\t%d\t%d\t%4.2f\t%s\t%d\t%d\t%4.2f\t%4.2f\n", pr->name,pr->state,pr->ts,pr->ntime,pr->super,pr->resource,pr->tb,pr->tc,pr->ti,pr->wi);
    }
    else {
        printf("\nname\tstate\tts\tntime\tsource\ttb\ttc\tti\twi\n");
        printf("%s\t%c\t%d\t%d\t%s\t%d\t%d\t%4.2f\t%4.2f\n",
        pr->name,pr->state,pr->ts,pr->ntime,pr->resource,pr->tb,pr->tc,pr->ti,pr->wi);
    }
    p=head;
    do{
    if(p->state=='W')
    if(m==3){
        printf("%s\t%c\t%d\t%d\t%4.2f\t%s\n",
        p->name,p->state,p->ts,p->ntime,p->super,p->resource);
    }
    else{
        printf("%s\t%c\t%d\t%d\t%s\n",
        p->name,p->state,p->ts,p->ntime,p->resource);
    }
    p=p->link;
    }while(p!=NULL);
    p=head;
    do{
        if(p->state=='F')
        if(m==3){
            printf("%s\t%c\t%d\t%d\t%4.2f\t%s\t%d\t%d\t%4.2f\t%4.2f\n",
            p->name,p->state,p->ts,p->ntime,p->super,p->resource,p->tb,p->tc,p->ti,p->wi);
        }
        else{
            printf("%s\t%c\t%d\t%d\t%s\t%d\t%d\t%4.2f\t%4.2f\n", p->name,p->state,p->ts,p->ntime,p->resource,p->tb,p->tc,p->ti,p->wi);
        }
        p=p->link;
    }
        while(p!=NULL);
}

void last(){
eti/=n;ewi/=n;
printf("\neti=%7.3f\tewi=%7.3f\n",eti,ewi);
}
super(){
    JCB *padv;
    padv=head;
    do{
        if(padv->state=='W'&&padv->ts<=time) padv->super=(float)(time-padv->ts+padv->ntime)/padv->ntime; padv=padv->link;
    }
    while(padv!=NULL);
}


void hrn(int m){
    JCB *min;
    int i,iden;
    for(i=0;i<n;i++){
        p=min=head;iden=1;
        super();
        do{
            if(p->state=='W'&&p->ts<=time)
            if(iden){
            min=p;iden=0;
            }
            else if(p->super>min->super) min=p;
            p=p->link;
        }
        while(p!=NULL);
        if(iden) {
            i--;time++;
            printf("\ntime=%d:\tno JCB submib...wait...",time); 
            if(time>1000)
            {
                printf("\nruntime is too long...error...");getch();
                } 
        }
        else{
            running(min,m);
        }
    }
}


void sjf(int m){
    JCB *min;
    int i,iden;
    for(i=0;i<n;i++){
        p=min=head;iden=1;
        do{
            if(p->state=='W'&&p->ts<=time)
            if(iden){
            min=p;iden=0;
            }
            else if(p->ntime<min->ntime) min=p;
            p=p->link;
        }
        while(p!=NULL) ;
        if(iden) {
            i--;printf("\ntime=%d:\tno JCB submib...wait...",time);time++;
            if(time>100){printf("\nruntime is too long...error");getch();}
        }
        else{
            running(min,m);
        }
    }
}

fcfs(int m){
    int i,iden;
    printf("\n\nthe jcb is runing...");
    for(i=0;i<n;i++){
        p=head;iden=1;
        do{
            if(p->state=='W'&&p->ts<=time)	iden=0;
            if(iden)p=p->link;
        }
        while(p!=NULL&&iden) ;
        if(iden) {
            i--;printf("\ntime=%d:\tno JCB submib...wait...",time);time++;
            if(time>100){printf("\nruntime is too long...error");getch();}
        }
        else{
            running(p,m);
        }
    }
}


void running(JCB *p,int m){
    p->tb=time;p->state='R';
    p->tc=p->tb+p->ntime;
    p->ti=(float)(p->tc-p->ts);
    p->wi=(float)(p->ti/p->ntime);
    eti+=p->ti;
    ewi+=p->wi;
    print(p,m);
    time+=p->ntime;
    p->state='F';
    printf("\n%s has been finished!\npress any key to continue...\n",p->name); getch();
}

void runjcb(int m){
    printf("\n\nstart running jcb...");
    switch(m){
        case 1:fcfs(m);break;
        case 2:sjf(m);break;
        case 3:hrn(m);break;
        default:printf("\nrunjcb error...\n");exit(0);
        }
}


fileway(){
    printf("\nadopts the file way to input the datas...y/n:") ;
    if(getch()=='y') fileinput();
    else inital();
}

start(){
    int m;
    char str[100]="\nselect algorithm\n1.FCFS\n2.SJF\n3.HRN\n" ;
    printf("%s",str);
    m=getch()-48;
    fileway();
    if(1<=m&&m<=3) runjcb(m);
    else {
        printf("\nselect error!try again...\n");
        start();
    }
    last();
}


main()
{
    start(); printf("\nfinished!");
    getch();
}

