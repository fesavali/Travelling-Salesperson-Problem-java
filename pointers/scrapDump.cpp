 #include <iostream>
 #define LONG_TO_INT(x) ((x)>=0?(int)((x)+0.5):(int)((x)-0.5));
 
 using namespace std;
 
int main(){

long double bigfloat;
double twolong;

cout << "Enter a Long Long: ";
cin >> bigfloat;
cout << "Enter a Long: ";
cin >> twolong;

union double_entendre {
long double bigfloat;
double twolong;
} thing;   
printf("\nunion double_entendre: %ld\n", sizeof(thing));

int x = LONG_TO_INT(bigfloat);
int y = LONG_TO_INT(twolong);

int size = (sizeof(long long int) * 8)-1;
for ( int i = size; i >= 0; i-- ){
printf( "%d", ( x >> i ) & 1 );
}
cout << "\n";
for ( int i = size; i >= 0; i-- ){
printf( "%d", ( y >> i ) & 1 );
}


printf("\nlong long: %ld\n", sizeof(long long));
printf("long double: %ld\n", sizeof (long double));

cout << "Long Long Location: ";
cout << &bigfloat;
cout << "\nLong Double Location: ";
cout << &twolong;

return 0;
}
