// ex1.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "ex1.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif


/////////////////////////////////////////////////////////////////////////////
// The one and only application object
void ThreadName1();
static HANDLE hHandle1 = NULL;
DWORD dwThreadID1;

CWinApp theApp;

using namespace std;

int _tmain(int argc, TCHAR* argv[], TCHAR* envp[])
{
	int nRetCode = 0;

	hHandle1 = CreateThread((LPSECURITY_ATTRIBUTES) NULL,
		0,
		(LPTHREAD_START_ROUTINE) ThreadName1,
		(LPVOID) NULL,
		0,
		&dwThreadID1);
	Sleep(5000);
	CloseHandle(hHandle1);
	ExitThread(0);

	return nRetCode;
}

void ThreadName1(){
	printf("Thread is Running!\n");
}


