/*
    Author: Tyerone Chen
    Date:  10/14/2024
    Desc: Sorting Algorithm Test
*/

#include <iostream>
#include "sortingFunctions.h"
#include "searchingFunctions.h"

int main()
{
    sortingFunctions insertion_vector(vector<int> {5, 4, 1, 2 , 4, 7, 10, 1});
    sortingFunctions bubble_vector(vector<int> {5, 4, 1, 2, 4, 7, 10, 1});


    insertion_vector.insertionSort();

    insertion_vector.printVector();

    bubble_vector.bubbleSort();

    bubble_vector.printVector();

    searchingFunctions binary_vector(vector<int> {1, 2, 3, 4, 5});
    cout << binary_vector.binarySearch(3);
}

