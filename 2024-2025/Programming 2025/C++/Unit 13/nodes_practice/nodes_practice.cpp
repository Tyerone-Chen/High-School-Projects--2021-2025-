#include <iostream>
#include "linkedNodes.h"
#include "linkedList.h"

int main()
{
	string word;

	linkedList pig_latin = linkedList();

	cout << "Do the Thing: ";
	cin >> word;

	for (char letter : word) {
		pig_latin.addItemEnd(new linkedNodes(letter, NULL));
	}

	cout << pig_latin.pigLatinTranslation() << endl;

}


