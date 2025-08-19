/*
    Author: Tyerone CHen    
    Update Date: 9/17/2024
    Desc: Dog Groomer Assign
*/

// notes to self
// make a 2d vector array: rows is the vector, columns should be the arrays
// Should be ? vecotr lenght and 4 array length

#include <iostream>
#include <string>
#include <array>
#include <vector>

using namespace std;

// Global Vars
vector <array <string, 4>> vector_dog;
int dog_id = 1;


void addDogInfo(string input_name, int input_weight) {
    // Thing
    string dog_cost;
    string dog_thingy = to_string(dog_id);

    // Determine shte dog cost based on weight
    if (input_weight <= 20) {
        dog_cost = "$40.00";
    }
    else if (input_weight <= 40) {
        dog_cost = "$60.00";
    }
    else if (input_weight <= 80) {
        dog_cost = "$70.00";
    }
    else {
        dog_cost = "$100.00";
    }

    // adds all that data into a array, i used a moder array setup to be more consistant to vectors :]
    array <string, 4> dog_row = {dog_thingy, input_name, to_string(input_weight), dog_cost};
    // adds that array into the vector
    vector_dog.push_back(dog_row);
    dog_id++;
}


void displayDatabase(vector <array <string, 4>> input_vector) {
    int vector_length = vector_dog.size();

    for (int row = 0; row < vector_length; row++) {
        // Initially prints out the dag id stuff
        cout << endl << "Here is the Info for [Dog #" << vector_dog[row][0] << "]: ";
        cout << endl << "Dog ID: [" << vector_dog[row][0] << "]";
        cout << endl << "Dog Name: [" << vector_dog[row][1] << "]";
        cout << endl << "Dog Weight(LBS): [" << vector_dog[row][2] << "]";
        cout << endl << "Cost To Groom Dog: [" << vector_dog[row][3] << "]" << endl;
    }
    cout << "////////////////////////////////////////////////////////////" << endl;
}

int main()
{
    // variable def
    string user_input;

    do {
        user_input = "";

        // ui stuff nad input grabber
        cout << endl << "Welcome to the Dog Groomer Database" << endl << "Please Enter Your Input" << endl << endl;
        cout << "[1] Input Dog Info" << endl << "[2] Display out Dog Database" << endl << "[-1] Exit Program" << endl << endl;
        cin >> user_input;
        cout << "////////////////////////////////////////////////////////////" << endl;

        // If the user wants to add new dog data
        if (user_input == "1") {
            // Declares and Innit the input vars
            string input_dog = " ";
            string input_weight = " 2";

            // Ui stuff and info grabber
            cout << endl << "Please Enter Dog Name: ";
            cin >> input_dog;

            cout << endl << "Please Enter Dog Weight(LBS): ";
            cin >> input_weight;

            addDogInfo(input_dog, stoi(input_weight));

            cout << endl << "Dog Data Added!" << endl;
            cout << "////////////////////////////////////////////////////////////" << endl;
        }
        // Else if the user wants to display the data
        else if (user_input == "2") {
            cout << endl << "Here is the Database!: " << endl;

            displayDatabase(vector_dog);
        }
    } 
    while (user_input != "-1");
}


