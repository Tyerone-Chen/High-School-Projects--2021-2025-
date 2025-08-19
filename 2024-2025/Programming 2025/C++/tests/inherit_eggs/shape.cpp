#include "shape.h"

//constructors
shape::shape() {
	area = 0;
	number_of_sides = 0;
	interior_angle = 0;
	shape_name = "N/A";
	shape_color = "N/A";
}


shape::shape(double a, int s, int ia = 0, string sn, string c = "") {
	area = a;
	number_of_sides = s;
	interior_angle = ia;
	shape_name = sn;
	shape_color = c;
}