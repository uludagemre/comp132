#include <stdio.h>

#define SENTINEL -1

void read_array(int arr[]){

    printf("Enter positive integers: \n");
    int value;
    scanf("%d",&value);
    int index=0;
    while(value != SENTINEL){
        arr[index] = value;
        index++;
        scanf("%d",&value);
    }

}


void print_array(int arr[]){
    
    int i=0;
    while(arr[i] != SENTINEL){  
        printf("%-4d",arr[i]);
        i++;
    }   
    puts("");

}


int main(void){

    int array[50];
    read_array(array);
    print_array(array);


    return 0;
}