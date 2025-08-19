/*
    Author: Tyerone Chen
    Update Date: 9/11/2024
    Desc: U4A1 Magazine Assignment 
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Function that removes commas yes i overcomplicated it probably, but idc now lol
string removeCommas(string& input_str) {

    // Converts the string into a vector so that each char value can be modi2fied
    vector<char> vector_string(input_str.begin(), input_str.end());

    //compartes the vector values to see if there is a ',' if so it will remove it :]
    // auto type is necessary as we are dealing with vectors
    auto index = vector_string.begin();
    while (index != vector_string.end()) {
        // checks if any oif the index values is a ','
        if (*index == ',') {
            index = vector_string.erase(index);  // Erase the comma and get the new iterator
        }
        else {
            index++;
        }
    }

    // Converts the vector into the return string
    string result_string(vector_string.begin(), vector_string.end());

    // returns back the uncomma'd string 
    return result_string;
}

int main()
{
    // Variabl;e Definm
    int age, annual_income;
    string gender, marital_status;

    string word = "word";

    // 
    int under_20 = 0, age_20s = 0, age_30s = 0, age_40s = 0, over_50s = 0;
    int count_male = 0, count_female = 0, count_other = 0;
    int count_married = 0, count_unmarried = 0;
    int under_25K = 0, count_50K = 0, count_80K = 0, over_80K = 0;

    // Example of a filed data set
    string input[5][4] = {
        {"57", "male", "n", "1,000,000,000"},
        {"30", "female", "y", "65,000"},
        {"24", "male", "y", "60,000"},
        {"35", "male", "n", "40,000"},
        {"63", "female", "n", "130,000"}
    };

    // loop through each piece of data in the 2d array
    //first we get the ages, they will always have the same index
    for (int row = 0; row < size(input); row++) {
        
        // Check for age
        age = stoi(input[row][0]);

        if (age < 20) {
            under_20++;
        }

        else if (age < 30) {
            age_20s++;
        }

        else if (age < 40) {
            age_30s++;
        }

        else if (age < 50) {
            age_40s++; 
        }

        else{
            over_50s++;
        }

        // Check gender
        string gender = input[row][1];

        if (gender == "male") {
            count_male++;
        }
        else if (gender == "female") {
            count_female++;
        }
        else
        {
            count_other++;
        }


        // check marigital status
        string marital_status = input[row][2];

        if (marital_status == "y") {
            count_married++;
        }
        else {
            count_unmarried++;
        }

        // Check income
        string converted_income = removeCommas(input[row][3]);
        annual_income = stoi(converted_income);

        if (annual_income < 25000) {
            under_25K++;
        }
        else if(annual_income < 50000){
            count_50K++;
        }
        else if (annual_income < 80000) {
            count_80K++;
        }
        else {
            over_80K++;
        }
    }

    // Print out all data
    cout << "Here is the Magazine Data Review" << endl << endl;

    cout << "Here is the Age Demographic Information" << endl;
    cout << "Under 20: " << under_20 << endl;
    cout << "20 - 29: " << age_20s << endl;
    cout << "30 - 39: " << age_30s << endl;
    cout << "40 - 49: " << age_40s << endl;
    cout << "50 and Over: " << over_50s << endl << endl;

    cout << "Here is out Gender Demographic" << endl;
    cout << "Male Demographic: " << count_male << endl;
    cout << "Female Demographic: " << count_female << endl;
    cout << "Other Demographic: " << count_other << endl << endl;

    cout << "Here is the Marital Demographic" << endl;
    cout << "Married Demographic: " << count_married << endl;
    cout << "Not Married Demographic: " << count_unmarried << endl << endl;

    cout << "Annual Income Demographic" << endl;
    cout << "Under 25K: " << under_25K << endl;
    cout << "25K - 49K: " << count_50K << endl;
    cout << "40K - 79K: " << count_80K << endl;
    cout << "Over 80K: " << over_80K << endl;

}