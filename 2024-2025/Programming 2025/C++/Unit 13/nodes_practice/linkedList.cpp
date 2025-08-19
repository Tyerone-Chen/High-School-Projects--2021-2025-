#include "linkedList.h"

//** COnstructors
linkedList::linkedList() {
	head = NULL;
	last = NULL;
	list_size = 0;
}

// Innitia w/first item
linkedList::linkedList(linkedNodes* input_node) {
	head = input_node;
	last = input_node;
	list_size = 1;
}
	

//** Getters & Setters
linkedNodes* linkedList::getHead() {
	return head;
}

linkedNodes* linkedList::getLast() {
	return last;
}

int linkedList::getSize() {
	return list_size;
}

void linkedList::setHead(linkedNodes* input_head) {
	head = input_head;
}
void linkedList::setLast(linkedNodes* input_node) {
	last = input_node;
}
void linkedList::setSize(int input_size) {
	list_size = input_size;
}


void linkedList::addItemEnd(linkedNodes* input_node) {
	if (list_size == 0) {
		head = input_node;
	}
	else {
		// Modify Link of Last Node the Update it 
		last->setLink(input_node);
	}
	last = input_node;
	list_size++;
}

string linkedList::traverseList() {
	linkedNodes* current = head;
	string return_string;

	while (current != NULL) {
		return_string += current->getInfo();
		current = current->getLink();
	}

	return return_string;
}


string linkedList::pigLatinTranslation() {
	string translated_word = traverseList();
	char first_char = tolower(head->getInfo());
	char second_char = head->getLink()->getInfo();
	char last_char = tolower(last->getInfo());

	if (first_char ==  'a' || first_char == 'e' || first_char == 'i' || first_char == 'o' || first_char == 'u') {
		translated_word += "way";
	}
	else
	{
		if (second_char == 'a' || second_char == 'e' || second_char == 'i' || second_char == 'o' || second_char == 'u') {
			translated_word.erase(0, 1);
			translated_word += first_char;
			translated_word += "ay";
		}
		else {
			translated_word.erase(0, 2); 
			translated_word += first_char;
			translated_word += second_char;
			translated_word += "ay";
		}
	}

	if (last_char == '!' || last_char == '?' || last_char == '.') {
		int index = translated_word.find(last_char);

		if (index != string::npos) {
			translated_word.erase(index, 1);
		}

		translated_word += last_char;
	}

	return translated_word;
}