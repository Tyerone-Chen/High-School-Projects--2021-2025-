/*
    Auhtor: Tyerone Chen
    Update Date: 9/16/2024
    Desc: Enumuration Example
*/

#include <iostream>

using namespace std;

int main()
{
    // Variables Def
    enum pet_type {DOG, CAT, HAMSTER, ALLIGATOR, BIRD, PIG, SPIDER, LIZARD, GECKO, OTHER};

    string user_input;
    enum pet_type curr_type = OTHER;

    int dog_count = 0, cat_count = 0, hamster_count = 0, alligator_count = 0, bird_count = 0, 
        spider_count = 0, lizard_count = 0, gecko_count = 0, other_count = 0;

    // cout stuff
    cout << "Begin Entering all Class Pets" << endl
        << "EX: Dog, Cat, Hamster, Alligator, Bird, Pig, Spider, Lizard, Gecko, Other" << endl
        << "[Enter -1 to Exit Program]" << endl << endl;

    do {
        user_input = "";

        cout << "Please Enter your Input: " << endl;
        cin >> user_input;

        if (user_input == "dog") {
            curr_type = DOG;
        }
        else if (user_input == "cat") {
            curr_type = CAT;
        }
        else if (user_input == "hamster") {
            curr_type = HAMSTER;
        }
        else if (user_input == "alligator") {
            curr_type = ALLIGATOR;
        }
        else if (user_input == "bird") {
            curr_type = BIRD;
        }
        else if (user_input == "pig") {
            curr_type = PIG;
        }
        else if (user_input == "spider") {
            curr_type = SPIDER;
        }
        else if (user_input == "lizard") {
            curr_type = LIZARD;
        }
        else if (user_input == "gecko") {
            curr_type = GECKO;
        }
        else {
            curr_type = OTHER;
        }
    }

    while (user_input != "-1");
}
