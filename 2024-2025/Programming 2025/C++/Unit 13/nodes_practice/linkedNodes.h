#pragma once

#include <iostream>

using namespace std;

class linkedNodes
{
private:
	char _info;
	linkedNodes* _link;

public:
	linkedNodes();
	linkedNodes(char, linkedNodes*);

	char getInfo();
	linkedNodes* getLink();

	void setInfo(char);
	void setLink(linkedNodes*);
};

