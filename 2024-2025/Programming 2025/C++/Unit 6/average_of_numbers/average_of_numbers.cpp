/*
    Author: Tyerone Chen
    Update Date: 9/19/2024
    Desc: Avg of Numbers..
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;


// Print List ffunc
float avgOfNumbers(vector <float> vector_input) {
    auto vector_length = vector_input.size();
    float total_amount = 0;
    float avg_number = 0;

    for (int i = 0; i < vector_length; i++) {
        total_amount += vector_input[i];
    }

    avg_number = total_amount / vector_length;
    return avg_number;
}


int main()
{
    string user_input = "";
    do {
        user_input = "";

        // prompts user for input
        cout << endl << "Welcome to Average Number Finder:" << endl;
        cout << "Please Select An Option" << endl;
        cout << "[1] Find Average of Numbers" << endl;
        cout << "[~] Exit Program" << endl << endl;
        cin >> user_input;

        if (user_input == "1") {

            // Vector creation + Var Creations
            vector <float> vector_numbers;
            int array_length = 0;
            int index = 1;

            // prompts for vector length
            do {
                cout << endl << "How Many Numbers Are You Averaging?: ";
                cin >> array_length;
            } while (array_length <= 0);



            while (vector_numbers.size() != array_length) {
                string num_input = "";
                cout << endl << "Please Enter Int #" << index << ": ";
                cin >> num_input;

                vector_numbers.push_back(stof(num_input));
                index++;
            }

            float average = avgOfNumbers(vector_numbers);

            cout << endl << "Here is the Average of the " << (index - 1) << " Numbers: " << average << endl;
        }

    } while (user_input != "~");
}

