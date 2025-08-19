/*
	Author: Tyerone Chen
	Date:  10/14/2024
	Desc: Searching Function  .h File
*/


#pragma once

#include<iostream>
#include <vector>


using namespace std;

class searchingFunctions
{
private:
	vector<int> input_vector;


public:
	//** Constructors
	searchingFunctions();
	searchingFunctions(vector<int> user_vector);


	//** Function Decalre
	// Searching ALghorithm
	int binarySearch(int input_search);
};

