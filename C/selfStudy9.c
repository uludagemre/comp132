#include <stdio.h>

static int fiboCall;
static int kocCall;

int fibonacci(int n){
    fiboCall++;
    if (n == 1) return 1;
    else if (n == 2) return 1;
    else{
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
int koc(int n){
    kocCall++;
    if (n == 1) return 1;
    else if (n == 2) return 1;
    else if (n == 3) return 1;
    else{
        return koc(n-1) + koc(n-2) +  koc(n-3);
    }
}

int findDigitCount(int n){
    int count=1;
    while((int)(n/10)!=0){
        count++;
        n = (int)(n/10);
    }
    return count;
}
int digit_sum(int n){
    int sum = 0;
    int count =findDigitCount(n);
    for(int i = 0; i < count; i++)
    {
        sum+=n%10;
        n=(int)(n/10);
    }
    return sum;
}
int super_digit(int n){
    if (findDigitCount(n) == 1) return n;
    else{
        int digitSum =digit_sum(n);
        printf("Partial sum is : %d\n",digitSum);
        return super_digit(digitSum);
    }


}


int main(void){

    //Question 1

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
    
    //Question 2

    int kocNum;
    int fibo;
    int number;
    puts("Enter a positive integer: ");
    scanf("%d",&number);

    fibo = fibonacci(number);
    kocNum = koc(number);

    printf("%dth fibonacci number = %d, calculated with %d function call\n",number,fibo,fiboCall);
    printf("%dth koc number = %d, calculated with %d function call\n",number,kocNum,kocCall);

    //Question 3

    int superSum;
    puts("Enter a positive integer: ");
    scanf("%d",&superSum);

    // printf("Super digit of %d = %d\n",superSum,(int)(superSum/10));
    printf("Super digit of %d : %d\n",superSum,super_digit(9875));
    
    
    return 0;
}