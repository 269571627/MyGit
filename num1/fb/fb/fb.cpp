

#include "pch.h"
#include <iostream>

#include<stdio.h>
using namespace std;
int f(int n)
{
	int y;
	if (n == 1 || n == 2)
	{
		y = 1;
	}
	else
	{
		y = f(n - 1) + f(n - 2);
	}
	return y;
}
int main()
{
	int n;
	cout << "输入项数";
		cin>> n;

	cout << "对应值为" << f(n);
	return 0;
}
