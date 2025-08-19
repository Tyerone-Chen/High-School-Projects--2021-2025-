/*
	Author: Tyerone Chen
	Update Date: 9/25/2024
	Desc: circle class .h file
*/

#pragma once

class circle
{
private:
	double radius;

protected:


public:
	//// funcs
	// radius stuff
	double getRadius();
	void setRadius(double radius);

	//printing stuff
	void printCircleArea();
	void printRadius();

	// Constructors
	circle();

	circle(double radius = 0.0);
};

