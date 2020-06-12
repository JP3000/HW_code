//philosopherDining.cpp: Defines the entry point for the console application
//#include "windows.h"
//#include<process.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

#include <iostream>
using namespace std;

const unsigned int PHILOSOPHER_NUM = 5;
const char THINKING = 1;
const char HUNGRY = 2;
const char DINING = 3;

//each fork has a semaphore
HANDLE mutex ;
void philosopherProc(void* param);
int main(int argc, char* argv[])
{
    int i;
    srand(time(0));

    mutex = CreateMutex(NULL, false, NULL);
    for(i = 0; i < PHILOSOPHER_NUM; i++)
    {
        semph[i] = CreateSemaphore(NULL, 1, 1, NULL);
        _beginthread(philosopherProc, 0, (void*) & i);
        Sleep(10);
    }

    Sleep(2000);
    return 0;
}
void philosopherProc(void* param); 
{
    int myid;
    char idStr[128];
    char stateStr[128];
    char mystate;
    int ret;
    unsigned int leftFork;
    unsigned int rightFork;

    myid = *((int*)(Param));
    itoa(myid, idStr, 10);

    cout << " philosopher " << myid << " begin...... " << endl;
    Sleep(10);

    //initial state is THINKING
    mystate = THINKING;
    leftFork = (myid) % PHILOSOPHER_NUM;
    rightFork = (myid + 1) % PHILOSOPHER_NUM;

    while(true)
    {
        switch(mystate)
        {
            case THINKING;
            //changing my state
            mystate = HUNGRY;
            strcpy(stateSrt, " HUNGRY ");
            break;

            case HUNGRY;
            strcpy(stateStr," HUNGRY ");
            //first test the left fork...
            ret = WaitForSingleObject(semph[leftFork], 0);
            if(ret == WAIT_OBJECT_0)
            {
                //left fork is ok, take it up!
                //then test the right fork...
                ret = WaitForSingleObject(semph[leftFork], 0);
                if(ret == WAIT_OBJECT_0)
                {
                    //right fork is also ok!
                    //changing my state
                    mystate = DINING;
                    strcpy(stateStr, " DINING ");
                }
                else
                {
                    //right fork is being used by others, so I must put down the left fork
                    ReleaseSemaphore(semph[leftFork], 1, NULL);   
                }
            }
            break;

            case DINING;
            //put down both the left and right fork
            ReleaseSemaphore(semph[leftFork], 1, NULL);
            ReleaseSemaphore(semph[rightFork], 1, NULL);

            //changing my state
            mystate = THINKING;
            strcpy(stateStr, " THINKING ");
            break;
        }

        //print my state
        WaitForSingleObject(mutex, INFINITE);
        cout << " philosopher " << myid << "is :" << stateStr << endl;
        ReleaseMutex(mutex);

        //sleep a random time: between 1 - 5 s
        int sleepTime;
        sleepTime = 1 + (int)(5.0 * rand() / (RAND_MAX + 1.0));
        Sleep(sleepTime * 10);
    }
}
