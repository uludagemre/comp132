// Static Arrays Versus Dynamically Created Arrays(malloc) 
// Static Array: Allocation of memory at compile-time before the associated program is executed.
// Assigned to stack in memory - example local arrays defined inside fucntions, global arrays etc
// Memory space for static arrays are reclaimed when the fucntion completes (the stack pace is released )
// If you create arrays using malloc, they will be allocated from heap
// If such arrasy are not needed anymore, the space need to freed using free()
#include <stdio.h>
#include <stdlib.h>

void print_array(int a[], int size) {
	int i;
	for(i=0; i<size; i++)
	   printf("%4d",a[i]);
	printf("\n");
}

void  f() {
	int i;
	int arr[10];   // 10 elements are allocated in stack
	                // when f completed, arr disappears
	for(i=0; i<10; i++) arr[i]=i;
	print_array(arr,10);		
}


int * g(int n) {
	int *arr;
	arr = (int *) malloc(n*sizeof(int));  // allocate n integers

	int i;
	for(i=0; i<n; i++) arr[i]=i*10;
	
    print_array(arr,n);

	return arr;

}

void h(int a[],int size) {
	int i;
	for(i=0; i<size; i++) a[i]++;
}







int main() {
    int *myArray;
	// static memory allocation for variables (at compile-time) in stack region of memory
	f();
	
	myArray = g(10);

    h(myArray,10);

	print_array(myArray,10);    
	
}