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