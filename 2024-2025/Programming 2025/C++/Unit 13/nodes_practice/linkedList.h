#pragma once

#include <iostream>
#include "linkedNodes.h"

class linkedList
{
private:
	linkedNodes* head = NULL;
	linkedNodes* last = NULL;
	int list_size = 0;

public:
	//** COnstructors
	linkedList();
	linkedList(linkedNodes* inpit_node); // Innitia w/first item

	//** Getters & Setters
	linkedNodes* getHead();
	linkedNodes* getLast();
	int getSize();

	void setHead(linkedNodes*);
	void setLast(linkedNodes*);
	void setSize(int list_size);

	void addItemEnd(linkedNodes*);

	string traverseList();
	string pigLatinTranslation();
};

