/*
	Author: Tyerone Chen
	Date:  10/14/2024
	Desc: Sorting Function Class .h file
*/

#pragma once

#include<iostream>
#include <vector>


using namespace std;

class sortingFunctions
{
private:
	vector<int> input_vector;


public:
	//** Constructors
	sortingFunctions();
	sortingFunctions(vector<int> user_vector);

	//** Function Decalre
	// Sorting Algorithms
	void insertionSort();

	void bubbleSort();

	// Cout Functions
	void printVector();

};

