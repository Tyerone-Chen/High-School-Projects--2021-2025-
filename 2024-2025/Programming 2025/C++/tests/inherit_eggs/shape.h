#pragma once

#include <string>

//// Parent Class

using namespace std;

class shape
{

private:
	double area;
	int number_of_sides;
	int interior_angle;
	string shape_name;

protected:
	string shape_color;

public:
	double getArea();
	void setArea(double area);

	int getNumSides();
	void setNumSides(int sides);

	int getInteriorAngle();
	void setInteriorAngle(int interior_angle);

	string getShapeName();
	void setShapeName(string shape_name);

	void calcArea();

	//// Constructorss
	shape();
	shape(double a, int s, int ia = 0, string sn, string c = "");
};

