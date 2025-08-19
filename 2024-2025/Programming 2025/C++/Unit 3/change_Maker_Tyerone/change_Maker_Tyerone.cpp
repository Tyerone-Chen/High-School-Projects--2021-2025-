/*
    Author: Tyerone Chen
    Update Date: 9/11/2024
    Desc: Determines The Amount of Change a person would havejhsdfgAAA
*/


// change_Maker_Tyerone.cpp : This file contains the 'main' function. Program execution begins and ends there.


#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main()
{
    // Variable Defin
    float input_change = 0;
    int dollar_amnt, quarter_amnt, dime_amnt, nickel_amnt, penny_amnt;
    
    // Grabbing User Input
    cout << "Please Input Your Change: ";
    cin >> input_change;
    input_change *= 100;

    // Deterimens the amount of change the user haves
    // First starts off with the dollar, i.e single digits
    dollar_amnt = input_change / 100;
    cout << "Dollars: " << dollar_amnt << endl;
    input_change = input_change - (100 * dollar_amnt); 

    // Next Quarters
    quarter_amnt = input_change / 25;
    cout << "Quarters: " << quarter_amnt << endl;
    input_change = input_change - (25 * quarter_amnt);

    // The Dimes
    dime_amnt = input_change / 10;
    cout << "Dimes: " << dime_amnt << endl;
    input_change = input_change - (10 * dime_amnt);

    // The Nicke;s
    nickel_amnt = input_change / 5;
    cout << "Nickels: " << nickel_amnt << endl;
    input_change = input_change - (5 * nickel_amnt);

    // lastly peenys
    penny_amnt = input_change / 1;
    cout << "Pennies: " << penny_amnt << endl;
}