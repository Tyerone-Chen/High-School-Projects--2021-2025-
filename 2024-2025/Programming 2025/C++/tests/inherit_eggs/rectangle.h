#pragma once

#include "shape.h" // necessary for inheritance
#include <string>

class rectangle : public shape // Inherated the shape class
{
private:
	double length;
	double width;

protected:


public:
	double getLength();
	void setLength(double length);

	double getWidth();
	void setWidth(double width);

	double calcArea(); // ref base class

	//// Constructors
	rectangle();
	rectangle(double l, double w, string c = "black");
};

