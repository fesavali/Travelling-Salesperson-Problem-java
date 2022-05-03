#include <iostream>
//define a method to parse long and double as int
#define DOUBLE_TO_INT(x) ((x)>=0?(int)((x)+0.5):(int)((x)-0.5));

using namespace std;
//initialise a function to handle all logics
void myWorkerFunction(){
    //initialise input values
    long double myLong;
    double myDouble;
    //take first value from user
    cout << "Enter Long: \n";
    cin >> myLong;
    //take second value from user
    cout << "Enter Double: ";
    cin >> myDouble;
  	
    //parse double to ints
    int a = DOUBLE_TO_INT(myLong);
    int b = DOUBLE_TO_INT(myDouble);

    cout << "\na Location: "; //get memory location of value one
    cout << &a;
    cout << "\nb Location:"; //get memory location of value two
    cout << &b;
    
    //initialise union
    union double_entendre {
    int b;// parse values through union
    int a;//parse second value
    } thing;
    
    //print out union memory location
    cout << "\nUnion Location:";
    cout << &thing << "\n";
    
    //initialise bitwise conversion
    int size = (sizeof(a) * 8)-1;
    //convert first value
    cout << "Converter: ";
	for ( int i = size; i >= 0; i-- ){
	printf( "%d", (a >> i ) & 1 );
	}
    cout << "\n";
    cout << "Converter: ";
    //convert second value
	for ( int i = size; i >= 0; i-- ){
    char convert2 = ( "%d", (b >> i ) & 1 );
	printf( "%ld", (b >> i ) & 1 ); 
   
	}}

    //main class
    int main() {
    
    myWorkerFunction(); // call my worker class
  	
  return 0;
}