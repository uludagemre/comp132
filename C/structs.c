
#include <stdio.h>
#include <stdlib.h>



struct person {

    char *name;
    char *surname;
    }person, personGroup[10],*personPtr;



int main(void){

    int numberOfNumbers;
    struct person person1;
    person1.name = "EMRE";
    person1.surname = "ULUDAĞ";
    
    printf("This is person is %s\n",person1.name);
    printf("His surname is %s\n",person1.surname);

    // printf("Enter how many numbers you want to store:\n");
    // scanf("%d",&numberOfNumbers);

    char *word= malloc(sizeof(char));

    // void *numbers = malloc(numberOfNumbers*sizeof(char));


    // if(word != NULL){

        //scan numbers:
        printf("Scan the word:\n");
        scanf("%s",word);
       
        //print numbers: 
        printf("The entered word is: %s\n",word);

        free(word);

    // }else{
        printf("You could not allocate enough memory for the entries!");
    // }
    
    
    


    return 0;
}
