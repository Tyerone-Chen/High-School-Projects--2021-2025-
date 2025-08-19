#include "rectangle.h"


// constructors

rectangle::rectangle() {

}


rectangle::rectangle(double l, double w, string c = "black") {
	length = l;
	width = w;
	shape_color = c;

	shape::shape(l * w,  4, 360, "rectangle", c);
}
