//哲学家就餐问题的解法
#include <windows.h>
#include <process.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <iostream>

using namespace std;

const unsigned int PHILOSOPHER_NUM = 5; //哲学家数目
/*标记当前哲学家状态，１表示等待，２表示得到饥饿，３表示正在吃饭*/
const char THINKING = 1;
const char HUNGRY = 2;
const char DINING = 3;

HANDLE hPhilosopher[5]; //定义数组存放哲学家
/*HANDLE(句柄)是windows操作系统中的一个概念．指的是一个核心对象在某一个进程中的唯一索引*/
HANDLE semaphore[PHILOSOPHER_NUM]; //semaphore用来表示筷子是否可用
HANDLE mutex; //Mutex用来控制安全输出
DWORD WINPAI philosopherProc(LPVOID 1pParameter)
{
    int myid;
    char idStr[128];
    char stateStr[128];
    char mystate;
    int ret;

    unsigned int leftFork;
    unsigned int rightFork;
    myid = int(1pParameter);
    itoa(myid, idStr, 10);

    WaitForSingObject(mutex, INFINITE);
    cout << "philosopher " << myid << "begin......" << endl;
    ReleaseMutex(mutex);

    mystate = THINKING;
    leftFork = (myid) % PHILOSOPHER_NUM;
    rightFork = (myid + 1) % PHILOSOPHER_NUM;
    while(true)
    {
        switch(mystate)
        {
            case THINKING:
            mystate = HUNGRY;
            strcpy(stateStr, "HUNGRY");
            break;
            case HUNGRY:
            strcpy(stateStr, "HUNGRY");
            ret = WaitForSingleObject(semaphore[leftFork], 0);
            if(ret == WAIT_OBJECT_０)
            {
                ret = WaitForSingleObject(semaphore[rightFork], 0);
                if(ret == WAIT_OBJECT_0)
                {
                    mystate = DINING;
                    strcpy(stateStr, "DINING");
                }
                else
                {
                    ReleaseSemaphore(Semaphore[leftFork], 1, NULL);
                }
            }
            break;
            case DINING:
            ReleaseSemaphore(Semaphore[leftFork], 1, NULL);
            ReleaseSemaphore(Semaphore[rightFork], 1, NULL);
            mystate = THINKING;
            strcpy(stateStr, "THINKING");
            break;
        }
        WaitForSingleObject(mutex, INFINITE);
        cout << "philosopher " << myid << "is: " << stateStr << endl;
        ReleaseMutex(mutex);

        int sleepTime;
        sleepTime = 1 + (int)(5.0 * rand() / (RAND_MAX + 1.0));
        Sleep(sleepTime * 10);
    }
}

int main()
{
    int i;
    srand(time(0));

    mutex = CreateMutex(NULL, false, NULL);
    for(i = 0; i < PHILOSOPHER_NUM; i++)
    {
        semaphore[i] = CreateSemaphore(NULL, 1, 1, NULL);
        hPhilosopher[i] = CreateThread(NULl, 0, philosopherProc, LPVOID(i), CREATE_SUSPENDED, 0);
    }
    for(i = 0; i < PHILOSOPHER_NUM; i++)
        ResumeThread(hPhilosopher[i]);
    Sleep(2000);
    return 0;
}


