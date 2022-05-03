#include <iostream>

using namespace std;
int main() {

    //initialise inputs
    long int value;
    long long int value1;
    
    cout << "Enter a long value here: \n";
    cin >> value;
    cout << "Enter a long long value here:\n";
    cin >> value1;

 //show user inputs 	
    cout << "You Entered Long: " << value << "  and Long Long: " << value1 << "\n";

//handle union
    union double_entendre {
    long int value;
    long long int value1;
    } thing;
    
    cout << "union double_entendre: " << sizeof(thing);
    
     //get memory location for value 1
    cout << "\nLong Value Memory Location:";
    cout << &value;

     //get memory location for value 1
    cout << "\nLong Long Memory Location:";
    cout << &value1;
    
 //get memory location for union
    cout << "\nUnion Memory Location:";
    cout << &thing << "\n";

    int size = (sizeof(value) * 8)-1;
 //calculte bitwise for value 1   
    cout << "Bitwise Long Long Value: ";
	for ( int i = size; i >= 0; i-- ){
	cout << ( "%lld", (value >> i ) & 1 );
	}
    cout << "\n";

//calculte bitwise for value 2
    cout << "Bitwise Long  value: ";
	for ( int i = size; i >= 0; i-- ){
    char convert2 = ( "%ld", (value1 >> i ) & 1 );
	cout << ( "%ld", (value1 >> i ) & 1 ); 
   
	}  	
  return 0;
}
