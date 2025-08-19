// hot_chocolate.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <cmath>


using namespace std;
int main()
{
    int num = 2;
    do {
        num = num * num * num * num;
        cout << num;
    } while (num != -1);
    std::cout << "Hello World!\n";
}

