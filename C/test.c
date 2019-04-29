#include <stdio.h>



enum Campus { WEST=1,MAIN=2,ISTINYE=3};

int factorial (int a ){

    if(a == 0)  return 1;
    else if(a == 1)  return 1;
    else return a * factorial(a-1);

}

int fibonacci (int a ){

    if(a == 1)  return 1;
    else if(a == 2)  return 1;
    else return  fibonacci(a-1) + fibonacci(a-2);

}


int local (int a){

    static int x=50;

    x += a;

    printf("This is %d\n",x);

    return 0;
}



int main(void){

    //local(10);
    //local(20);
    for(int i = 1; i <= 10; i++)
    {
     printf("This is fibonacci %d : %d \n",i,fibonacci(i));
    }
    

}