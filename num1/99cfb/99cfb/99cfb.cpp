#include"pch.h"

#include <iostream>
#include <iomanip>
#include <cstdio>


using namespace std;
void n1()
{
	int i = 0;
	int j = 0;
	int result;
	for (i = 1; i < 10; i++)
	{
		for (j = 1; j < 10; j++)
		{
			cout << i << "*" << j << "=" << i * j;
		}

		cout << endl;
	}
}
void n2()
{
	for (int i = 1; i < 10; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			cout << i << "*" << j << "=" << i * j;
		}

		cout << endl;
	}
}
void n3()
{
	for (int i = 1; i < 10; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			cout << setw(4) << i << "*" << j << "=" << setw(2) << i * j << setw(4);
		}

		cout << endl;
	}
}
int main(void)
{
	n1();
	cout << endl;
	n2();
	cout << endl;
	n3();
	return 0;
}
