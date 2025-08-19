/*
    Author: Tyerone Chen
    Update Date: 9/6/2024
    Desc: A program which displays all prime numbers between 2 - 1000
*/

// prime_numbers_Tyerone.cpp : This file contains the 'main' function. Program execution begins and ends there.


#include <iostream>

using namespace std;

int main()
{
    // Var Defin
    // Set Array length to 170, since i looked it up and google said thats the amount between 2 - 1000
    int prime_array[168];
    int prime_array_index = 0;

    // Nested loop for determining the prime numbers
    // Since we are skipping 1, we are only looking for numbers with 1 divison.
    for (int n = 2; n <= 1000; n++) {
        int divisions = 0;

        for (int d = 2; d <= 1000; d++) {
            if (n % d == 0) {
                divisions++;
            }
        }

        if (divisions == 1) {
            prime_array[prime_array_index] = n;
            prime_array_index++;
        }
    }

    // Print out all values in the array
    // First cout is just for 1, since it is "technically" a prime number, but kinda wierd
    cout << "1, "; 
    for (int i = 0; i < 168; i++) {
        cout << prime_array[i] << ", ";
    }
}