/*
	Author: Tyerone Chen
	Update Date: 9/25/2024
	Desc: circle class .h file
*/

#pragma once
#include <iostream>

using namespace std;

class circle
{
private:
	double radius;

protected:


public:
	// Constructors
	circle();

	circle(double radius);

	//// funcs
	// radius stuff
	double getRadius();
	void setRadius(double radius);

	//printing stuff
	void printCircleArea();
	void printRadius();


	// Overload Operators
	friend ostream& operator << (ostream&, circle&);

	bool operator == (circle&);

};

