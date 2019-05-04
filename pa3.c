#include <stdio.h>
#include<stdlib.h> 
#include <stdbool.h>
#include <string.h>


//THIS CODE IS MY OWN WORK. I DID NOT CONSULT TO ANY PROGRAM WRITTEN BY OTHER STUDENTS. 
//I READ AND FOLLOWED THE GUIDELINE GIVEN IN THE PROGRAMMING ASSIGNMENT 3. NAME: EMRE ULUDAĞ

struct Grade{
    char examName[20];
    int points;
};
struct Student{
    int id;
    char name[20];
    char surname[20];
    char letterGrade;
    struct Grade grades[5];
    int numberOfExamsGraded;
    struct Student *next;
};


// Prototypes
void addStudentSorted(struct Student** headPtr, int id, char name[], char surname[]);
struct Student* removeStudent(struct Student** headPtr, int id);
void addGrade(struct Student* head, int id, char exam[], int takenPoint);
void printCourseReportForAllStudents(struct Student* head);
double calculateClassAvarageForOneExam (struct Student* head, char examName[]);
bool isStudentInList(struct Student * head, int id);
void calculateLetterGradesOfAllStudents (struct Student * head);
char decideLetterGrade(double average);

// Helper functions
struct Student* findStudentById(struct Student* head, int id);
bool isListEmpty(struct Student **headPtr);

int main(void){
    // initialize empty linkedlist
    struct Student* head = (struct Student*)malloc(sizeof(struct Student));
    struct Student* tail = (struct Student*)malloc(sizeof(struct Student));
    head->next=tail;
    // initialize empty linkedlist

    // addStudentSorted(&head,50209,"emre","uludağ");     
    // addStudentSorted(&head,53781,"aylin","akseki");
    // addStudentSorted(&head,60350,"haşmettin","kıllibacak");     
    // addGrade(head,60350,"quiz1",60);
    // addGrade(head,60350,"quiz2",80);
    // addGrade(head,50209,"quiz1",80);
    // addGrade(head,53781,"quiz2",50);
    // addGrade(head,60350,"quiz3",60);
    // addGrade(head,60350,"quiz4",80);
    // addGrade(head,50209,"quiz2",80);
    // addGrade(head,53781,"quiz1",50);
    // addGrade(head,60350,"quiz5",100);
    // calculateLetterGradesForAllStudents(head);
    // // removeStudent(&head,60350);
    // struct Student* myStudent= findStudentById(head,50209);
    // printCourseReportForEveryStudent(head);

    // double average = calculateClassAvarageForOneExam(head,"quiz2");
    // printf("The average in science is %2.1f\n",average);

    
    int option;
    printf("Option 1 – Enter 1 in order to add a new student then press Enter\n");
    printf("Option 2 – Enter 2 in order to check if a student is in the course list\n"); 
    printf("Option 3 – Enter 3 in order to delete a student in the course then press Enter\n");
    printf("Option 4 – Enter 4 in order to add or change the grade of the student then press Enter\n");
    printf("Option 5 – Enter 5 in order to calculate the class average point then press Enter\n");
    printf("Option 6 – Enter 6 in order to print the course report for one student then press Enter\n");
    printf("Option 7 – Enter 7 in order to print the course report for all students then press Enter\n");
    printf("Option 8 – Enter 8 in order to exit then press Enter\n");
    printf("Choose one option: \n");
    scanf("%d",&option);
    while(option != 8){
        if(option == 1){
            char name[20];
            char surname[20];
            int id;
            printf("You have chosen the option 1. Enter the student name, surname and ID seperated by one space then press Enter:\n");
            scanf("%s %s %d",name,surname,&id);
            addStudentSorted(&head,id,name,surname);     
        }
        else if(option == 2){
            char name[20];
            char surname[20];
            int id;
            printf("You have chosen the option 2. Enter the student ID to check if he/she is in the list then press Enter:\n");
            scanf("%d",&id);
            if(isStudentInList(&head,id)){
                printf("The student with given id is in the student list.\n");
            }else{
                printf("The student with given id is not in the student list.\n");
            }
        }
        else if(option == 3){
            char name[20];
            char surname[20];
            int id;
            printf("You have chosen the option 3. Enter the student ID to delete him/her then press Enter:\n");
            scanf("%d",&id);
            struct Student* student = removeStudent(&head,id);   
            
        }
        else if(option == 4){
            
        }
        else if(option == 5){
            
        }
        else if(option == 6){
            
        }
        else if(option == 7){
            
        }
        else if(option == 8){
            
        }else{
            printf("Invalid choice!");
            break;
        }
        
    printf("Choose one option: \n");
    scanf("%d",&option);
    }
    
    
    printf("Bye bye !\n");


return 0;
}


