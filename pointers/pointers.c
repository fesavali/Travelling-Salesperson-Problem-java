#include <stdio.h>
#define FLOAT_TO_INT(x) ((x)>=0?(int)((x)+0.5):(int)((x)-0.5));
//create function to show bits
void showbits( unsigned int x )
{
 int i=0;
 for (i = (sizeof(int) * 8) - 1; i >= 0; i--)
 {
 putchar(x & (1u << i) ? '1' : '0');
 }
 printf("\n");
}
int main()
{
// get the user input
 float f; //initialise float value
 printf("Enter a floating Point: \n");
 scanf("%ff", &f); //get user input
 
 //trick the compiler into treating the float as an integer
//NB: Bitwise operation work on integers but not floating-point numbers
 union fp_bit_twiddler { // initialise an onion
 float f;
 unsigned int i; // introduce unsinged int
} q;
int a;
q.f = a; //match user input to onion
q.i &= (1 << 3);
a = q.f;
 printf("Float is = %f\n",f); // print user input
 
 float my_float = f;
int my_int;
my_int = FLOAT_TO_INT(my_float);
 int *p; /* a pointer to an integer */
 // printf("%d Location pointer %d\n", p, &a);
 p = &a;
 printf("Memory Location Pointer %d\n", p, &a);
printf("\nAddress of value is: %p", &a);
printf("\nAddress of value is: %p", p);
printf("\nAddress of pointer p is: %p", &p);
 
 //show binary value using bitwise
 printf("\n%d in binary \t\t ", my_float);
 /* assume we have a function that prints a binary string when given 
 a decimal integer 
 */
 showbits(my_float);
 /* the loop for right shift operation */
 for (int m = 0; m <= 5; m++)
 {
 int n = a >> m;
 printf("%d right shift %d gives ", my_float, m);
 showbits(my_float); //print bitwise and shift rights
 }
 return 0;
}
