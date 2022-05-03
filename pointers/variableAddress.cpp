 #include <iostream>
 #include <string>
 using namespace std;

#define Converter(x) ((x)>=0?(int)((x)+0.5):(int)((x)-0.5));

int main() {
    string valueMem = "Value1 mem location:  ";
    string valueMem1 = "Value2 mem location:  "; 
    string bits = "showbits output1:  "; 
    string bits2 = "showbits output2:  "; 
    string unionMen = "union location:  ";
    
double x ; //initialise double
long double y ;//initialise long

    printf("Enter a double value:");//Request user input double
    cin >> x;
    printf("Enter a Long value:");//Request user input double
    cin >> y;
    
    int newx = Converter(x);
    int newy = Converter(y);
    cout << valueMem;
    cout << &newx;
    cout << valueMem1;
    cout << &newy;

    union double_entendre {
    long double bigfloat;
    long long twolong[2];
    } thing;
    printf("union double_entendre: %ld\n", sizeof(thing));
  	cout << unionMen;
    cout << &thing;
    cout << bits;
    int size = (sizeof(newx) * 8)-1;
    for ( int i = size; i >= 0; i-- ){
    printf( "%d", ( newx >> i ) & 1 );
    }
    cout << bits2;
    for ( int i = size; i >= 0; i-- ){
    printf( "%d", ( newy >> i ) & 1 );
    }

  return 0;
}
