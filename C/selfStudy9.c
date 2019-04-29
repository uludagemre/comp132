#include <stdio.h>


int main(void){

    int size;

    puts("Enter a integer between 1 and 20");
    scanf("%d",&size);
    for(int i = 1; i <= size; i++)
    {
        for(int j = 1; j <= size; j++)
        {
            printf("%4d",i*j);
        }
        puts("");
        
    }
    
    return 0;
}