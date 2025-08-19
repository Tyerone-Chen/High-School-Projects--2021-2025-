/*
    Author; Tyerone Chen
    Update Date; 9/17/2024
    Desc; U4A2 Time Conversion
*/


#include <iostream>
#include <string>
#include <vector>

using namespace std;


// Notes to self 
/*
* We only care about the hour time, the minutes we can save for later and readd it in
* I will only need to read it to check for that it either has a ";", is the length of 3 or a length of 4
* If it is a ";" but they added to many numbers, i can just check that the length is over 5
* If the time enterd in the 24 hour is anything less than 13 hours itll be the smae
*/


//formqqting the time seemlessly function
// we're using vectors ;]
string formatTime(string input_time) {
    // Loop which will remove ";"
    vector<char> vector_time(input_time.begin(), input_time.end());
    auto vector_index = vector_time.begin();
    while (vector_index != vector_time.end()) {
        if (*vector_index == ':') {
            vector_index = vector_time.erase(vector_index);
        }
        else {
            vector_index++;
        }
    }

    // Removes any values beyond an index of 4 to keep it formatted to be like "0000"
    if (vector_time.size() >= 4) {
        vector_time.erase(vector_time.begin() + 4, vector_time.end());
    }
    // If the inpout isn only 3 indexs loing, itll add a "0" to the front
    else if (vector_time.size() <= 3) {
        while (vector_time.size() < 4) {
            vector_time.insert(vector_time.begin(), '0');
        }
    }

    // return var
    string formated_time(vector_time.begin(), vector_time.end());

    return formated_time;
}

string colonTime(string input_time) {
    // Loop which will remove ";"
    vector<char> vector_time(input_time.begin(), input_time.end());
    auto vector_index = vector_time.begin();

    // Removes any values beyond an index of 4 to keep it formatted to be like "0000"
    if (vector_time.size() >= 4) {
        vector_time.erase(vector_time.begin() + 4, vector_time.end());
    }
    // If the inpout isn only 3 indexs loing, itll add a "0" to the front
    else if (vector_time.size() <= 3) {
        while (vector_time.size() < 4) {
            vector_time.insert(vector_time.begin(), '0');
        }
    }
    // readds the colon at index 2
    vector_time.insert(vector_time.begin() + 2, ':');

    // return var
    string formated_time(vector_time.begin(), vector_time.end());

    return formated_time;
}


// 24 to 12 func
string convert24To12(string input_time) {
    //variable def
    static string converted_time = "";
    static string am_or_pm = " A.M.";

    // Converts the input string into a int
    int int_time = stoi(formatTime(input_time));

    // Checks to see what the value of the time to see what specific calculations it needs to do
    if (int_time >= 1200 && int_time < 2400) {
        if (int_time >= 1200 && int_time < 1300) {
            am_or_pm = " P.M.";
            converted_time = to_string(int_time) + am_or_pm;
        }
        else {
            am_or_pm = " P.M.";
            converted_time = to_string(int_time - 1200) + am_or_pm;
        }
    }
    else if (int_time >= 0000 && int_time < 1200) {
        if (int_time >= 0000 && int_time < 0100) {
            am_or_pm = " A.M.";
            converted_time = to_string(int_time + 1200) + am_or_pm;
        }
        else {
            am_or_pm = " A.M.";
            converted_time = to_string(int_time) + am_or_pm;
        }
    }

    return colonTime(converted_time);
}


// 12 to 24 func
string convert12to24(string input_time, string am_or_pm) {
    //variable def
    static string converted_time = "";

    // Converts the input string into a int
    int int_time = stoi(formatTime(input_time));

    // Checks to see what the Am Pm thing is to see what to do
    if (am_or_pm == "1") {
        // Further checks if it is 1200 to make more specific changes
        if (int_time < 1200) {
            converted_time = to_string(int_time);
        }
        else {
            converted_time = to_string(int_time - 1200);
        }
    }
    else if (am_or_pm == "2") {
        if (int_time < 1200) {
            converted_time = to_string(int_time + 1200);
        }
        else {
            converted_time = to_string(int_time);
        }
    }

    return colonTime(converted_time);
}


int main()
{
    // Variable Definition
    string user_input;
    string time_converted = "";

    do {
        // Clears the var at the start of the do while for safety
        user_input = "";

        // Prompts user for an input showing options
        cout << "Please Enter Which Option To Choose: " << endl;
        cout << "[1] Convert 24 Hour to 12 Hour" << endl;
        cout << "[2] Convert 12 Hour to 24 Hour" << endl;
        cout << "[-1] Quit Program" << endl << endl;

        cin >> user_input;
        
        if (user_input == "1") {
            // Clears the var at the start of the do while for safety
            user_input = "";
            time_converted = "";

            cout << "Please Input the Time: " << endl << endl;
            cin >> user_input;

            //convert24To12(user_input);

            time_converted = convert24To12(user_input);
            cout << endl << "Your Converted Time is: " << time_converted << endl << endl;
        }

        else if (user_input == "2") {
            // Clears the var at the start of the do while for safety
            user_input = "";
            time_converted = "";
            string sub_time = "";
            
            do {
                // Clears the var at the start of the do while for safety

                // Prompts user for whether the enter time will be AM or PM
                cout << "Are you Entering From A.M. or P.M." << endl;
                cout << "[1] A.M." << endl;
                cout << "[2] P.M." << endl << endl;

                cin >> sub_time;
            }
            while (sub_time != "1" && sub_time != "2");

            cout << "Please Input the Time: " << endl;
            cin >> user_input;

            time_converted = convert12to24(user_input, sub_time);
            cout << endl << "Your Converted Time is: " << time_converted << endl << endl;
        }
    }

    while (user_input != "-1");
}