/*
	Author: Tyerone Chen
	Update Date: 9/27/2024
	Desc: cylinder class .h file
*/

#pragma once

#include "circle.h" 

class cylinder : public circle
{
private:
	double height;
	double radius;


protected:


public:
	//// funcs
	//height stuff
	double getHeight();
	void setHeight(double height);

	//printing stuff
	void printHeight();
	// SInce it inherits circle.h, the printRadius() func should be inhereted
	void printCylArea();
	void printCylVolume();

	// constructor
	cylinder();
	cylinder(double height, double radius);
};

