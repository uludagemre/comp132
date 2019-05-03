#include <stdio.h>


void change(int *a){
    *a = *a + 5;
}


int main(void){
    
    int a = 5;
    printf("This is a %d\n",a);
    change(&a);
    printf("This is a %d\n",a);

}