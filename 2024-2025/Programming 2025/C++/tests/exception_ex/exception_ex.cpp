/*
    Author: Tyerone Chen
    zDate: 10/9/2024        
    Desc: thingy
*/

#include <iostream>
#include <string>

using namespace std;

int main()
{
    cout << "Heres a test thing";

    string user_input;
    int dividend, divisor, quotient;
    dividend = 0;

    do {
        try {
            cout << "Enter a Number: ";
            cin >> user_input;
            dividend = stoi(user_input);
            cout << endl;

            if (dividend ==  42) {
                throw "Error, Cannot Compute the Answer to Everything";
            }
        }
        catch (...) {
            cout << "Something Went Wrong...";
       }

    } while (dividend != -1);
}


