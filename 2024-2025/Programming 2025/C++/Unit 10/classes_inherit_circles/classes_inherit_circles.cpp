/*
    Author: Tyerone Chen
    Update Date: 10/2/2024
    Desc: Operator Overloading
*/

#include <iostream>
#include "cylinder.h"

using namespace std;

int main()
{
    /*
    // innit and definement of var classwes
    cylinder cylinder_1(4, 6);
    cylinder cylinder_2;

    cylinder* dynamic_cylinder;
    dynamic_cylinder = new cylinder(8, 3);
    // Pointer var
    */

    ////printing section
    // print cylinder 1
    circle circle1;
    cout << "Circle Class Overload Test" << endl;
    cout << circle1 << endl << endl;


    cylinder cylinder1(4, 6);
    cylinder cylinder2;
    cout << "Cylinder Class Overload Test" << endl;
    cout << "Cylinder 1 Data: " << endl << cylinder1 << endl;
    cout << "Cylinder 2 Data: " << endl <<  cylinder2 << endl << endl;

    cout << "++ Overload Example: " << endl;
    ++cylinder1;
    ++cylinder2;
    cout << "Cylinder 1 Data: " << endl <<  cylinder1 << endl;
    cout << "Cylinder 2 Data: " << endl <<  cylinder2 << endl << endl;

    cout << "+ Overload Example" << endl;
    cout << cylinder1 + cylinder2 << endl << endl;

    cout << "== Overload Example" << endl;
    if (cylinder1 == cylinder2) {
        cout << "Wait the cylinders shouldn't be equal..." << endl;
    }
    else {
        cout << "THEY'RE NOT EQUAL, good its working" << endl;
    }

    /*
    cout << "Cylinder 1 Data: " << endl;
    cylinder_1.printRadius();
    cylinder_1.printCircleArea();

    cylinder_1.printHeight();
    cylinder_1.printCylArea();
    cylinder_1.printCylVolume();

    cout << endl << "---------------------------------------------" << endl;

    cout << "Cylinder 2 Data: " << endl;
    cylinder_2.printRadius();
    cylinder_2.printCircleArea();

    cylinder_2.printHeight();
    cylinder_2.printCylArea();
    cylinder_2.printCylVolume();

    cout << endl << "---------------------------------------------" << endl;

    cout << "Cylinder 3 Data: " << endl;
    dynamic_cylinder->printRadius();
    dynamic_cylinder->printCircleArea();

    dynamic_cylinder->printHeight();
    dynamic_cylinder->printCylArea();
    dynamic_cylinder->printCylVolume();

    cout << endl << "---------------------------------------------" << endl;

    cout << "Cylinder 2 Again But Data Changed: " << endl;
    cylinder_2.setRadius(3);
    cylinder_2.setHeight(9);

    cylinder_2.printRadius();
    cylinder_2.printCircleArea();

    cylinder_2.printHeight();
    cylinder_2.printCylArea();
    cylinder_2.printCylVolume();
    */
}