bool isListEmpty(struct Student **headPtr){
    struct Student *current = *headPtr;
    if(current ->next -> id == 0) return true;
    else return false;
}
void addStudentSorted(struct Student **headPtr, int id, char name[], char surname[]){
    struct Student *currentIter = *headPtr;
    if(isListEmpty(headPtr)){ //if the list is empty condition!
        struct Student *tail = currentIter -> next ;
        struct Student *nodeToPut = (struct Student*)malloc(sizeof(struct Student));
        currentIter -> next = nodeToPut;
        nodeToPut -> next = tail;
        nodeToPut ->id=id;
        strcpy(nodeToPut->name,name);
        strcpy(nodeToPut->surname,surname); 
    }
     else{ //if the list is not empty!
        struct Student *nodeToPut = (struct Student*)malloc(sizeof(struct Student));   
        while(id> currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;  //according to my code's logic currentIter never becomes tail node!
        }
        nodeToPut->id = id;
        strcpy(nodeToPut->name,name);
        strcpy(nodeToPut->surname,surname);
        nodeToPut->next=currentIter->next;
        currentIter->next =nodeToPut;
    }    
    
}
struct Student* removeStudent(struct Student **headPtr, int id){
    struct Student *currentIter = *headPtr;
    if(isListEmpty(headPtr)){ //if the list is empty condition!
        return NULL;
    }
     else{ //if the list is not empty!
        while(id > currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;//according to my code's logic currentIter never becomes tail node!
            if(id == currentIter->next->id) {
                struct Student *previousNode = currentIter;
                struct Student *nodeToBeDeleted = currentIter->next;
                struct Student *nextNode = nodeToBeDeleted->next;
                previousNode->next=nextNode;
                return nodeToBeDeleted;
            }
        }
        return NULL;
    }    
    
}

struct Student* findStudentById(struct Student* head, int id){
    struct Student* currentIter = head;
    if(isListEmpty(&head)){ //if the list is empty condition!
        return NULL;
    }else{
        while(id > currentIter->next->id && currentIter->next->next != NULL){ //in the first place currentIter was header student node
            currentIter = currentIter ->next;//according to my code's logic currentIter never becomes tail node!
            if(id == currentIter->next->id) {
                return currentIter->next;
            }
        }
        return currentIter->next;   
    }
 }


bool isStudentInList(struct Student * head, int id){
    struct Student* tempStudent = findStudentById(head,id);
    if (tempStudent == NULL) return false;
    else return true;
}

void printStudent(struct Student* student) {

       printf("%-10s %-10s\t id:%-10d\t", student->name, student->surname, student->id);
       printf("Graded exams: ");
       for (int i = 0; i <5; i++) {
            printf("%10s :%2d\t", student->grades[i].examName, student->grades[i].points);
        }
       printf("\nLetter : %c\n", student->letterGrade); }

void addGrade(struct Student* head, int id, char exam[], int takenPoint){
    struct Student* tempStudent = findStudentById(head,id);
    struct Grade* tempGrade = (struct Grade*)malloc(sizeof(struct Grade));
    strcpy(tempGrade->examName,exam);
    tempGrade->points=takenPoint;
    for (int i = 0; i < 5; ++i)
    {
        
        if(tempStudent->grades[i].points==0){
            tempStudent->grades[i]=*tempGrade;
            break;
        }
    }

}
void printCourseReportForEveryStudent(struct Student* head){
    struct Student* current = head;
    if(isListEmpty(&head)){ //if the list is empty condition!
        return;
    }
     else{ //if the list is not empty!
        while(current->next->next != NULL){ //in the first place currentIter was header student node
            printStudent(current->next);
            current = current ->next;//according to my code's logic c   
        }
        }
}

double calculateClassAvarageForOneExam (struct Student* head, char examName[]){
    struct Student* current = head;
    if(isListEmpty(&head)){ //if the list is empty condition!
        return 0;
    }
     else{ //if the list is not empty!
        double pointSum = 0;
        int studentCount = 0;
        while(current->next->next != NULL){ //in the first place currentIter was header student node
            for(int i = 0; i < 5; i++)
            {
                if(strcmp(current->next->grades[i].examName,examName)==0){
                    pointSum += current->next->grades[i].points;
                    studentCount++;
                }
            }
            
            current = current ->next;//according to my code's logic!   

        }
        return pointSum/studentCount;
        }
}
char decideLetterGrade(double average){
    char letter;
    if (average < 60) letter = 'F';
    else if (average < 70 && average >= 60) letter = 'D';
    else if (average < 80 && average >= 70) letter = 'C';
    else if (average < 90 && average >= 80) letter = 'B';
    else if (average <= 100 && average >= 90) letter = 'A';
    return letter;
}

void calculateLetterGradesOfAllStudents(struct Student* head){
    struct Student* current = head;
    if(isListEmpty(&head)){ //if the list is empty condition!
        return;
    }
     else{ //if the list is not empty!
        while(current->next->next != NULL){ //in the first place currentIter was header student node
            double pointSum = 0;
            for(int i = 0; i < 5; i++)
            {
                pointSum+=current->next->grades[i].points;
            }
            double average = pointSum / 5;
            current->next->letterGrade =decideLetterGrade(average);
            current = current ->next;//according to my code's logic c   
        }
        }
}

