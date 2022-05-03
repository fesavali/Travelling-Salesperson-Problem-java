#include <iostream>
using namespace std;

void getInput(){
    long long int x;
    long int y;
    
    cout << "Type a number: \n";
    cin >> x;
    cout << "Type another number: \n";
    cin >> y;
  	
    cout << "\nScrap Memory Location for x:";
    cout << "\n" << &x;
    cout << "\nScrap Memory Location for y:";
    cout << "\n" << &y << "\n";
    int size = (sizeof(x) * 8)-1;
    
    cout << "Converted Long Long: Int\n";
	for ( int i = size; i >= 0; i-- ){
	printf( "%lld", (x >> i ) & 1 );
	}
    cout << "\n";
    cout << "Converted Long Int:\n";
    
	for ( int i = size; i >= 0; i-- ){
    char convert2 = ( "%ld", (y >> i ) & 1 );
	printf( "%ld", (y >> i ) & 1 ); 
   
	}
    
    union double_entendre {
    long int y;
    long long int x;
    } thing;
    
    
    cout << "\nScrap Memory Location for union: ";
    cout << "\n" << &thing;
   
    }

    int main() {
    
    getInput();
  	
  return 0;
}
