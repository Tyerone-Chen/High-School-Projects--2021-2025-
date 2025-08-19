#include "sortingFunctions.h"

//** Constructors
sortingFunctions::sortingFunctions() {
	input_vector = {};
}

sortingFunctions::sortingFunctions(vector<int> user_vector) {
	input_vector = user_vector;
}


/*
	Author: Tyerone Chen
	Date:  10/14/2024
	Desc: Sorting Functions .cpp FIle
*/


//** Functions
//// Sorting Algorithm
/*
Insertion Sort Algorithm
*/
void sortingFunctions::insertionSort() {
	for (int index = 0; index < input_vector.size(); index++) {
		int compare_index = index;
		while (compare_index  != 0 && input_vector[compare_index - 1] > input_vector[compare_index]) {
			swap(input_vector[compare_index - 1], input_vector[compare_index]);
			compare_index--;
		}
	}
}

/*
Bubble Sort Algorithm
*/
void sortingFunctions::bubbleSort() {
	bool has_swapped;
	do {
		has_swapped = false;

		for (int index = 0; index < input_vector.size(); index++) {
			if (input_vector[index] > input_vector[index + 1]) {
				swap(input_vector[index], input_vector[index + 1]);
				has_swapped = true;
			}
		}
	} while (has_swapped != false);
}


// Cout Stuff
void sortingFunctions::printVector() {
	for (int index : input_vector) {
		cout << index << ", ";
	}
	cout << endl;
}