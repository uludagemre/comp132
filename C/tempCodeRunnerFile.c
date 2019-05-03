  int kocNum;
    int fibo;
    int number;
    puts("Enter a positive integer: ");
    scanf("%d",&number);

    fibo = fibonacci(number);
    kocNum = koc(number);

    printf("%dth fibonacci number = %d, calculated with %d function call\n",number,fibo,fiboCall);
    printf("%dth koc number = %d, calculated with %d function call\n",number,kocNum,kocCall);