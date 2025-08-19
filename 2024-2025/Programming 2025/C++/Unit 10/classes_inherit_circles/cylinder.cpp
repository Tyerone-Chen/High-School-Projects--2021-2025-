/*
	Author: Tyerone Chen
	Update Date: 9/26/2024
	Desc: cylinder class .cpp file
*/

#define _USE_MATH_DEFINES

#include "cylinder.h"
#include <iostream>

#include <cmath>
#include <math.h>

#include <string>

using namespace std;

// overload operator 


ostream& operator << (ostream& os_obj, cylinder& cylinder_obj) {
	os_obj << "Here's the Radius: " << cylinder_obj.getRadius() << endl << "Here's the Height: " << cylinder_obj.getHeight();

	return os_obj;
}

// TWo classes needed,  the left one, "this", and the right one, "that"
// COmbines the two cylinders radius and heights, then adds the radius and height to return the total
double cylinder::operator + (cylinder& cylinder_obj) {
	double total_radius = this->getRadius() + cylinder_obj.getRadius();
	double total_height = this->getHeight() + cylinder_obj.getHeight();
	double total = total_radius + total_height;

	return total;
}

// place in the "++" operator first, then the object
// ex: ++cylinder_obj;
// INcrements up the cylinder height and radius
void operator ++ (cylinder& cylinder_obj) {
	cylinder_obj.setRadius(cylinder_obj.getRadius() + 1);
	cylinder_obj.setHeight(cylinder_obj.getHeight() + 1);
}

bool cylinder::operator == (cylinder& cylinder_obj) {
	double my_radius = this->getRadius();
	double my_height = this->getHeight();
	double that_radius = cylinder_obj.getRadius();
	double that_height = cylinder_obj.getHeight();

	if (my_radius == that_radius && my_height == that_height) {
		return true;
	}
	return false;
}

// constructors
cylinder::cylinder(): circle(0.0){
	height = 0.0;
	radius = 0.0;
}

cylinder::cylinder(double in_height, double in_radius) : circle(in_radius) {
	height = in_height;
	radius = in_radius;
}

//// funcs
// height stuff
double cylinder::getHeight() {
	return height;
}


void cylinder::setHeight(double in_height) {
	height = in_height;
}


//printers
void cylinder::printHeight() {
	cout << "Height of Cylinder: " << height << endl;
}


void cylinder::printCylArea() {
	double area = (2 * M_PI * radius) + (2 * M_PI * pow(radius, 2));
	cout << "Area of Cylinder: " << area << endl;
}


void cylinder::printCylVolume() {
	double volume = (M_PI) * pow(radius, 2) * (height);
	cout << "Volume of Cylinder: " << volume << endl;
}