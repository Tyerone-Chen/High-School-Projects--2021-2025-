
#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main()
{
	stack<string> studentSignUp;

	studentSignUp.push("John");
	studentSignUp.push("Jacob");
	studentSignUp.push("Jingleheimer");
	studentSignUp.push("Schmidt");

	int count = studentSignUp.size();
	cout << "Count: " << count << endl;

	string next_element = studentSignUp.top(); // Peaking the top of the stack
	cout << "Next Element is: " << next_element << endl;
	
	string popped_element = studentSignUp.top();
	studentSignUp.pop();
	cout << "After Poppin, Next Top Value is: " << studentSignUp.top() << endl;ufdgs as 
}

