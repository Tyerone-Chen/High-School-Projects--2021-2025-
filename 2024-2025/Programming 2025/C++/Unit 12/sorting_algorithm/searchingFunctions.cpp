/*
	Author: Tyerone Chen
	Date:  10/14/2024
	Desc: Searching Function.cpp File
*/

#include "searchingFunctions.h"

//** Constructors
searchingFunctions::searchingFunctions() {
	input_vector = {};
}

searchingFunctions::searchingFunctions(vector<int> user_vector) {
	input_vector = user_vector;
}


//** Functions
//// Searching Algorithm
/*
Binary Search Algorithm
	Return Value -  int
	Parameter Value(s) - int
*/
int searchingFunctions::binarySearch(int input_search) {
	int left_value = 0;
	int right_value = input_vector.size() - 1;

	do {
		int calc_mid = left_value + ((right_value + left_value) / 2);

		if (input_vector[calc_mid] == input_search) {
			return calc_mid;
		}
		else if(input_vector[calc_mid] < input_search){
			left_value = calc_mid + 1;
		}
		else {
			right_value = calc_mid - 1;
		}
	} while (left_value <= right_value);
	// Returns -42 if the input value was not found in the data
	return -42;
}