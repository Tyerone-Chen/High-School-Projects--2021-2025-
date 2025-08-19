/*
	Author: Tyerone Chen
	Update Date: 9/25/2024
	Desc: circle class .cpp file
*/

#define _USE_MATH_DEFINES

#include "circle.h"
#include <iostream>

#include <cmath>
#include <math.h>

#include <string>

using namespace std;

// constructors

circle::circle() {
	radius = 0.0;
}

circle::circle(double in_radius) {
	radius = in_radius;
}

//// Functions 
// the radius getters and setters
double circle::getRadius() {
	return radius;
}


void circle::setRadius(double in_radius) {
	radius = in_radius;
}


// cout things
void circle::printCircleArea() {
	double area = M_PI * pow(radius, 2);

	cout << "Area of Circle: " << area << endl;
}


void circle::printRadius() {
	cout << "Radius of Circle: " << radius << endl;
}