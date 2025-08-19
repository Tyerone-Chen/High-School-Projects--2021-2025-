#include "linkedNodes.h"


//** Functions
// Getters & Setters
char linkedNodes::getInfo() {
	return _info;
}


linkedNodes* linkedNodes::getLink() {
	return _link;
}


void linkedNodes::setInfo(char input_info) {
	_info = input_info;
}


void linkedNodes::setLink(linkedNodes* input_link) {
	_link = input_link;
}


//** Constructors
linkedNodes::linkedNodes() {
	_info = '-';
	_link = NULL;
}

linkedNodes::linkedNodes(char input_info, linkedNodes* input_link) {
	_info = input_info;
	_link = input_link;
}